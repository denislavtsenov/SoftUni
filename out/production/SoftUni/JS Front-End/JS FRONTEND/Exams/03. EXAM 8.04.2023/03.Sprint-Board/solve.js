// TODO:
function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  let loadBtn = document.getElementById("load-board-btn");
  let createTaskBtn = document.getElementById("create-task-btn");
  let toDoSection = document.getElementById("todo-section");
  let inProgressSection = document.getElementById("in-progress-section");
  let codeReviewSection = document.getElementById("code-review-section");
  let doneSection = document.getElementById("done-section");

  loadBtn.addEventListener("click", loadTasks);
  createTaskBtn.addEventListener("click", createNewTask);

  async function createNewTask(e) {
    e.preventDefault();
    let title = document.getElementById("title").value;
    let description = document.getElementById("description").value;
    let status = "ToDo";

    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({ title, description, status }),
    };

    await fetch(BASE_URL, httpHeaders);
    loadTasks();

    document.getElementById("title").value = "";
    document.getElementById("description").value = "";
  }

  async function loadTasks() {
    toDoSection.innerHTML = "";
    inProgressSection.innerHTML = "";
    codeReviewSection.innerHTML = "";
    doneSection.innerHTML = "";

    let response = await fetch(BASE_URL);
    let data = await response.json();
    data = Object.values(data);

    for (const { title, description, status, _id } of data) {
      let li = document.createElement("li");
      li.className = "task";

      li.id = _id;

      let h3 = document.createElement("h3");
      h3.textContent = title;

      let p = document.createElement("p");
      p.textContent = description;

      li.appendChild(h3);
      li.appendChild(p);

      let button = document.createElement("button");

      if (status === "ToDo") {
        button.textContent = "Move to In Progress";
        button.addEventListener("click", moveToInProgress);
        li.appendChild(button);
        toDoSection.appendChild(li);
      } else if (status === "In Progress") {
        button.textContent = "Move to Code Review";
        button.addEventListener("click", moveToInReview);
        li.appendChild(button);
        inProgressSection.appendChild(li);
      } else if (status === "Code Review") {
        button.textContent = "Move to Done";
        button.addEventListener("click", moveToDone);
        li.appendChild(button);
        codeReviewSection.appendChild(li);
      } else if (status === "Done") {
        button.textContent = "Close";
        button.addEventListener("click", deleteTask);
        li.appendChild(button);
        doneSection.appendChild(li);
      }
    }
  }

  async function deleteTask(e) {
    e.preventDefault();

    let id = e.currentTarget.parentElement.id;

    let httpHeaders = {
      method: "DELETE",
    };
    await fetch(BASE_URL + id, httpHeaders);
    loadTasks();
  }

  async function moveToInReview(e) {
    toDoSection.innerHTML = "";
    inProgressSection.innerHTML = "";
    codeReviewSection.innerHTML = "";
    doneSection.innerHTML = "";

    let id = e.currentTarget.parentElement.id;
    let status = (e.currentTarget.parentElement.status = "Code Review");

    let httpHeaders = {
      method: "PATCH",
      body: JSON.stringify({ status }),
    };

    await fetch(BASE_URL + id, httpHeaders);
    loadTasks();
  }

  async function moveToDone(e) {
    toDoSection.innerHTML = "";
    inProgressSection.innerHTML = "";
    codeReviewSection.innerHTML = "";
    doneSection.innerHTML = "";

    let id = e.currentTarget.parentElement.id;
    let status = (e.currentTarget.parentElement.status = "Done");

    let httpHeaders = {
      method: "PATCH",
      body: JSON.stringify({ status }),
    };

    await fetch(BASE_URL + id, httpHeaders);
    loadTasks();
  }

  async function moveToInProgress(e) {
    toDoSection.innerHTML = "";
    inProgressSection.innerHTML = "";
    codeReviewSection.innerHTML = "";
    doneSection.innerHTML = "";

    let id = e.currentTarget.parentElement.id;
    let status = (e.currentTarget.parentElement.status = "In Progress");
    console.log(status);

    let httpHeaders = {
      method: "PATCH",
      body: JSON.stringify({ status }),
    };

    await fetch(BASE_URL + id, httpHeaders);
    loadTasks();
  }
}

attachEvents();
