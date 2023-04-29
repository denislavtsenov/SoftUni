function oddPositions(input) {
  let result = [];

  for (let index = 0; index < input.length; index++) {
    if (index % 2 !== 0) {
      result.push(input[index]);
    }
  }

  let doubled = result.map(e => e * 2);
  doubled.reverse();
  console.log(doubled.join(' '));
}

oddPositions([3, 0, 10, 4, 7, 3]);
