function findSubstring(word, text) {
  let textArr = text.split(" ");
  let searchedWord = word.toLowerCase();
  let isFound = false;

  for (let index = 0; index < textArr.length; index++) {
    let currentWord = textArr[index].toLowerCase();

    if (currentWord === searchedWord) {
      isFound = true;
      break;
    }
  }

  if (isFound === true) {
    console.log(word);
  } else {
    console.log(`${word} not found!`);
  }
}
