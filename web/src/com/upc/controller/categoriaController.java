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
import com.upc.model.categoriaModel;

/**
 * Servlet implementation class categoriaController
 */
@WebServlet({ "/cinsert", "/cupdate", "/cdelete", "/clist", "/cedit","/cread","/newc","/removec"})
public class categoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private categoriaModel cmodel =null;
	private String mensaje= null;
	private String destino= "/panelc.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel= new categoriaModel();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		try {

			
				if (path.equals("/newc")) {//Llama a una vista
					destino = "createc.jsp";
				} else if (path.equals("/cinsert")) {//insert BD
					insert(request);
					mensaje = list(request, cmodel);
					destino = "/panelc.jsp";
					
				} else if (path.equals("/cedit")) {//Llama a una vista
					read(request, cmodel);
					destino = "/updatec.jsp";
				}else if (path.equals("/cupdate")) {//update BD
						update(request);
						mensaje = list(request, cmodel);
						destino = "/panelc.jsp";
					 
					
				} else if (path.equals("/removec")) {//Llama a una vista
					read(request, cmodel);
					destino = "/deletec.jsp";				
				} else if (path.equals("/cdelete")) {//Delete en una BD
					delete(request);
					mensaje = list(request, cmodel);
					destino = "/panelc.jsp";
				
				}else if (path.equals("/clist")) {//Lista todos dato BD
					mensaje = list(request, cmodel);
					destino = "/panelc.jsp";
				} else if (path.equals("/cread")) {//Muestra dato seleccionado
					read(request, cmodel);
					destino = "readc.jsp";
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
		Categoria c= new Categoria();
		c.setNombre(request.getParameter("nombre"));
		
		cmodel.registrarCategoria(c);
	}
	
	protected void update(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//TODO
		Categoria c = new Categoria();
		c.setIdCategoria(Integer.parseInt(request.getParameter("id")));
		c.setNombre(request.getParameter("nombre"));
		
		cmodel.actualizarCategoria(c);

	}
	
	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		cmodel.eliminarCategoria(id);
	}
	
	protected String list(HttpServletRequest request, categoriaModel cmodel) throws SQLException {
		String error = null;

		List<Categoria> list = cmodel.listarcategorias();

		if (list != null) {
			request.setAttribute("listcategorias", list);
		} else {
			error = "Sin acceso a Base de Datos";
		}

		return error;
	}
	
	protected String read(HttpServletRequest request, categoriaModel cmodel) throws SQLException {
		String error = null;
		int id =Integer.parseInt(request.getParameter("id"));
		Categoria ca=cmodel.buscarCategoria(id);
		if (ca !=null) {
			request.setAttribute("cate", ca);
			
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
