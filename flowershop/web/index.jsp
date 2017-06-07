<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Jamaica Flower Shop</title>
<%@include file = "imports.jsp"%>
</head>
<body>
	<%if(request.getSession().getAttribute("active") != null) {%>
		<%@include file="headerL.jsp"%>
	<%} else {%>
		<%@include file="header.jsp"%>
        <%}%>
        <!---->
               <%@include file="menu.jsp"%>
        <!---->
<!---->
<div id="content">
    <div class="banner">
             <div class="container">
             </div>
    </div>
    <!---->
    <div class="welcome">
             <div class="container" >
                     <div class="col-md-3 welcome-left">
                             <h2>Bienvenido a nuestro sitio</h2>
                     </div>
                     <div class="col-md-9 welcome-right">
                             <h3>Floreria Jamaica.</h3>
                            <p>
                                Desde 1990 acompañandote en tus momentos mas importantes.
                                Sabemos que en cada arreglo se transmiten grandes sentimientos y emociones.
                                Nos gusta romper la barrera de la distancia y hacer llegar detalles a personas especiales que deseas sorprender.
                                Nos alimenta recibir sonrisas cuando nos permites a través de nuestro servicio, ser parte de tu historia.     
                            </p>
                     </div>
             </div>
    </div>
    <!---->
    <div class="bride-grids">
             <div class="container">
                     <div class="col-md-4 bride-grid">
                             <div class="content-grid l-grids" onclick = "getArticulos(-100,'rosa')">
                                    <figure class="effect-bubba">
                                                    <img src="images/corazonRosas.jpg" alt="" class = "imagen-home"/>
                                                    <figcaption>
                                                            <h4>Rosas</h4>
                                                            <p>Para esa persona que camina a tu lado en esta vida.</p>
                                                    </figcaption>
                                    </figure>
                                    <div class="clearfix"></div>
                                    <h3>Rosas</h3>
                             </div>
                             <div class="content-grid l-grids" onclick = "getArticulos(-100,'ramo')">
                                     <figure class="effect-bubba">
                                                    <img src="images/ramoRosasRojas.jpg" class="imagen-home" alt=""/>
                                                    <figcaption>
                                                            <h4>Ramos </h4>
                                                            <p>Para ese dia tan importante en tu vida.</p>
                                                    </figcaption>
                                     </figure>
                                     <div class="clearfix"></div>
                                     <h3>Ramos</h3>
                             </div>
                     </div>
                     <div class="col-md-4 bride-grid">
                            <div class="clearfix"></div>
                            <div class="content-grid l-grids">
                                <img src="images/floreriajamaica.png" alt=""/>
                                <h2>&nbsp;&nbsp;Floreria Jamaica</h2>
                            </div>
                     </div>
                     <div class="col-md-4 bride-grid">
                             <div class="content-grid l-grids" onclick = "getArticulos(-100,'figura')">
                                     <figure class="effect-bubba">
                                                    <img src="images/perrito2.jpg" class ="imagen-home" alt=""/>
                                                    <figcaption>
                                                            <h4>Figuras</h4>
                                                            <p>Para robarle una sonrisa a alguien.</p>
                                                    </figcaption>
                                     </figure>
                                     <div class="clearfix"></div>
                                     <h3>Figuras</h3>
                             </div>
                             <div class="content-grid l-grids" onclick = "getArticulos(-100,'corona')">
                                     <figure class="effect-bubba">
                                                    <img src="images/corona2.jpg" class ="imagen-home" alt=""/>
                                                    <figcaption>
                                                            <h4>Coronas </h4>
                                                            <p>Para decir adios</p>
                                                    </figcaption>
                                     </figure>
                                            <div class="clearfix"></div>
                                     <h3>Coronas</h3>
                             </div>
                     </div>
                     <div class="clearfix"></div>
             </div>
    </div>
    <!---->
    <!--
    <div class="featured">
             <div class="container">
                     <h3>Featured Products</h3>
                     <div class="feature-grids">
                             <div class="col-md-3 feature-grid jewel">
                                     <a href="product.html"><img src="images/f1.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid">
                                     <a href="product.html"><img src="images/f2.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 68000</p>
                                                     <span class="pric1"><del>Rs 70000</del></span>
                                                     <span class="disc">[10% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid jewel">
                                     <a href="product.html"><img src="images/f3.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Wedding Ceramic Pot </h4>
                                                     <p>Rs 1200</p>
                                                     <span class="pric1"><del>Rs 2000</del></span>
                                                     <span class="disc">[10% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid">
                                     <a href="product.html"><img src="images/f4.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                             <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="clearfix"></div>
                     </div>
                     <div class="feature-grids">
                             <div class="col-md-3 feature-grid jewel">
                                     <a href="product.html"><img src="images/p7.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid">
                                     <a href="product.html"><img src="images/p11.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid jewel">
                                     <a href="product.html"><img src="images/p12.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="col-md-3 feature-grid">
                                     <a href="product.html"><img src="images/f2.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Jewellerys #1</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="product.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="product.html"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                             </div>
                             <div class="clearfix"></div>
                     </div>
             </div>
    </div>
    -->
    <!---->
    <!--
    <div class="arrivals">
             <div class="container">
                     <h3>New Arrivals</h3>
                     <div class="arrival-grids">
                             <ul id="flexiselDemo1">
                                     <li>
                                             <a href="product.html"><img src="images/a1.jpg" alt=""/>
                                             <div class="arrival-info">
                                                     <h4>Fusion Black Polyester Suits</h4>
                                                     <p>Rs 12000</p>
                                                     <span class="pric1"><del>Rs 18000</del></span>
                                                     <span class="disc">[12% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                                     </li>
                                     <li>
                                             <a href="product.html"><img src="images/a2.jpg" alt=""/>
                                                    <div class="arrival-info">
                                                     <h4>Vogue4All White Net Gowns</h4>
                                                     <p>Rs 14000</p>
                                                     <span class="pric1"><del>Rs 15000</del></span>
                                                     <span class="disc">[10% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                                     </li>
                                     <li>
                                             <a href="product.html"><img src="images/a3.jpg" alt=""/>
                                                    <div class="arrival-info">
                                                     <h4>Platinum Waist Coat Set Navy</h4>
                                                     <p>Rs 4000</p>
                                                     <span class="pric1"><del>Rs 8500</del></span>
                                                     <span class="disc">[45% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                                     </li>
                                     <li>
                                        <a href="product.html"> <img src="images/a4.jpg" alt=""/>
                                                    <div class="arrival-info">
                                                     <h4>La Fanatise White Net Gowns</h4>
                                                     <p>Rs 18000</p>
                                                     <span class="pric1"><del>Rs 21000</del></span>
                                                     <span class="disc">[8% Off]</span>
                                             </div>
                                             <div class="viw">
                                                    <a href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a>
                                             </div>
                                             <div class="shrt">
                                                    <a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Shortlist</a>
                                             </div></a>
                                     </li>
                                    </ul>
                                    <script type="text/javascript">
                                     $(window).load(function() {
                                      $("#flexiselDemo1").flexisel({
                                            visibleItems: 4,
                                            animationSpeed: 1000,
                                            autoPlay: true,
                                            autoPlaySpeed: 3000,
                                            pauseOnHover:true,
                                            enableResponsiveBreakpoints: true,
                                            responsiveBreakpoints: {
                                                    portrait: {
                                                            changePoint:480,
                                                            visibleItems: 1
                                                    },
                                                    landscape: {
                                                            changePoint:640,
                                                            visibleItems: 2
                                                    },
                                                    tablet: {
                                                            changePoint:768,
                                                            visibleItems: 3
                                                    }
                                            }
                                    });
                                    });
                                    </script>
                                    <script type="text/javascript" src="js/jquery.flexisel.js"></script>
                      </div>
             </div>
    </div>
    -->
</div>
<%@include file='footer.jsp'%>
</body>
</html>
