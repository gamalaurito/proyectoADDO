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
<div class="container">
	<ol class="breadcrumb">
		<li>
                    <a href="index.jsp">Home</a>
		</li>
		<li class="active">Registro</li>
	</ol>
	<div class="registration">
		<div class="registration_left">
			<h2>Registro <span> crear una cuenta.</span></h2>
			<!-- [if IE] 
			< link rel='stylesheet' type='text/css' href='ie.css'/>  
			[endif] -->  

			<!-- [if lt IE 7]>  
			< link rel='stylesheet' type='text/css' href='ie6.css'/>  
			<! [endif] -->  
			<script>
				(function() {
					// Create input element for testing
					var inputs = document.createElement('input');
					// Create the supports object
					var supports = {};
					supports.autofocus   = 'autofocus' in inputs;
					supports.required    = 'required' in inputs;
					supports.placeholder = 'placeholder' in inputs;
					// Fallback for autofocus attribute
					if(!supports.autofocus) {
					}
					// Fallback for required attribute
					if(!supports.required) {
					}
					// Fallback for placeholder attribute
					if(!supports.placeholder) {

					}
					// Change text inside send button on submit
					var send = document.getElementById('register-submit');
					if(send) {
						send.onclick = function () {
                                                        alert("enviar")
                                                        ban = validaRegistro();
                                                        alert(ban);
                                                        if(ban)
                                                            this.innerHTML = '...Sending';
                                                        else
                                                            return false;
						}
					}
				})();
			</script>
			<div class="registration_form">
				<!-- Form -->
				<form id="registration_form" action="registroCliente" method="post">
					<div>
						<label>
                                                    <input id = "nombre" name = "nombre" placeholder="Nombre: " type="text" tabindex="1" required autofocus>
						</label>
					</div>
					<div>
						<label>
                                                    <input id = "email" name="email" placeholder="Email:" type="email" tabindex="2" required autofocus>
						</label>
					</div>
                                        <div>
						<label>
                                                    <input id = "telefono" name ="telefono" placeholder="Telefono:" type="tel" tabindex="3" required autofocus>
						</label>
					</div>	
					<div>
						<label>
                                                    <input id = "mobile" name ="mobile" placeholder="Telefono Movil:" type="tel" tabindex="4" required autofocus>
						</label>
					</div>					
					<div>
						<label>
							<input id = "password" name = "password" placeholder="Contraseña:" type="password" tabindex="5" required autofocus>
						</label>
					</div>						
					<div>
						<label>
							<input id = "re-pass" name ="re-pass" placeholder="Re-ingrese contraseña:" type="password" tabindex="5" required>
						</label>
					</div>	
					<div>
						<input type="submit" onclick = "return validaRegistro()"  value="Crear una Cuenta" id="register-submit">
					</div>
					<div class="sky-form">
						<label class="checkbox">
							<input id = "checkB" type="checkbox" name="checkbox" ><i></i>Acepto &nbsp;<a class="terms" href="#"> los terminos y condiciones</a>
						</label>
					</div>
				</form>
				<!-- /Form -->
			</div>
		</div>
		<div class="registration_left">
			<h2>Ya tienes una cuenta</h2>
			<div class="registration_form">
			<!-- Form -->
				<form id="registration_form" action="login" method="post">
					<div>
						<label>
							<input id = "user" name = "user" placeholder="Email:" type="email">
						</label>
					</div>
					<div>
						<!--<label>-->
							<input id = "pass" name = "pass" placeholder="Contraseña" type="password">
						<!--</label>-->
					</div>						
					<div>
						<input type="submit" value="Iniciar Secion" id="register-submit">
					</div>
				</form>
			<!-- /Form -->
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!---->
<%@include file='footer.jsp'%>
</body>
</html>