function sortingNumbers(numbers) {

    let arrayWithNumbers = [...numbers];

    arrayWithNumbers.sort((a, b) => a - b);

    let newArr = [];

    for (let index = 0; index < arrayWithNumbers.length; index++) {
      let firstNum = arrayWithNumbers.shift();
      newArr.push(firstNum);

      let lastNum = arrayWithNumbers.pop();
      newArr.push(lastNum);

      index = -1;
        
    }

    return newArr;
}

console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));