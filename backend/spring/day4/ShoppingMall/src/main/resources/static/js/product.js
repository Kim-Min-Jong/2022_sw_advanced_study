var SEARCH_WORD = "";

window.onload = function(){

    initUserInfo();

    productList();

    // 검색어 검색
    document.querySelector("#btnSearchWord").onclick = function(){
        SEARCH_WORD = document.querySelector("#inputSearchWord").value;
        productList();
    }

    // 글 등록
    document.querySelector("#btnInsert").onclick = function(){
        document.querySelector("#productNameInsert").value = "";
        document.querySelector("#productStockInsert").value = "";
        document.querySelector("#productImageUrlInsert").value = "";

        // bootstrap 5 show modal
        // 상품등록 클릭하면 모달창 띄움
        let modal = new bootstrap.Modal(document.querySelector("#productInsertModal") );
        modal.show();
    }

    // insert
    // 모달 창에서 등록버튼 클릭하면
    document.querySelector("#btnProductInsert").onclick = function(){

        if( validateInsert() ){
            // 실행
            productInsert();
        }
    };


    // update
    document.querySelector("#btnProductUpdateForm").onclick = function(){
        // 상품상세 모달 -> 상품수정모달로 데이터를 가지고옴
        var productId = document.querySelector("#productDetailModal").getAttribute("data-productId");
        document.querySelector("#productUpdateModal").setAttribute("data-productId", productId);

        document.querySelector("#productNameUpdate").value = document.querySelector("#productNameDetail").innerHTML;
        document.querySelector("#productStockUpdate").value = document.querySelector("#productStockDetail").innerHTML;
        document.querySelector("#productImageUrlUpdate").value
            = document.querySelector("#productImageUrlDetail").getAttribute("src");

        // bootstrap 5 show modal
        // 상세 숨기고
        let detailModal = new bootstrap.Modal( document.querySelector("#productDetailModal") )
        detailModal.hide();
        // 수정창 띄우고
        let updateModal = new bootstrap.Modal( document.querySelector("#productUpdateModal") )
        updateModal.show();
    };

    // update
    document.querySelector("#btnProductUpdate").onclick = function(){

        // valid 체크
        if( validateUpdate() ){
            productUpdate();
        }
    };

    // delete
    document.querySelector("#btnProductDeleteConfirm").onclick = function(){
        alertify.confirm('삭제 확인', '이 상품을 삭제하시겠습니까?',
            function() {
                productDelete();
            },
            function(){
                console.log('cancel');
            }
        );
    };
}

// list  화면이 뜰 때 디비에서 목록을 가져와서 보여줌 console
async function productList(){

    var url = '/products';
    var urlParams = `?searchWord=${SEARCH_WORD}`;

    try{
        let response = await fetch(url + urlParams);
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
        let productStock = el.productStock;
        let productRegisterDate = el.productRegisterDate;

        listHTML += `<tr style="cursor:pointer" data-productId=${productId}>
                        <td>${productId}</td>
                        <td>${productName}</td>
                        <td>${productStock}</td>
                        <td>${productRegisterDate}</td>
                     </tr>`;
    });


    document.querySelector("#productTbody").innerHTML = listHTML

    // 테이블 각 요소 클릭시 핸들러
    makeListHtmlEventHandler();
}

function makeListHtmlEventHandler(){
    // tr에 클릭리스너를 달아서
    document.querySelectorAll("#productTbody tr").forEach( el => {
        el.onclick = function(){
            // 상세 정보로 전환(아이디값을 통해)
            var productId = this.getAttribute("data-productId");
            // 상세 정보
            productDetail(productId);
        }
    });
}

// image 는 제외
function validateInsert(){
    var isProductNameInsertValid = false;
    var isProductStockInsertValid = false;

    var productNameInsert = document.querySelector("#productNameInsert").value;
    var productNameInsertLength = productNameInsert.length;

    if( productNameInsertLength > 0 ){
        isProductNameInsertValid = true;
    }

    var productStockInsert = document.querySelector("#productStockInsert").value;
    var productStockInsertLength = productStockInsert.length;

    if( productStockInsertLength > 0 ){
        isProductStockInsertValid = true;
    }

    if(	isProductNameInsertValid && isProductStockInsertValid ){
        return true;
    }else{
        return false;
    }
}

// insert
// headers 에 content-type 을 multipart/form-data 로 주면 boundary 를 찾지 못하는 오류 발생 (mdn 문서와 다른다.)
async function productInsert(){

    // 파일 업로드 기능을 만들경우는 반드시 FormData를 사용
    // 폼데이터를 가져와서
    let formData = new FormData();
    formData.append("productName", document.querySelector("#productNameInsert").value);
    formData.append("productStock", document.querySelector("#productStockInsert").value);
    formData.append("productImageUrl", document.querySelector("#productImageUrlInsert").value);


    // url로 보냄
    let url = '/products';

    let fetchOptions = {
        method: 'POST',
        body: formData
    }

    // 전송함
    try{
        let response = await fetch(url, fetchOptions);
        // 전송완료되면 반환 값을 받아서 성공/실패 출력
        let data = await response.json();

        if( data.result == 1 ){
            alertify.success('상품이 등록되었습니다.');
            productList();
        }else{
            alertify.error('상품 등록 과정에 문제가 생겼습니다.');
        }
    }catch(error){
        console.error( error );
        alertify.error('상품 등록 과정에 문제가 생겼습니다.');
    }
}

// detail
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

// update
function validateUpdate(){
    var isProductNameUpdateValid = false;
    var isProductStockUpdateValid = false;

    var productNameUpdate = document.querySelector("#productNameUpdate").value;
    var productNameUpdateLength = productNameUpdate.length;

    if( productNameUpdateLength > 0 ){
        isProductNameUpdateValid = true;
    }

    var productStockUpdate = document.querySelector("#productStockUpdate").value;
    var productStockUpdateLength = productStockUpdate.length;

    if( productStockUpdateLength > 0 ){
        isProductStockUpdateValid = true;
    }

    if(	isProductNameUpdateValid && isProductStockUpdateValid ){
        return true;
    }else{
        return false;
    }
}

// headers 에 content-type 을 multipart/form-data 로 주면 boundary 를 찾지 못하는 오류 발생 (mdn 문서와 다른다.)
async function productUpdate(){

    var productId = document.querySelector("#productUpdateModal").getAttribute("data-productId");
    var formData = new FormData();

    formData.append("productId", productId);
    formData.append("productName", document.querySelector("#productNameUpdate").value);
    formData.append("productStock", document.querySelector("#productStockUpdate").value);
    formData.append("productImageUrl", document.querySelector("#productImageUrlUpdate").value);

    var url = '/products/' + productId;

    let fetchOptions = {
        method: 'PUT',
        body: formData
    }

    try{
        let response = await fetch(url, fetchOptions);
        let data = await response.json();

        if( data.result == 1 ){
            alertify.success('상품이 수정되었습니다.');
            productList();
        }else{
            alertify.error('상품 수정 과정에 문제가 생겼습니다.');
        }
    }catch(error){
        console.error( error );
        alertify.error('상품 수정 과정에 문제가 생겼습니다.');
    }
}

// delete
async function productDelete(){

    var productId = document.querySelector("#productDetailModal").getAttribute("data-productId");
    var url = '/products/' + productId;

    let fetchOptions = {
        method: 'DELETE',
    }

    try{
        let response = await fetch(url, fetchOptions);
        let data = await response.json();
        console.log(data)
        if( data.result == 1 ){
            alertify.success('상품이 삭제되었습니다.');
            productList();
        }else{
            alertify.error('상품 삭제 과정에 문제가 생겼습니다.');
        }
    }catch(error){
        console.error( error );
        alertify.error('상품 삭제 과정에 문제가 생겼습니다.');
    }

}

async function productList(){

    var url = '/products';
    var urlParams = `?searchWord=${SEARCH_WORD}`;

    try{
        let response = await fetch(url + urlParams);
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