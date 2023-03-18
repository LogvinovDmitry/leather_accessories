﻿<!-- -*- coding: utf-8 -*- -->

# Проект магазину з продажу шкіряних виробів

## Технології

* Java Servlets
* Tomcat 7
* MySQL
* Maven

## Запуск сайту на своєму ПК

1. Встановити MySQL сервер
2. Створити базу даних під назвою `leather_accessories_schema`
3. Створити користувача з паролем у MySQL та дати йому доступ до бази диних `leather_accessories_schema`
4. Импортувати таблиці з даними використовуючи SQL скрипти, які лежать у папці `sql`
5. Вказати адресу для з'еднання з базою даних, користувача та його пароль:
   * Метод 1 - змінити константи у файлі `src/main/java/app/util/ConnectionLeatherAccessoriesSchema.java` (потрібна перекомпіляція проекту)
   * Метод 2 - встановити змінні середовища (потрібен перезапуск проекту): 
     * `DATABASE_URL`, наприклад `jdbc:mysql://localhost:3306/leather_accessories_schema`
     * `DATABASE_USER`, наприклад `squser`
     * `DATABASE_PASSWORD`, наприклад `pass1234`
6. Запустити проект Мавен командою
    ```shell
    clean compile tomcat7:run
    ```
7. **Порт** за замовчуванням налаштован як **8080**. Сайт доступен за адресою [http://localhost:8080/](http://localhost:8080/)

### Створення WAR файлу

Для створення war файлу треба запустити наступну Мавен команду

```shell
clean compile war:war
```

_Увага: для запуску створеного WAR файлу у Tomcat треба створити у базі даних необхідні таблиці, користувача та налаштувати дані для з'еднання з базою даних, як це було описано вище. Крім того, у корневу папку сайту, коли WAR файл буде распаковано на сервері, треба покласти папку file, пусту, або з зображеннями, які були імпортовані до таблиці `bag_photo`. Ймовірно цій папці треба налаштувати права, щоб мати можливість завантажувати фото нових товарів через адмінку._

## Запуск сайту у Docker контейнері

### Створення Docker Image з проекту

Dockerfile вже налаштован таким чином, щоб скомпілити проект використовуючи Maven та скопіювати необхідні файли у Docker Image. Для запуску компіляції треба тільки запустити наступну команду

```shell
docker build -t leather-accessories ./
```

* Створений Docker Image використовує Tomcat версії 7.0.57 та OpenJdk версії 8. 
* Папка `file` з зображеннями буде включена у Docker Image. Для цього, перед компіляцією її треба помістити у корінь проекту.
* **Порт** за замовчуванням налаштован як **80**
* Проект запускається як ROOT, тож адреса матиме вигляд [http://localhost/](http://localhost/)
* Сервісні сайти, які йдуть у комплекті з Tomcat видалені.

### Запуск Docker Container з використанням створенного Image

У проекті є вже налаштованний конфігураційний файл Docker Compose, який дає можливість запустити проект однією командою.
Все, що треба зробити завчасно, так це вказати данні для з'єднання з базою даних, як це описано у розділі `Запуск сайту на своєму ПК` пункт 5.2.

_Звісно, база данних має бути встановлена, запущена та налаштована, як це описано у тому ж розділі._

Команда для запуску Docker Container:

```shell
docker-compose up
```

## Загрузка та запуск сайту як Docker Container на хостінгу fly.io

Консольна програма [flyctl](https://fly.io/docs/hands-on/install-flyctl/) має бути вже встановлена.
Авторизуватись можна виконавши наступну команду

```shell
fly auth login
```

### Встановлення та запуск бази даних MySQL на сервері

Повна інструкція знаходиться [тут](https://fly.io/docs/app-guides/mysql-on-fly/)

1. Відкрити конфігураційний файл `./fly-mysql.toml`, змінити ім'я серверу (`app`), ім'я користувача бази даних (`MYSQL_USER`) та ім'я бази даних (`MYSQL_DATABASE`) якщо це необхідно.
2. Для запуску MySQL сервера треба запустити команду `fly launch --config ./fly-mysql.toml` (_Можливо цю команду треба запускати тільки за відсутності файлу `./fly-mysql.toml`_)

    Під час виконання команди треба:
    * підтвердити використання існуючого конфігураційного файлу `./fly-mysql.toml`,
    * ввести ім'я серверу, яке буде використовуватись як адреса до бази даних. Наприклад `leather-mysql`, тоді база даних буде доступна за адресою `leather-mysql.internal`
    * обрати регіон розташування бази даних (`wow` або інший)
3. Створити volume, де будуть сберігатись дані бази, виконавши наступну команду (2 - об'ем місця у гігабайтах)
    ```shell
    fly volumes create mysqldata --size 2 --config ./fly-mysql.toml
    ```
4. Встановити пароль `root` користувача (`MYSQL_ROOT_PASSWORD`), та користувача (`MYSQL_PASSWORD`), який вказан у файлі `./fly-mysql.toml` виконавши наступну команду (`password` мають бути змінені на паролі)
    ```shell
    fly secrets set MYSQL_PASSWORD=password MYSQL_ROOT_PASSWORD=password --config ./fly-mysql.toml
    ```
5. У разі необхідності, можна додати базі даніх оперативної пам'яті (`1024` - об'єм у мегабайтах) наступною командою (може зніматися додаткова оплата)
    ```shell
    fly scale memory 1024 --config ./fly-mysql.toml
    ```
6. Залити все налаштоване віще на сервер, виконавши наступну команду

    ```shell
    fly deploy --config ./fly-mysql.toml
    ```

### List secrets variables

```shell
flyctl secrets list
```

### Set secret variable

```shell
flyctl secrets set DATABASE_URL=jdbc:mysql://leather-mysql.internal:3306/leather_accessories_schema
```

### Remove secret variable

```shell
flyctl secrets unset DATABASE_URL
```

З'єднатися з базою даних зі свого компьютера можливо тільки за допомогою проксі, яке можна запустити наступною командою

```shell
flyctl proxy 3306 -a leather-mysql
```

Поки проксі запущено, база даних доступна за адресою `localhost:3306`

### Завантаження сайту на сервер fly.io

Якщо сайт коректно пакується у Docker Image та працює у вигляді контейнера, для завантаження його на сервер достатньо виконати наступні кроки

1. Запустити сборку та завантаження сайту на сервер наступною командою (для сборки буде використовуватись локальний Docker сервер)

```shell
fly deploy --local-only
```

2. Впевнетись що на сервері налаштовані змінні середовища, необхідні для підключення до бази даних (описані у розділі `Запуск сайту на своєму ПК` пункт 5.2.)
    * Подивитись, які змінні налаштовані можна наступною командою:

        ```shell
        flyctl secrets list
        ```
    * Створити змінну можна виконавши таку команду
        ```shell
        flyctl secrets set DATABASE_URL=jdbc:mysql://leather-mysql.internal:3306/leather_accessories_schema
        ```
   * Видалити змінну можна виконавши таку команду
        ```shell
        flyctl secrets unset DATABASE_URL
        ```
     
## Корисно

1. Видалення усіх не запущених Docker контейнерів, усіх імеджей, які не використовуються запущеними контейнерами, усіх волюмів, нетворків, та очищення кешу

    ```shell
    docker system prune -a --volumes
    ```

2. Подивитись консоль сайту на сервері можна за адресою [https://fly.io/apps/leather-server/monitoring](https://fly.io/apps/leather-server/monitoring) (`leather-server` - ім'я сайту)