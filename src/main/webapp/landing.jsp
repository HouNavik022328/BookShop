
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/landing.css">
    <link rel="stylesheet" href="./assets/css/item.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-5.15.4-web/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500;600;700&family=Noto+Serif+Display:ital,wght@1,500;1,600&family=Zilla+Slab:wght@400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="wrapper">
            <header class="header">
                <div class="header-top__wrapper">
                    <jsp:include page="header-top.jsp"/>
                    <c:if test="${requestScope.ACTIVE_PRODUCT_LIST == null}">
                        <c:redirect url="MainController?action=GetLanding"></c:redirect>
                    </c:if>
                    
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
                                    Categoryyyyyyyyy
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
                <div class="header-bottom">
                    <div class="header-bottom__col">
                        <div class="header-bottom__quote">
                            <h1 class="header-bottom__quote-title">If you don’t like to read, you haven’t found the <span>right book</span>.</h1>
                            <p class="description">J.K. Rowling</p>
                        </div>
                        <!-- <button class="btn btn--primary">EXPLORE</button> -->
                    </div>
                    <div class="header-bottom__col col-img">
                    </div>
                </div>
            </header>
    
            <div class="content">
                <div class="section section--popular">
                    <a href="category.jsp" class="view-all font-white">View all</a>
                    <div class="section-popular__container">
                        <div class="section-header section-popular__header">
                            <h1 class="header-item font-white">Popular books of the month.</h1>
                        </div>
                        <div class="section-popular__item-wrapper item-wrapper">
                            <c:forEach items="${requestScope.ACTIVE_PRODUCT_LIST}" var="o">
                            <div class="section-popular__item item item-3">
                                <div class="item__description">
                                    <h2 class="item-name font-black">${o.name}</h2>
                                    <p class="item-author font-black">${o.author}</p>
                                    <div class="item-rating item-rating--medium">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
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
                <div class="section">
                    <div class="section-blog__container">
                        <div class="section-col-2 section-header">
                            <h1 class="header-item blog-header">Top 10 Vietnamese novels</h1>
                            <p class="header-description">
                                Novels have long become spiritual food for human life.
                                Not only in foreign countries, but also in Vietnam, there are countless good novels that have made their name in world literature.</p>
                                <button class="btn btn--primary">See the books</button>
                        </div>
                        <div class="section-col-2 section-img">
                            <!-- <img src="./assets/img/toi_thay_hoa_vang.jpg" alt=""> -->
                        </div>
                    </div>
                </div>
                <div class="section">
                    <div class="section-hint__container">
                        <c:forEach items="${requestScope.TYPE_LIST_3}" var="o">
                        <div class="section-hint__item">
                            <div class="hint-img ">
                                <img src="./assets/img/collection1.jpg" alt="" class="width-100" style="height:100%">
                            </div>
                            <div class="hint-content">
                                <h3 class="hint-content__item hint-header"><a href="#" class="no-deco hint-header__link">${o.name} Books</a></h3>
                                <p class="hint-content__item hint-description">Giving used books new life is what we do best. The choice of used books is massive - from classic novels to cookbooks, children's books, and so much more.</p>
                                <a href="MainController?action=GetType&ID=${o.ID}" class="hint-content__item go-to no-deco">
                                    Search for ${o.name} Books<i class="fas fa-arrow-right"></i>
                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="section">
                    <div class="section-recent__container">
                        <div class="section-header">
                            <h1 class="header-item">Frequently viewed items</h1>
                        </div>
                        <div class="section-recent__item-wrapper item-wrapper">
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                            <div class="item item--recent">
                                <div class="item__description">
                                    <h2 class="item-name">Tôi đi code dạo.</h2>
                                    <p class="item-author">Phạm Huy Hoàng</p>
                                </div>
                                <div class="item__img">
                                    <img src="./assets/img/book1.jpg" alt="" class="width-100">
                                </div>
                                <div class="quick-nav-modal">
                                    <button class="btn btn--slide-down"><a href="/product.html" class="product-view no-deco">View Item</a></button>
                                    <button class="btn btn--slide-up"><a href="" class="add-to-cart no-deco"><i class="fas fa-cart-plus"></i> Add to cart</i></a></button>
                                </div>
                            </div>
                        </div>
                    </div>
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