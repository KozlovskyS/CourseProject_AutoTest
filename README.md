# Курсовой проект по модулю «Автоматизация тестирования»
## Процедура запуска автотестов
### Настройка окружения
На компьютере должно быть установлено ПО:
- **Git** — система управления версиями. Используется для переноса проекта на локальный компьютер
- **Java Development Kit (JDK) ver.11 или выше** - язык программирования
- **IntelliJ IDEA**, с установленными плагинами Lombok, Docker, Gradle - интегрированная среда разработки
- **Docker Desktop** — система контейнеризации приложений. Используется для запуска контейнера MySQL
### Клонирование проекта
Выполнить в терминале команду: git clone https://github.com/KozlovskyS/CourseProject_AutoTest.git
### Запуск автотестов
1. Открыть проект в IntelliJ IDEA
2. Запустить Docker Desktop
3. Запустить контейнер MySQL командой:   docker-compose up<br>
   Дождаться сообщения в терминале: _Plugin ready for connections_
4. Запустить приложение командой:  java -jar ./artifacts/aqa-shop.jar<br>
   Дождаться сообщения в терминале  _Started ShopApplication._ Приложение доступно в браузере  [http://localhost:8080](http://localhost:8080).
5. Запустить автотестирование командой:  ./gradlew clean test
6. Сформировать отчеты Allure командой:   ./gradlew allureServe
7. Завершить работу приложения и контейнера: Ctrl+C,  docker-compose down

