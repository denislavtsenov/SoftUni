function colorize() {
  let allTableRows = Array.from(document.querySelectorAll("tr"));
  allTableRows.shift();

  for (let index = 0; index < allTableRows.length; index++) {
    
    if (index % 2 === 0) {
        allTableRows[index].style.backgroundColor = "teal";
      }
    
  }
}

