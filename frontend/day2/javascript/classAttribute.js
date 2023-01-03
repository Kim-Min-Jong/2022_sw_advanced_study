var shape;
window.onload = function(){
    shape = document.querySelector("#shape");

    ///// 주의!! this. 사용하는 event handler 에 () => e.target 을 시용  !!!
    // remove add class
    // document.querySelector("#btnCircle").addEventListener("click", function(){
    //     shape.classList.remove("rect");
    //     shape.classList.remove("rounded-rect");
    //     shape.classList.add("circle");
    //     this.setAttribute( "data-click-count", parseInt(this.getAttribute("data-click-count")) + 1 );
    // });

    document.querySelector("#btnCircle").addEventListener("click", ( e ) => {
        shape.classList.remove("rect");
        shape.classList.remove("rounded-rect");
        shape.classList.add("circle");
        e.target.setAttribute( "data-click-count", parseInt(e.target.getAttribute("data-click-count")) + 1 );
    });

    document.querySelector("#btnRect").addEventListener("click", function(){
        shape.classList.remove("circle", "rounded-rect"); // 한꺼번에 여러개
        // shape.classList.remove("rounded-rect");
        shape.classList.add("rect");
        this.setAttribute( "data-click-count", parseInt(this.getAttribute("data-click-count")) + 1 );
    });

    document.querySelector("#btnRoundedRect").addEventListener("click", function(){
        
        shape.classList.remove("circle");
        shape.classList.remove("rect");
        shape.classList.add("rounded-rect");
        this.setAttribute( "data-click-count", parseInt(this.getAttribute("data-click-count")) + 1 );
    });

    // class toggle
    shape.addEventListener("mouseover", function(){
        shape.classList.toggle("bg-black");
    });

    shape.addEventListener("mouseout", function(){
        shape.classList.toggle("bg-black");
    });

    // click count attribute get
    document.querySelector("#btnClickCountInfo").addEventListener("click", () => {
        let click1 = document.querySelector("#btnCircle").getAttribute("data-click-count");
        let click2 = document.querySelector("#btnRect").getAttribute("data-click-count");
        let click3 = document.querySelector("#btnRoundedRect").getAttribute("data-click-count");
        document.querySelector("#pCountInfo").innerText = `클릭한 횟수는 원( ${click1} ) 사각( ${click2} ) 라운드 사각 ( ${click3} ) 입니다.`;
    });
    
}