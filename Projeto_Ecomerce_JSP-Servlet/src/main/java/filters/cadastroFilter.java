package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.annotation.WebFilter;
import service.UserRepository;



@WebFilter("/cadastro")
public class cadastroFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	public cadastroFilter() {
        super();
        
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) resp;

		if(req.getMethod().equalsIgnoreCase("get")) {
				if(req.getSession(false)==null) {
					chain.doFilter(request, resp);
				}
				else {
					res.sendRedirect("perfil");
					
				}
		}
		else {
			UserRepository usr=new UserRepository();
			String cpf=req.getParameter("cpf").replace("-", "");
			cpf=cpf.replace(".","");
			if(usr.contain(cpf)==false) {
					chain.doFilter(request, resp);
     		}
		    else {
		    	res.sendRedirect("cadastro");
		    	
		    }
		}
		    	
	}
	

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
