package com.etc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {

//	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

//	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;
		HttpSession session = hreq.getSession();
                                   
                                    String id = (String) session.getAttribute("id");
                                    String admin = (String) session.getAttribute("admin");
		if((id!=null) && (admin.equals("1")))
		{
			arg2.doFilter(req, res);
                                                     
		}
		else
		{
			
			((HttpServletResponse) res).sendRedirect("../Login.jsp");
		}
		
	}

//	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
