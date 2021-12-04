
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category</title>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/category.css">
    <link rel="stylesheet" href="./assets/css/item.css">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-5.15.4-web/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500;600;700&family=Noto+Serif+Display:ital,wght@1,500;1,600&family=Zilla+Slab:wght@400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="wrapper">
            <div class="header-top__wrapper">
                <jsp:include page="header-top.jsp"/>
                <div class="header-nav">
                    <ul class="header-nav__list">
                        <li class="list__item">
                            <a href="landing.jsp" class="list__item-link no-deco">Home</a>
                        </li>
                        <li class="list__item">
                            <a href="#" class="list__item-link no-deco">Popular</a>
                        </li>
                        <li class="list__item">
                            <a href="category.jsp" class="list__item-link no-deco">
                                Category
                                <i class="fas fa-chevron-down"></i>
                            </a>
                            <ul class="list__sub-menu">
                                <ul class="sub-menu__content">
                                    <h3 class="sub-menu__header">Content</h3>
                                    <c:forEach items="${requestScope.CATEGORY_LIST}" var="o">
                                        <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="MainController?action=GetCate&ID=${o.ID}">${o.name}</a></li>
                                    </c:forEach>
                                </ul>
                                <ul class="sub-menu__content">
                                    <h3 class="sub-menu__header">Type</h3>
                                    <c:forEach items="${requestScope.TYPE_LIST}" var="o">
                                        <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="MainController?action=GetType&ID=${o.ID}">${o.name}</a></li>
                                    </c:forEach>
                                </ul>
                            </ul>
                        </li>
                        <li class="list__item">
                            <a href="#" class="list__item-link no-deco">Bestseller</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="category">
                <h1 class="category__header section-header" style="text-align:center;">Collection</h1>
                <ul class="category__tag">
                    <c:forEach items="${requestScope.CATEGORY_LIST}" var="o">
                        <li class="tag__item"><a href="MainController?action=GetCate&ID=${o.ID}" class="tag__item-link no-deco font-black">${o.name}</a></li>
                    </c:forEach>
                </ul>
                <c:if test="${requestScope.ACTIVE_PRODUCT_LIST == null}">
                    <c:redirect url="MainController?action=GetBook"></c:redirect>
                </c:if>
                <div class="category__item-wrapper item-wrapper">
                    <c:forEach items="${requestScope.ACTIVE_PRODUCT_LIST}" var="o">
                        <div class="category__item item ">
                            <div class="category__item-description item__description">
                                <h2 class="item-name font-black">${o.name}</h2>
                                <p class="item-author font-black">${o.author}</p>
                                <div class="item-rating item-rating--medium">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="far fa-star"></i>
                                </div>
                            </div>
                            <div class="item__img">
                                <img src="${o.image}" alt="" class="width-100">
                            </div>
                            <div class="quick-nav-modal">
                                <button class="btn btn--slide-down"><a href="MainController?action=Detail&ID=${o.ID}" class="product-view no-deco">View Item</a></button>
                                <button class="btn btn--slide-up"><a href="MainController?action=AddToCart&ID=${o.ID}" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="footer-nav">
                <a href="#" class="footer-nav__link no-deco">
                    <i class="fas fa-chevron-up"></i>
                    Back to top</a>
            </div>
        </footer>
    </div>
</body>
</html>