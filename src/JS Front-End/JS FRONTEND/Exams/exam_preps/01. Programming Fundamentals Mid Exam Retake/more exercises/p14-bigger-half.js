function biggerHalf(input) {
  input.sort((a, b) => a - b);

  let half = Math.floor(input.length / 2);
  let biggerHalfArr = input.splice(half);
  console.log(biggerHalfArr);
}

biggerHalf([3, 19, 14, 7, 2, 19, 6]);
