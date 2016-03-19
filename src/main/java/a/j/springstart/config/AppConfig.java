package a.j.springstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "a.j.springstart" })
//@ImportResource({ "classpath:beans-config.xml" })
public class AppConfig extends /* WebMvcConfigurationSupport */ WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

//	@Bean
//	public FreeMarkerViewResolver freemarkerViewResolver() {
//		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//		resolver.setCache(true);
//		resolver.setPrefix("");
//		resolver.setSuffix(".ftl");
//		return resolver;
//	}
//
//	@Bean
//	public FreeMarkerConfigurer freemarkerConfig() {
//		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//		freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
//		return freeMarkerConfigurer;
//	}

//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/database");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("root");
//		return driverManagerDataSource;
//	}
	@Bean(name="HelloWorld")
	 public ViewResolver viewResolver() {
	 InternalResourceViewResolver viewResolver = new
	 InternalResourceViewResolver();
	 viewResolver.setViewClass(JstlView.class);
	 viewResolver.setPrefix("/WEB-INF/views/");
	 viewResolver.setSuffix(".jsp");
	 return viewResolver;
	 }

}
