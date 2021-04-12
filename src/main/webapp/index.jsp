<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"></jsp:include>

<!-- Hero Section Begin -->
<section class="hero">
  <div class="hero__slider owl-carousel">
    <div class="hero__item set-bg" data-setbg="img/hero/hero-1.jpg">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-lg-8">
            <div class="hero__text">
              <h2>Làm cho cuộc sống của bạn ngọt ngào hơn từng chút một!</h2>
              <a href="#" class="primary-btn">Bánh của chúng tôi</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="hero__item set-bg" data-setbg="img/hero/hero-1.jpg">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-lg-8">
            <div class="hero__text">
              <h2>Making your life sweeter one bite at a time!</h2>
              <a href="#" class="primary-btn">Our cakes</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Hero Section End -->

<!-- About Section Begin -->
<section class="about spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6">
        <div class="about__text">
          <div class="section-title">
            <span>GIỚI THIỆU CỬA HÀNG BÁNH KẸO</span>
            <h2>Cakes and bakes from the house of Queens!</h2>
          </div>
          <p>"Cake Shop" là một Thương hiệu của Jordan, khởi đầu là một doanh nghiệp gia đình nhỏ.
            Chủ sở hữu là Tiến sĩ Iyad Sultan và Tiến sĩ Sereen Sharabati, được hỗ trợ bởi đội ngũ 80 nhân viên.</p>
        </div>
      </div>
      <div class="col-lg-6 col-md-6">
        <div class="about__bar">
          <div class="about__bar__item">
            <p>Cake design</p>
            <div id="bar1" class="barfiller">
              <div class="tipWrap"><span class="tip"></span></div>
              <span class="fill" data-percentage="95"></span>
            </div>
          </div>
          <div class="about__bar__item">
            <p>Cake Class</p>
            <div id="bar2" class="barfiller">
              <div class="tipWrap"><span class="tip"></span></div>
              <span class="fill" data-percentage="80"></span>
            </div>
          </div>
          <div class="about__bar__item">
            <p>Cake Recipes</p>
            <div id="bar3" class="barfiller">
              <div class="tipWrap"><span class="tip"></span></div>
              <span class="fill" data-percentage="90"></span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- About Section End -->

<!-- Categories Section Begin -->
<div class="categories">
  <div class="container">
    <div class="row">
      <div class="categories__slider owl-carousel">
        <a href="/index?action=showProductCategory&id=1">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-029-cupcake-3"></span>
            <h5>Bánh cupcake</h5>
          </div>
        </div>
        </a>
        <a href="/index?action=showProductCategory&id=2">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-034-chocolate-roll"></span>
            <h5>Bơ</h5>
          </div>
        </div>
        </a>
        <a href="/index?action=showProductCategory&id=3">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-005-pancake"></span>
            <h5>Nhung đỏ</h5>
          </div>
        </div>
        </a>
        <a href="/index?action=showProductCategory&id=4">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-030-cupcake-2"></span>
            <h5>Bánh quy</h5>
          </div>
        </div>
        </a>
        <a href="/index?action=showProductCategory&id=5">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-006-macarons"></span>
            <h5>Bánh vòng</h5>
          </div>
        </div>
        </a>
        <a href="/index?action=showProductCategory&id=1">
        <div class="categories__item">
          <div class="categories__item__icon">
            <span class="flaticon-006-macarons"></span>
            <h5>Cupcake</h5>
          </div>
        </div>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- Categories Section End -->

<!-- Product Section Begin -->
<section class="product spad">
  <div class="container">
    <div class="row">
<c:forEach items='${requestScope["products"]}' var="product" begin="1" end="8">
      <div class="col-lg-3 col-md-6 col-sm-6">
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
            <div class="product__item__price">${product.getUnitPrice()} $</div>
            <div class="cart_add">
              <a href="/CartServlet?action=insert&productName=${product.getName()}&productPrice=${product.getUnitPrice()}&priceTotal=${product.getUnitPrice()}&userId=1&thumbnail=${product.getThumbnail()}">Thêm vào giỏ hàng</a>
            </div>
          </div>
        </div>
      </div>
</c:forEach>
    </div>
  </div>
</section>
<!-- Product Section End -->

<!-- Class Section Begin -->
<section class="class spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <div class="class__form">
          <div class="section-title">
            <span>Học làm bánh</span>
            <h2>Làm từ bàn tay <br />của chính mình</h2>
          </div>
          <form action="#">
            <input type="text" placeholder="Name">
            <input type="text" placeholder="Phone">
            <select>
              <option value="">Studying Class</option>
              <option value="">Writting Class</option>
              <option value="">Reading Class</option>
            </select>
            <input type="text" placeholder="Type your requirements">
            <button type="submit" class="site-btn">đăng ký</button>
          </form>
        </div>
      </div>
    </div>
    <div class="class__video set-bg" data-setbg="img/class-video.jpg">
      <a href="https://youtu.be/T_4wLg1gVJ0"
         class="play-btn video-popup"><i class="fa fa-play"></i></a>
    </div>
  </div>
</section>
<!-- Class Section End -->

<!-- Team Section Begin -->
<section class="team spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-7 col-md-7 col-sm-7">
        <div class="section-title">
          <span>Nhóm của chúng tôi</span>
          <h2>Sweet Baker </h2>
        </div>
      </div>
      <div class="col-lg-5 col-md-5 col-sm-5">
        <div class="team__btn">
          <a href="#" class="primary-btn">Tham gia với chúng tôi</a>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="team__item set-bg" data-setbg="img/team/team-1.jpg">
          <div class="team__item__text">
            <h6>Randy Butler</h6>
            <span>Decorater</span>
            <div class="team__item__social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
              <a href="#"><i class="fa fa-youtube-play"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="team__item set-bg" data-setbg="img/team/team-2.jpg">
          <div class="team__item__text">
            <h6>Randy Butler</h6>
            <span>Decorater</span>
            <div class="team__item__social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
              <a href="#"><i class="fa fa-youtube-play"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="team__item set-bg" data-setbg="img/team/team-3.jpg">
          <div class="team__item__text">
            <h6>Randy Butler</h6>
            <span>Decorater</span>
            <div class="team__item__social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
              <a href="#"><i class="fa fa-youtube-play"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="team__item set-bg" data-setbg="img/team/team-4.jpg">
          <div class="team__item__text">
            <h6>Randy Butler</h6>
            <span>Decorater</span>
            <div class="team__item__social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-twitter"></i></a>
              <a href="#"><i class="fa fa-instagram"></i></a>
              <a href="#"><i class="fa fa-youtube-play"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Team Section End -->

<!-- Testimonial Section Begin -->
<section class="testimonial spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <div class="section-title">
          <span>Testimonial</span>
          <h2>Phản hồi của khách hàng</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="testimonial__slider owl-carousel">
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-1.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Kerry D.Silva</h5>
                <span>New york</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-2.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Kerry D.Silva</h5>
                <span>New york</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-1.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Ophelia Nunez</h5>
                <span>London</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-2.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Kerry D.Silva</h5>
                <span>New york</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-1.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Ophelia Nunez</h5>
                <span>London</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="testimonial__item">
            <div class="testimonial__author">
              <div class="testimonial__author__pic">
                <img src="img/testimonial/ta-2.jpg" alt="">
              </div>
              <div class="testimonial__author__text">
                <h5>Kerry D.Silva</h5>
                <span>New york</span>
              </div>
            </div>
            <div class="rating">
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star"></span>
              <span class="icon_star-half_alt"></span>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
              ut labore et dolore magna aliqua viverra lacus vel facilisis.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Testimonial Section End -->

<!-- Instagram Section Begin -->
<section class="instagram spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-4 p-0">
        <div class="instagram__text">
          <div class="section-title">
            <span>Follow us on instagram</span>
            <h2>Những khoảnh khắc ngọt ngào được lưu lại làm kỷ niệm.</h2>
          </div>
          <h5><i class="fa fa-instagram"></i> @sweetcake</h5>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="row">
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic">
              <img src="img/instagram/instagram-1.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic middle__pic">
              <img src="img/instagram/instagram-2.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic">
              <img src="img/instagram/instagram-3.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic">
              <img src="img/instagram/instagram-4.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic middle__pic">
              <img src="img/instagram/instagram-5.jpg" alt="">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-6">
            <div class="instagram__pic">
              <img src="img/instagram/instagram-3.jpg" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Instagram Section End -->

<!-- Map Begin -->
<div class="map">
  <!--        <div class="container">-->
  <!--            <div class="row">-->
  <!--                <div class="col-lg-4 col-md-7">-->
  <!--                    <div class="map__inner">-->
  <!--                        <h6>COlorado</h6>-->
  <!--                        <ul>-->
  <!--                            <li>1000 Lakepoint Dr, Frisco, CO 80443, USA</li>-->
  <!--                            <li>Sweetcake@support.com</li>-->
  <!--                            <li>+1 800-786-1000</li>-->
  <!--                        </ul>-->
  <!--                    </div>-->
  <!--                </div>-->
  <!--            </div>-->
  <!--        </div>-->
  <div class="map__iframe">
    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14895.691654844091!2d105.7682175!3d21.0357702!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xe713200541b7456d!2sCodeGym!5e0!3m2!1svi!2s!4v1617441072578!5m2!1svi!2s" height="300" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
  </div>
</div>
<!-- Map End -->

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
