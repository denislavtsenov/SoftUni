function carFactory(carRequirements) {
  let smallEngine = { power: 90, volume: 1800 };
  let normalEngine = { power: 120, volume: 2400 };
  let monsterEngine = { power: 200, volume: 3500 };

  let hatchback = { type: "hatchback", color: carRequirements.color };
  let coupe = { type: "coupe", color: carRequirements.color };

  let engine;
  if (carRequirements.power < 90) {
    engine = smallEngine;
  } else if (carRequirements.power < 120) {
    engine = normalEngine;
  } else {
    engine = monsterEngine;
  }

  let carriage;
  if (carRequirements.carriage === "hatchback") {
    carriage = hatchback;
  } else {
    carriage = coupe;
  }

  let wheels;
  let wheelsReq = carRequirements.wheelsize;
  let inches = 0;
  if (wheelsReq % 2 !== 0) {
    inches = wheelsReq;
  } else {
    inches = wheelsReq - 1;
  }

  wheels = [inches, inches, inches, inches];

  let car = {};
  car.model = carRequirements.model;
  car.engine = engine;
  car.carriage = carriage;
  car.wheels = wheels;
 
  return car;
}

carFactory({ model: 'Opel Vectra',
power: 110,
color: 'grey',
carriage: 'coupe',
wheelsize: 17 }
);
