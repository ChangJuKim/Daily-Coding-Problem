/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a
 single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic 
characters. You can assume the string to be decoded is valid.
*/

function repeat(textToRepeat: string, num: number) {
    let text = '';
    for (let i = 0; i < num; i++) {
        text += textToRepeat;
    }
    return text;
}

function runLengthEncoding(text: string) {
    if (text.length === 0) {
        return '';
    }
    let count = 0;
    let currentChar = text[0];
    let code = '';
    for (let i = 0; i < text.length; i++) {
        if (currentChar !== text[i]) {
            code += count + currentChar;
            currentChar = text[i];
            count = 1;
        } else {
            count += 1;
        }
    }
    code += count + currentChar;
    return code;
}

function runLengthDecoding(code: string) {
    if (code.length === 0) {
        return '';
    }
    // Giving errors for some reason
    let regexAry = code.match(/[0-9]+[a-zA-z]+/g);
    if (regexAry) {
        for (let i = 0; i < regexAry.length; i++) {
            console.log(regexAry[i]);
            /*
                Continue doing stuff
            */
        }
    }
}

runLengthDecoding("4A3B2C1D2A");
console.log("4A3B2C1D2A".match(/[0-9]+[a-zA-z]+/g));