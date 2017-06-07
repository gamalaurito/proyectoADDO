function loginEmpleado() {
    $.ajax({
        type: 'POST',
        url: 'admminLogin',
        data : {
            usuario : $('#usuario').val(),
            pass: $('#pass').val()
        },
        statusCode: {
            404: function() {
                    alert('Alerta ');
            },
            500: function(){
                    alert('Error oooohh');
            }
        },
        success: function(datos) {
            alert("exito");
            window.location = "index.jsp";
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
                
}

function validaProd() {
        var num = $('#prodNum');
	var name = $('#nombre');
	var piezas = $('#piezas');
        var precio = $('#precio');
        var iva = $('#iva');
        var desc = $('#desc');
        var foto = $("#file_add");
	if(name.val() == "" || piezas.val() == "" || precio.val() == "" || iva.val() == "" || desc.val() == "") {
		alert("Favor de llenar todos los campos");
		return false;
	}
	if(isNaN(piezas.val())) {
		piezas.val("");
                piezas.focus();
		alert("Numero de piezas invalidas, favor de verificarlo.");
		return false;
	}
        if(isNaN(precio.val())) {
		precio.val("");
                precio.focus();
		alert("Precio invalido, favor de verificarlo.");
		return false;
	}
        
        if(isNaN(iva.val())) {
		iva.val("");
                iva.focus();
		alert("Iva invalido, favor de verificarlo.");
		return false;
	}
        if(!foto.val()) {
                alert("Foto no seleccionada, favor de elegir una foto.");
		return false;
        }
	return true;
}


function fileName() {
	document.getElementById("file_name").innerHTML = " Archivo: " + document.getElementById("file_add").value;
}