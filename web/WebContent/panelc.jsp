<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Insert Code - Panel Categorias</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="blue-grey lighten-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.html" class="brand-logo"><img class="responsive-img" src="imagenes/Insert_Project.png" height="20px" width="100px" ></a>
      <ul class="right hide-on-med-and-down">
        <li><a  href="paneladmin.jsp">HOME</a></li>
        <li><a  href="clist">Categorias</a></li>
        <li><a   href="culist">Cursos</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a   href="paneladmin.jsp">HOME</a></li>
        <li><a   href="clist">Categorias</a></li>
        <li><a  href="culist">Cursos</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <div class="container">
  
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