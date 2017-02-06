package jp.co.addli.filter;

import jp.co.addli.config.DBContextHolder;
import jp.co.addli.config.DbType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
@Component
@Slf4j
public class PathFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        log.info("path=" + path );
        if ( path.startsWith( "/master") ){
            DBContextHolder.setDbType( DbType.MASTER );
        }
        else if ( path.startsWith( "/second" ) ){
            DBContextHolder.setDbType( DbType.SECOND );
        }
        else{
            new ServletException("Unexpected context.");
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
}
