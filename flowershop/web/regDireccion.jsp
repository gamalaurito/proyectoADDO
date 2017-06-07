<!DOCTYPE html>
<html>
<head>
<title>Jamaica Flower Shop</title>
<%@include file = "imports.jsp"%>
</head>
<body>
	<%if(request.getSession().getAttribute("active") == null) {
            response.sendRedirect("index.jsp");
	} else {%>
		<%@include file="header.jsp"%>
        <!---->
                <%@include file="menu.jsp"%>
        <!---->
<div class="container">
	<ol class="breadcrumb">
		<li>
                    <a href="index.jsp">Home</a>
		</li>
		<li class="active">Registro Direccion</li>
	</ol>
	<div class="registration">
		<div class="registration_left">
			<h2>Agrega <span> Nueva Direccion.</span></h2>
			<!-- [if IE] 
			< link rel='stylesheet' type='text/css' href='ie.css'/>  
			[endif] -->  

			<!-- [if lt IE 7]>  
			< link rel='stylesheet' type='text/css' href='ie6.css'/>  
			<! [endif] -->  
			<script>
                                var forP = "vom";
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
                                                        ban = true;
                                                        alert(ban);
                                                        if(ban)
                                                            this.innerHTML = '...Sending';
                                                        else
                                                            return false;
						}
					}
				})();
			</script>
                        <!--calle colonia cod_pos ciudad estado contacto telefono dsc-->
			<div class="registration_form">
				<!-- Form -->
				<form id="registration_form" action="agregaDireccion" method="post">
					<div>
						<label>
                                                    <input id = "calle" name = "calle" placeholder="Calle: " type="text" tabindex="1" required autofocus>
						</label>
					</div>
					<div>
						<label>
                                                    <input id = "colonia" name="colonia" placeholder="Colonia:" type="text" tabindex="2" required autofocus>
						</label>
					</div>
                                        <div>
						<label>
                                                    <input id = "codpos" name ="codpos" placeholder="Codigo Postal:" type="text" tabindex="3" required autofocus>
						</label>
					</div>	
					<div>
						<label>
                                                    <input id = "ciudad" name ="ciudad" placeholder="Municipio o Delegacion:" type="text" tabindex="4" required autofocus>
						</label>
					</div>					
					<div>
						<label>
							<input id = "estado" name = "estado" placeholder="Estado:" type="text" tabindex="5" required autofocus>
						</label>
					</div>						
					<div>
						<label>
							<input id = "contacto" name ="contacto" placeholder="Contacto:" type="text" tabindex="6" required>
						</label>
					</div>				
					<div>
						<label>
							<input id = "telefono" name ="telefono" placeholder="Telefono:" type="tel" tabindex="7" required>
						</label>
					</div>	
					<div>
						<input type="submit" value="Agregar Direccion" id="register-submit">
					</div>
				</form>
				<!-- /Form -->
			</div>
		</div>
		<div class="registration_left">
			<h2>Forma Pago</h2>
                        <div class = "Buttons">
                            <h3 class="b3">
                                <a><span id = "vom" class="label label-success" onclick="camForPag('vom')">Visa o Master Card</span></a>
                                <a><span id = "ame" class="label label-info" onclick="camForPag('ame')">American Express</span></a>
                                <a><span id = "dep" class="label label-info" onclick="camForPag('dep')">Deposito</span></a>
                            </h3>
                        </div>
			<div id="vomF" class="registration_form" style="">
			<!-- Form -->
				<form id="forma_pagovom" action="forpago" method="post" >
					<div>
						<label>
							<input id = "ownervom" name = "owner" placeholder="Propetiario de la Tarjeta: V" type="text" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "numTvom" name = "numT" placeholder="Numero de la Tarjeta:" type="tel" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "numTvom" name = "numT" placeholder="Numero de la Tarjeta:" type="tel" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "fecVvom" name = "fecV" placeholder="Fecha Vencimiento (mm/YY):" type="text" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "codSvom" name = "codS" placeholder="Codigo Seguridad:" type="password" required>
						</label>
					</div>
				</form>
			<!-- /Form -->
			</div>
                        <div id="ameF" class="registration_form" style="display: none;">
			<!-- Form -->
				<form id="forma_pagoame" action="forpago" method="post" >
					<div>
						<label>
                                                    <input id = "ownerame" name = "owner" placeholder="Propetiario de la Tarjeta:" type="text" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "numTame" name = "numT" placeholder="Numero de la Tarjeta:" type="tel" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "numTame" name = "numT" placeholder="Numero de la Tarjeta:" type="tel" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "fecVame" name = "fecV" placeholder="Fecha Vencimiento (mm/YY):" type="text" required>
						</label>
					</div>
                                        <div>
						<label>
							<input id = "codSame" name = "codS" placeholder="Codigo Seguridad:" type="password" required>
						</label>
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
<%}%>