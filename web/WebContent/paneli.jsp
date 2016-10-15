<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Insert Code - Aprende Programación</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
 <c:if test="${sessionScope.usuario == null}">
		<jsp:forward page="index.jsp" />
</c:if>
 <c:if test="${sessionScope.usuario.rol=='admin' }">
		<jsp:forward page="index.jsp" />
</c:if>
  <nav class="blue-grey lighten-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo"><img class="responsive-img" src="imagenes/Insert_Project.png" height="20px" width="100px" ></a>
      <ul class="right hide-on-med-and-down">
        <li><a href="listcuru">Cursos</a></li>
        <li><a href="listinu?id=${sessionScope.usuario.idUsuario }">Perfil de "${sessionScope.usuario.nombre}"</a></li>
        <li><a href="cerraru">Cerrar Sesion</a></li>
        
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="listcuru">Cursos</a></li>
        <li><a href="listinu?id=${sessionScope.usuario.idUsuario }">Perfil de "${sessionScope.usuario.nombre}"</a></li>
        <li><a href="cerraru">Cerrar Sesion</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
   <div class="container">
		
		<div class="row">
			<h3>Cursos de ${sessionScope.usuario.nombre} </h3>
			<table class="striped">
      <thead>
          <tr>
              <th data-field="id">ID</th>
              <th data-field="curso">Curso</th>
              <th data-field="fecha">FECHA</th>
              
          </tr>
        </thead>

        <tbody>
        <c:forEach var="c" items="${requestScope.listinscripcionesxusuario}" >
        <tr>
        <td>${c.idInscripcion }</td>
        <td>${c.idCurso.getNombre() }</td>
        <td>${c.fecha_inscripcion }</td>

        
        </tr>
        </c:forEach>
        </tbody>
    </table>
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