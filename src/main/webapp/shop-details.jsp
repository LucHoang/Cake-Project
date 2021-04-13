<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"></jsp:include>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Chi tiết sản phẩm</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="/index">Trang chủ</a>
                        <a href="shop.jsp">Cửa hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__img">
                        <div class="product__details__big__img">
                            <img class="big_img" src="${product.getThumbnail()}" alt="" width="440" height="440">
                        </div>
                        <div class="product__details__thumb">
                            <div class="pt__item active">
                                <img data-imgbigurl="${product.getThumbnail()}"
                                src="${product.getThumbnail()}" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${product.getThumbnail()}"
                                src="${product.getThumbnail()}" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${product.getThumbnail()}"
                                src="${product.getThumbnail()}" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="img/shop/details/product-big-3.jpg"
                                src="img/shop/details/product-big-3.jpg" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="img/shop/details/product-big-5.jpg"
                                src="img/shop/details/product-big-5.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <div class="product__label">${category.getName()}</div>
                        <h4>${product.getName()}</h4>
                        <h5>$${product.getUnitPrice()}</h5>
                        <p>${product.getProductDescription()}</p>
                        <ul>
                            <li>SKU: <span>${product.getProductId()}</span></li>
                            <li>Category: <span>${category.getName()}</span></li>
<%--                            <li>Tags: <span>Gadgets, minimalisstic</span></li>--%>
                        </ul>
                        <div class="product__details__option">
                            <c:if test="${sessionScope.account != null}">
                            <form action="ProductServlet?action=insert&productName=${product.getName()}&productPrice=${product.getUnitPrice()}&priceTotal=${product.getUnitPrice()}&userId=${account.getUserId()}&thumbnail=${product.getThumbnail()}&productId=${product.getProductId()}" method="post">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" name="quantity" value="1">
                                </div>
                            </div>
<%--                            <a href="#" class="primary-btn">Add to cart</a>--%>
<%--                            <a href="#" class="heart__btn"><span class="icon_heart_alt"></span></a>--%>
<%--                                <button class="primary-btn" type="submit">Add to cart</button>--%>
                                <input class="primary-btn" style="border: none" type="submit" value="Add to cart"/>
                            </form>
                            </c:if>
                            <c:if test="${sessionScope.account == null}">
                                <form action="login.jsp" method="post">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="text" name="quantity" value="1">
                                        </div>
                                    </div>
                                        <%--                            <a href="#" class="primary-btn">Add to cart</a>--%>
                                        <%--                            <a href="#" class="heart__btn"><span class="icon_heart_alt"></span></a>--%>
                                        <%--                                <button class="primary-btn" type="submit">Add to cart</button>--%>
                                    <input class="primary-btn" style="border: none" type="submit" value="Add to cart"/>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product__details__tab">
                <div class="col-lg-12">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                        </li>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Additional information</a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Previews(1)</a>--%>
<%--                        </li>--%>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="row d-flex justify-content-center">
                                <div class="col-lg-8">
                                    <p>${product.getProductDescription()}</p>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="tabs-2" role="tabpanel">
                            <div class="row d-flex justify-content-center">
                                <div class="col-lg-8">
                                    <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                        tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                        bite will send you to summertime. Each gift arrives in an elegant gift box and
                                        arrives with a greeting card of your choice that you can personalize online!2
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="tabs-3" role="tabpanel">
                            <div class="row d-flex justify-content-center">
                                <div class="col-lg-8">
                                    <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                        tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                        bite will send you to summertime. Each gift arrives in an elegant gift box and
                                        arrives with a greeting card of your choice that you can personalize online!3
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Details Section End -->

    <!-- Related Products Section Begin -->
    <section class="related-products spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="section-title">
                        <h2>Related Products</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="related__products__slider owl-carousel">

                    <c:forEach items='${requestScope["products"]}' var="product" begin="1" end="6">
                    <div class="col-lg-3">
                        <div class="product__item">
                            <a href="/ProductServlet?action=view&id=${product.getProductId()}&categoryId=${product.getCategoryId()}">
                            <div class="product__item__pic set-bg" data-setbg="${product.getThumbnail()}">
                                <div class="product__label">
                                    <span>${category.getName()}</span>
                                </div>
                            </div>
                            </a>
                            <div class="product__item__text">
                                <h6><a href="/ProductServlet?action=view&id=${product.getProductId()}&categoryId=${product.getCategoryId()}">${product.getName()}</a></h6>
                                <div class="product__item__price">$${product.getUnitPrice()}</div>
                                <div class="cart_add">
                                    <c:if test="${sessionScope.account != null}">
                                    <a href="/CartServlet?action=insert&productName=${product.getName()}&productPrice=${product.getUnitPrice()}&priceTotal=${product.getUnitPrice()}&userId=${account.getUserId()}&thumbnail=${product.getThumbnail()}&productId=${product.getProductId()}">Add to cart</a>
                                    </c:if>
                                    <c:if test="${sessionScope.account == null}">
                                        <a href="login.jsp">Add to cart</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
    <!-- Related Products Section End -->

<jsp:include page="footer.jsp"></jsp:include>


<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery.barfiller.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nicescroll.min.js"></script>
<script src="js/main.js"></script>
</body>

</html>