function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/messenger/";
  let messagesArea = document.getElementById("messages");
  let inputName = document.querySelector('input[name="author"]');
  let inputMessage = document.querySelector('input[name="content"]');

  let submitBtn = document.getElementById("submit");
  let refreshBtn = document.getElementById("refresh");

  submitBtn.addEventListener("click", submitMsg);
  refreshBtn.addEventListener("click", refreshPage);

  async function refreshPage() {
    let response = await fetch(BASE_URL);
    let data = await response.json();
    data = Object.values(data);

    let textArea = document.createElement("textarea");

    for (const { author, content } of data) {
      textArea.textContent += `${author}: ${content}\n`;
    }

    messagesArea.textContent = textArea.textContent.trim();
  }

  async function submitMsg() {
    let author = inputName.value;
    let content = inputMessage.value;
    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({ author, content }),
    };
  

    const response = await fetch(BASE_URL, httpHeaders);
    let data = response.json();
    return data;
  }
}

attachEvents();
