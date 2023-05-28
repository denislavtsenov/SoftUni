function sumTable() {
  let allTableRows = document.querySelectorAll("tr");

  let totalSum = document.getElementById("sum");
  let sum = 0;

  for (let index = 1; index < allTableRows.length; index++) {
    let currentRow = allTableRows[index];
    let currentRowChildren = currentRow.children;
    sum += Number(currentRowChildren[1].textContent);
  }

  totalSum.textContent = sum;
}
