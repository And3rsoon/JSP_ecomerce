package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import dao.User;
import service.UserRepository;
import service.PasswordDecoder;



@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf=request.getParameter("cpf");
		String senha=request.getParameter("senha");
		String senhaencoder= new PasswordDecoder().encoder(senha);
		UserRepository usr=new UserRepository();	
		Boolean contem=usr.contain(cpf);
		if(contem==true) {
			User user=usr.consultar(cpf);
			if(user.getCpf().equals(cpf) && user.getPassword().equals(senhaencoder)) {
				HttpSession session=request.getSession();
				session.setAttribute("nome", user.getNome());
				session.setAttribute("cpf", user.getCpf());
				session.setAttribute("roles", user.getRoles());
				response.sendRedirect("perfil");
			}
			else {
				request.setAttribute("mensagem", "Usuario ou Senha incorreto!");
				request.getRequestDispatcher("/erro").forward(request, response);
			}
		}
		else {
			request.setAttribute("mensagem", "Usuario ou Senha incorreto!");
			request.getRequestDispatcher("/erro").forward(request, response);
			
		}
		
		
	}

}
