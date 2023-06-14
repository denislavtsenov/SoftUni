function addItem() {
  let newItemText = document.getElementById("newItemText");
  let newItemValue = document.getElementById("newItemValue");
  let menu = document.getElementById("menu");
  let textResult = newItemText.value + " " + newItemValue.value;

  let newOption = document.createElement("option");
  let optionText = document.createTextNode(textResult);

  newOption.appendChild(optionText);
  newOption.textContent = textResult;
  newOption.value = textResult;
  newItemText.value = '';
  newItemValue.value = '';

  menu.appendChild(newOption);
}
