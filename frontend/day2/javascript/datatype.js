var str = 'Hello';
var str2 = "Hello";
var isTrue = false;
var curr = undefined;
var ref = null;
var obj = {name:"kim", age:26};
var arr =[1,2,3,4];
var date = new Date();
console.log(str);
console.log(str2);
console.log(isTrue);
console.log(curr);
console.log(ref);
console.log(obj);
console.log(arr);
console.log(date);

console.log('----------------------------');
console.log( typeof str );
console.log( typeof(str2) );
console.log( typeof(num) );
console.log( typeof(isTrue) );
console.log( typeof(curr) );
console.log( typeof(ref) );
console.log( typeof(obj) );
console.log( typeof(arr) );
console.log( typeof(date) );

console.log('----------------------------');
var a;  // default 값으로 undefined
console.log( a ); // undifined

var b = null;
console.log( b ); // null
console.log( a == b ); // true; 값이 없는 것들이다.
console.log( a === b ); // false;
console.log( typeof( a )); // undifined