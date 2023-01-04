window.onload = function () {
    // input 
    // val( data )
    document.querySelector("#setName").onclick = function () {
        document.querySelector("#userName").value = document.querySelector("#userData").value;
    };

    document.querySelector("#setEmail").onclick = function () {
        document.querySelector("#userEmail").value = document.querySelector("#userData").value;
    };

    document.querySelector("#setDesc").onclick = function () {
        document.querySelector("#desc").value = document.querySelector("#userData").value;
    };

    // radio
    document.querySelector("#setMale").onclick = function () {
        document.querySelector("#male").checked = true;
    };

    document.querySelector("#setFemale").onclick = function () {
        document.querySelector("#female").checked = true;
    };

    // checkbox
    document.querySelector("#setMovieOn").onclick = function () {
        document.querySelector("#movie").checked = true;
    };
    document.querySelector("#setMovieOff").onclick = function () {
        document.querySelector("#movie").checked = false;
    };

    document.querySelector("#setSportOn").onclick = function () {
        document.querySelector("#sport").checked = true;
    };
    document.querySelector("#setSportOff").onclick = function () {
        document.querySelector("#sport").checked = false;
    };

    document.querySelector("#setMungOn").onclick = function () {
        document.querySelector("#mung").checked = true;
    };
    document.querySelector("#setMungOff").onclick = function () {
        document.querySelector("#mung").checked = false;
    };

    // checkbox 전체 선택
    document.querySelector("#setHobbyAllOn").onclick = () => {
        document.querySelectorAll("input[name='hobby']").forEach(el => el.checked = true);
    }

    // checkbox 전체 선택 해제
    document.querySelector("#setHobbyAllOff").onclick = () => {
        document.querySelectorAll("input[name='hobby']").forEach(el => el.checked = false);
    }


    // select
    // with multiple : 각각 하나씩 제어
    // without multiple : selected = true 가 발생되는 항목이 선택됨

    document.querySelector("#setCSOn").onclick = function () {
        document.querySelector("#major option[value='CS']").selected = true;
    };
    document.querySelector("#setCSOff").onclick = function () {
        document.querySelector("#major option[value='CS']").selected = false;
    };

    document.querySelector("#setHIOn").onclick = function () {
        document.querySelector("#major option[value='HI']").selected = true;
    };
    document.querySelector("#setHIOff").onclick = function () {
        document.querySelector("#major option[value='HI']").selected = false;
    };

    document.querySelector("#setKLOn").onclick = function () {
        document.querySelector("#major option[value='KL']").selected = true;
    };
    document.querySelector("#setKLOff").onclick = function () {
        document.querySelector("#major option[value='KL']").selected = false;
    };

    // checkbox 전체 선택
    document.querySelector("#setMajorAllOn").onclick = () => {
        document.querySelectorAll("#major option").forEach(el => el.selected = true);
    }

    // checkbox 전체 선택 해제
    document.querySelector("#setMajorAllOff").onclick = () => {
        document.querySelectorAll("#major option").forEach(el => el.selected = false);
    }
}