package net.ivancl4udio.apps.SBAdminJava;

import net.ivancl4udio.apps.SBAdminJava.SBAdminJava;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SBAdminJava.class);
	}

}
