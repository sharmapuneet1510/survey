package com.grandviewtech.surveysystem.configuration;

/*@Component
@Order(Ordered.HIGHEST_PRECEDENCE)*/
class CorsFilter /*implements Filter*/
	{
		
		/*		@Override
				public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
					{
						HttpServletResponse response = (HttpServletResponse) res;
						HttpServletRequest request = (HttpServletRequest) req;
						response.setHeader("Access-Control-Allow-Origin", "*");
						response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
						response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
						response.setHeader("Access-Control-Max-Age", "3600");
						if (request.getMethod() != "OPTIONS")
							{
								chain.doFilter(req, res);
							}
						else
							{
							}
					}
		
				@Override
				public void init(FilterConfig filterConfig)
					{
					}
		
				@Override
				public void destroy()
					{
					}*/
		
	}
