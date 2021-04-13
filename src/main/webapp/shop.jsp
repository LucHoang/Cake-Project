<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="menu.jsp"></jsp:include>

<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__text">
                    <h2>Shop</h2>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__links">
                    <a href="/index">Trang chủ</a>
                    <a href="/shop">Cửa hàng</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="shop__option">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <form action="#">
                        <c:forEach items="${listC}" var="o">
                            <a href="category?categoryId=${o.categoryId}"
                               class="list-group-item ${tag == o.categoryId?"active":""}" style="background-color: #f08632; color: white">${o.name}</a>
                        </c:forEach>
                    </form>
                </div>
                <div class="col-lg-5 col-md-5">
                    <div class="shop__option__search">
                        <form action="/search">
                            <input name="text" type="text" placeholder="Search">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4">
                    <div class="shop__option__right">
                        <form style="border: 1px">
                            <p>Sắp xếp theo giá</p>
                            <a href="/sortH2L">Cao xuống thấp</a><br>
                            <a href="/sortL2H">Thấp đến cao</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <c:forEach items="${requestScope['listP']}" var="o">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${o.thumbnail}">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="detail?productId=${o.productId}">${o.name}</a></h6>
                            <div class="product__item__price">${o.unitPrice}</div>
                            <div class="cart_add">
                                <a href="#">Thêm vào giỏ hàng</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</section>
<!-- Shop Section End -->

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