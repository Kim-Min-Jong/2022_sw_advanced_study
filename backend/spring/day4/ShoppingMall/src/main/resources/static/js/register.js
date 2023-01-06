window.onload = function(){

    document.querySelector("#userName").focus();

    // manually check
    document.querySelector("#userName").onblur = function () {
        if (validateUserName( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userPassword").onblur = function () {
        if (validatePassword( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userPassword2").onblur = function () {
        if (validatePassword2( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userEmail").onblur = function () {
        if (validateEmail( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector('input').onfocus = function () {
        this.classList.remove('is-valid', 'is-invalid');
    };

    //submit
    document.querySelector("#btnRegister").onclick = function(){
        if( document.querySelectorAll("form .is-invalid").length > 0 ){
            alert("입력이 올바르지 않습니다.")
        }else{
            register();
        }
    };

}

// jQuery 버전과 비교해서 element 가 아니라 value 를 전달한다.
function validateUserName(userName) {

    if (userName.length > 0) return true;
    else return false;
}

function validatePassword(userPassword) {

    var patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// + for at least one

    if( patternSpeAtListOne.test( userPassword ) && userPassword.length >= 8 ){
        return true;
    }
    else return false;
}

function validatePassword2(userPassword2) {
    if (userPassword2 == document.querySelector("#userPassword").value ) return true;
    else return false;
}

function validateEmail(userEmail) {
    // ^ 시작일치, $ 끝 일치
    // {2, 3} 2개 ~ 3개
    // * 0회 이상, + 1회 이상
    // [-_.] - 또는 _ 또는 .
    // ? 없거나 1회
    let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regexp.test(userEmail)) return true;
    else return false;
}

async function register() {

    var userName = document.querySelector("#userName").value;
    var userPassword = document.querySelector("#userPassword").value;
    var userEmail = document.querySelector("#userEmail").value;

    let urlParams = new URLSearchParams({
        userName: userName,
        userEmail: userEmail,
        userPassword: userPassword,
    });

    let fetchOptions = {
        method: "POST",
        body: urlParams,
    }

    let response = await fetch("/register", fetchOptions);
    console.log(response);
    let data = await response.json();
    if( data.result == "success" ){
        alertify.alert('Welcome!', '회원가입을 축하합니다. 로그인 페이지로 이동합니다.', function(){
            window.location.href="/login";
        });
    }else if( data.result == "fail" ){
        alert("서버 오류!!");
    }
}