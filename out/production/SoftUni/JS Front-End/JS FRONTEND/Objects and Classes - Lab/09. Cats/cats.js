function cats(arr) {

    for (const line of arr) {
        let tokens = line.split(' ');
        let name = tokens[0];
        let age = tokens[1];

        console.log(`${name}, age ${age} says Meow`);
    }
}


cats(['Mellow 2', 'Tom 5']);