<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"></jsp:include>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Shopping cart</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="/index?action=showProductCategory&id=1">Home</a>
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach items='${requestScope["carts"]}' var="cart">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="${cart.getThumbnail()}" alt="" width="90" height="90">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6><c:out value="${cart.getProductName()}"/></h6>
                                            <h5><c:out value="${cart.getProductPrice()}"/></h5>
                                        </div>
                                    </td>
                                    <td class="quantity__item">
                                        <form action="CartServlet?action=update&id=${cart.getCartId()}&userId=${account.getUserId()}" method="post">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                    <input type="text" name="quantity" value="${cart.getQuantity()}">
                                            </div>
                                        </div>
                                        <input type="submit" value=" Update "/>
                                        </form>
                                    </td>
                                    <td class="cart__price">$ <c:out value="${cart.getProductPrice()*cart.getQuantity()}"/></td>
                                    <td class="cart__close"><a href="/CartServlet?action=delete&id=${cart.getCartId()}&userId=${account.getUserId()}"><span class="icon_close"></span></a></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn">
                                <a href="#">Continue Shopping</a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-lg-4">

                    <div class="cart__total">
                        <h6>Cart total</h6>
                        <ul>
                            <li>Subtotal <span>$ 0</span></li>
                            <c:set var = "total" value = "${0}"/>
                            <c:forEach items='${requestScope["carts"]}' var="cart">
                                <span hidden>${total = total + cart.getProductPrice()*cart.getQuantity()}</span>
                            </c:forEach>
                            <li>Total <span>$ <c:out value = "${total}"/></span></li>
                        </ul>
                        <a href="/CheckoutServlet?userId=${account.getUserId()}" class="primary-btn">Proceed to checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

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