function storeProvision(currentStock, ordered) {
  let store = {};

  for (let index = 0; index < currentStock.length; index++) {
    let product = currentStock.shift();
    let values = Number(currentStock.shift());

    index = -1;

    store[product] = values;
  }

  for (let index = 0; index < ordered.length; index++) {
    let currentProduct = ordered.shift();
    let currentValue = Number(ordered.shift());

    index = -1;

    if (store.hasOwnProperty(currentProduct)) {
      store[currentProduct] += currentValue;
    } else {
      store[currentProduct] = currentValue;
    }
  }

  for (const product in store) {
    console.log(`${product} -> ${store[product]}`);
  }
}

storeProvision(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);
