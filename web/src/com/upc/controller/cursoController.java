package com.upc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.dto.Categoria;
import com.upc.dto.Curso;
import com.upc.model.categoriaModel;
import com.upc.model.cursoModel;

/**
 * Servlet implementation class cursoController
 */
@WebServlet({ "/newcu", "/createcu", "/removecu", "/deletecu", "/editcu", "/updatecu", "/listcu", "/readcu","/cuinsert","/listcur" })
public class cursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private cursoModel cumodel=null;
	private String destino ="/panelcu.jsp";
	private String mensaje=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cursoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cumodel = new cursoModel();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String path = request.getServletPath();
		
		try {

			
				if (path.equals("/newcu")) {//Llama a una vista
					destino = "createcu.jsp";
				} else if (path.equals("/cuinsert")) {//insert BD
					insert(request);
					mensaje = list(request, cumodel);
					destino = "/panelcu.jsp";
					
				} else if (path.equals("/editcu")) {//Llama a una vista
					read(request, cumodel);
					destino = "/updatecu.jsp";
				}else if (path.equals("/updatecu")) {//update BD
						update(request);
						mensaje = list(request, cumodel);
						destino = "/panelcu.jsp";
					 
					
				} else if (path.equals("/removecu")) {//Llama a una vista
					read(request, cumodel);
					destino = "/deletecu.jsp";				
				} else if (path.equals("/deletecu")) {//Delete en una BD
					delete(request);
					mensaje = list(request, cumodel);
					destino = "/panelcu.jsp";
				
				}else if (path.equals("/listcu")) {//Lista todos dato BD
					mensaje = list(request, cumodel);
					destino = "/panelcu.jsp";
				} else if (path.equals("/readcu")) {//Muestra dato seleccionado
					read(request, cumodel);
					destino = "/readcu.jsp";
				}else if(path.equals("/listcur")){
					mensaje =list(request,cumodel);
					destino = "/vistacursos.jsp";
				}

				if (mensaje != null) {
					request.setAttribute("mensaje", mensaje);
				} else {
					request.removeAttribute("mensaje");
				}

				System.out.println(path);
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
		
	}
	
	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Curso c= new Curso();
		Categoria ca = new Categoria();
		c.setNombre(request.getParameter("nombre"));
		ca.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
		c.setIdCategoria(ca);
		c.setMonto(request.getParameter("monto"));
	
		
		cumodel.registrarCurso(c);
	}
	protected void update(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//TODO
		Curso c= new Curso();
		Categoria ca = new Categoria();
		c.setNombre(request.getParameter("nombre"));
		ca.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
		c.setIdCategoria(ca);
		c.setMonto(request.getParameter("monto"));
		
		cumodel.actualizarCurso(c);

	}
	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		cumodel.eliminarCurso(id);
	}
	protected String list(HttpServletRequest request, cursoModel cumodel) throws SQLException {
		String error = null;

		List<Curso> list = cumodel.listarCursos();

		if (list != null) {
			request.setAttribute("listcursos", list);
		} else {
			error = "Sin acceso a Base de Datos";
		}

		return error;
	}
	
	protected String read(HttpServletRequest request, cursoModel cumodel) throws SQLException {
		String error = null;
		int id =Integer.parseInt(request.getParameter("id"));
		Curso cu=cumodel.buscarCurso(id);
		if (cu !=null) {
			request.setAttribute("cur", cu);
			
		}else{
			error="Sin acceso a Base de Datos";
		}
		//TODO
		return error;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
