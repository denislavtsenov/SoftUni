function pieceOfPie(piesArr, firstInput, secondInput) {
  let firstIndex = piesArr.indexOf(firstInput);
  let secondIndex = piesArr.indexOf(secondInput);

  let result = piesArr.splice(firstIndex, secondIndex);
  console.log(result);
}

pieceOfPie(
  [
    "Pumpkin Pie",
    "Key Lime Pie",
    "Cherry Pie",
    "Lemon Meringue Pie",
    "Sugar Cream Pie",
  ],
  "Key Lime Pie",
  "Lemon Meringue Pie"
);
