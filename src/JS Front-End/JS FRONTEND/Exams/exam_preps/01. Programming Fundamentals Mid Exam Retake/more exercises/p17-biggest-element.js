function biggestElement(matrix) {
  let biggestNum = -Number.MAX_VALUE;

  for (const array of matrix) {
    for (const num of array) {
      if (num > biggestNum) {
        biggestNum = num;
      }
    }
  }

  console.log(biggestNum);
}

biggestElement([
  [0, 0, 0, 0],
  [0, 0, 0, 0],
]);
