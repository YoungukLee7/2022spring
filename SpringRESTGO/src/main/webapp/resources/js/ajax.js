
const btn1 = document.getElementById('btn-xhttp');
const out = document.getElementById('out'); 
const selectall = document.getElementById('selectall');

// AJAX

// 1. Ajax를 위한 xhttp 인스턴스 생성
const xhttp = new XMLHttpRequest();

// 2. xhttp 에 이벤트 생성
xhttp.addEventListener('readystatechange' , (e) => {
    //console.log('readystate event: ', e);

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if (readyState == 1) {
        console.log('서버로 비동기 요청을 보냈다');
    }else if (readyState == 2) {
        console.log('서버가 내 요청을 받았다');
    }else if (readyState == 3) {
        console.log('서버가 내 요청에 대한 처리를 시작했다');
    }else if (readyState == 4) {
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답도 도착했다');
        console.log('응답은 responseText에 들어있다',responseText);

    // 5. JSON 문자열 -> Javascript Object로 변환
    const pizza = JSON.parse(responseText);

    console.log('pizza name: ', pizza.pizza_name);
    console.log('pizza calories: ', pizza.pizza_calories);

    // 받아온 데이터 활용
    const pizzaDiv = document.createElement('div');

    pizzaDiv.innerText = `${pizza.pizza_name}/${pizza.pizza_calories}/${pizza.pizza_price}`;

    out.appendChild(pizzaDiv);

    }else {
        console.log('?? : ', readyState, ',', responseText);
    }
});

btn1.addEventListener('click' , (e) => {
    // 3. 새로운 xhttp 연결을 설정
    xhttp.open('GET', '/restful/sample/pizza/1');
    // 4. 원하는 타이밍에 요청을 전송
    xhttp.send();
});

var selectPizza = function(value) {
    $("changeInput").val(value);
}