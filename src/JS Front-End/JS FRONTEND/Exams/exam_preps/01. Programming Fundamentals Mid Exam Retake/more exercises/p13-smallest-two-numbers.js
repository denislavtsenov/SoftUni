function smallestTwoNumbers(input) {
  input.sort((f, s) => f - s);

  let result = input.splice(0, 2);

  console.log(result.join(" "));
}

smallestTwoNumbers([30, 15, 50, 5]);
