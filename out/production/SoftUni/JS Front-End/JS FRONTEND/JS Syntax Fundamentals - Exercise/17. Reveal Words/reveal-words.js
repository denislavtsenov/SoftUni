function revealWords(words, text) {
  let textArr = text.split(" ");
  let wordArr = words.split(", ");

  for (let index = 0; index < textArr.length; index++) {
    let currentWord = textArr[index];

    if (currentWord.charAt(0) === "*") {
      for (let index = 0; index < wordArr.length; index++) {
        let word = wordArr[index];

        if (currentWord.length === word.length) {
         text = text.replace(currentWord, word)
        }
      }
    }
  }

  return text;
}

console.log(
  revealWords(
    'great',
    'softuni is ***** place for learning new programming languages'
    
  )
);
