<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<h3>Eliminar curso</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="deletecu" method="post">
				<input type="hidden" name="id" value="${requestScope.cur.idCurso}" />
				<p class="alert alert-error">
					Esta seguro de eliminar este curso?<br /> <b>Nombre</b>:${requestScope.cur.nombre}
					<br />
				</p>
				<div class="form-actions">
					<button type="submit" class="btn btn-danger">Si eliminar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listcu">No eliminar</a>
				</div>
			</form>
		</div>
	</div>
  
  




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