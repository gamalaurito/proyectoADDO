<!DOCTYPE html>
<html>
<head>
<title>Jamaica Flower Shop</title>
<%@include file = "imports.jsp"%>
<%@page import="java.text.DecimalFormat,java.util.ArrayList,bean.Producto,bean.Carrito"%>
<%
    
    DecimalFormat df = new DecimalFormat("#.##");
    Carrito carrito = (Carrito)session.getAttribute("carrito");
    ArrayList<Producto> productos = carrito.getProductos();
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
<div class="checkout">	 
    <div class="container">	
        <ol class="breadcrumb">
            <li><a href="index.jsp">Home</a></li>
            <li class="active">Carrito</li>
        </ol>
	<div class="col-md-9 product-price1">
            <div class="check-out">			
		<div class=" cart-items">
                    <h3>Mi Carrito</h3>
                    <div class="in-check" >
			<ul class="unit">
                            <li><span>Producto</span></li>
                            <li><span>Nombre</span></li>		
                            <li><span>Piezas</span></li>
                            <li><span>Total</span></li>
                            <li> </li>
                            <div class="clearfix"> </div>
			</ul>
                        <%
                            double total;
                            int i = -1;
                            for(Producto p: productos) {
                                i ++;
                                total = (p.getPrecio() + p.getPrecio() * p.getIva())*p.getPiezas();
                                byte[] bdata = p.getImagenes().get(0).getUrl().getBytes(1, (int) p.getImagenes().get(0).getUrl().length());
                                String url = new String(bdata);  
                        %>
			<ul class="cart-header">
                            <li class="ring-in">
                                <a>
                                    <img src="data:image/jpeg;base64,<%=url%>" class="img-responsive" alt="">
                                </a>
                            </li>
                            <li><span><%=p.getNombre()%></span></li>
                            <li><span><%=p.getPiezas()%></span></li>
                            <li><span><%=df.format(total)%></span></li>
                            <li onclick = "quitarProd(<%=i%>)"><a href="">Eliminar</a></li>
                            <div class="clearfix"> </div>
			</ul>
                        <%}%>
                    </div>
                </div>					  
            </div>
        </div>
	<div class="col-md-3 cart-total">
            <a class="continue" href="#">Mi carrito</a>
                <div class="price-details">
                    <h3>Detalles de precio</h3>
                    <span>Total</span>
                    <span class="total"><%=df.format(carrito.getTotal())%></span>
                    <span>Iva</span>
                    <span class="total"><%=df.format(carrito.getIva())%></span>
                    <span>Costo de envio</span>
                    <span class="total">0.00</span>
                    <div class="clearfix"></div>				 
		</div>	
		<h4 class="last-price">TOTAL</h4>
                <span class="total final"><%=df.format(carrito.getTotal()+carrito.getIva())%></span>
		<div class="clearfix"></div>
                <%if(carrito.getClienteNum() == 0) {%>
                    <a class="order" href="registro.jsp">Registrarse</a>
                <%} else if(carrito.getDirNum() != 0){%>
                    <a onclick="hacerPedido()" class="order" href="#">Comprar</a>
                <%} else {%>
                    <a class="order" href="regDireccion.jsp">Comprar</a>
                <%}%>
                <div class="total-item">
                    <h3>Opciones</h3>
                    <h4>Cupones</h4>
                    <a class="cpns" href="#">Aplicar cupones</a>
                    <%if(session.getAttribute("active")==null) {%>
                    <p><a href="login.jsp">Log In</a> to use accounts - linked coupons</p>
                    <%}%>
		</div>
            </div>
    </div>
</div>
<%@include file='footer.jsp'%>
</body>
</html>