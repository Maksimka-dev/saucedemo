#language:ru
#encoding:UTF-8

@test
Функционал: Проверка заказа товара

  Сценарий: Проверка полного пути заказа товара
    Допустим открыта страница "https://www.saucedemo.com/"
    Когда в поле имя пользователя введено значение "standard_user"
    И в поле пароль введено значение "secret_sauce"
    И переходим на следующую страницу кнопокй "Login"
    Тогда открылась страница "https://www.saucedemo.com/inventory.html"
    Когда у товара "Sauce Labs Backpack" выполнено нажатие на кнопку ADD TO CART
    И нажата ссылка "Shopping Cart"
    Тогда открылась страница "https://www.saucedemo.com/cart.html"
    Когда товар "Sauce Labs Backpack" показан в корзине
    И нажата кнопка "Checkout"
    Тогда открылась страница "https://www.saucedemo.com/checkout-step-one.html"
    Когда в поле имя введено значение "Oleg"
    И в поле фамилия введено значение "Petrov"
    И в поле почтовый индекс введено значение "222160"
    И переходим на следующую страницу кнопокй "Continue"
    Тогда открылась страница "https://www.saucedemo.com/checkout-step-two.html"
    Когда товар "Sauce Labs Backpack" показан в таблице
    И нажата кнопка "Finish"
    Тогда открылась страница "https://www.saucedemo.com/checkout-complete.html"
    Когда нажата кнопка "Back Home"
    Тогда открылась страница "https://www.saucedemo.com/inventory.html"