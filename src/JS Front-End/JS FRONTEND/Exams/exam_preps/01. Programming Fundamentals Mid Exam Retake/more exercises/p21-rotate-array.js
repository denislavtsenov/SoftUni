function rotateArray(inputArr, numOfRotations) {
  for (let index = 0; index < numOfRotations; index++) {

    let lastElement = inputArr.pop();
    inputArr.unshift(lastElement);
  }

  console.log(inputArr.join(' '));
}

rotateArray(["1", "2", "3", "4"], 2);
rotateArray(["Banana", "Orange", "Coconut", "Apple"], 15);
