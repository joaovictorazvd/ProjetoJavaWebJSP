package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "/principal/*" }) /* Intercepta todas as requisições que vinherem do projeto */
public class FilterAutenticacao implements Filter {

	public FilterAutenticacao() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletRequest session = (HttpServletRequest) req.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath();

		/* Validar se esta logado */

		if ((usuarioLogado == null) && (!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin"))) {

			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "por favor realize o login");
			redireciona.forward(request, response);
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
