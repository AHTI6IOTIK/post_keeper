# Post Keeper
### Приложение отслеживания почтовых отправлений

---


## Функционал

- регистрации почтового отправления
- перемещение отправления
  - его прибытие в промежуточное почтовое отделение
  - его убытие из почтового отделения
  - его получение адресатом
- просмотр статуса и полной истории движения почтового отправления

## Структура таблиц

- history - История перемещений отправления
- history_type - Тип перемещения (Принято/Готово к выдаче/Выдано)
- post_office - Почтовые отделения
- shipment - Отправление
- shipment_type - Тип почтового отправления(письмо, посылка, бандероль, открытка)

---

### Использование

1. Создаем (history_type, shipment_type, post_office)
2. Регистрируем отправление (shipment)
3. Перемещаем отравления (history)

---

#### Доп. материал

- [postman_collection](PostKeeper.postman_collection.json)
- [swagger](api-docs.json)

---


# Запуск приложения

Сборка и запуск контейнера

> docker compose -f docker-prod.yml  up --build

Будет собран контейнер с приложением под веб-сервером(**tomcat**) и сервером баз данных **PostgresSql**
