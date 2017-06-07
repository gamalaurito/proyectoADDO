<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Subir Archivo-->
<div class="android-more-section">
  <div class="android-section-title mdl-typography--display-1-color-contrast">Registro Nuevo Producto</div>
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
          <label>Piezas</label>
        </div>
        <div class = "group">
          <input type="text" class = "form" name = "precio" id = "precio" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Precio sin Iva</label>
        </div>
        <div class = "group">
          <input type="text" class = "form" name = "iva" id = "iva" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Iva de 0.0 a 1.0</label>
        </div>
        <div class = "group">
          <input type="text" class = "form" name = "desc" id = "desc" value = "" required>
          <span class="highlight"></span>
          <span class="bar"></span>
          <label>Descripcion</label>
        </div>
        <div class="group">
          <i id = "cloud" class = "material-icons" onclick = "document.getElementById('file_add').click()">cloud_upload</i>
          <span id = "file_name"> Selecciona tu Imagen</span>
          <input id="file_add" id ="foto" name ="foto" accept = "image/*" class="none" style = "display:none;" onchange = "fileName()" type="file" />
        </div>
        <span onclick = "if(validaProd())document.getElementById('registro').submit()" class = "android-update-profile">
          <i class = "material-icons android-profile-edit">send</i>Registrar Producto
        </span>
      </form>
    </div>
  </div>
</div>
<!--Subir Archivo-->
