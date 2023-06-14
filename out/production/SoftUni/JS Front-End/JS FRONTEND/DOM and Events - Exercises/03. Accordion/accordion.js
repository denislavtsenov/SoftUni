function toggle() {
  let btn = document.querySelector("span");
  let extraText = document.getElementById("extra");

  if (extraText.style.display === "none") {
    extraText.style.display = "block";
    btn.textContent = "Less";
  } else {
    extraText.style.display = "none";
    btn.textContent = "More";
  }
}
