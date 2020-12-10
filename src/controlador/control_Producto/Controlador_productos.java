package controlador.control_Producto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.time.*;

import DAO.ProductoDAO;
import modelo.Producto;
import modelo.Usuario;

@WebServlet("/Controlador_productos")
public class Controlador_productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private ProductoDAO productoDAO;
	
    public Controlador_productos() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			productoDAO =new ProductoDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		String boton=request.getParameter("enviar");
		if (boton==null) {
			mostrarTodo(request, response);
		}else {
			switch(boton) {
			case "mostrar":
				mostrarTodo(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			case "mostrarProducto":
				mostrarProducto(request, response);	
				break;
			default:
				break;
		}
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Producto p=new Producto(request.getParameter("codProd"), request.getParameter("seccion"), request.getParameter("nomProd"), 
				Double.parseDouble(request.getParameter("precio")), LocalDate.parse(request.getParameter("fecha")), 
				Boolean.parseBoolean(request.getParameter("imp")), request.getParameter("pais"));
		try {
			productoDAO.create(p);
			mostrarTodo(request, response);
		} catch (SQLException e) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}catch(NumberFormatException n) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
	}

	private void mostrarTodo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Producto> listProd=(ArrayList<Producto>) productoDAO.readAll();
		request.setAttribute("listProd", listProd);
		request.getRequestDispatcher("vistasProducto/mostrarTodos.jsp").forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String codProd=request.getParameter("codProd");
		try {
			productoDAO.delete(codProd);
			mostrarTodo(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
	}
	
	private void mostrarProducto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Producto p=productoDAO.read(request.getParameter("codProd"));
		request.setAttribute("productoBus", p);
		request.getRequestDispatcher("vistasProducto/ActualizaProducto.jsp").forward(request, response);
	}
	
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto p=productoDAO.read(request.getParameter("codProd"));
		
		if (p!=null) {
			Producto p2=new Producto(request.getParameter("codProd"), request.getParameter("seccion"), request.getParameter("nomProd"), 
					Double.parseDouble(request.getParameter("precio")), LocalDate.parse(request.getParameter("fecha")), 
					Boolean.parseBoolean(request.getParameter("imp")), request.getParameter("pais"));
			
			
			request.getSession().setAttribute("productoEncontrado", new Usuario());
			
			if (productoDAO.update(p2)) {
				request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			}
		}
		else {request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);}		
	}
}
