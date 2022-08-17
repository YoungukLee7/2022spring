
const btn1 = document.getElementById('btn-xhttp');
const out = document.getElementById('out'); 
const selectall = document.getElementById('selectall');

// AJAX

// 1. Ajax�� ���� xhttp �ν��Ͻ� ����
const xhttp = new XMLHttpRequest();

// 2. xhttp �� �̺�Ʈ ����
xhttp.addEventListener('readystatechange' , (e) => {
    //console.log('readystate event: ', e);

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if (readyState == 1) {
        console.log('������ �񵿱� ��û�� ���´�');
    }else if (readyState == 2) {
        console.log('������ �� ��û�� �޾Ҵ�');
    }else if (readyState == 3) {
        console.log('������ �� ��û�� ���� ó���� �����ߴ�');
    }else if (readyState == 4) {
        console.log('������ ó���� ������ �� ��û�� ���� ���䵵 �����ߴ�');
        console.log('������ responseText�� ����ִ�',responseText);

    // 5. JSON ���ڿ� -> Javascript Object�� ��ȯ
    const pizza = JSON.parse(responseText);

    console.log('pizza name: ', pizza.pizza_name);
    console.log('pizza calories: ', pizza.pizza_calories);

    // �޾ƿ� ������ Ȱ��
    const pizzaDiv = document.createElement('div');

    pizzaDiv.innerText = `${pizza.pizza_name}/${pizza.pizza_calories}/${pizza.pizza_price}`;

    out.appendChild(pizzaDiv);

    }else {
        console.log('?? : ', readyState, ',', responseText);
    }
});

btn1.addEventListener('click' , (e) => {
    // 3. ���ο� xhttp ������ ����
    xhttp.open('GET', '/restful/sample/pizza/1');
    // 4. ���ϴ� Ÿ�ֿ̹� ��û�� ����
    xhttp.send();
});

var selectPizza = function(value) {
    $("changeInput").val(value);
}