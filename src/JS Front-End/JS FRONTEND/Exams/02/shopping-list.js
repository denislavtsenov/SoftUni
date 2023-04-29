function solve(input) {
  let allProducts = input.shift();
  let products = allProducts.split("!");
 

  for (const line of input) {
    let tokens = line.split(" ");
    let command = tokens[0];
    let product = tokens[1];

    if (command === "Go Shopping") {
      break;
    }

    let isExist = false;

    for (const p of products) {
      if (p === product) {
        isExist = true;
        break;
      }
    }

    if (command === "Urgent") {
      if (!isExist) {
        products.unshift(product);
      }
    } else if (command === "Unnecessary") {
      if (isExist) {
        let index = products.indexOf(product);
        products.splice(index, 1);
      }

    } else if (command === "Correct") {
        if (isExist) {
            let newProduct = tokens[2];
            let index = products.indexOf(product);
            products.splice(index, 1);
            products.splice(index, 0, newProduct);
        }
    } else if (command === "Rearrange") {
        if (isExist) {
            let index = products.indexOf(product);
            products.splice(index, 1);
            products.push(product);

        }
    }
  }

console.log(products.join(', '));
}

solve([
  "Milk!Pepper!Salt!Water!Banana",
  "Urgent Salt",
  "Unnecessary Grapes",
  "Correct Pepper Onion",
  "Rearrange Grapes",
  "Correct Tomatoes Potatoes",
  "Go Shopping!",
]);

solve((["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Urgent Tomatoes",
"Go Shopping!"])
);
