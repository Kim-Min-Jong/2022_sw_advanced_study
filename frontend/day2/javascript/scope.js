//global
var a = 5;

let b = 10;

const c = 100;

// scope
{
    let b = 20;
    console.log(b);
    {
        let b = 30;
        console.log(b);
    }

    // let 은 같은 scope에서 중복해서 쓸 수 없음, 다른 scope면 가능
    // let b = 30; --> error

    const c = 200;
    console.log(c);

    var a = 55;
}

// 55 출력 -> 전역변수 이므로 scope내부에서 새로 선언해도 바깥에서도 바뀜
console.log(a)

// 10 출력 -> scope에 영향을 받음
console.log(b);