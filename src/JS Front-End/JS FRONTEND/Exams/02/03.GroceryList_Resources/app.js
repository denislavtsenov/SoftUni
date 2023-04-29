let BASE_URL = "http://localhost:3030/jsonstore/grocery/";

let productInput = document.getElementById("product");
let countInput = document.getElementById("count");
let priceInput = document.getElementById("price");

let addProductBtn = document.getElementById("add-product");
let updateProductBtn = document.getElementById("update-product");
let loadProductBtn = document.getElementById("load-product");

let tableBody = document.getElementById("tbody");
let updateId;
let form = document.querySelector(".list");

addProductBtn.addEventListener("click", addProductToTheStore);
updateProductBtn.addEventListener("click", updateProduct);
loadProductBtn.addEventListener("click", loadProducts);

async function editRow() {
  updateId = this.parentNode.parentNode.id;

  let allRows = Array.from(tableBody.children);
  
  let rowChildren = [];
  for (const row of allRows) {
    if (updateId === row.id) {
      rowChildren = Array.from(row.children);
      break;
    }
  }

  productInput.value = rowChildren[0].textContent;
  countInput.value = rowChildren[1].textContent;
  priceInput.value = rowChildren[2].textContent;

  updateProductBtn.disabled = false;
  addProductBtn.disabled = true;
}

async function updateProduct(e) {
  e.preventDefault();

  let product = productInput.value;
  let price = priceInput.value;
  let count = countInput.value;

  let httpHeader = {
    method: "PATCH",
    body: JSON.stringify({ product, price, count }),
  };

  await fetch(BASE_URL + updateId, httpHeader);

  loadProducts(e);
  form.reset();
  updateProductBtn.disabled = true;
  addProductBtn.disabled = false;
}

async function loadProducts(e) {
  e.preventDefault();

  tableBody.innerHTML = "";

  let response = await fetch(BASE_URL);
  let data = await response.json();
  data = Object.values(data);

  for (const { product, count, price, _id } of data) {
    let tr = document.createElement("tr");
    tr.id = _id;

    let tdName = document.createElement("td");
    tdName.className = "name";

    let tdCount = document.createElement("td");
    tdCount.className = "count-product";

    let tdPrice = document.createElement("td");
    tdPrice.className = "product-price";

    let tdBtn = document.createElement("td");
    tdBtn.className = "btn";

    let updateBtn = document.createElement("button");
    updateBtn.className = "update";
    updateBtn.textContent = "Update";
    updateBtn.addEventListener("click", editRow);

    let deleteBtn = document.createElement("button");
    deleteBtn.className = "delete";
    deleteBtn.textContent = "Delete";
    deleteBtn.addEventListener("click", deleteRow);

    tdName.textContent = product;
    tdCount.textContent = count;
    tdPrice.textContent = price;

    tdBtn.appendChild(updateBtn);
    tdBtn.appendChild(deleteBtn);

    tr.appendChild(tdName);
    tr.appendChild(tdCount);
    tr.appendChild(tdPrice);
    tr.appendChild(tdBtn);

    tableBody.appendChild(tr);
  }
}

async function addProductToTheStore(e) {
  e.preventDefault();
  let product = productInput.value;
  let count = countInput.value;
  let price = priceInput.value;

  let httpHeader = {
    method: "POST",
    body: JSON.stringify({ product, count, price }),
  };

  let response = await fetch(BASE_URL, httpHeader);

  productInput.value = "";
  countInput.value = "";
  priceInput.value = "";

  loadProducts(e);
}

async function deleteRow(e) {
  e.preventDefault();

  let id = this.parentNode.parentNode.id;
  let httpHeaders = {
    method: "DELETE",
  };

  let response = await fetch(BASE_URL + id, httpHeaders);
  loadProducts(e);
}
