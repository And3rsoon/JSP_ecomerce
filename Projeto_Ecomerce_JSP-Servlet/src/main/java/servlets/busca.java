package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.Products;
import dao.User;
import jakarta.servlet.RequestDispatcher;
import service.ProductRepository;

@WebServlet("/busca")
public class busca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public busca() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Products> podutos=new ProductRepository().buscarPorParteDoNome(request.getParameter("nome"));
			request.setAttribute("produtos",podutos);
			request.getRequestDispatcher("/produtos.jsp").forward(request, response);
		}
		catch(Exception e) {
			request.setAttribute("mensagem","Desculpe, o produto não foi encontrado!");
			request.getRequestDispatcher("/erro").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
