package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.Products;
import jakarta.servlet.RequestDispatcher;
import service.ProductRepository;




@WebServlet("/cadastrarprodutos")
public class CadastroProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastroProdutos() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Products psd=new Products();
		Integer quantidade=Integer.parseInt(request.getParameter("quantidade"));
		Float vcompra=Float.parseFloat(request.getParameter("vcomnpra"));
		Float vvenda=Float.parseFloat(request.getParameter("vvenda"));
		psd.setCategoria(request.getParameter("categoria"));
		psd.setDescricao(request.getParameter("descricao"));
		psd.setFabricante(request.getParameter("fabricante"));
		psd.setNome(request.getParameter("nome"));
		psd.setQuantidade(quantidade);
		psd.setUrl_img(request.getParameter("url"));
		psd.setValor_comp(vcompra);
		psd.setValor_venda(vvenda);
		try {
			new ProductRepository().gavar(psd);
			request.setAttribute("mensagem","Produto cadastrado com sucesso!");
			request.getRequestDispatcher("/erro").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("mensagem","Verifique se o produto já não estar cadastado!");
			request.getRequestDispatcher("/erro").forward(request, response);
		}
		
	}

}
