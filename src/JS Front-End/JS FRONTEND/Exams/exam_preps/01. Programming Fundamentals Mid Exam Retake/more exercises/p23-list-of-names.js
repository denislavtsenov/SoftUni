function listOfNames(inputArr) {
  inputArr.sort((a, b) => a.localeCompare(b));

  for (let index = 0; index < inputArr.length; index++) {
    console.log(`${index + 1}.${inputArr[index]}`);
  }
}

listOfNames(["John", "Bob", "Christina", "Ema"]);
