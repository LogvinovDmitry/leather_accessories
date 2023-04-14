<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
 <title>Список заказов</title>
 <style>
  body {
   margin: 0;
   padding: 0;
  }

  .container {
   display: flex;
   flex-direction: column;
   align-items: center;
   margin-top: 50px;
   border: 2px solid black;
   padding: 20px 7%;
  }

  .order {
   display: flex;
   flex-direction: column;
   align-items: center;
   border: 1px solid black;
   padding: 20px;
   margin-bottom: 20px;
   width: 100%;
  }

  .order-info {
   display: flex;
   flex-direction: row;
   justify-content: space-between;
   width: 100%;
   margin-bottom: 20px;
  }

  .order-info div:first-child {
   display: flex;
   flex-direction: column;
   align-items: flex-end;
   width: 50%;
   margin-right: 10%;
  }

  .order-info h3 {
   margin: 0;
   margin-bottom: 10px;
  }

  .order-items {
   display: flex;
   flex-direction: row;
   align-items: center;
   width: 100%;
  }

  .order-item {
   display: flex;
   flex-direction: column;
   align-items: center;
   margin-right: 20px;
  }

  .order-item img {
   width: 380px;
   height: 280px;
   margin-bottom: 10px;
  }

  .order-item h4 {
   margin: 0;
   margin-bottom: 5px;
  }

  .order-item p {
   margin: 0;
   line-height: 1.5;
  }
 </style>
</head>
<body>
 <div class="container">
  <div class="order">
   <div class="order-info">
    <div>
     <p><u>Имя:</u> Иванов Иван</p>
     <p><u>Телефон:</u> +7 999 123 45 67</p>
     <p><u>Адрес доставки:</u> г. Москва, ул. Пушкина, д. 10, кв. 5</p>
     <p><u>Соцсеть:</u> vk.com/ivanov</p>
     <p><u>Комментарий:</u> Без соли</p>
    </div>
    <div>
     <h3>Заказ</h3>
     <div class="order-items">
      <div class="order-item">
       <img src="photo.jpg">
       <h4>ID товара:</h4>
       <p>123</p>
       <h4>Название товара:</h4>
       <p>Товар 1</p>
       <h4>Количество:</h4>
       <p>2</p>
      </div>
      <div class="order-item">
       <img src="photo.jpg">
       <h4>ID товара:</h4>
       <p>456</p>
       <h4>Название товара:</h4>
       <p>Товар 2</p>
       <h4>Количество:</h4>
       <p>1</p>
      </div>
     </div>
     <p><u>Номер заказа:</u> 12345</p>
     <p><u>Дата заказа:</u> 01.01.2022</p>
    </div>
   </div>
  </div>
  <div class="order">
   <div class="order-info">
    <div>
     <p><u>Имя:</u> Петров Петр</p>
     <p><u>Телефон:</u> +7 999 765 43 21</p>
     <p><u>Адрес доставки:</u> г. Санкт-Петербург, ул. Лермонтова, д. 5, кв. 10</p>
     <p><u>Соцсеть:</u> instagram.com/petrov</p>
     <p><u>Комментарий:</u> Без лука</p>
    </div>
    <div>
     <h3>Заказ</h3>
     <div class="order-items">
      <div class="order-item">
       <img src="photo.jpg">
       </div>
</body>
</html>