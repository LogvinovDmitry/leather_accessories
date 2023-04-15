<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Отображение заказов</title>
    <style>
      /* Стили для таблицы */
      table {
        border-collapse: collapse;
        width: 100%;
      }

      th, td {
        text-align: left;
        padding: 8px;
      }

      th {
        background-color: #f2f2f2;
      }

      /* Стили для фото товара */
      .product-image {
        width: 190px;
        height: 140px;
        object-fit: cover;
        margin-right: 10px;
        float: left;
      }

      /* Стили для текста */
      body {
        font-family: 'Montserrat', sans-serif;
      }

      h2, ul, th, td {
        text-transform: uppercase;
        color: #9f9f9f;
      }

      ul li, tbody td {
        text-transform: none;
        color: #5a5a5a;
      }

      .client-fields {
        display: flex;
        flex-direction: column;
      }

      .client-fields li {
        flex: 1 1 50%;
      }

      .client-fields li:before {
        content: attr(data-label);
        font-weight: bold;
        display: inline-block;
        width: 150px;
        text-transform: uppercase;
      }
    </style>
  </head>
  <body>
    <h1>Отображение заказов</h1>
    <div>
      <h2>Поля клиента</h2>
      <ul class="client-fields">
        <li data-label="Имя:">Иван</li>
        <li data-label="Телефон:">+7 (123) 456-78-90</li>
        <li data-label="Адрес доставки:">ул. Пушкина, д. 10, кв. 5</li>
        <li data-label="Соцсеть:">vk.com/ivanov</li>
        <li data-label="Комментарий:">Безопасно оставить у соседей</li>
      </ul>
    </div>
    <div>
      <h2>Заказы</h2>
      <table>
        <thead>
          <tr>
            <th>Фото товара</th>
            <th>Номер заказа</th>
            <th>Дата заказа</th>
            <th>ID товара</th>
            <th>Количество товара</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><img src="path/to/product-image.jpg" alt="Фото товара" class="product-image"></td>
            <td>1</td>
            <td>01.01.2022</td>
            <td>123</td>
            <td>2</td>
          </tr>
          <tr>
            <td><img src="path/to/product-image.jpg" alt="Фото товара" class="product-image"></td>
            <td>2</td>
            <td>02.01.2022</td>
            <td>456</td>
            <td>1</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>