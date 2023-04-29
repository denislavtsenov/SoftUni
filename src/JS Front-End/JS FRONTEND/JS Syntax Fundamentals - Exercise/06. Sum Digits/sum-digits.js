function solve(num) {
  let str = String(num);
  let arr = str.split("");
  let sum = 0;

  for (let index = 0; index < str.length; index++) {
    let number = Number(str[index]);

    sum += number;
  }

  console.log(sum);
}
