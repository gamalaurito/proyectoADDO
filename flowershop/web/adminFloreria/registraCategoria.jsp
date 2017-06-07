<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Subir Archivo-->
<script>
    $( function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
</script>
<div class="android-more-section">
  <div class="android-section-title mdl-typography--display-1-color-contrast">Registra Nueva Categoria</div>
  <div class = "mdl-grid">
    <div class = "mdl-cell mdl-cell--12-col mdl-cell--12-col-tablet mdl-cell--12-col-phone" id = "add_file">
      <form enctype="multipart/form-data" method = "post" name = "registro" id = "registro" action = "registraProducto">
        <div class="group">
          <input type="text" class = "form" name = "prodNum" id = "prodNum" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Numero</label>
        </div>  
        <div class="group">      
          <input type="text" class = "form" name = "nombre" id = "nombre" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Nombre</label>
        </div>
        <div class = "group">
          <input type="number" class = "form" name = "piezas" id = "piezas" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Descripcion</label>
        </div>
        <div class = "group">
          <input type="text" class = "form" name = "tags" id = "tags" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Numero de Productos</label>
        </div>
        <span onclick = "if(validaCate())document.getElementById('registro').submit()" class = "android-update-profile">
          <i class = "material-icons android-profile-edit">send</i>Registrar Categoria
        </span>
      </form>
    </div>
  </div>
</div>
<!--Subir Archivo-->
