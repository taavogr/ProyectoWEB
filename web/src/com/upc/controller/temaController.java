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
import com.upc.dto.Temario;
import com.upc.model.cursoModel;
import com.upc.model.temaModel;

/**
 * Servlet implementation class temaController
 */
@WebServlet({ "/newt", "/createt", "/removet", "/deletet", "/editt", "/updatet", "/listt", "/readt","/insertt" })
public class temaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private temaModel tmodel=null;
	private String destino ="/panelt.jsp";
	private String mensaje=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public temaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		tmodel=new temaModel();
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String path = request.getServletPath();
		
		try {

			
				if (path.equals("/newt")) {//Llama a una vista
					destino = "createt.jsp";
				} else if (path.equals("/insertt")) {//insert BD
					insert(request);
					mensaje = list(request, tmodel);
					destino = "/panelt.jsp";
					
				} else if (path.equals("/editt")) {//Llama a una vista
					read(request, tmodel);
					destino = "/updatet.jsp";
				}else if (path.equals("/updatet")) {//update BD
						update(request);
						mensaje = list(request, tmodel);
						destino = "/panelt.jsp";
					 
					
				} else if (path.equals("/removet")) {//Llama a una vista
					read(request, tmodel);
					destino = "/deletet.jsp";				
				} else if (path.equals("/deletet")) {//Delete en una BD
					delete(request);
					mensaje = list(request, tmodel);
					destino = "/panelt.jsp";
				
				}else if (path.equals("/listt")) {//Lista todos dato BD
					mensaje = list(request, tmodel);
					destino = "/panelt.jsp";
				} else if (path.equals("/readt")) {//Muestra dato seleccionado
					read(request, tmodel);
					destino = "readt.jsp";
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
		Temario t=new Temario();
		t.setNombre(request.getParameter("nombre"));
		c.setIdCurso(Integer.parseInt(request.getParameter("idcurso")));
		t.setIdCurso(c);
	
	
		
		tmodel.registrarTema(t);
	}
	protected void update(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//TODO
		Curso c= new Curso();
		Temario t=new Temario();
		t.setNombre(request.getParameter("nombre"));
		c.setIdCurso(Integer.parseInt(request.getParameter("idtema")));
		
		tmodel.actualizarTema(t);

	}
	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		tmodel.eliminarTema(id);
	}
	protected String list(HttpServletRequest request, temaModel tmodel) throws SQLException {
		String error = null;

		List<Temario> list = tmodel.listarTemas();

		if (list != null) {
			request.setAttribute("listtemas", list);
		} else {
			error = "Sin acceso a Base de Datos";
		}

		return error;
	}
	
	protected String read(HttpServletRequest request,temaModel tmodel) throws SQLException {
		String error = null;
		int id =Integer.parseInt(request.getParameter("id"));
		Temario te=tmodel.buscarTema(id);
		if (te !=null) {
			request.setAttribute("tem", te);
			
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
