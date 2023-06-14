function townsParser(inputArr) {
  let towns = {};

  for (const line of inputArr) {
    let tokens = line.split(" | ");
    let name = tokens[0];
    let latitude = tokens[1];
    let longitude = tokens[2];

    towns['town'] = name;
    towns['latitude'] = Number(latitude).toFixed(2);
    towns['longitude'] = Number(longitude).toFixed(2);
    
    console.log(towns);
  }
}

townsParser([
  "Sofia | 42.696552 | 23.32601",
  "Beijing | 39.913818 | 116.363625",
]);
