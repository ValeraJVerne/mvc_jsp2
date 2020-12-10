package controlador.control_Usuario;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelo.Usuario;
import DAO.UsuarioDAO;

/**
 * Servlet implementation class Controlador_mostrarTodos
 */
@WebServlet("/Controlador_mostrarTodos")
public class Controlador_mostrarTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_mostrarTodos() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO =new UsuarioDAO(miPool);
		}catch (Exception e){
			throw new ServletException();
		}
		ArrayList<Usuario> lista=(ArrayList<Usuario>)usuarioDAO.readAll();
		request.setAttribute("listaUsu", lista);
		request.getRequestDispatcher("vistasUsuario/mostrarTodos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
