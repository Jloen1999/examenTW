package es.unex.cum.tw.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
        ,          urlPatterns = { "/Restringido/*" })
public class LoginFilter implements Filter {
    private static final Logger logger = Logger.getLogger(Filter.class.getName());
    public LoginFilter() {

    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = ((HttpServletRequest)request).getSession(true);
        logger.info("checking user in session");
        if(session.getAttribute("user") == null) {
            session.setAttribute("mensaje", "No tienes permisos para acceder a la página solicitada");
            session.setAttribute("showLogin", true);
            logger.info("session not ok");
            res.sendRedirect("index.jsp");
        }
        else
            // pass the request along the filter chain
            chain.doFilter(request, response);
        logger.info("session ok");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
