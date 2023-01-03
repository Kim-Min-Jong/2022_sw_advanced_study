// let obj = {
//     name:'111',
//     fun: function() { 
//         console.log(this)
//         console.log(this.name)}
// }
// obj.fun();

// const myFunc2 = () => {
//     var aaa = 10;
//     aaa++;
//     return aaa;
// }

// console.log( myFunc2() )

// // advanced / firstClassFunction.html 도 참고

// // normal
// function add_1( a, b ){
//     return a + b;
// }

// // anonymous with variable
// var add_2 = function( a, b ){
//     return a + b;
// }

// // with new
// var add_3 = new Function( 'a', 'b', 'return a + b' );

// console.log( add_1( 10, 20 ) );
// console.log( add_2( 30, 40 ) );
// console.log( add_3( 50, 60 ) );

// // as parameter
// function add_4( a, b, func ){
//     let ret = func(a, b);
//     return ret;
// }
// // 아래와 같이 callback 으로 활용 가능 설명
// // function add_4( a, b, func1, func2 ){
// //     // 서버 요청
// //     // 결과 정상 - func1
// //     // 결과 오류 - func2
// //     let ret = func( a, b );
// //     return ret;
// // }

// console.log( add_4(20, 40, add_2) ); // add_1, add_2, add_3 모두 가능

// // as return 
// function myFunc(){
//     // #1
//     const add_5 = function( a, b ){
//         return a + b;
//     }
//     return add_5;
//     // #2
//     // return function( a, b ){
//     //     return a + b;
//     // }
// }

// const add_param = myFunc();
// console.log( add_param(20, 100));

// // 일급 객체 (first class object 변수에 할당, 파라미터, 리턴 3가지 만족)






  // normal function
function print( a ){
    console.log( a );
}

print( 0 );
print( "normal" );

// arrow 1
var print = ( a ) => console.log ( a );

print( 1 );
print( "arrow 1" );

// arrow 2 : no ()
var print = a => { console.log ( a ); }
print( 2 );
print( "arrow 2" );

// arrow 3 : ()
var print = () => { console.log ( "arrow 3" ); }
print();

// arrow 4 : statement simple
var print = () => console.log ( "arrow 4-1" ); console.log ( "arrow 4-2" ); // 4-2 는 별개
print();

// arrow 5 : return simple
var add = ( a, b ) => a + b;
console.log( add( 2, 3 ) );

// this !!!! 주의!!!!
// this : function 이 정의된 객체
const obj = {
    num: 5,
    print: function(){
        console.log(this.num);
    }
    // print: () => {
    //     console.log(this.num); // undefined
    //     console.log(this); // obj 의 상위 => window
    // }
}

obj.print();

function test(){
    console.log(this); // window
}