function addressBook(arrOfStrings) {
  let person = {};

  for (const line of arrOfStrings) {
    let tokens = line.split(":");
    let name = tokens[0];
    let address = tokens[1];

    person[name] = address;
  }

  let personArr = Object.entries(person);
  personArr.sort((a, b) => a[0].localeCompare(b[0]));

  for (const [name, address] of personArr) {
    console.log(`${name} -> ${address}`);
  }
}

addressBook([
  "Tim:Doe Crossing",
  "Bill:Nelson Place",
  "Peter:Carlyle Ave",
  "Bill:Ornery Rd",
]);
