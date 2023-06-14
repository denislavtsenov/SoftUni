function solve(typeOfFruit, weightInGrams, pricePerKg) {
    let weightInKg = Number(weightInGrams / 1000);
    let price = Number(pricePerKg);

    let totalPrice = weightInKg * price;

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${typeOfFruit}.`);
}
