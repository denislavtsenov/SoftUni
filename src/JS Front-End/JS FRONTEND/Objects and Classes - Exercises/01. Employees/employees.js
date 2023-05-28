function employees(inputArr) {

    for (const person of inputArr) {
        console.log(`Name: ${person} -- Personal Number: ${person.length}`);
    }
}

employees([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
    )