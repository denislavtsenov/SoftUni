function solve() {
  document.querySelector("#searchBtn").addEventListener("click", onClick);
  
  
  function onClick() {
     let input = document.getElementById("searchField").value;
     let allBodyRows = Array.from(document.querySelector("tbody").children);
     allBodyRows.forEach((row) => (row.className = ""));
    for (const row of allBodyRows) {
      let rowChildren = Array.from(row.children);

      for (let child of rowChildren) {
        if (child.textContent.includes(input)) {
          row.className = "select";
        }
      }
    }
  }
}
