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
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_BuscaUsuario
 */
@WebServlet("/Controlador_BuscaUsuario")
public class Controlador_BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_BuscaUsuario() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		usuarioDAO=new UsuarioDAO(miPool);
		
		Long id=Long.parseLong(request.getParameter("id"));
		
		Usuario u=usuarioDAO.read(id);
		System.out.println("el id es: "+id+" "+ u);
		
		if (u!=null) {
			request.setAttribute("usuarioBuscado", u);
			request.getRequestDispatcher("vistasUsuario/mostrarUsuario.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
		}catch(NumberFormatException e1) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}catch(Exception e) {
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
