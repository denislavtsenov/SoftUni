function solve(arr) {
  let oddSum = 0;
  let evenSum = 0;

  for (let index = 0; index < arr.length; index++) {
    arr[index] === Number(arr[index]);

    if (arr[index] % 2 === 0) {
      evenSum += arr[index];
    } else {
      oddSum += arr[index];
    }
  }

  console.log(evenSum - oddSum);
}

