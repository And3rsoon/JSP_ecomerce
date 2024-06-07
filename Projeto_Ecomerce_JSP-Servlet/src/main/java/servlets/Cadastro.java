package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.User;
import jakarta.servlet.RequestDispatcher;
import service.UserRepository;
import service.PasswordDecoder;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Cadastro() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordDecoder psd=new PasswordDecoder();
		String password=psd.encoder(request.getParameter("senha"));
		User user=new User();
		user.setCep(request.getParameter("cep"));
		user.setCpf(request.getParameter("cpf"));
		user.setEmail(request.getParameter("email"));
		user.setEndereco(request.getParameter("endereco"));
		user.setNome(request.getParameter("nome"));
		user.setPassword(password);
		user.setRoles("admin");
		user.setTelefone(request.getParameter("tel"));
		UserRepository usr=new UserRepository();
		usr.gavar(user);
		response.sendRedirect("login");
		
	}

}
