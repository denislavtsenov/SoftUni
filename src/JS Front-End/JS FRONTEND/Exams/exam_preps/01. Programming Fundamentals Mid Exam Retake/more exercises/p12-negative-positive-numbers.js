function negativePositive(input) {
  let result = [];

  for (const num of input) {
    if (num < 0) {
      result.unshift(num);
    } else {
      result.push(num);
    }
  }

  console.log(result.join("\n"));
}

negativePositive([3, -2, 0, -1]);
