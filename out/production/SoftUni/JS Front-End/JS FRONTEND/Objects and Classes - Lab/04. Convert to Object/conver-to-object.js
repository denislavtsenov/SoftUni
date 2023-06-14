function convertToObj(objAsJson) {
    let person = JSON.parse(objAsJson);

    for (const key in person) {
        console.log(`${key}: ${person[key]}`);
    }
}



convertToObj('{"name": "George", "age": 40, "town": "Sofia"}');