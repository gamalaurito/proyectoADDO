<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession().getAttribute("activo") == null) {
        response.sendRedirect("index.html");
    } else {
%>
        <!doctype html>
        <html lang="es">
          <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="Admin Jamaica">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Floreria Jamaica</title>

            <!-- Estilos -->
            <link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=es" rel="stylesheet">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" href="css/material.min.css">
            <link rel="stylesheet" href="css/styles.css">
            <link rel="stylesheet" href="css/cambios.css">
            <link rel="stylesheet" href="css/mdl-jquery-modal-dialog.css">
          </head>
          <body>
            <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
              <!--Header-->
              <div class="android-header mdl-layout__header mdl-layout__header--waterfall" id = "header">
                <div class="mdl-layout__header-row">
                  <span class="android-title mdl-layout-title">
                    <img class="android-logo-image" src="images/floreria-logo-white.png">
                  </span>
                  <!-- Agregamos un espacio entre el logo de y el menú -->
                  <div class="android-header-spacer mdl-layout-spacer"></div>
                  <div class="android-search-box mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right mdl-textfield--full-width">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="search-field">
                      <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                      <input class="mdl-textfield__input" type="text" id="search-field"/>
                    </div>
                  </div>
                  <!-- Menú -->
                  <div class="android-navigation-container">
                    <nav class="android-navigation mdl-navigation">
                      <a class="mdl-navigation__link mdl-typography--text-uppercase" onclick = "menu(0)">
                        <i class = "material-icons">apps</i>Home
                      </a>
                      <a class="mdl-navigation__link mdl-typography--text-uppercase" onclick = "menu(2)">
                        <i class="material-icons">account_circle</i>
                      </a>
                      <a class="mdl-navigation__link mdl-typography--text-uppercase" onclick = "menu(3)">
                        <i class = "material-icons">group</i>Mis Salas
                      </a>
                    </nav>
                  </div>

                  <button class="android-more-button mdl-button mdl-js-button mdl-button--icon mdl-js-ripple-effect" id="more-button">
                    <i class="material-icons">more_vert</i>
                  </button>
                  <ul class="mdl-menu mdl-js-menu mdl-menu--bottom-right mdl-js-ripple-effect" for="more-button">
                      <li class="mdl-menu__item" onclick = "menu(100)">Cerrar Sesión</li>
                    <li class="mdl-menu__item">Reportar Problema</li>
                    <li class="mdl-menu__item">FAQs</li>
                    <li class="mdl-menu__item">Ayuda</li>
                    <li class="mdl-menu__item">Descargar Manual</li>
                  </ul>
                  <span class="android-mobile-title mdl-layout-title">
                    <img class="android-logo-image" src="images/floreria-logo1.png">
                  </span>
                </div>
              </div>
              <!--Header-->
              <!--Menu-->
              <div class="android-drawer mdl-layout__drawer">
                <span class="mdl-layout-title">
                  <img class="android-logo-image1" src="images/floreria-logo.png">
                </span>
                <nav class="mdl-navigation sidenav" id = "menu">
                  <a onclick = "menu(0)">
                    <i class = "material-icons">home</i>Home
                  </a>
                  <a id = "perfil" onclick = "menu(1)">
                    <i class="material-icons">account_circle</i> Nuevo
                  </a>
                  <a id = "groups" onclick = "menu(2)">
                    <i class="material-icons mdl-js-ripple-effect">group</i>Categoria
                  </a>
                  <a>
                  </a>
                  <a href="menu(100)">
                      <i class = "material-icons">close</i>Cerrar Sesion
                  </a>
                </nav>
              </div>
              <!--Menu-->
              <!--Main-->
              <div class="android-content mdl-layout__content" id = "container">
                <a name="top"></a>
                <div id = "content">
                    <%@include file = "registroProducto.jsp"%>
                </div>
                <footer class="android-footer mdl-mega-footer" id = "footer">
                  <div class="mdl-mega-footer--top-section">
                    <div class="mdl-mega-footer--left-section">
                      <button class="mdl-mega-footer--social-btn">G +</button>
                      &nbsp;
                      <button class="mdl-mega-footer--social-btn">F</button>
                      &nbsp;
                      <button class="mdl-mega-footer--social-btn">T</button>
                    </div>
                    <div class="mdl-mega-footer--right-section">
                      <a class="mdl-typography--font-light" href="#top">
                        <i class="material-icons">expand_less</i>
                      </a>
                    </div>
                  </div>

                  <div class="mdl-mega-footer--middle-section">
                    <p class="mdl-typography--font-light">Floreria Jamaica</p>
                  </div>

                  <div class="mdl-mega-footer--bottom-section">
                    <a class="android-link android-link-menu mdl-typography--font-light" id="version-dropdown">
                      Configuraciones
                      <i class="material-icons">arrow_drop_up</i>
                    </a>
                    <ul class="mdl-menu mdl-js-menu mdl-menu--top-left mdl-js-ripple-effect" for="version-dropdown">
                      <li class="mdl-menu__item">Ayuda</li>
                      <li class="mdl-menu__item">FAQ</li>
                      <li class="mdl-menu__item">Idioma</li>
                      <li class="mdl-menu__item">Editar</li>
                    </ul>
                    <a class="android-link mdl-typography--font-light" href="">Política de Privacidad</a>
                  </div>
                </footer>
              </div>
              <!--Main-->
            </div>
            <script src="js/material.min.js"></script>
            <script src="js/jquery-1.11.3.js"></script>
            <script src="js/mdl-jquery-modal-dialog.js"></script>
            <script src="js/jamaica.js"></script>
            <script src="js/eq_editor-lite-18.js"></script>
            <script src="js/eq_config.js"></script>
          </body>
        </html>
<%  }%>
