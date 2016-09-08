package loc.sn.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);

		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

		FilterRegistration.Dynamic characterEncodingFilter = container.addFilter("characterEncoding", encodingFilter());
		characterEncodingFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
		ctx.setServletContext(container);


		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));


		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

	public CharacterEncodingFilter encodingFilter() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return encodingFilter;
	}

}
