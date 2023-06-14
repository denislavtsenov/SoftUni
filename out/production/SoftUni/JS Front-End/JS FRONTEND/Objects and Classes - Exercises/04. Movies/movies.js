function moviesParser(inputArr) {
  let movies = [];

  for (let index = 0; index < inputArr.length; index++) {
    if (inputArr[index].split(" ")[0] === "addMovie") {
      let currentLine = inputArr[index].split(" ");
      currentLine.shift();

      let movieName = currentLine.join(" ");
      movies.push(movieName);

      console.log(movies);
    } else if (inputArr[1] === "directedBy") {
    } else {
    }
  }
}

moviesParser([
  "addMovie Fast and Furious",
  "addMovie Godfather",
  "Inception directedBy Christopher Nolan",
  "Godfather directedBy Francis Ford Coppola",
  "Godfather onDate 29.07.2018",
  "Fast and Furious onDate 30.07.2018",
  "Batman onDate 01.08.2018",
  "Fast and Furious directedBy Rob Cohen",
]);
