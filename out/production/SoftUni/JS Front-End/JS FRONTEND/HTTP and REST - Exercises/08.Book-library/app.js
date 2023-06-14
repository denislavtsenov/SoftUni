function attachEvents() {
  let loadBooksBtn = document.getElementById("loadBooks");
  let tbody = document.querySelector("tbody");
  let BASE_URL = "http://localhost:3030/jsonstore/collections/books/";

  let inputTitle = document.querySelector('input[name="title"]');
  let inputAuthor = document.querySelector('input[name="author"]');
  let submitBtn = document.querySelector("div#form button");
  let updateId;
  let formHeader = document.querySelector("div#form h3");

  loadBooksBtn.addEventListener("click", loadAllBooks);
  submitBtn.addEventListener("click", submitNewBook);

  async function submitNewBook() {
    let title = inputTitle.value;
    let author = inputAuthor.value;

    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({ author, title }),
    };

    let url = BASE_URL;

    if (submitBtn.textContent === "Save") {
      httpHeaders.method = "PUT";
      url += updateId;
    }

    let response = await fetch(url, httpHeaders);
    
    if (formHeader.textContent === "Edit FORM") {
      formHeader.textContent = "FORM";
      submitBtn.textContent = "Submit";
    }
    inputTitle.value = "";
    inputAuthor.value = "";
    loadAllBooks();
    
  }

  async function loadAllBooks() {
    tbody.innerHTML = "";
    let promise = await fetch(BASE_URL);
    let data = await promise.json();

    for (const bookId in data) {
      let { author, title } = data[bookId];

      let newRow = document.createElement("tr");

      let bookTd = document.createElement("td");
      bookTd.textContent = title;

      let authorTd = document.createElement("td");
      authorTd.textContent = author;
      let buttonsTd = document.createElement("td");

      let editBtn = document.createElement("button");
      editBtn.id = bookId;
      editBtn.textContent = "Edit";
      editBtn.addEventListener("click", editRow);

      let deleteBtn = document.createElement("button");
      deleteBtn.id = bookId;
      deleteBtn.textContent = "Delete";
      deleteBtn.addEventListener("click", deleteRow);

      buttonsTd.appendChild(editBtn);
      buttonsTd.appendChild(deleteBtn);

      newRow.appendChild(bookTd);
      newRow.appendChild(authorTd);
      newRow.appendChild(buttonsTd);

      tbody.appendChild(newRow);
    }
  }

  async function editRow() {
    formHeader.textContent = "Edit FORM";
    submitBtn.textContent = "Save";
    updateId = this.id;

    let response = await fetch(BASE_URL + updateId);
    let data = await response.json();

    inputTitle.value = data.author;
    inputAuthor.value = data.title;
  }

  async function deleteRow() {
    let id = this.id;
    let httpHeaders = {
      method: "DELETE",
    };

    let response = await fetch(BASE_URL + id, httpHeaders);
    loadAllBooks();
  }
}

attachEvents();
