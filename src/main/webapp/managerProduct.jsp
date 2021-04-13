<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<jsp:include page="menu.jsp"></jsp:include>

<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__text">
                    <h2>Quản lý sản phẩm</h2>
                    <a class="primary-btn" href="/ManagerProductServlet?action=viewPageCreateOrEdit" style="margin-top: 10px">Thêm mới</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->
<section class="shopping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-11">
                <div class="shopping__cart__table">
                    <table>
                        <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Ảnh</th>
                            <th colspan="2">Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <form action="/ManagerProductServlet" method="get">
                            <c:forEach items='${requestScope["listPro"]}' var="product">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__text">
                                            <h6>${product.productId}</h6>
                                        </div>
                                    </td>

                                    <td class="product__cart__item">
                                        <div class="product__cart__item__text">
                                            <h6>${product.name}</h6>
                                        </div>
                                    </td>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__text">
                                            <h6>${product.unitPrice}</h6>
                                        </div>
                                    </td>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__text">
                                            <h6>${product.quantityStock}</h6>
                                        </div>
                                    </td>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="${product.thumbnail}" alt="">
                                        </div>
                                    </td>
                                    <td class="cart__close">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </td>
                                    <td class="cart__close">
                                        <a href="/ManagerProductServlet?action=delete&productId=${product.productId}"><span class="glyphicon glyphicon-trash"></span></a>
                                    </td>
                                    </td>
                                </tr>
                            </c:forEach>
                        </form>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="continue__btn">
                            <a href="#">Continue Shopping</a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="continue__btn update__btn">
                            <a href="#"><i class="fa fa-spinner"></i> Update cart</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Shopping Cart Section End -->

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
