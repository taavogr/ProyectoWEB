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

import com.upc.dto.Categoria;
import com.upc.dto.Usuario;
import com.upc.model.usuarioModel;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet({ "/insertu", "/deleteu", "/updateu", "/listu", "/editu" })
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private usuarioModel umodel = null;
	private String mensaje = null;
	private String destino = "/usuario.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		umodel = new usuarioModel();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		try {
			if (path.equals("/newu")) {
				
			}else if (path.equals("/insertu")) {
				insert(request);
				
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		
		rd.forward(request, response);
	}
	
	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		user.setNombre(request.getParameter("nombre"));
		user.setUsuario(request.getParameter("nick"));
		user.setDNI(request.getParameter("dni"));
		user.setClave(request.getParameter("password"));
		user.setCorreo(request.getParameter("email"));
		
		umodel.registrarUsuario(user);
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
