function attachEvents() {
  let tableBody = document.querySelector("tbody");
  let firstNameInput = document.querySelector('input[name="firstName"]');
  let lastNameInput = document.querySelector('input[name="lastName"]');
  let facultyNumberInput = document.querySelector(
    'input[name="facultyNumber"]'
  );
  let gradeInput = document.querySelector('input[name="grade"]');
  let BASE_URL = "http://localhost:3030/jsonstore/collections/students/";

  let notification = document.querySelector("p.notification");
  let submitBtn = document.getElementById("submit");

  
  async function loadAllStudents() {
    let response = await fetch(BASE_URL);
    let data = await response.json();
    data = Object.values(data);

    for (const { firstName, lastName, facultyNumber, grade, _id } of data) {
      let newRow = document.createElement("tr");

      let tdFirstName = document.createElement("td");
      tdFirstName.textContent = firstName;

      let tdLastName = document.createElement("td");
      tdLastName.textContent = lastName;

      let tdFacultyNum = document.createElement("td");
      tdFacultyNum.textContent = facultyNumber;

      let tdGrade = document.createElement("td");
      tdGrade.textContent = grade;

      newRow.appendChild(tdFirstName);
      newRow.appendChild(tdLastName);
      newRow.appendChild(tdFacultyNum);
      newRow.appendChild(tdGrade);

      tableBody.appendChild(newRow);
    }
  }

  submitBtn.addEventListener("click", submitNewStudent);

  async function submitNewStudent() {
    tableBody.innerHTML = "";
    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let facultyNumber = facultyNumberInput.value;
    let grade = gradeInput.value;

    try {
      if (
        firstName.trim().length < 0 ||
        lastName.trim().length < 0 ||
        facultyNumber.trim().length < 0 ||
        grade.trim().length < 0
      ) {
        throw new Error();
      }

      let httpHeaders = {
        method: "POST",
        body: JSON.stringify({ firstName, lastName, facultyNumber, grade }),
      };

      let response = await fetch(BASE_URL, httpHeaders);
      let data = await response.json();

      loadAllStudents();

      firstNameInput.value = "";
      lastNameInput.value = "";
      facultyNumberInput.value = "";
      gradeInput.value = "";
    } catch (error) {
      notification.textContent = "Error";
    }
  }

  loadAllStudents();
}

attachEvents();
