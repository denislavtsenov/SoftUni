window.addEventListener("load", solve);

function solve() {
  let title = document.getElementById("title");
  let description = document.getElementById("description");
  let label = document.getElementById("label");
  let points = document.getElementById("points");
  let assignee = document.getElementById("assignee");

  let taskSection = document.getElementById("tasks-section");
  let totalPoints = document.getElementById("total-sprint-points");

  let createTaskBtn = document.getElementById("create-task-btn");
  let deleteTaskBtn = document.getElementById("delete-task-btn");

  // let isOk = true;

  // if (
  //   title.value.length === 0 ||
  //   description.value.length === 0 ||
  //   points.value.length === 0 ||
  //   assignee.value.length === 0
  // ) {
  //   isOk = false;
  // }

  createTaskBtn.addEventListener("click", createTaskHandler);

  function createTaskHandler() {
    let newArticle = document.createElement("article");
    newArticle.id = "task-1";
    newArticle.className = "task-card";

    let divLabel = document.createElement("div");
    divLabel.className = "task-card-lavel feature";
    
    divLabel.textContent = label.textContent;

    let h3title = document.createElement("h3");
    h3title.className = "task-card-title";
    h3title.textContent = title.value;

    let pDesc = document.createElement("p");
    pDesc.className = "task-card-description";
    pDesc.textContent = description.value;

    let divPoints = document.createElement("div");
    divPoints.className = "task-card-points";
    divPoints.textContent = points.value;

    let divAssignee = document.createElement("div");
    divAssignee.className = "task-card-assignee";
    divAssignee.textContent = assignee.value;

    let divActions = document.createElement("div");
    divActions.className = "task-card-actions";

    let deleteBtn = document.createElement("button");
    deleteBtn.textContent = "Delete";
    deleteBtn.addEventListener("click", () => {
      deleteBtn.parentElement.parentElement.remove();
    });

    divActions.appendChild(deleteBtn);

    newArticle.appendChild(divLabel);
    newArticle.appendChild(h3title);
    newArticle.appendChild(pDesc);
    newArticle.appendChild(divPoints);
    newArticle.appendChild(divAssignee);
    newArticle.appendChild(divActions);

    taskSection.appendChild(newArticle);
  }
}
