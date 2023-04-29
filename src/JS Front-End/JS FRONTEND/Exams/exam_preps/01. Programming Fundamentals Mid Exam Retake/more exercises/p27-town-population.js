function townPopulation(inputArr) {
  let cities = {};

  for (const line of inputArr) {
    let tokens = line.split(" <-> ");
    let name = tokens[0];
    let population = Number(tokens[1]);

    if (cities[name] !== undefined) {
      population += cities[name];
    }
    cities[name] = population;
  }

  for (const key in cities) {
    console.log(`${key} : ${cities[key]}`);
  }
}

townPopulation([
  "Istanbul <-> 100000",
  "Honk Kong <-> 2100004",
  "Jerusalem <-> 2352344",
  "Mexico City <-> 23401925",
  "Istanbul <-> 1000",
]);
