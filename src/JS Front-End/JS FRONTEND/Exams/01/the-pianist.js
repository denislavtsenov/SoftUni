function solve(input) {
  let num = Number(input.shift());

  let pianistArr = [];

  for (let index = 0; index < num; index++) {
    let tokens = input.shift().split("|");
    let pieces = tokens[0];
    let composer = tokens[1];
    let key = tokens[2];

    let currentObj = {};
    currentObj.pieces = pieces;
    currentObj.composer = composer;
    currentObj.key = key;
    pianistArr.push(currentObj);
  }

  for (let index = 0; index < input.length; index++) {
    let tokens = input[index].split("|");
    let command = tokens[0];
    let pieces = tokens[1];

    if (command === "Stop") {
      break;
    }

    let isInclude = false;

    for (const currentObj of pianistArr) {
      if (currentObj.pieces === pieces) {
        isInclude = true;
      }
    }

    if (command === "Add") {
      let composer = tokens[2];
      let key = tokens[3];

      if (isInclude) {
        console.log(`${pieces} is already in the collection!`);
      } else {
        let newObj = {};
        newObj.pieces = pieces;
        newObj.composer = composer;
        newObj.key = key;

        pianistArr.push(newObj);
        console.log(
          `${pieces} by ${composer} in ${key} added to the collection!`
        );
      }
    } else if (command === "Remove") {
      if (isInclude) {
        for (const currentObj of pianistArr) {
          if (currentObj.pieces === pieces) {
            let index = pianistArr.indexOf(currentObj);
            pianistArr.splice(index, 1);
          }
        }
        console.log(`Successfully removed ${pieces}!`);
      } else {
        console.log(
          `Invalid operation! ${pieces} does not exist in the collection.`
        );
      }
    } else if (command === "ChangeKey") {
      if (isInclude) {
        let newKey = tokens[2];
        for (const currentObj of pianistArr) {
          if (currentObj.pieces === pieces) {
            currentObj.key = newKey;
          }
        }

        console.log(`Changed the key of ${pieces} to ${newKey}!`);

      } else {
        console.log(
          `Invalid operation! ${pieces} does not exist in the collection.`
        );
      }
    }
  }

  for (const {pieces, composer, key} of pianistArr) {
    //Fur Elise -> Composer: Beethoven, Key: A Minor

    console.log(`${pieces} -> Composer: ${composer}, Key: ${key}`);
  }
}

solve([
  "3",
  "Fur Elise|Beethoven|A Minor",
  "Moonlight Sonata|Beethoven|C# Minor",
  "Clair de Lune|Debussy|C# Minor",
  "Add|Sonata No.2|Chopin|B Minor",
  "Add|Hungarian Rhapsody No.2|Liszt|C# Minor",
  "Add|Fur Elise|Beethoven|C# Minor",
  "Remove|Clair de Lune",
  "ChangeKey|Moonlight Sonata|C# Major",
  "Stop",
]);
