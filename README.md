# EWYSMobile

## Описание

EWYS- приложение, для демонстрации электронного меню, а также блюд в дополненной реальности (AR)


# Заросы

## Для работы приложения


---
> Запрос на получение меню

GET: `/get_menu`

IN: `id={id}`

OUT:
```json
{
    "name": "Супы",
    "items": [{
        "id": "0",
        "name": "Борщ",
        "img": ["https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200", "https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200"],
        "price": 20,
        "time": 20,
        "structure": "Ну какое то описание Борща"
    }, {
        "id": "1",
        "name": "ТамЯн",
        "img": ["https://im0-tub-ru.yandex.net/i?id=a9bad21238c3ef954e45d932a8e64d29&n=13&exp=1"],
        "price": 200,
        "time": 10,
        "structure": "Ну какое то описание ТамЯна"
    }, {
        "id": "2",
        "name": "Щавель суп",
        "img": ["https://fb.ru/media/i/1/6/0/2/4/4/5/i/1602445.jpg"],
        "price": 2000,
        "time": 25,
        "structure": "Ну какое то описание Щавель супа"
    }]
}
```

---
> Запрос на поиск товаров

GET: `/search`

IN: `name={Название продукта}`

OUT:

```json
[{
    "id": "0",
    "name": "Борщ",
    "img": ["https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200", "https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200"],
    "price": 20,
    "time": 20,
    "structure": "Ну какое то описание Борща"
}, {
    "id": "1",
    "name": "ТамЯн",
    "img": ["https://im0-tub-ru.yandex.net/i?id=a9bad21238c3ef954e45d932a8e64d29&n=13&exp=1"],
    "price": 200,
    "time": 10,
    "structure": "Ну какое то описание ТамЯна"
}]
```
---

## Для работы Админки

---
> Запрос для добовления продукта

POST: `add_poduct`

IN:

```json
{
    "name": "Борщ", // Название товара
    "img": ["BASE64","BASE64","BASE64"], // Масив картинок в base64
    "price": 20, // Цена товара
    "time": 20, // Время готовки
    "structure": "Ну какое то описание Борща" // Состав
}
```

OUT:

```json
// Если успешно
{ "status": "ok" }
// Если ошибка
{ "status": "erorr" }
```

---

> Запрос на удаление продукта

DELETE: `delete_product`
IN:

```json
{"id":"id продукта"}
```

OUT:

```json
// Если успешно
{ "status": "ok" }
// Если ошибка
{ "status": "erorr" }
```
---

> Запрос на получение всех товаров

GET: `/get_menu`

IN:
```json
    {"id": "id menu"}
```

OUT:

```json
{
    "name": "Супы",
    "items": [{
        "id": "0",
        "name": "Борщ",
        "img": ["https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200", "https://avatars.mds.yandex.net/get-zen_doc/2468786/pub_5f5f3d7e93cc6c72ff0b8396_5f5f40c993cc6c72ff121b84/scale_1200"],
        "price": 20,
        "time": 20,
        "structure": "Ну какое то описание Борща"
    }, {
        "id": "1",
        "name": "ТамЯн",
        "img": ["https://im0-tub-ru.yandex.net/i?id=a9bad21238c3ef954e45d932a8e64d29&n=13&exp=1"],
        "price": 200,
        "time": 10,
        "structure": "Ну какое то описание ТамЯна"
    }, {
        "id": "2",
        "name": "Щавель суп",
        "img": ["https://fb.ru/media/i/1/6/0/2/4/4/5/i/1602445.jpg"],
        "price": 2000,
        "time": 25,
        "structure": "Ну какое то описание Щавель супа"
    }]
}
```
---

> Запрос на редактирование продукта

POST: `edit_product`

IN:


```json
// Передаются только поля которые измененны
{
    "id": "13", // id товара который изминяем
    "name": "Борщ", // Название товара
    "img": ["BASE64","BASE64","BASE64"], // Масив картинок в base64
    "price": 20, // Цена товара
    "time": 20, // Время готовки
    "structure": "Ну какое то описание Борща" // Состав
}
```
---
