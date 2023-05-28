function create(words) {
  let parrentDiv = document.getElementById("content");

  for (let word of words) {
    let p = document.createElement("p");
    p.style.display = "none";
    p.textContent = word;

    let myDiv = document.createElement("div");
    myDiv.appendChild(p);

    myDiv.addEventListener("click", () => {
      p.style.display = "";
    });

    parrentDiv.appendChild(myDiv);
  }
}
