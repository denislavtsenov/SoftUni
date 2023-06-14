window.addEventListener("load", solve);

function solve() {
  let inputGenre = document.getElementById("genre");
  let inputName = document.getElementById("name");
  let inputAuthor = document.getElementById("author");
  let inputDate = document.getElementById("date");
  let submitBtn = document.getElementById("add-btn");
  let allHitsContainer = document.querySelector(
    "section#all-hits div.all-hits-container"
  );

  let savedHitsContainer = document.querySelector(
    "section#saved-hits div.saved-container"
  );

  let totalLikes = document.querySelector("section#total-likes div.likes p");
  submitBtn.addEventListener("click", addToTheCollection);

  function addToTheCollection(e) {
    e.preventDefault();

    let isOk = true;

    if (
      inputGenre.value.trim().length === 0 ||
      inputName.value.trim().length === 0 ||
      inputAuthor.value.trim().length === 0 ||
      inputDate.value.trim().length === 0
    ) {
      isOk = false;
    }

    if (isOk) {
      let div = document.createElement("div");
      div.className = "hits-info";
      let img = document.createElement("img");
      img.src = "./static/img/img.png";

      let h2Genre = document.createElement("h2");
      h2Genre.textContent = `Genre: ${inputGenre.value}`;

      let h2Name = document.createElement("h2");
      h2Name.textContent = `Name: ${inputName.value}`;

      let h2Author = document.createElement("h2");
      h2Author.textContent = `Author: ${inputAuthor.value}`;

      let h3Date = document.createElement("h3");
      h3Date.textContent = `Date: ${inputDate.value}`;

      let saveBtn = document.createElement("button");
      saveBtn.className = "save-btn";
      saveBtn.textContent = "Save song";
      saveBtn.addEventListener("click", () => {
        let divSavedHits = allHitsContainer.children[1];
        saveBtn.remove();
        likeBtn.remove();
        console.log(divSavedHits);
        savedHitsContainer.appendChild(divSavedHits);
      });

      let likeBtn = document.createElement("button");
      likeBtn.className = "like-btn";
      likeBtn.textContent = "Like song";
      likeBtn.addEventListener("click", () => {
        let currentLikes = Number(totalLikes.textContent.split(" ")[2]);
        currentLikes = currentLikes + 1;
        totalLikes.textContent = `Total Likes: ${currentLikes}`;
        likeBtn.disabled = true;
      });

      let deleteBtn = document.createElement("button");
      deleteBtn.className = "delete-btn";
      deleteBtn.textContent = "Delete";
      deleteBtn.addEventListener("click", () => {
        div.parentElement.removeChild(div);
      });

      div.appendChild(img);
      div.appendChild(h2Genre);
      div.appendChild(h2Name);
      div.appendChild(h2Author);
      div.appendChild(h3Date);
      div.appendChild(saveBtn);
      div.appendChild(likeBtn);
      div.appendChild(deleteBtn);

      allHitsContainer.appendChild(div);

      inputGenre.value = "";
      inputName.value = "";
      inputAuthor.value = "";
      inputDate.value = "";
    }
  }
}
