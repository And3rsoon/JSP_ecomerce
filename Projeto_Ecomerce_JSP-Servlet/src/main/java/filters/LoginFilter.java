package filters;

import jakarta.servlet.Filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.annotation.WebFilter;


@WebFilter("/login")
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	public LoginFilter() {
        super();
        
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) resp;
		
		if(req.getSession(false)==null) {
				chain.doFilter(request, resp);
	
		}
		else {
			res.sendRedirect("perfil");
			
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
