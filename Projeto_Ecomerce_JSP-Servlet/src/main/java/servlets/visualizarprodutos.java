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

@WebServlet("/verprodutos")
public class visualizarprodutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public visualizarprodutos() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 String queryString = request.getQueryString();
		     Integer codigo = Integer.parseInt(request.getParameter("codigo"));
		     Products prooduto=new ProductRepository().consultar(codigo);
		     request.setAttribute("produto",prooduto);
			 request.getRequestDispatcher("/visualizarproduto.jsp").forward(request, response);
		}
		catch(Exception e) {
			request.setAttribute("mensagem","Desculpe, tivemos um problema!");
			request.getRequestDispatcher("/erro").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
