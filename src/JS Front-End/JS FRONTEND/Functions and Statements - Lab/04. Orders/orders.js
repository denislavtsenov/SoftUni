function orders(product, quantity) {
  let priceOfProduct = 0;

  switch (product) {
    case `coffee`:
      priceOfProduct = 1.5;
      break;
    case `water`:
      priceOfProduct = 1.0;
      break;
    case `coke`:
      priceOfProduct = 1.4;
      break;
    case `snacks`:
      priceOfProduct = 2.0;
      break;
  }

  let totalSum = quantity * priceOfProduct;

  console.log(totalSum.toFixed(2));
}
