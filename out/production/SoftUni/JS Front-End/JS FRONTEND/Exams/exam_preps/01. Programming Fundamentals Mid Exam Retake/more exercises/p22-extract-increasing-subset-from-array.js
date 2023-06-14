function solve(inputArr) {
  let biggestNum = inputArr.shift();
  let result = [];
  result.push(biggestNum);

  for (const num of inputArr) {
    if (num >= biggestNum) {
        biggestNum = num;
        result.push(num);
    }
  }

  return result;
}

solve([1, 3, 8, 4, 10, 12, 3, 2, 24]);
