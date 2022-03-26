package IdealListaV2.IdealListaV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import IdealListaV2.IdealListaV2.config.SwaggerConfiguration;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class IdealListaV2Application {

	public static void main(String[] args) {
		SpringApplication.run(IdealListaV2Application.class, args);
	}

}
