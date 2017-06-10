function action(name) {
  $.ajax({
      type: 'POST',
      url: 'sendPage',
      data: {
          "name" : name
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
          $('#content').html("");
          $('#content').html(datos);
      },
      complete : function() {
          //window.componentHandler.upgradeDom();
          console.log(name);
      }
  });
}


function validaRegistro() {
    var x = $('#nombre');
    if(x.val().length === 0) {
        x.focus();
        alert("Ingrese su nombre por favor.");
        return false;
    }
    x = $('#email');
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    if(!emailRegex.test(x.val())) {
        x.focus();
        alert("Ingrese email valido");
        return false;
    }
    x = $('#telefono');
    telefonoRegex = /^[0-9]{10}$/i;
    if(!telefonoRegex.test(x.val())) {
        x.focus();
        alert("Ingrese telefono valido");
        return false;
    }
    x = $('#mobile');
    if(!telefonoRegex.test(x.val())) {
        x.focus();
        alert("Ingrese telefono movil valido");
        return false;
    }
    x = $('#password');
    y = $('#re-pass');
    if(x.val() != y.val()) {
        x.focus();
        y.focus();
        alert("Contraseñas no coinciden");
        return false;
    }
    if(!$("#checkB").is(':checked')) {
        alert("Por favor acepte los terminos y condiciones");
        return false;
    }
    return true;
}

function getMenu() {
    $.ajax({
        type: 'POST',
        url: 'getMenu',
        statusCode: {
            404: function() {
                    alert('Alerta ');
            },
            500: function(){
                    alert('Error oooohh');
            }
        },
        success: function(datos) {
            $('#divMenu').html("");
            $('#divMenu').html(datos);
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function getArticulos(id, word) {
    $.ajax({
        type: 'POST',
        url: 'getArticulos',
        data : {
            idx : id,
            words: word
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
            window.location = "articulos.jsp?b="+word;
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function addToCart(prod, pre) {
    $.ajax({
        type: 'POST',
        url: 'agregaProducto',
        data : {
            item: prod,
            pzs: $('#'+prod).val(),
            precio: pre
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
            datos = datos.split(',');
            $('#totalC').html(datos[0]);
            $('#totalP').html(datos[1]);
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function quitarProd(id) {
    $.ajax({
        type: 'POST',
        url: 'quitarProducto',
        data : {
            idx : id
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
            window.location = "checkout.jsp";
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function hacerPedido() {
     $.ajax({
        type: 'POST',
        url: 'hacerPedido',
        statusCode: {
            404: function() {
                    alert('Alerta ');
            },
            500: function(){
                    alert('Error oooohh');
            }
        },
        success: function(datos) {
            alert("Compra realizada");
            window.location = "index.jsp";
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function vaciarCarrito() {
    $.ajax({
        type: 'POST',
        url: 'vaciarCarrito',
        statusCode: {
            404: function() {
                    alert('Alerta ');
            },
            500: function(){
                    alert('Error oooohh');
            }
        },
        success: function(datos) {
            window.location = "index.jsp";
        },
        complete : function() {
            //window.componentHandler.upgradeDom();
            console.log(name);
        }
    });
}

function trackPedido() {
    $.ajax({
         type: 'POST',
         url: 'setPedido',
         statusCode: {
             404: function() {
                     alert('Alerta ');
             },
             500: function(){
                     alert('Error oooohh');
             }
         },
         success: function(datos) {
            if(datos.startsWith("Exito"))window.location = "trackorder.jsp";
            else alert("No tiene pedidos disponibles");
         },
         complete : function() {
             console.log(name);
         }
     }); 
}

function cerrarSesion() {
    $.ajax({
        type: 'POST',
        url: 'logout',
        statusCode: {
            404: function() {
                    alert('Alerta ');
            },
            500: function(){
                    alert('Error oooohh');
            }
        },
        success: function(datos) {
            window.location = "index.jsp";
        },
        complete : function() {
            console.log(name);
        }
    });
}

function camForPag(x) {
    forP = x;
    $('#forma_pagovom').css("display", "none");
    $('#forma_pagoame').css("display", "none");
    $('#forma_pagodep').css("display", "none");
    $('#vom').removeClass("label-success");
    $('#vom').addClass("label-info");
    $('#ame').removeClass("label-success");
    $('#ame').addClass("label-info");
    $('#dep').removeClass("label-success");
    $('#dep').addClass("label-info");
    $('#forma_pago'+x).css("display", "block");
    $('#'+x).removeClass("label-info");
    $('#'+x).addClass("label-success");
}

