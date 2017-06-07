<!DOCTYPE html>
<html>
<head>
<title>Jamaica Flower Shop</title>
<%@include file = "imports.jsp"%>
<%@page import="java.text.DecimalFormat,java.util.ArrayList,bean.Producto,bean.Catalogo,bean.Categoria"%>
<%
    Catalogo cata = (Catalogo)session.getAttribute("catalogo");
    ArrayList<Producto> productos = cata.getProductos();
    DecimalFormat df = new DecimalFormat("#.##");
%>
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
<div class="product-model">	 
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index.jsp">Home</a></li>
			<li class="active">Productos</li>
		</ol>
		<h2>Our Products</h2>		
		<div class="col-md-12 product-model-sec">
			<%
                            double total;
                            int i = -1;
                            for(Producto p: productos) {
                                i ++;
                                total = p.getPrecio() + p.getPrecio() * p.getIva();
                                byte[] bdata = p.getImagenes().get(0).getUrl().getBytes(1, (int) p.getImagenes().get(0).getUrl().length());
                                String url = new String(bdata);
                        %>
                            <a>
                                    <div class="product-grid love-grid">
                                            <div class="more-product"><span> </span></div>						
                                            <div class="product-img b-link-stripe b-animate-go  thickbox">
                                                    <img src="data:image/jpeg;base64,<%=url%>" class="img-responsive imagen-prod" alt=""/>
                                                    <div class="b-wrapper">
                                                            <h4 class="b-animate b-from-left  b-delay03">							
                                                                    <button class="btns">
                                                                            <span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
                                                                            Quick View
                                                                    </button>
                                                            </h4>
                                                    </div>
                                            </div>
                                    </a>						
                                    <div class="product-info simpleCart_shelfItem">
                                            <div class="product-info-cust prt_name">
                                                    <h4><%=p.getNombre()%></h4>
                                                    <p>ID: <%=p.getProdNum()%></p>
                                                    <span class="item_price">$<%=df.format(total)%></span>								
                                                    <input type="text" class="item_quantity" value="1" id="<%=p.getProdNum()%>"/>
                                                    <input type="button" class="item_add items" value="ADD" onclick="addToCart('<%=p.getProdNum()%>', <%=p.getPrecio()%>)">
                                            </div>													
                                            <div class="clearfix"> </div>
                                    </div>
                            </div>
                        <%}%>
                    </div>
        </div>
                        
<%@include file='footer.jsp'%>
</body>
</html>
