package th.co.gosoft.rmos.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MasterApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MasterApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		System.out.println(context.getBeanDefinitionCount());
		for (String bean:beans) {
			System.out.println(bean);
		}

	}

}
