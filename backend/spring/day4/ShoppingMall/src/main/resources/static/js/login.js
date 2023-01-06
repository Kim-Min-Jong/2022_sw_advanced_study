window.onload = function(){

    destroyUserInfo();

    document.querySelector("#btnLogin").onclick = function(){

        if( validate() ){
            login();
        }
    }
}

function validate(){
    var isUserEmailValid = false;
    var isUserPasswordValid = false;

    var userEmailValue = document.querySelector("#userEmail").value;
    var userEmailLength = userEmailValue.length;

    if( userEmailLength > 0 ){
        isUserEmailValid = true;
    }

    var userPasswordValue = document.querySelector("#userPassword").value;
    var userPasswordLength = userPasswordValue.length;

    if( userPasswordLength > 0 ){
        isUserPasswordValid = true;
    }

    if(   isUserEmailValid && isUserPasswordValid ){
        return true;
    }else{
        return false;
    }
}


async function login(){

    let userEmail = document.querySelector("#userEmail").value;
    let userPassword = document.querySelector("#userPassword").value;

    let urlParams = new URLSearchParams({
        userEmail: userEmail,
        userPassword: userPassword,
    });

    let fetchOptions = {
        method: "POST",
        body: urlParams,
    }

    let response = await fetch("/login", fetchOptions);
    console.log(response);
    let data = await response.json();
    if( data.result == "success" ){
        sessionStorage.setItem("userProfileImageUrl", data.userProfileImageUrl);
        window.location.href="/product"; // HomeController
    }else if( data.result == "fail" ){
        alert("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}
