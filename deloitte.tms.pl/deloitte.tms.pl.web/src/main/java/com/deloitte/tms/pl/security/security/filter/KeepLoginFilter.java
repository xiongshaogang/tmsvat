package com.deloitte.tms.pl.security.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.tms.pl.core.context.ContextHolder;

public class KeepLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String requesturl = request.getRequestURI();
		ContextHolder.setHttpRequestResponseHolder((HttpServletRequest)request,(HttpServletResponse)response);
		arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
