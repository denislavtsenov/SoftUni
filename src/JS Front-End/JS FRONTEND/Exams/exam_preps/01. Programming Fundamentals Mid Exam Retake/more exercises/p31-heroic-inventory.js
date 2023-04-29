function heroicInventory(inputArr) {
  let allHeroes = [];

  for (const line of inputArr) {
    let [name, level, items] = line.split(" / ");
    level = Number(level);

    items = items ? items.split(", ") : [];

    allHeroes.push({ name, level, items });
  }

  console.log(JSON.stringify(allHeroes));
}

heroicInventory([
  "Isacc / 25 / ",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
]);
