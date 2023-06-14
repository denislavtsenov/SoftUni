function fruit(typeOfFruit, weightInGrams, priceKg){
let totalMoney = 0;
let totalWeight = weightInGrams / 1000;

totalMoney = totalWeight * priceKg;

console.log(`I need $${totalMoney.toFixed(2)} to buy ${totalWeight.toFixed(2)} kilograms ${typeOfFruit}.`)
}


fruit('apple', 1563, 2.35);