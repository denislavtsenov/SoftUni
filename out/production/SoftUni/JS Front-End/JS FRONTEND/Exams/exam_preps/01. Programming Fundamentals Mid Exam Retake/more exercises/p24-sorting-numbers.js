function sortingNumbers(inputArr) {
  inputArr.sort((a, b) => a - b);
  let result = [];

  while (inputArr.length > 0) {
    result.push(inputArr.shift());
    result.push(inputArr.pop());
  }
  return result;
}

sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);
