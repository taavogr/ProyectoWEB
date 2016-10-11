<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Insert Code - Panel Cursos</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="blue-grey lighten-2" role="navigation">
    <div class="nav-wrapper container">
      <ul class="right hide-on-med-and-down">
        <li><a  href="paneladmin.jsp">HOME</a></li>
        <li><a  href="clist">Categorias</a></li>
        <li><a   href="culist">Cursos</a></li>
        <li><a   href="listt">Temas</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a   href="paneladmin.jsp">HOME</a></li>
        <li><a   href="clist">Categorias</a></li>
        <li><a  href="culist">Cursos</a></li>
        <li><a   href="listt">Temas</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <div class="container">
  
   <form class="col s12" action="cuinsert" method="post">
      <div class="row">
        
        <div class="input-field col s6">
          <input id="nombre" name="nombre" type="text" class="validate">
          <label for="nombre">Nombre del curso</label>
        </div>
      </div>
      
            <div class="row">
        
        <div class="input-field col s6">
          <input id="idcategoria" name="idcategoria" type="text" class="validate">
          <label for="idcategoria">ID de la categoria</label>
        </div>
      </div>
      
                  <div class="row">
        
        <div class="input-field col s6">
          <input id="monto" name="monto" type="text" class="validate">
          <label for="monto">Monto</label>
        </div>
      </div>
      
      

 
      <div class="center">
             <button class="btn waves-effect waves-light cyan darken-4" type="submit" name="action">

             Agregar<i class="material-icons right">send</i>
    </button>
    <a class="waves-effect waves-light cyan darken-4 btn" href="listcu">Cancelar</a>
    </div>
    </form>
  </div>
  
    <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

</body>
</html>