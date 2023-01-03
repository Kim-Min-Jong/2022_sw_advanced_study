// 셋 다 기능은 비슷하지만 형식만 다름
// 1. 함수 만들어서 html태그 onclick등 속성에 삽입
// 2. dom의 onclick 메소드 사용
// 3. eventlistener 직접 등록
function fun1(){
    document.querySelector("#title").innerText = "제목이 변경되었습니다.";
}

document.querySelector("#btn2").onclick = function(){
    document.querySelector("#content").innerText = "내용이 변경되었습니다.";
};

document.querySelector("#btn3").addEventListener("click", function(){
    document.querySelector("#content").style.border = "1px solid blue";
});
document.querySelector("#content").addEventListener("mouseover", function(){
    document.querySelector("#content").style.border = "5px solid blue";
});
document.querySelector("#content").addEventListener("mouseout", function(){
    document.querySelector("#content").style.border = "5px solid red";
});
