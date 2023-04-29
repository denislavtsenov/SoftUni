function solve() {
  let input = document.getElementById("input").value;
  let output = document.getElementById("output");

  let inputArr = input.split(".");
  inputArr.pop();

  while (inputArr.length > 0) {
    let oneP = inputArr.splice(0, 3)
    .map(p => p.trimStart());

    let p = document.createElement("p");
    p.textContent = oneP.join(".") + '.';

    output.appendChild(p);
  }
}
