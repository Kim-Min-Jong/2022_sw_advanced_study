// #1 object property
let book = {
    name : "Javascript",
    author : "삐따기",
    price : 20000,
}

console.log(book);
console.log(book.price);

// #2 object with function
let book1 = {
    name : "Javascript",
    author : "삐따기",
    price : 20000,
    getPrice: function(){
        return this.price;
    }
}

console.log(book1);
console.log(book1.getPrice());
alert(book1); // alert 로는 내용 확인이 어렵다.

// #3
// arrow function 은 this biding X
let book2 = {
    name: "Javascript",
    author: "삐따기",
    price: 20000,
    getPrice: () => {
        return this.price;
    }
}

console.log(book2.getPrice());