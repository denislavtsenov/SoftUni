function arrayRotation(arr, numberOfRotations) {
 
   
    for (let index = 0; index < numberOfRotations; index++) {
      let num = Number(arr.shift());
      arr.push(num);
    }
  

  console.log(arr.join(" "));
}

