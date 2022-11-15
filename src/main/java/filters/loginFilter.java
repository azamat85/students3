package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req  = (HttpServletRequest)servletRequest;
        HttpServletResponse resp  = (HttpServletResponse)servletResponse;
        Integer isLogin = (Integer)req.getSession().getAttribute("isLogin");
        String uri = req.getRequestURI();

        if (isLogin == null&& !uri.endsWith("/login")){
            resp.sendRedirect("/login");
            return;
        }
        if (isLogin == null&& uri.endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if (isLogin != null &&isLogin==1 && uri.endsWith("/login")){
            resp.sendRedirect("/");
            return;
        }
        if (isLogin!=null&&isLogin==1&& !uri.endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);

        }
return;

    }

    @Override
    public void destroy() {

    }
}
