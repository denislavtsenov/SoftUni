function pascalCaseSplitter(input) {
  input = input.replace(/([A-Z][a-z])/g, " $1").replace(/([A-Z][0-9])/g, " $1")
  .replace(/([A-Z][!@#$%^&*<>.,?+=-\\])/g, " $1");

  input = input.trim();
  let arr = input.split(" ");
  console.log(arr.join(", "));
}
