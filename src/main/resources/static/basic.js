$(document).ready(function () {
    // HTML 문서를 로드할 때마다 실행합니다.
    getMarkets();
})

function getMarkets() {
    // 1. 기존 메모 내용을 지웁니다.
    $('#cards-box').empty();
    // 2. 메모 목록을 불러와서 HTML로 붙입니다.
    $.ajax({
        type: 'GET',
        url: "/market/markets",
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let market = response[i];
                let name = market['name'];
                let minOrderPrice=market['minOrderPrice'];
                let deliveryFee=market['deliveryFee'];
                addHTML(name,minOrderPrice,deliveryFee);
            }

        }
    })
}

function addHTML(name,minOrderPrice,deliveryFee) {
    // 1. HTML 태그를 만듭니다.
    let tempHtml = `<div class="card">
        <!-- date/username 영역 -->
        <div class="contents">
            <div class="name">${name}</div>
            <div class="minOrderPrice">${minOrderPrice}</div>
            <div class="deliveryFee">${deliveryFee}</div>
        </div>
        <div class="footer">
            <button id="${id}-submit" class="icon-end-edit" onclick="submitEdit('${id}')">
        </div>
    </div>`;
    $('#cards-box').append(tempHtml);
}

function makeMarket() {
    // 1. 작성한 메모를 불러옵니다.
    let name = $('#name').val();
    let minOrderPrice = $('#minOrderPrice').val();
    let deliveryFee = $('#deliveryFee').val();
    // 2. 작성한 메모가 올바른지 isValidContents 함수를 통해 확인합니다.
    if (isValidContents(minOrderPrice,deliveryFee))
        return;
    // 4. 전달할 data JSON으로 만듭니다.
    let data = {'name': name, 'minOrderPrice': minOrderPrice, 'deliveryFee': deliveryFee};
    // 5. POST /api/memos 에 data를 전달합니다.
    $.ajax({
        type: "POST",
        url: "/market/markets",
        contentType: "application/json", // JSON 형식으로 전달함을 알리기
        data: JSON.stringify(data), //stringify: json을 문자열 형태로 반환하는 것
        success: function (response) {
            alert('음식점이 등록되었습니다!.');
            window.location.reload();
        }
    });

}

function isValidContents(minOrderPrice,deliveryFee) {
    if (minOrderPrice>1000000||minOrderPrice<1000) {
        alert('1000원 이상, 1000,000원 이하로 입력해주세요');
        return false;
        //빈 내용일 때
    }
    if(minOrderPrice%100!=0) {
        alert("100원 단위로 입력해주세요.");
        return false;
    }
    if(deliveryFee>10000){
        alert("10,000원 이하로 입력해주세요.");
        return false;
    }
    if(deliveryFee%500!=0){
        alert("500원 단위로 입력해주세요");
        return false;
    }

    return true;
}