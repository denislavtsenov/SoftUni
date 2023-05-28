function printWordsWithHashtag(input) {
  let inputArr = input.split(" ");

  for (let index = 0; index < inputArr.length; index++) {
    let currentWord = inputArr[index];

    if (currentWord.startsWith("#") && currentWord.length > 1) {
      let currentWordArr = currentWord.split("");
      let isLetter = true;
      let wordToPrint = "";
      for (let index = 1; index < currentWordArr.length; index++) {
        let currentChar = currentWordArr[index];
        wordToPrint += currentChar;
        let number = currentChar.toLowerCase().charCodeAt(0);
        if (number < 97 || number > 122) {
          isLetter = false;
        }
      }

      if (isLetter === true) {
       
        console.log(wordToPrint);
      }
    }
  }
}
