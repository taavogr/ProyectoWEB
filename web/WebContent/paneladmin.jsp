<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <c:if test="${sessionScope.usuario == null}">
		<jsp:forward page="index.jsp" />
</c:if>
 <c:if test="${sessionScope.usuario.rol=='usuario' }">
		<jsp:forward page="index.jsp" />
</c:if>
  <nav class="blue-grey lighten-2" role="navigation">
    <div class="nav-wrapper container">
      <ul class="right hide-on-med-and-down">
        <li><a  href="paneladmin.jsp">HOME</a></li>
        <li><a  href="clist">Categorias</a></li>
        <li><a   href="listcu">Cursos</a></li>
        <li><a   href="listt">Temas</a></li>
        
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a   href="paneladmin.jsp">HOME</a></li>
        <li><a   href="clist">Categorias</a></li>
        <li><a  href="listcu">Cursos</a></li>
        <li><a   href="listt">Temas</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <div class="container">
  <div class="row">
  <h1>Panel de administrador</h1>  
  </div>
  <div class="row">
  <a class="waves-effect waves-light cyan darken-4 btn" href="cerraru"> Cerrar Sesión </a>
  </div>

  </div>
  
    <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

</body>
</html>