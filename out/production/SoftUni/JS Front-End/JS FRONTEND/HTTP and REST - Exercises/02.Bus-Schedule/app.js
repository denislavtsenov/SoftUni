function solve() {
  let departBtn = document.getElementById("depart");
  let arriveBtn = document.getElementById("arrive");
  let result = document.querySelector("span.info");
  const BASE_URL = "http://localhost:3030/jsonstore/bus/schedule/";
  let id = "depot";
  let nameOfStation = "";

  async function depart() {
    result.textContent = "GOSHO";
    console.log(result);
    try {
      let response = await fetch(BASE_URL + id);

      if (response.ok === false) {
        let error = await response.json();
        throw error;
      }

      let data = await response.json();
      let { name, next } = data;
      nameOfStation = name;
      id = next;
      result.innerHTML = `Next stop ${nameOfStation}`;
      departBtn.disabled = true;
      arriveBtn.disabled = false;

      console.log(`${name} - ${next} -> ID: ${id}`);
      console.log(result);
    } catch (error) {
      console.log(error);
    }
  }

  async function arrive() {
    departBtn.disabled = false;
    arriveBtn.disabled = true;
    result.innerHTML = `Arriving at ${nameOfStation}`;
  }

  return {
    depart,
    arrive,
  };
}

let result = solve();
