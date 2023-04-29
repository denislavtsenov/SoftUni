function focused() {
  let allInputs = Array.from(document.querySelectorAll("input"));

  for (let input of allInputs) {
    input.addEventListener("focus", (event) => {
      event.currentTarget.parentElement.className = "focused";
    });

    input.addEventListener("blur", (event) => {
      event.currentTarget.parentElement.className = "";
    });
  }
}
