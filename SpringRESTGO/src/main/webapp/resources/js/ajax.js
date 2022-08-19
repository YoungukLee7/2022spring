
const btn1 = document.getElementById('btn-xhttp');
const btn2 = document.getElementById('btn-xhttp-put');
const btn3 = document.getElementById('btn-xhttp-post');

const out = document.getElementById('out'); 
const out2 = document.getElementById('out2'); 
const out3 = document.getElementById('out3'); 

const select1 = document.getElementById('select-pizza-name');

const input_pizza_name = document.getElementById('input-pizza-name');
const input_pizza_price = document.getElementById('input-pizza-price');
const input_pizza_calories = document.getElementById('input-pizza-calories');
const input_pizza_id = document.getElementById('input-pizza-id');

const post_pizza_name = document.getElementById('post-pizza-name');
const post_pizza_price = document.getElementById('post-pizza-price');
const post_pizza_calories = document.getElementById('post-pizza-calories');

const xhttp2 = new XMLHttpRequest();

xhttp2.addEventListener('readystatechange', (e) => {
	const readyState = e.target.readyState;
	
	if (readyState == 4) {
		const responseText = e.target.responseText;
		const pizza = JSON.parse(responseText);
		
		input_pizza_calories.value = pizza.pizza_calories;
		input_pizza_price.value = pizza.pizza_price;
		input_pizza_id.value = pizza.pizza_id;
		input_pizza_name.value = pizza.pizza_name;
	}
});

select1.addEventListener('change', (e) => {
    //console.log('select tag event:', e);
    //console.log('selected option:', e.target.value);
    xhttp2.open('GET', '/restful/sample/pizza/' + e.target.value);
    xhttp2.send();
})

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

const xhttp3 = new XMLHttpRequest();

xhttp3.addEventListener('readystatechange' , (e) => {
	// put 방식으로 요청이 도착했을 때 확인
	const readyState = e.target.readyState;
	
	if (readyState == 4) {
	const responseText = e.target.responseText;
	
	if (responseText == 1) {
		out2.innerText = 'SUCCESS';
		out2.style.color = 'green';
	} else {
		out2.innerText = responseText;
		out2.style.color = 'red';
	}
}		
});

btn2.addEventListener('click' , (e) => {
	//console.log('input pizza id value: ', input_pizza_id.value);
	//console.log('input pizza name value: ', input_pizza_name.value);
	//console.log('input pizza price value: ', input_pizza_price.value);
	//console.log('input pizza calories value: ', input_pizza_calories.value);
	
	const pizza = {
		pizza_id:		input_pizza_id.value,
		pizza_name:		input_pizza_name.value,
		pizza_price:	input_pizza_price.value,
		pizza_calories:	input_pizza_calories.value
	};
	
	// GET방식은 주소 뒤에 ?name=value&... 로 실어 보내면 되지만
	// 그 외의 방식은 send() 메서드에 데이터를 실어 보낸다
    xhttp3.open('PUT', '/restful/sample/pizza');
    
    //xhr 요청 헤더 설정 (JSON 형식으로 보낸다고 서버에 알려야 한다)
    xhttp3.setRequestHeader('Content-type', 'application/json;charset=UTF-8')
    
    //xhttp3.send("{'name':${input_pizza_id.value}}");
    // Object -> JSON (stringify) 위에 방법을 간소화 한 문법
    console.log('JSON string: ', JSON.stringify(pizza));
    xhttp3.send(JSON.stringify(pizza));
    
});

const xhttp4 = new XMLHttpRequest();

xhttp4.addEventListener('readystatechange' , (e) => {
	// put 방식으로 요청이 도착했을 때 확인
	const readyState = e.target.readyState;
	
	if (readyState == 4) {
	const responseText = e.target.responseText;
	
	console.log(responseText);
	//if (responseText == 1) {
	//	out3.innerText = 'SUCCESS';
	//	out3.style.color = 'green';
	//} else {
	//	out3.innerText = 'FAILED';
	//	out3.style.color = 'red';
	//}
	}		
});

btn3.addEventListener('click' , (e) => {

	const pizza = {
		pizza_name:		post_pizza_name.value,
		pizza_price:	post_pizza_price.value,
		pizza_calories:	post_pizza_calories.value
	};
	
	console.log(pizza);

	xhttp4.open('POST', '/restful/sample/pizza');
    xhttp4.setRequestHeader('Content-type', 'application/json;charset=UTF-8')
    xhttp4.send(JSON.stringify(pizza));
});















