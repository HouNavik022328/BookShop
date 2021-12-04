
<%@page import="com.bookshop.shopping.CartProduct"%>
<%@page import="com.bookshop.shopping.Cart"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
                <div class="header-top">
                    <a href="/landing.jsp" class="header__logo no-deco font-black">
                        <i class="fas fa-bookmark"></i>
                        Books.
                    </a>
                    <div class="header__searchbar">
                        <input type="text" placeholder="Find your favourite books..." class="searchbar__input">
                        <div class="searchbar__logo">
                            <i class="fas fa-search"></i>
                        </div>   
                    </div>
                    <div class="header-right">
                        <a href="cart.jsp" class="shopping-cart__link"><i class="fas fa-shopping-cart header-right__logo"></i></a>
                        <div class="header-right__user">
                            <i class="far fa-user header-right__logo"></i>
                            <ul class="user-menu">
                                <li class="sign "><a class="sign__link sign__link--sign-up si no-deco" href="">Sign Up</a></li>
                                <li class="sign "><a class="sign__link sign__link--log-in no-deco" href="">Log In</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="cart-wrapper">
                <h1 class="section-header" style="text-align:center;">Check Out</h1>
                <div class="checkout">
                    <div class="checkout-inner">
                        <%
                            Cart cart = (Cart)session.getAttribute("CART");
                            boolean checkQuantity = true;
                            
                            int totalMoney = 0;
                            if (cart != null) {
                                if (cart.getCart().size() != 0) {
                        %>
                        <form action="MainController" method="POST">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Full name <span class="required">*</span></label><br>
                                    <input type="text" required class="form-control" name="fullName">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Address: <span class="required">*</span></label><br>
                                    <input type="text" value="" class="form-control" name="address" required="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>City / Town: <span class="required">*</span></label><br>
                                    <input class="form-control" required type="text" name="city">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>State / County <span class="required">*</span></label><br>
                                    <input class="form-control" required type="text" name="state">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Phone <span class="required">*</span></label><br>
                                    <input class="form-control" required type="text" name="phone" pattern="/^+84(7\d|8\d|9\d)\d{9}$/">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                        <label>Order notes</label><br>
                                        <textarea name="note" rows="5" class="form-control"></textarea>
                                </div>
                            </div>
                        <%
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
                            LocalDateTime now = LocalDateTime.now();
                            String order_time = dtf.format(now);
                        %>
                        <input type="hidden" name="order_time" value="<%= order_time %>">
                        <div class="col-12 payment_method_custom">
                            <div class="payment_method">
                                <div class="custome-radio">
                                    <input class="form-check-input" type="radio" name="payment_option" id="exampleRadios5" value="vnpay" checked="">
                                    <label class="form-check-label" for="exampleRadios5">Checkout with VN Pay - Discount 5%</label>
                                    <p data-method="option5" class="payment-text">Pay via VN Pay; you can pay with your credit card if you don't have a VN Pay account.</p>
                                </div>
                            </div>
                    </div>
                        <%
                            if (cart == null || cart.getCart().size() == 0 || checkQuantity == false) {
                        %>
                        <button style="cursor: not-allowed;" disabled="" type="submit" name="action" value="GetInfoCheckout" class="btn btn-default">Place Order</button>
                        <%        
                            }
                            else {
                            %>
                            <button type="submit" name="action" value="GetInfoCheckout" class="btn btn-default">Place Order</button>
                        <%
                            }
                        %>
                    </form>
                         <%
                                for(CartProduct product : cart.getCart().values()) {
                                    totalMoney += product.getQuantity() * product.getPrice();
                                    if (product.getQuantity() == 0) {
                                        checkQuantity = false;
                                    }
                        %>
                        <div class="cart-total-price">
                        <div class="prices">
                            <div class="prices__items">
                                <div class="prices__item">
                                    <span class="prices__text">Discount:</span>
                                    <span class="prices__value">0đ</span>
                                </div>
                                <div class="prices__item">
                                    <span class="prices__text">Estimated:</span>
                                    <span class="prices__value"><%= totalMoney %>đ</span>
                                </div>
                            </div>
                            <div class="prices__total">

                                <span class="prices__text">Total price:</span>
                                <span class="prices__value prices__value-final"><%= totalMoney %>đ</span>
                            </div>
                        </div>
                    </div>
                    </div>
                       
                    
                    <%
                                }
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>