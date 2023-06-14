function simpleCalculator(numOne, numTwo, operator) {
  numOne = Number(numOne);
  numTwo = Number(numTwo);

  let total = 0;

  switch (operator) {
    case `multiply`:
      total = numOne * numTwo;
      break;
    case `divide`:
      total = numOne / numTwo;
      break;
    case `add`:
     total = numOne + numTwo;
      break;
    case "subtract":
     total = numOne - numTwo;
      break;
  }

  console.log(total);
}

simpleCalculator(5, 5, "multiply");
