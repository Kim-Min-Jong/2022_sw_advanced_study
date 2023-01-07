window.onload = function(){
    initUserInfo();
    productList();
}
async function productList(productId){

    var url = '/products'
    try{
        let response = await fetch(url);
        let data = await response.json();
        console.log(data);
        if( data.result == 1){
            makeListHtml(data.list);
        }else{
            alertify.error('상품 조회 과정에 문제가 생겼습니다.');
        }
    }catch(error){
        console.error( error );
        alertify.error('상품 조회 과정에 문제가 생겼습니다.');
    }
}
function makeListHtml(list){
    console.log(list);

    let listHTML = ``;

    // 가져온 리스트의 상세를 쭉 파싱해서 테이블 태그에 넣음
    list.forEach( el => {
        let productId = el.productId;
        let productName = el.productName;
        let imgUrl = el.productImageUrl;
        let productStock = el.productStock;
        let productRegisterDate = el.productRegisterDate;

        listHTML += `<div class="col">
                        <div class="card" style="width: 18rem;">
                        <img src="${imgUrl}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${productName}</h5>
                                <p class="card-text"${productRegisterDate}</p>
                                <button onclick="productDetail(${productId});" class="btn btn-primary">상세보기</a>
                            </div>
                        </div>
                    </div>`;
    });


    document.querySelector(".row").innerHTML = listHTML
}

async function productDetail(productId){

    // 백엔드 url연결해서 페이지 탐색
    let url = '/products/' + productId;

    try{
        let response = await fetch(url);
        let data = await response.json();
        console.log(data);

        if( data.result == 1 ){
            makeDetailHtml(data.dto);
        }else{
            alertify.error('상품 상세 조회 과정에 문제가 생겼습니다.');
        }
    }catch(error){
        console.error( error );
        alertify.error('상품 상세 조회 과정에 문제가 생겼습니다.');
    }
}

function makeDetailHtml(detail){

    var productId = detail.productId;
    var productName = detail.productName;
    var productStock = detail.productStock;
    var productImageUrl = detail.productImageUrl;
    var productRegisterDate = detail.productRegisterDate;

    document.querySelector("#productDetailModal").setAttribute("data-productId", productId);
    document.querySelector("#productIdDetail").innerHTML = "#" + productId;
    document.querySelector("#productNameDetail").innerHTML = productName;
    document.querySelector("#productStockDetail").innerHTML = productStock;
    document.querySelector("#productImageUrlDetail").setAttribute("src", productImageUrl);
    document.querySelector("#productRegisterDateDetail").innerHTML = productRegisterDate;

    // bootstrap 5 show modal
    let modal = new bootstrap.Modal(document.querySelector("#productDetailModal"), {  keyproduct: false } )
    modal.show();
}