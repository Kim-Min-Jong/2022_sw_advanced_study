window.onload = function () {

    // login
    document.querySelector("#btnLogin").onclick = function () {
        console.log(document.querySelector("#domain").value);
        console.log(document.querySelector("#userId").value);
        console.log(document.querySelector("#password").value);
    };

    // register
    document.querySelector("#btnRegister").onclick = function () {
        console.log(document.querySelector("#userName").value);
        console.log(document.querySelector("#userEmail").value);

        // radio
        // 쿼리 셀렉터의 파라미터는 css에서도 동일하게 사용가능
        console.log("-------- radio -----------");
        console.log(document.querySelector("input[name='gender']:checked").value); // 1 개 OK
        // radio 1개 선택 여부
        if (document.querySelector("#female").checked) console.log("female is checked");


        // checkbox
        console.log("-------- checkbox -----------");
        console.log(document.querySelector("input[name='hobby']:checked").value); // Not OK, checkbox 는 복수 선택 필요하므로 
        // loop (나은 방법)
        document.querySelectorAll("input[name=hobby]:checked").forEach(el => console.log(el.value));
        // checkbox 1개 선택 여부
        if (document.querySelector("#movie").checked) console.log("movie is checked");


        // select
        console.log("-------- select -----------");
        console.log(document.querySelector("#major option:checked").value); // 1 개 OK //selected 는 안된다. checked 로!!!

        // with multiple //selected 는 안된다. checked 로!!!
        document.querySelectorAll("#major option:checked").forEach(el => console.log(el.value));

        // select option 1개 선택 여부
        // console.dir( document.querySelector("#KL") ); // checked 아니고 selected 임을 dir로 확인
        // a. id로
        // if( document.querySelector("#KL").selected ) console.log( "KL is selected"); // checked 는 안된다. selected 는 속성
        // b. option value로
        if (document.querySelector("#major option[value='KL']").selected) console.log("KL is selected"); // checked 는 안된다. selected 는 속성

        // textarea
        console.log("-------- textarea -----------");
        console.log(document.querySelector("#desc").value);

        // search
        document.querySelector("#btnSearch").onclick = function () {
            console.log(document.querySelector("#searchWord").value);
        };

        document.querySelector("#searchWord").onkeydown = function(e){
            console.log( e.keyCode );
            if( e.keyCode == 13 ){
                console.log( this.value );
                e.preventDefault();
            }  
        }
 
        // arrow function event handler - this
        // document.querySelector("#searchWord").onkeydown = (e) => {

        //     console.log(e.keyCode);
        //     if (e.keyCode == 13) {
        //         //console.log( this.value ); // 오류 undefined <= this 는 window
        //         console.log(e.target.value); //e.target 또는 currentTarget
        //         e.preventDefault();
        //     }
        // }
    };
}