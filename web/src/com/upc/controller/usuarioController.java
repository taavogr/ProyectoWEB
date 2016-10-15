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
import javax.servlet.http.HttpSession;

import com.upc.dto.Categoria;
import com.upc.dto.Usuario;
import com.upc.model.usuarioModel;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet({ "/insertu", "/deleteu", "/updateu", "/listu", "/editu","/login","/cerraru" })
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private usuarioModel umodel = null;
	private String mensaje = null;
	private String destino = "/index.jsp";
	private Usuario u = new Usuario();
	
	private HttpSession session=null;
	
       
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
		session = request.getSession(true);
		
		String path = request.getServletPath();
		
		try {
			if (path.equals("/insertu")) {
				insert(request);
				destino="/index.jsp";
			}else if(path.equals("/login")){
				String nick=request.getParameter("nick");
				String password=request.getParameter("password");
				
				u=umodel.iniciosesion(nick, password);
				System.out.println(u.getNombre());
				System.out.println(password);
				
				if (u!=null) {
					session.setAttribute("usuario", u);
					session.setAttribute("ID", session.getId());
					switch(u.getRol()){
					
					case "admin" :
						destino="paneladmin.jsp";
						break;
					case "usuario" :
						destino="paneli.jsp";
						break;
					
					}
					
				}else{
					request.setAttribute("mensaje", "credenciales no validas");
					destino="index.jsp";
					
				}
			}else if(path.equals("/cerraru")){
				session.invalidate();
				destino="index.jsp";
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		
		rd.forward(request, response);
	}
	
	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		u.setNombre(request.getParameter("nombre"));
		u.setUsuario(request.getParameter("nick"));
		u.setDNI(request.getParameter("dni"));
		u.setClave(request.getParameter("password"));
		u.setCorreo(request.getParameter("email"));
		
		umodel.registrarUsuario(u);
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
