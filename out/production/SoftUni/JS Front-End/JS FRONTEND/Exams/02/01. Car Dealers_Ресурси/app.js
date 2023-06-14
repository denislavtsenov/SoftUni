window.addEventListener("load", solve);

function solve() {
  let make = document.getElementById("make");
  let model = document.getElementById("model");
  let year = document.getElementById("year");
  let fuel = document.getElementById("fuel");
  let originalCost = document.getElementById("original-cost");
  let sellingPrice = document.getElementById("selling-price");
  let tableBody = document.getElementById("table-body");

  let carList = document.getElementById("cars-list");

  let publishBtn = document.getElementById("publish");

  publishBtn.addEventListener("click", (event) => {
    event.preventDefault();

    if (
      make.value !== "" &&
      model.value !== "" &&
      year.value !== "" &&
      fuel.value !== "" &&
      originalCost.value !== "" &&
      sellingPrice.value !== "" &&
      Number(originalCost.value) < Number(sellingPrice.value)
    ) {
      let currentRow = document.createElement("tr");
      currentRow.className = "row";

      let tdMake = document.createElement("td");
      tdMake.textContent = make.value;

      let tdModel = document.createElement("td");
      tdModel.textContent = model.value;

      let tdYear = document.createElement("td");
      tdYear.textContent = year.value;

      let tdFuel = document.createElement("td");
      tdFuel.textContent = fuel.value;

      let tdOriginalCost = document.createElement("td");
      tdOriginalCost.textContent = originalCost.value;

      let tdSellingPrice = document.createElement("td");
      tdSellingPrice.textContent = sellingPrice.value;

      let editBtn = document.createElement("button");
      editBtn.className = "action-btn edit";
      editBtn.textContent = "Edit";
      editBtn.addEventListener("click", () => {
        make.value = tdMake.textContent;
        model.value = tdModel.textContent;
        year.value = tdYear.textContent;
        fuel.value = tdFuel.textContent;
        originalCost.value = tdOriginalCost.textContent;
        sellingPrice.value = tdSellingPrice.textContent;

        currentRow.remove();
      });

      let sellBtn = document.createElement("button");
      sellBtn.className = "action-btn sell";
      sellBtn.textContent = "Sell";
      sellBtn.addEventListener("click", () => {
        let li = document.createElement("li");
        li.className = "each-list";

        let spanModel = document.createElement("span");
        spanModel.innerHTML = `${tdMake.textContent} ${tdModel.textContent}`;

        let spanYear = document.createElement("span");
        spanYear.innerHTML = `${tdYear.textContent}`;

        let spanProfit = document.createElement("span");

        let currentProfit =
          Number(tdSellingPrice.textContent) -
          Number(tdOriginalCost.textContent);

        spanProfit.innerHTML = currentProfit;

        let totalProfit = document.getElementById("profit").textContent;
        let profitNum = Number(totalProfit);

        let sum = profitNum + currentProfit;
        document.getElementById("profit").textContent = sum.toFixed(2);

        li.appendChild(spanModel);
        li.appendChild(spanYear);
        li.appendChild(spanProfit);

        carList.appendChild(li);
        currentRow.remove();
      });

      let tdButtons = document.createElement("td");
      tdButtons.appendChild(editBtn);
      tdButtons.appendChild(sellBtn);

      currentRow.appendChild(tdMake);
      currentRow.appendChild(tdModel);
      currentRow.appendChild(tdYear);
      currentRow.appendChild(tdFuel);
      currentRow.appendChild(tdOriginalCost);
      currentRow.appendChild(tdSellingPrice);
      currentRow.appendChild(tdButtons);

      tableBody.appendChild(currentRow);

      make.value = "";
      model.value = "";
      year.value = "";
      fuel.value = "";
      originalCost.value = "";
      sellingPrice.value = "";
    }
  });
}
