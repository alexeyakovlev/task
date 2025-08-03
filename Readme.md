# Wallet Service

Простое Spring Boot приложение для управления электронными кошельками с поддержкой операций пополнения и снятия средств.

## Технологии

- Java 17
- Spring Boot 3.5.4
- PostgreSQL 16
- Liquibase (для миграций БД)
- Docker

## Функционал

- Создание кошелька
- Получение информации о кошельке
- Пополнение баланса (депозит)
- Снятие средств (withdraw)

## Запуск приложения

### Требования

- Установленный Docker и Docker Compose
- JDK 17 (только для разработки)

### Запуск через Docker

1. Клонируйте репозиторий:
```bash
git clone https://github.com/alexeyakovlev/task.git
cd wallet-service
```

### Сборка и запуск

2. Соберите и запустите приложение:
```bash
docker-compose up --build
```
Приложение будет доступно по адресу: http://localhost:8080

3. Остановка приложения
```bash
docker-compose down -v
```
### Api Endpoints

1. Кошельки 

-POST /api/v1/wallets/save - Создать новый кошелек

{
"amount": 1000.00
}

GET /api/v1/wallets/{id} - Получить информацию о кошельке

POST /api/v1/wallets/change - Изменить баланс (депозит/снятие)

{
"id": "123e4567-e89b-12d3-a456-426614174000",

"amount": 100.00,

"operationType": "DEPOSIT"
}

### Разработка

1. Запуск для разработки

Убедитесь, что PostgreSQL запущен (можно использовать docker-compose)

Запустите приложение:
```bash
mvn spring-boot:run
```

Сборка
```bash
mvn clean package
```