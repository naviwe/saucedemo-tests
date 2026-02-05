# Saucedemo UI Automation

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java&logoColor=white)](https://www.java.com/)
[![Selenium](https://img.shields.io/badge/Selenium-4.21+-green?style=flat&logo=selenium)](https://www.selenium.dev/)
[![JUnit5](https://img.shields.io/badge/JUnit-5.10+-blue?style=flat&logo=junit5)](https://junit.org/junit5/)
[![Allure](https://img.shields.io/badge/Allure-2.27+-brightgreen?style=flat&logo=allure)](https://allurereport.org/)
[![Maven](https://img.shields.io/badge/Maven-3+-c17a00?style=flat&logo=apache-maven)](https://maven.apache.org/)

Автотесты UI для демонстрационного сайта [saucedemo.com](https://www.saucedemo.com/)  
Покрытие сценариев авторизации с разными типами пользователей.

---

## Возможности проекта

- Page Object Model + Fluent Interface
- Поддержка браузеров Chrome и Firefox
- Чтение конфигурации из `config.properties`
- Thread-safe WebDriver (ThreadLocal)
- Allure-отчёты с аннотациями `@Step`, `@Epic`, `@Feature`, `@Story`, `@Severity`
- Явные ожидания через `WebDriverWait`
- Проверка основных сценариев логина на saucedemo

---

## Покрытые сценарии

| № | Сценарий                                 | Пользователь                  | Ожидаемый результат                              |
|---|------------------------------------------|-------------------------------|--------------------------------------------------|
| 1 | Успешный логин                           | standard_user                 | Открывается страница инвентаря                   |
| 2 | Некорректный пароль                      | standard_user + invalid pass  | Сообщение об ошибке                              |
| 3 | Заблокированный пользователь             | locked_out_user               | Сообщение "Sorry, this user has been locked out" |
| 4 | Пустые поля username и password          | —                             | Сообщение "Username is required"                 |
| 5 | Пользователь с задержкой (performance)   | performance_glitch_user       | Страница инвентаря загружается (с ожиданием)     |

---

## Технологии

- Java 17
- Selenium WebDriver 4.21+
- WebDriverManager (bonigarcia)
- JUnit 5
- Allure Framework
- Maven
- SLF4J + Logback

---

## Быстрый старт

### 1. Клонировать репозиторий

```bash
git clone https://github.com/your-username/saucedemo-automation.git
cd saucedemo-automation
```

### 2. Установить зависимости
```bash
mvn clean install
```

### 3. Запустить тесты

По умолчанию — Chrome:

```bash
mvn clean test
```

Явно указать браузер:
```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
```

### 4. Сформировать и открыть Allure-отчёт
```bash
mvn allure:serve
```