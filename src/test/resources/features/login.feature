#language:ru
#encoding:UTF-8

@test
Функционал: Тестирование логина

  Структура сценария: Проверка логина с разными username
    Допустим открыта страница "https://www.saucedemo.com/"
    Когда в поле имя пользователя введено значение "<userName>"
    И в поле пароль введено значение "<password>"
    И переходим на следующую страницу кнопокй "Login"
    Тогда открылась страница "https://www.saucedemo.com/inventory.html"

    Примеры:
      | userName                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |