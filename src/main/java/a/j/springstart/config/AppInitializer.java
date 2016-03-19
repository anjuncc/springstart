package a.j.springstart.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);
		ctx.register(AppConfig.class);
		ctx.refresh();

		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ctx);
//		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}
}

//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//	 
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] { AppConfig.class };
//    }
//  
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//  
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/*" };
//    }
//}