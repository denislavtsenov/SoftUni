function listOfNames(names) {
  let arrWithNames = [...names];

  
  arrWithNames.sort((a, b) => a.localeCompare(b));

  for (let index = 0; index < arrWithNames.length; index++) {
    console.log(`${index + 1}.${arrWithNames[index]}`);
  }
}

