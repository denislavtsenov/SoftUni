function solve(num) {
  let number = Number(num);

  for (let index = 1; index <= 10; index++) {
    let product = number * index;

    console.log(`${number} X ${index} = ${product}`);
  }
}
