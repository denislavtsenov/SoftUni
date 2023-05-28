function solve(input) {
  let str = String(input);
  let arr = str.split("");

  let firstNum = Number(arr[0]);

  let sum = firstNum;
  let isTrue = true;

  for (let index = 1; index < arr.length; index++) {
    if (firstNum !== Number(arr[index])) {
      isTrue = false;
    }

    sum += Number(arr[index]);
  }

  console.log(isTrue);
  console.log(sum);
}

