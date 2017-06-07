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
<div class="login_sec">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">Iniciar Secion</li>
		 </ol>
		 <h2>Iniciar Secion</h2>
		 <div class="col-md-6 log">
				<p>Binvenido.</p>
				<form action="login" method="post">
                                        <h5>Email:</h5>
					<input type="text" name = "user" value="">
					<h5>Contraseña:</h5>
					<input type="password" name = "pass" value="">
					<input type="submit" value="Iniciar Secion">
					<a class="acount-btn" href="#"><span onclick = "action('registro')">Crear una Cuenta</span></a>
				</form>
				<a href="#"><span onclick = "action('forpass')">Forgot Password ?</span></a>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<%@include file='footer.jsp'%>
</body>
</html>
