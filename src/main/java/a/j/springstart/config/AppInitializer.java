package a.j.springstart.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class AppInitializer implements WebApplicationInitializer {
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.setServletContext(servletContext);
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//
//		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//		registration.setLoadOnStartup(1);
//		registration.addMapping("/");
//
//		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ctx);
////		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//	}
//}

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class };
    	
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] { AppConfig.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}