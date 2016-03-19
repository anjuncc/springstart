package a.j.springstart.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.cache.WebappTemplateLoader;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "a.j.springstart.controller" })
@ImportResource({ "classpath:beans-config.xml" })
public class AppConfig extends  WebMvcConfigurationSupport/*WebMvcConfigurerAdapter*/ {
	@Bean 
	public FreeMarkerViewResolver freemarkerViewResolver() { 
	    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver(); 
	    resolver.setCache(true); 
	    resolver.setPrefix(""); 
	    resolver.setSuffix(".ftl"); 
	    return resolver; 
	}
	@Bean 
	public FreeMarkerConfigurer freemarkerConfig() { 
	    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
	    freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
	    return freeMarkerConfigurer; 
	}
//	@Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//    @Bean
//    public FreeMarkerViewResolver freeMarkerViewResolver() {
//        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
//        viewResolver.setPrefix("/WEB-INF/ftl/");
//        viewResolver.setSuffix(".ftl");
//        viewResolver.setCache(true);
//        viewResolver.setContentType("text/html;charset=UTF-8");
//        viewResolver.setRequestContextAttribute("requestContext");
//        viewResolver.setOrder(0);
//        return viewResolver;
//    }
//    @Bean
//    public FreeMarkerConfig freeMarkerConfig(){
//        FreeMarkerConfigurer fmCfg=new FreeMarkerConfigurer();
//        freemarker.template.Configuration tplCfg = new freemarker.template.Configuration();
//        tplCfg.setTagSyntax(freemarker.template.Configuration.AUTO_DETECT_TAG_SYNTAX);
//        tplCfg.setTemplateUpdateDelay(1);
//        tplCfg.setDefaultEncoding("UTF-8");
//        tplCfg.setOutputEncoding("UTF-8");
//        tplCfg.setLocale(Locale.SIMPLIFIED_CHINESE);
//          tplCfg.setDateFormat("yyyy-MM-dd");
//        tplCfg.setTimeFormat("HH:mm:ss");
//        tplCfg.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
//        tplCfg.setClassicCompatible(true);//空串显示""
//        tplCfg.setTemplateLoader(new WebappTemplateLoader(getServletContext()));
//        fmCfg.setConfiguration(tplCfg);
//    
//        return fmCfg;
//    }
}
