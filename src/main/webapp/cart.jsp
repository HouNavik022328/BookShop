
<%@page import="com.bookshop.shopping.CartProduct"%>
<%@page import="com.bookshop.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/cart.css">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-5.15.4-web/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500;600;700&family=Noto+Serif+Display:ital,wght@1,500;1,600&family=Zilla+Slab:wght@400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="wrapper">
            <div class="header-top__wrapper">
                <jsp:include page="header-top.jsp"/>
            </div>

            <div class="cart-wrapper">
                <h1 class="section-header" style="text-align:center;">Shopping Cart</h1>
                <%
                    Cart cart = (Cart)session.getAttribute("CART");
                    String error = (String)request.getAttribute("ERROR_CART");
                    if (error == null) {
                        error = "";
                    }

                    boolean checkQuantity = true;

                    int totalMoney = 0;
                    if (cart != null) {
                        if (cart.getCart().size() != 0) {
                %>  
                <div class="cart">
                    <div class="cart-inner">
                        <ul class="cart-title">
                            <li class="cart-item__checkbox"><span></span></li>
                            <li class="cart-item__name">Product Name</li>
                            <li class="cart-item__price ">Item Price</li>
                            <li class="cart-item__amount ">Amount</li>
                            <li class="cart-item__total">Total Price</li>
                            <li class="cart-item__options">Operate</li>
                        </ul>
                        <%
                                for(CartProduct product : cart.getCart().values()) {
                                    totalMoney += product.getQuantity() * product.getPrice();
                                    if (product.getQuantity() == 0) {
                                        checkQuantity = false;
                                    }
                        %>
                        <ul class="cart-item">
                            <li class="cart-item__checkbox"><span></span></li>
                            <li class="cart-item__info">
                                <div class="info__pic">
                                </div>
                                <h3 class="info__name"><%= product.getName() %></h3>
                            </li>
                            <li class="cart-item__price"><%= product.getPrice() %>đ</li>
                            <li class="cart-item__amount product-quantity" data-title="Quantity">
                                <form action="MainController" method="POST">
                                    <button id="submit-form-cart" name="action" value="UpdateCart" type="submit" style="visibility: hidden; float: right"></button>
                                    <div class="quantity">
                                        <button type="submit" name="action" value="UpdateCart" class="minus">-</button>
                                        <input type="number" min="1" name="quantity" value="<%= product.getQuantity() %>" title="Qty" class="qty" size="4">
                                        <button type="submit" name="action" value="UpdateCart" class="plus">+</button>
                                        <input type="hidden" name="ID" value="<%= product.getID() %>">
                                    </div>
                                </form>
                            </li>
                            <li class="cart-item__total" style="color:var(--primary-color); font-weight:600;"><%= product.getQuantity() * product.getPrice() %></li>
                            <li class="cart-item__options">
                                <a class="delete-cart" href="MainController?action=DeleteCart&ID=<%= product.getID() %>">Delete</a>
                            </li>
                        </ul>
                        <%
                            }
                        %>
                    </div>
                    <div class="cart-total-price">
                        <div class="prices">
                            <div class="prices__items">
                                <div class="prices__item">
                                    <span class="prices__text">Discount:</span>
                                    <span class="prices__value">0đ</span>
                                </div>
                                <div class="prices__item">
                                    <span class="prices__text">Estimated:</span>
                                    <span class="prices__value"><%= totalMoney %></span>
                                </div>
                            </div>
                            <div class="prices__total">

                                <span class="prices__text">Total price:</span>
                                <span class="prices__value prices__value-final"><%= totalMoney %></span>
                            </div>
                            <div class="btn btn--submit">
                                <a class="cart-btn" href="checkout.jsp">Buy</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                        else if (cart.getCart().size() == 0){
                %>
                        <img class="empty-cart-img" src="./assets/img/empty-cart.jpg">
                <%
                        }
                    }
                    else if (cart == null || cart.getCart().size() == 0){
                %>
                <img class="empty-cart-img" src="./assets/img/empty-cart.jpg">
                <%
                    }
                %>        
            </div>
        </div>
    </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="./assets/js/app.js"></script>        
</body>
</html>
