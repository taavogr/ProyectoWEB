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
        <li><a  href="culist">Cursos</a></li>
        <li><a   href="listt">Temas</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  
  <div class="container">
  <div class="row">
    <h3> Mantenimiento de Categorias</h3>
  </div>
  <div class="row">
    
    <a class="waves-effect waves-light btn right" href="newc">Agregar</a>
    <table class="striped">
      <thead>
          <tr>
              <th data-field="id">ID</th>
              <th data-field="name">CATEGORÍA</th>
              <th data-field="acciones">ACCIONES</th>
              
          </tr>
        </thead>

        <tbody>
        <c:forEach var="c" items="${requestScope.listcategorias}" >
        <tr>
        <td>${c.idCategoria }</td>
        <td>${c.nombre }</td>
        <td width=350>

       <a class="btn" href="cedit?id=${c.idCategoria}">Editar</a>
&nbsp; <a class="btn" href="removec?id=${c.idCategoria}">Eliminar</a>
        
        </tr>
        </c:forEach>
        </tbody>
    </table>
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