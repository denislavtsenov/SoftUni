function meetings(arrOfStrings) {
  let weekDays = {};

  for (const line of arrOfStrings) {
    let tokens = line.split(" ");
    let day = tokens[0];
    let name = tokens[1];

    if (weekDays.hasOwnProperty(day)) {
      console.log(`Conflict on ${day}!`);
    } else {
      weekDays[day] = name;
      console.log(`Scheduled for ${day}`);
    }
  }

  for (const key in weekDays) {
    console.log(`${key} -> ${weekDays[key]}`);
  }
}

meetings(["Monday Peter", "Wednesday Bill", "Monday Tim", "Friday Tim"]);
