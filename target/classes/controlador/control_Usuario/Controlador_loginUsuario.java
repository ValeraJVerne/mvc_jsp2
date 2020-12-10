package controlador.control_Usuario;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;

/**
 * Servlet implementation class Controlador_loginUsuario
 */
@WebServlet("/Controlador_loginUsuario")
public class Controlador_loginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_loginUsuario() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO=new UsuarioDAO(miPool);
		}catch(Exception e) {
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		String usuario=request.getParameter("usuario");
		String contrasena=request.getParameter("contrasena");
		
		if (usuarioDAO.login(usuario, contrasena)!=null) {
			request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
