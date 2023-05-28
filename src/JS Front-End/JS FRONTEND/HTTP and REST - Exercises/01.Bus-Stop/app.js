async function getInfo() {
  let stopId = document.getElementById("stopId").value;
  let stopName = document.getElementById("stopName");
  let busesContainter = document.getElementById("buses");
  let output = document.getElementById("result");
  let BASE_URL = "http://localhost:3030/jsonstore/bus/businfo/";

  try {
    const response = await fetch(BASE_URL + stopId);
    output.replaceChildren();

    if (response.ok === false) {
      let error = await response.json();
      throw error;
    }

    let data = await response.json();
    let {name, buses} = data;

    stopName.textContent = name;

    for (const busId in buses) {
      let li = document.createElement("li");
      li.textContent = `Bus ${busId} arrives in ${buses[busId]} minutes`;
      busesContainter.appendChild(li);
    }
    output.appendChild(stopName);
    output.appendChild(busesContainter);
  } catch (error) {
    stopName.textContent = "Error";
    output.appendChild(stopName);
  }
}
