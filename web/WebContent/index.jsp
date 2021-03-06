<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Insert Code - Aprende Programaci�n</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="blue-grey lighten-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo"><img class="responsive-img" src="imagenes/Insert_Project.png" height="20px" width="100px" ></a>
      <ul class="right hide-on-med-and-down">
        <li><a   href="login.jsp">Ingresar</a></li>
        <li><a href="listcur">Cursos</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a  href="login.jsp">Ingresar</a></li>
        <li><a href="listcur">Cursos</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Comienza a Programar</h1>
      <div class="row center">
        <h5 class="header col s12 light">Los mejores cursos gratuitos de la red</h5>
      </div>
      <div class="row center">
        <a href="usuario.jsp" id="download-button" class="btn-large waves-effect waves-light cyan darken-4">Registrate</a>
      </div>
      <br><br>

    </div>
  </div>


  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center purple-text"><i class="material-icons">query_builder</i></h2>
            <h5 class="center">CLASES CONCRETAS</h5>

            <p class="light">Clases con duraci�n m�xima de dos horas, faciles de llevar en tu d�a a d�a de aprendizaje.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">today</i></h2>
            <h5 class="center">ACCESO 24/7</h5>

            <p class="light">Accede a los cursos en cualquier momento, desde cualquier lugar.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center red-text text-accent-3"><i class="material-icons">chat</i></h2>
            <h5 class="center">APRENDIZAJE COLOBORATIVO</h5>

            <p class="light">Aprende de los dem�s dejando tus dudas para que profesores y compa�eros te ayuden.</p>
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div id="modal1" class="modal">
    <div class="modal-content">
      <form class="col s12" action="login" method="post">
      <div class="row">
        
        <div class="input-field col s6">
          <input id="nick" name="nick" type="text" class="validate">
          <label for="nick">Nick de Usuario</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" name="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
 
      <div class="center">
             <button class="btn waves-effect waves-light cyan darken-4" type="submit" name="action">

Ingresar<i class="material-icons right">send</i>
   
    </button>
    </div>
    </form>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
    </div>
  </div>

    
  </div>
  </div>

  <footer class="page-footer grey lighten-3">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="grey-text text-darken-3">INSERT CODE</h5>
          <p class="grey-text text-darken-3">Aprende a desarrollar aplicaciones web desde cero.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="grey-text text-darken-3">Acerca de</h5>
          <ul>
            <li><a class="grey-text text-darken-3" href="#!">Autor</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Planes</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Privacidad</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Terminos y condiciones</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="grey-text text-darken-3">Redes Sociales</h5>
          <ul>
            <li><a class="grey-text text-darken-3" href="#!">Facebook</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Twiter</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Youtube</a></li>
            <li><a class="grey-text text-darken-3" href="#!">Linkedin</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container grey-text text-darken-3">
      Made by <a class="blue-text text-darken-4" href="http://materializecss.com">Materialize</a>
      </div>
      </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
  <script>
      $(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
  });
  </script>

  </body>
</html>
