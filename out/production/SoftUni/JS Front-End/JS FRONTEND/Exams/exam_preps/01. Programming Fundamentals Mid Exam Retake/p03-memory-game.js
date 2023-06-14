function solve(input) {
  let twins = input.shift().split(" ");

  let moves = 0;
  let isEnd = false;

  for (const line of input) {
   
    if (line === "end" || twins.length <= 0) {
      isEnd = true;
      break;
    }

    moves++;
    let tokens = line.split(" ");
    let firstIndex = Number(tokens[0]);
    let secondIndex = Number(tokens[1]);

    let firstElement = twins[firstIndex];
    let secondElement = twins[secondIndex];

    if (
      firstIndex === secondIndex ||
      firstIndex < 0 ||
      firstIndex >= twins.length ||
      secondIndex < 0 ||
      secondIndex >= twins.length
    ) {
      let half = twins.length / 2;
      let putMessage = `-${moves}a`;

      twins.splice(half, 0, putMessage, putMessage);
      console.log("Invalid input! Adding additional elements to the board");

      continue;
    }

    if (firstElement === secondElement) {
 
      if (firstIndex > secondIndex) {
        twins.splice(firstIndex, 1);
        twins.splice(secondIndex, 1);
      } else {
        twins.splice(firstIndex, 1);
        twins.splice(secondIndex - 1, 1);
      }
      console.log(
        `Congrats! You have found matching elements - ${firstElement}!`
      );
      
    } else {
      console.log("Try again!");
    }
  }

  if (isEnd && twins.length > 0) {
    console.log("Sorry you lose :(");
    console.log(twins.join(" "));
  } else {
    console.log(`You have won in ${moves} turns!`);
  }
}

solve( [
    "1 1 2 2 3 3 4 4 5 5", 
    "1 0",
    "-1 0",
    "1 0", 
    "1 0", 
    "1 0", 
    "end"
    ]
    
    )