function addRemoveElements(inputArr) {
  let initialNum = 1;
  let resultArr = [];

  for (const command of inputArr) {
    if (command === "add") {
      resultArr.push(initialNum);
    } else {
      resultArr.pop();
    }
    initialNum++;
  }

  if (resultArr.length > 0) {
    console.log(resultArr.join("\n"));
  } else {
    console.log("Empty");
  }
}

addRemoveElements(["add", "add", "add", "add"]);
addRemoveElements(["remove", "remove", "remove"]);
addRemoveElements(["add", "add", "remove", "add", "add"]);
