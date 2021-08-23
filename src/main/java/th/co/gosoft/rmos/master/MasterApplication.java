package th.co.gosoft.rmos.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MasterApplication {

	@Bean
	public RestTemplate createRestTemplete() {
		return new RestTemplateBuilder().build();
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MasterApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		System.out.println(context.getBeanDefinitionCount());
		for (String bean:beans) {
			System.out.println(bean);
		}

	}

}
