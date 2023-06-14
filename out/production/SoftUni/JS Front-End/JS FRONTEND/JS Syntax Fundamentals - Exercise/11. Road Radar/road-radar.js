function solve(speed, area) {
  speed = Number(speed);

  let status;

  let diff;

  switch (area) {
    case "motorway":
      if (speed <= 130) {
        console.log(`Driving ${speed} km/h in a 130 zone`);
      } else {
        diff = speed - 130;

        if (speed <= 150) {
          status = "speeding";
        } else if (speed > 150 && speed <= 170) {
          status = "excessive speeding";
        } else {
          status = "reckless driving";
        }

        console.log(
          `The speed is ${diff} km/h faster than the allowed speed of 130 - ${status}`
        );
      }
      break;

    case "interstate":
      if (speed <= 90) {
        console.log(`Driving ${speed} km/h in a 90 zone`);
      } else {
        diff = speed - 90;

        if (speed <= 110) {
          status = "speeding";
        } else if (speed > 110 && speed <= 130) {
          status = "excessive speeding";
        } else {
          status = "reckless driving";
        }

        console.log(
          `The speed is ${diff} km/h faster than the allowed speed of 90 - ${status}`
        );
      }
      break;

    case "city":
      if (speed <= 50) {
        console.log(`Driving ${speed} km/h in a 50 zone`);
      } else {
        diff = speed - 50;

        if (speed <= 70) {
          status = "speeding";
        } else if (speed > 70 && speed <= 90) {
          status = "excessive speeding";
        } else {
          status = "reckless driving";
        }

        console.log(
          `The speed is ${diff} km/h faster than the allowed speed of 50 - ${status}`
        );
      }
      break;

    case "residential":
      if (speed <= 20) {
        console.log(`Driving ${speed} km/h in a 20 zone`);
      } else {
        diff = speed - 20;

        if (speed <= 40) {
          status = "speeding";
        } else if (speed > 40 && speed <= 60) {
          status = "excessive speeding";
        } else {
          status = "reckless driving";
        }

        console.log(
          `The speed is ${diff} km/h faster than the allowed speed of 20 - ${status}`
        );
      }
      break;
  }
}

