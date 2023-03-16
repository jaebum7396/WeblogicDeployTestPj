package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring Mvc 프로젝트에 관련된 설정을 하는 클래스
@Configuration
@EnableWebMvc
@ComponentScan("controller,config")
public class ServletAppContext implements WebMvcConfigurer{
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/view/",".jsp");
	}
	//@Override
	//public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//	// TODO Auto-generated method stub
	//	WebMvcConfigurer.super.addResourceHandlers(registry);
	//	registry.addResourceHandler("/**").addResourceLocations("/resources/");
	//}
}