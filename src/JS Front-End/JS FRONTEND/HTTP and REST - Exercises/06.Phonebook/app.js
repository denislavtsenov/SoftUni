function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/phonebook/";
  let phonebookContainer = document.getElementById("phonebook");
  let loadBtn = document.getElementById("btnLoad");
  let personInput = document.getElementById("person");
  let phoneInput = document.getElementById("phone");
  let createBtn = document.getElementById("btnCreate");

  loadBtn.addEventListener("click", loadPhoneBookHandler);
  createBtn.addEventListener("click", createNew);

  async function loadPhoneBookHandler() {
    phonebookContainer.textContent = "";

    let response = await fetch(BASE_URL);
    let data = await response.json();
    data = Object.values(data);

    for (const { person, phone, _id } of data) {
      let li = document.createElement("li");
      li.textContent = `${person}: ${phone}`;

      let deleteBtn = document.createElement("button");
      deleteBtn.textContent = "Delete";
      deleteBtn.id = _id;
      deleteBtn.addEventListener("click", deleteRow);

      li.appendChild(deleteBtn);
      phonebookContainer.appendChild(li);
    }
  }

  async function deleteRow() {
    let id = this.id;
    let httpHeaders = {
      method: "DELETE",
    };

    let response = await fetch(BASE_URL + id, httpHeaders);
    loadPhoneBookHandler();
  }

  async function createNew() {
    let person = personInput.value;
    let phone = phoneInput.value;

    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({ person, phone }),
    };

    const response = await fetch(BASE_URL, httpHeaders);
    let data = response.json();
    loadPhoneBookHandler();
    personInput.value = "";
    phoneInput.value = "";
    return data;
  }
}

attachEvents();
