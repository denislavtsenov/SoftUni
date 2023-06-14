window.addEventListener("load", solve);

function solve() {
  let firstNameInput = document.getElementById("first-name");
  let lastNameInput = document.getElementById("last-name");
  let ageInput = document.getElementById("age");
  let genderSelect = document.getElementById("genderSelect");
  let dishDescription = document.getElementById("task");
  let submitBtn = document.getElementById("form-btn");
  let progressCount = document.getElementById("progress-count");
  let clearBtn = document.getElementById("clear-btn");

  let finished = document.getElementById("finished");

  clearBtn.addEventListener("click", () => {
    finished.innerHTML = "";
  });

  submitBtn.addEventListener("click", (event) => {
    event.preventDefault();
    
    if (
      firstNameInput.value.length > 0 &&
      lastNameInput.value.length > 0 &&
      ageInput.value.length > 0 &&
      dishDescription.value.length > 0
    ) {
      let ul = document.getElementById("in-progress");

      let li = document.createElement("li");
      li.className = "each-line";

      let article = document.createElement("article");

      let h4 = document.createElement("h4");
      h4.textContent = `${firstNameInput.value} ${lastNameInput.value}`;

      let p = document.createElement("p");
      p.textContent = `${genderSelect.value}, ${ageInput.value}`;

      let pDesc = document.createElement("p");
      pDesc.textContent = `Dish description: ${dishDescription.value}`;

      let editBtn = document.createElement("button");
      editBtn.className = "edit-btn";
      editBtn.textContent = "Edit";
      editBtn.addEventListener("click", (event) => {
        event.preventDefault();
        let currentLi = Array.from(event.currentTarget.parentElement.children);

        let currentArticle = Array.from(currentLi[0].children);
        let names = currentArticle[0].textContent.split(" ");
        let genderAndAge = currentArticle[1].textContent.split(", ");
        let desc = pDesc.textContent.split(": ");
        // let desc = currentArticle[2].textContent.split(': ');
        desc.shift();

        firstNameInput.value = names[0];
        lastNameInput.value = names[1];
        ageInput.value = genderAndAge[1];
        genderSelect.value = genderAndAge[0];
        dishDescription.value = desc;

        let currentCount = Number(progressCount.textContent);
        progressCount.textContent = currentCount - 1;

        currentLi[0].parentElement.remove();
      });

      let completeBtn = document.createElement("button");
      completeBtn.className = "complete-btn";
      completeBtn.textContent = "Mark as complete";
      completeBtn.addEventListener("click", (event) => {
        event.preventDefault();

        finished.appendChild(li);
        editBtn.remove();
        completeBtn.remove();
        let currentCount = Number(progressCount.textContent);
        progressCount.textContent = currentCount - 1;
      });

      article.appendChild(h4);
      article.appendChild(p);
      article.appendChild(pDesc);

      li.appendChild(article);
      li.appendChild(editBtn);
      li.appendChild(completeBtn);

      ul.appendChild(li);

      let currentCount = Number(progressCount.textContent);
      progressCount.textContent = currentCount + 1;

      firstNameInput.value = "";
      lastNameInput.value = "";
      ageInput.value = "";
      dishDescription.value = "";
    }
  });
}
