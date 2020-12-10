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

@WebServlet("/Controlador_actualizaUsuario")
public class Controlador_actualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;   
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_actualizaUsuario() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO=new UsuarioDAO(miPool);
		}catch(Exception e) {
			throw new ServletException();
		}
		Usuario u=null;
		
		if("Busca Usuario".equals(request.getParameter("buscaUsuario"))) {
			buscaUsuario(u,request, response);
		}else if("Actualiza usuario".equals(request.getParameter("actualizaUsuario"))){
			actualizaUsuario(u,request, response);
		}
	}

	private void buscaUsuario(Usuario u, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario=request.getParameter("usuario");
		String contrasena=request.getParameter("contrasena");
		
		if(!usuario.isEmpty()&&!contrasena.isEmpty()) {
			u=usuarioDAO.login(usuario, contrasena);
			if(u!=null) {
				request.getSession().setAttribute("usuarioEncontrado", u);
				System.out.println(u);
				request.getRequestDispatcher("vistasUsuario/actualizaUsuario.jsp").forward(request, response);
				System.out.println("detras de la vista");
			}
		}
	}
	
	private void actualizaUsuario(Usuario u, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		u=(Usuario)request.getSession().getAttribute("usuarioEncontrado");
		
		if (u!=null) {
			request.setCharacterEncoding("UTF-8");
			Usuario u2=new Usuario(Long.parseLong(request.getParameter("id")),
					request.getParameter("nombre"),
					request.getParameter("apellidos"),
					request.getParameter("usuario"),
					request.getParameter("contrasena"),
					request.getParameter("pais"),
					request.getParameter("tecnologia"));
			
			
			request.getSession().setAttribute("usuarioEncontrado", new Usuario());
			
			if (usuarioDAO.update(u2)) {
				request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			}
		}//Controla el boton actualiza cuando no se ha pulsado el boton busca
		else {request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
