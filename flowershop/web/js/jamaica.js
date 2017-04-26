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
