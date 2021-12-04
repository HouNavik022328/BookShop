<%@page import="com.bookshop.users.UserDTO"%>
<div class="header-top">
    <a href="landing.jsp" class="header__logo no-deco font-black">
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
                <%
                    UserDTO user = (UserDTO)session.getAttribute("LOGIN_USER");
                    if (user == null) {

                %>
                <li class="sign "><a class="sign__link sign__link--sign-up si no-deco" href="">Sign Up</a></li>
                <li class="sign "><a class="sign__link sign__link--log-in no-deco" href="login.html">Log In</a></li>
                <%
                    }
                else {
                %>
                <li class="sign "><a class="sign__link sign__link--log-in no-deco" href="MainController?action=Logout">Log Out</a></li>
                <%
                }
                %>
            </ul>
        </div>
    </div>
</div>