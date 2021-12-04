<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/product.css">
    <link rel="stylesheet" href="./assets/css/item.css">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-5.15.4-web/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500;600;700&family=Noto+Serif+Display:ital,wght@1,500;1,600&family=Zilla+Slab:wght@400;500;600&display=swap" rel="stylesheet">
    
</head>
<body>
    <div class="main">
        <div class="wrapper">
            <div class="header-top__wrapper">
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
                                <li class="sign "><a class="sign__link sign__link--sign-up si no-deco" href="">Sign Up</a></li>
                                <li class="sign "><a class="sign__link sign__link--log-in no-deco" href="">Log In</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="header-nav">
                    <ul class="header-nav__list">
                        <li class="list__item">
                            <a href="/landing.html" class="list__item-link no-deco">Home</a>
                        </li>
                        <li class="list__item">
                            <a href="#" class="list__item-link no-deco">Popular</a>
                        </li>
                        <li class="list__item">
                            <a href="/category.html" class="list__item-link no-deco">
                                Category
                                <i class="fas fa-chevron-down"></i>
                            </a>
                            <ul class="list__sub-menu">
                                <ul class="sub-menu__content">
                                    <h3 class="sub-menu__header">Content</h3>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Horror</a></li>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Love</a></li>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Science</a></li>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Educational</a></li>
                                </ul>
                                <ul class="sub-menu__content">
                                    <h3 class="sub-menu__header">Type</h3>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Used</a></li>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Sales</a></li>
                                    <li class="sub-menu__item"><a class="sub-menu__item-link no-deco" href="">Rare</a></li>
                                </ul>
                            </ul>
                        </li>
                        <li class="list__item">
                            <a href="#" class="list__item-link no-deco">Bestseller</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="product">
                <div class="product-info">
                    <div class="product-info__item">
                        <div class="product-info__img">
                            <img src="${requestScope.PRODUCT_DETAIL.image}" alt="" class="width-100" style="height: 100%">
                        </div>
                    </div>
                    <div class="product-info__item">
                        <div class="product-view">
                            <h1 class="product-view__item product-view__name">${requestScope.PRODUCT_DETAIL.name}</h1>
                            <h3 class="product-view__item product-view__author">${requestScope.PRODUCT_DETAIL.author}</h3>
                            <div class="product-view__item item-rating item-rating--large">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="far fa-star"></i>
                            </div>
                            <h3 class="product-view__item product-view__price">${requestScope.PRODUCT_DETAIL.price}đ</h3>
                        </div>
                        <div class="product-view__description">
                            <h2 class="product-view__description-header">PRODUCT DESCRIPTION</h2>
                            <p class="product-view__description-paragraph">${requestScope.PRODUCT_DETAIL.description}</p>
                        </div>
                        <div class="buy-btns">
                            <button class="btn btn--buy btn--primary">Buy Now</button>
                            <a href="MainController?action=AddToCart&ID=${requestScope.PRODUCT_DETAIL.ID}" class="btn btn--buy btn--secondary"><i class="cart fas fa-cart-plus"></i>Add to cart</a>
                        </div>
                    </div>
                </div>
    
                <div class="product-review">
                    <div class="product-review__header section-header">
                        <h1 class="header-item">Reviews and ratings</h1>
                    </div>
                    <div class="product-review__container">
                        <div class="product-review__overall">
                            <div class="overall__ratings-summary">4.8 out of 5</div>
                            <div class="overall__ratings-resutl">
                                <div class="overall-rating item-rating item-rating--large">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="far fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="product-ratings">
                            <div class="product-rating">
                                <div class="product-rating__avatar">
                                    <img src="./assets/img/male.jpg" alt="" class="avatar__img width-100">
                                </div>
                                <div class="product-rating__main">
                                    <h3 class="client__name">Nguyễn Văn A</h3>
                                    <div class="item-rating item-rating--medium mt-10">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                    <p class="client__comment mt-10">This product is very good!</p>
                                </div>
                            </div>
                            <div class="product-rating">
                                <div class="product-rating__avatar">
                                    <img src="./assets/img/male.jpg" alt="" class="avatar__img width-100">
                                </div>
                                <div class="product-rating__main">
                                    <h3 class="client__name mt-10">Nguyễn Văn B</h3>
                                    <div class="item-rating item-rating--medium mt-10">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                    <p class="client__comment mt-10">Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam sed pariatur aut soluta ut reiciendis tenetur voluptas molestias perspiciatis rem dolore voluptate odio aperiam adipisci, incidunt ea qui ratione nihil!</p>
                                </div>
                            </div>
                            <div class="product-rating">
                                <div class="product-rating__avatar">
                                    <img src="./assets/img/male.jpg" alt="" class="avatar__img width-100">
                                </div>
                                <div class="product-rating__main">
                                    <h3 class="client__name mt-10">Nguyễn Văn C</h3>
                                    <div class="item-rating item-rating--medium mt-10">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                    <p class="client__comment mt-10">This product is very good!</p>
                                </div>
                            </div>
                            <div class="product-rating">
                                <div class="product-rating__avatar">
                                    <img src="./assets/img/male.jpg" alt="" class="avatar__img width-100">
                                </div>
                                <div class="product-rating__main">
                                    <h3 class="client__name mt-10">Nguyễn Văn D</h3>
                                    <div class="item-rating item-rating--medium mt-10">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                    <p class="client__comment mt-10">This product is very good!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="section">
                <div class="section__container">
                    <div class="section-header">
                        <h1 class="header-item">Frequently viewed items</h1>
                    </div>
                    <div class="item-wrapper">
                        <div class="item">
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
                        <div class="item">
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
                        <div class="item">
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
                        <div class="item">
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
                        <div class="item">
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
