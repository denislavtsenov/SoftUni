function calorieObject(inputArr) {
    let foods = {};
  while (inputArr.length > 0) {
    let product = inputArr.shift();
    let calories = Number(inputArr.shift());

    foods[product] = calories;
  }

  console.log(foods);
}

calorieObject(["Yoghurt", "48", "Rise", "138", "Apple", "52"]);
