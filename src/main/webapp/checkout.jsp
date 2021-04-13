<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"></jsp:include>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Checkout</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="/index">Home</a>
                        <span>Checkout</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="CheckoutServlet?action=insertOrder&userId=${account.getUserId()}" method="post" onsubmit="alert('Đặt hàng thành công!')">
                    <div class="row">
                        <div class="col-lg-7 col-md-6">
<%--                            <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click--%>
<%--                            here</a> to enter your code</h6>--%>
                            <h6 class="checkout__title">Billing Details</h6>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Name:</p>
                                        <input type="text" value="${account.getName()}" disabled>
                                    </div>
                                </div>
<%--                                <div class="col-lg-6">--%>
<%--                                    <div class="checkout__input">--%>
<%--                                        <p>Last Name<span>*</span></p>--%>
<%--                                        <input type="text">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                            </div>
<%--                            <div class="checkout__input">--%>
<%--                                <p>Country<span>*</span></p>--%>
<%--                                <input type="text">--%>
<%--                            </div>--%>
                            <div class="checkout__input">
                                <p>Address:</p>
                                <input type="text" class="checkout__input__add" value="${account.getAddress()}" disabled>
<%--                                <input type="text" placeholder="Apartment, suite, unite ect (optinal)">--%>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone:</p>
                                        <input type="text" value="${account.getPhone()}" disabled>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email:</p>
                                        <input type="text" value="${account.getEmail()}" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="acc">
                                    Create an account?
                                    <input type="checkbox" id="acc">
                                    <span class="checkmark"></span>
                                </label>
                                <p>Create an account by entering the information below. If you are a returning customer
                                please login at the top of the page</p>
                            </div>
                            <div class="checkout__input">
                                <p>Account Password<span>*</span></p>
                                <input type="text">
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="diff-acc">
                                    Note about your order, e.g, special noe for delivery
                                    <input type="checkbox" id="diff-acc">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="checkout__input">
                                <p>Order notes<span>*</span></p>
                                <input type="text"
                                placeholder="Notes about your order, e.g. special notes for delivery.">
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-6">
                            <div class="checkout__order">
                                <h6 class="order__title">Your order</h6>
                                <div class="checkout__order__products">Product <span>Total</span></div>
                                <ul class="checkout__total__products">
                                    <c:set var = "stt" value = "${0}"/>
                                    <c:forEach items='${requestScope["carts"]}' var="cart">
                                    <li><samp><c:out value = "${stt = stt + 1}"/></samp>. ${cart.getProductName()} (x${cart.getQuantity()}) <span>$ ${cart.getProductPrice()*cart.getQuantity()}</span></li>
                                    </c:forEach>
                                </ul>
                                <ul class="checkout__total__all">
                                    <li>Subtotal <span>$750.99</span></li>
                                    <c:set var = "total" value = "${0}"/>
                                    <c:forEach items='${requestScope["carts"]}' var="cart">
                                        <span hidden>${total = total + cart.getProductPrice()*cart.getQuantity()}</span>
                                    </c:forEach>
                                    <li>Total <span>$ <c:out value = "${total}"/></span></li>
                                </ul>
                                <button type="submit" class="site-btn">PLACE ORDER</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

<jsp:include page="footer.jsp"></jsp:include>

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search End -->

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