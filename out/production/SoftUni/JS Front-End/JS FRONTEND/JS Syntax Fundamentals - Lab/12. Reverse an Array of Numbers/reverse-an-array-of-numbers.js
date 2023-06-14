function solve(n, inputArr) {
  let arr = [];

  for (let index = 0; index < n; index++) {
    arr.push(inputArr[index]);
  }

  arr.reverse();

  console.log(arr.join(" "));
}
