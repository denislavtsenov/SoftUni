// TODO
function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  let inputTitle = document.getElementById('title'); 
  let addBtn = document.getElementById('add-button');
  let loadBtn = document.getElementById('load-button');

  // loadBtn.addEventListener('click', loadAll(e));

  // async function loadAll(e) {
  //   e.preventDefault();

  //   let response = await fetch(BASE_URL);
  //   let data = await response.json();

  //   console.log(data);
  // }

}

attachEvents();
