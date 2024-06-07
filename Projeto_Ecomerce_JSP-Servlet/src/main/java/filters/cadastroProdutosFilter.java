package filters;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.annotation.WebFilter;


@WebFilter("/cadastrarprodutos")
public class cadastroProdutosFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	public cadastroProdutosFilter() {
        super();
        
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) resp;
		HttpSession session=req.getSession(false);
		
		if(req.getSession(false)!=null) {
			   if(req.getMethod().equalsIgnoreCase("post")) {
					String roles=session.getAttribute("roles").toString();
					if(roles.equalsIgnoreCase("admin")) {
						chain.doFilter(request, resp);
					}
					else {
						request.setAttribute("mensagem", "Usuário sem permissão!");
						request.getRequestDispatcher("/erro").forward(req, res);
						
						
					}}
				else {
					req.getRequestDispatcher("/cadastrarProdutos.jsp").forward(req, res);
				}
			}
			else {
				request.setAttribute("mensagem", "Usuário sem permissão!");
				request.getRequestDispatcher("/erro").forward(req, res);	
			}
		}

	

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
