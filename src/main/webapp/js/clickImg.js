function clickImg() {
    // 이미지 요소의 src 속성을 동적으로 가져오기 위해 URL을 수정합니다.
    var img = document.getElementById('img');
    var imgUrl = img.src;
    
    // 새 창을 엽니다. resizable 옵션을 설정하여 크기 조절이 가능하게 합니다.
    window.open(imgUrl, 'popup', 'width=600, height=600, resizable=yes');
}