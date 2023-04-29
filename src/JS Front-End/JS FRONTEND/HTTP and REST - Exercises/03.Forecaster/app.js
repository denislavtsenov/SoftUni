function attachEvents() {
  let inputLocation = document.querySelector("input#location");
  let weatherBtn = document.querySelector("input#submit");
  let forecastContainer = document.querySelector("div#forecast");
  let currentContainer = document.querySelector("div#current");
  let upcomingContainer = document.querySelector("div#upcoming");

  const LOCATIONS_URL = "http://localhost:3030/jsonstore/forecaster/locations/";
  const TODAY_URL = "http://localhost:3030/jsonstore/forecaster/today/";
  const UPCOMING_URL = "http://localhost:3030/jsonstore/forecaster/upcoming/";

  weatherBtn.addEventListener("click", locationHandler);

  async function locationHandler() {
    try {
      let response = await fetch(LOCATIONS_URL);
      let data = await response.json();
      data = Object.values(data);
      let currentCode = "";

      for (const { code, name } of data) {
        if (name === inputLocation.value) {
          currentCode = code;
          break;
        }
      }

      if (response.ok === false || currentCode.trim().length < 0) {
        let error = await response.json();
        throw error;
      }

      forecastContainer.style.display = "block";
      let today = await fetch(TODAY_URL + currentCode);
      let todayData = await today.json();

      let todayCondSymbol = "";
      let todayCondition = todayData.forecast.condition;
      let todayLow = todayData.forecast.low;
      let todayHigh = todayData.forecast.high;

      switch (todayCondition) {
        case "Sunny":
          todayCondSymbol = "☀";
          break;
        case "Partly sunny":
          todayCondSymbol = "⛅";
          break;
        case "Overcast":
          todayCondSymbol = "☁";
          break;
        case "Rain":
          todayCondSymbol = "☂";
          break;
      }

      let forecasts = document.createElement("div");
      forecasts.className = "forecasts";

      let spanConditions = document.createElement("span");
      spanConditions.className = "condition";
      spanConditions.textContent = "";

      let spanName = document.createElement("span");
      spanName.className = "forecast-data";
      spanName.textContent = todayData.name;

      let spanTemp = document.createElement("span");
      spanTemp.className = "forecast-data";
      spanTemp.innerHTML = `${todayLow}&#176;/${todayHigh}&#176;`;

      let spanCond = document.createElement("span");
      spanCond.className = "forecast-data";
      spanCond.textContent = todayCondition;

      let spanCondSymbol = document.createElement("span");
      spanCondSymbol.className = "condition symbol";
      spanCondSymbol.textContent = todayCondSymbol;

      spanConditions.appendChild(spanName);
      spanConditions.appendChild(spanTemp);
      spanConditions.appendChild(spanCond);

      forecasts.appendChild(spanCondSymbol);
      forecasts.appendChild(spanConditions);

      currentContainer.appendChild(forecasts);

      let upcomingResp = await fetch(UPCOMING_URL + currentCode);
      let upcomingData = await upcomingResp.json();

      for (const { condition, low, high } of upcomingData.forecast) {
        let upcomingConditionSymbol = "";
        switch (condition) {
          case "Sunny":
            upcomingConditionSymbol = "☀";
            break;
          case "Partly sunny":
            upcomingConditionSymbol = "⛅";
            break;
          case "Overcast":
            upcomingConditionSymbol = "☁";
            break;
          case "Rain":
            upcomingConditionSymbol = "☂";
            break;
        }

        let upcomingSpan = document.createElement("span");
        upcomingSpan.className = "upcoming";

        let spanUpSymbol = document.createElement("span");
        spanUpSymbol.className = "symbol";
        spanUpSymbol.textContent = upcomingConditionSymbol;

        let spanUpTemp = document.createElement("span");
        spanUpTemp.className = "forecast-data";
        spanUpTemp.innerHTML = `${low}&#176;/${high}&#176;`;

        let spanUpCondition = document.createElement("span");
        spanUpCondition.className = "forecast-data";
        spanUpCondition.textContent = condition;

        upcomingSpan.appendChild(spanUpSymbol);
        upcomingSpan.appendChild(spanUpTemp);
        upcomingSpan.appendChild(spanUpCondition);

        let upcomingFcInfo = document.createElement("div");
        upcomingFcInfo.className = "forecast-info";
        upcomingFcInfo.appendChild(upcomingSpan);

        let upcomingParent = document.querySelector("div#upcoming");
        upcomingParent.appendChild(upcomingFcInfo);
      }
    } catch (error) {
      forecastContainer.innerHTML = "Error";
    }
  }
}

attachEvents();
