function solve(inputArr) {

    inputArr.sort((a, b) => a.length - b.length || 
    a.localeCompare(b));

   console.log(inputArr.join('\n'));
}

solve(["alpha", "beta", "gamma"]);
