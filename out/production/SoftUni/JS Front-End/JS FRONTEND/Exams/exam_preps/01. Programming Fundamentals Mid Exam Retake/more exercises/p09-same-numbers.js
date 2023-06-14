function sameNumbers(input){
    input = String(input);
let numArr = input.split('');

let searchNum = numArr[0];
let isSame = true;
let sum = 0;

for (const num of numArr) {
    sum += Number(num);
    if (num !== searchNum) {
        isSame = false;
    }
}

if (isSame) {
    console.log('true');
    console.log(sum)
} else {
    console.log('false');
    console.log(sum);
}

}

sameNumbers(1234);