package com.upc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.dto.Curso;
import com.upc.dto.Inscripcion;
import com.upc.dto.Temario;
import com.upc.dto.Usuario;
import com.upc.model.inscripcionModel;
import com.upc.model.temaModel;

/**
 * Servlet implementation class inscripcionController
 */
@WebServlet({ "/newi", "/createi", "/removei", "/deletei","/listi","/readi" })
public class inscripcionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private inscripcionModel imodel = null;
	private String destino = "/paneli.jsp";
	private String mensaje=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		imodel = new inscripcionModel();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		
		try {
			if (path.equals("/newi")) {
				destino="/createi.jsp";
				
			}else if(path.equals("/createi")){
				insert(request);
				mensaje = list(request,imodel);
				destino = "/paneli.jsp";
			}else if(path.equals("/removei")){
				destino="/deletei.jsp";
			}else if(path.equals("/deletei")){
				delete(request);
				mensaje = list(request,imodel);
				destino="/paneli.jsp";
			}else if(path.equals("/listi")){
				mensaje = list(request,imodel);
				destino ="/paneli.jsp";
			}else if(path.equals("/readi")){
				read(request,imodel);
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
		Usuario u = new Usuario();
		Inscripcion ins = new Inscripcion();
		
		u.setIdUsuario(Integer.parseInt(request.getParameter("iduser")));
		c.setIdCurso(Integer.parseInt(request.getParameter("idcurso")));
		
		ins.setIdUsuario(u);
		ins.setIdCurso(c);
		
		imodel.registrarIncripcion(ins);
	}
	
	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("idins"));
		
		imodel.eliminarInscripcion(id);
		
		
	}
	
	protected String read(HttpServletRequest request,inscripcionModel imodel) throws SQLException {
		String error = null;
		int id =Integer.parseInt(request.getParameter("idins"));
		Inscripcion ins = imodel.buscarInscripcion(id);
		if (ins !=null) {
			request.setAttribute("ins", ins);
			
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
