function solve(input) {
  let n = Number(input.shift());

  let assigneeObj = [];

  for (let index = 0; index < n; index++) {
    let tokens = input.shift().split(":");
    let name = tokens[0];
    let taksId = tokens[1];
    let title = tokens[2];
    let status = tokens[3];
    let points = tokens[4];

    let currentObj = {
      name: name,
      taksId: [{ taksId, title, status, points }],
    };

    // for (const [name, taksId] of Object.entries(currentObj)) {
    //     console.log(`${name} -> ${taksId}`);
    // }

    assigneeObj.push(currentObj);
  }
  //   for (const obj of assigneeObj) {
  //       console.log(obj.taksId[0]);
  //   }

  for (const line of input) {
    let tokens = line.split(":");
    let command = tokens[0];
    let name = tokens[1];

    let isExists = false;

    let currentObj;
    for (const obj of assigneeObj) {
      if (obj.name === name) {
        isExists = true;
        currentObj = obj;
      }
    }

    if (command === "Add New") {
      if (isExists) {
        let taskId = tokens[2];
        let title = tokens[3];
        let status = tokens[4];
        let points = tokens[5];
        let newTask = { taskId, title, status, points };
        currentObj.taksId.push(newTask);
      } else {
        console.log(`Assignee ${name} does not exist on the board!`);
      }
    } else if (command === "Change Status") {
      if (isExists) {
        let id = tokens[1];
        let newStatus = tokens[2];
        let currentObjTask = currentObj.taksId;

        for (const task of currentObjTask) {
          if (task.taksId === id) {
            task.status = newStatus;
          } else {
            console.log(`Task with ID ${id} does not exist for ${name}!`);
          }
        }
      } else {
        console.log(`Assignee ${name} does not exist on the board!`);
      }
    } else if (command === "Remove Taks") {
      if (isExists) {
        let index = tokens[2];

        if (currentObj.taksId.length < index) {
            console.log("Index is out of range!");
        } else {
            currentObj.taksId.splice(index, 1);
        }
      } else {
        console.log(`Assignee ${name} does not exist on the board!`);
      }
    }
  }

  for (const obj of assigneeObj) {
    console.log(obj);
  }
}

solve([
  "5",
  "Kiril:BOP-1209:Fix Minor Bug:ToDo:3",
  "Mariya:BOP-1210:Fix Major Bug:In Progress:3",
  "Peter:BOP-1211:POC:Code Review:5",
  "Georgi:BOP-1212:Investigation Task:Done:2",
  "Mariya:BOP-1213:New Account Page:In Progress:13",
  "Add New:Kiril:BOP-1217:Add Info Page:In Progress:5",
  "Change Status:Peter:BOP-1290:ToDo",
  "Remove Task:Mariya:1",
  "Remove Task:Joro:1",
]);
