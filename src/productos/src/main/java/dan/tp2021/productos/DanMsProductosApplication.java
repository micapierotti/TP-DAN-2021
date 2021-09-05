package dan.tp2021.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class DanMsProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanMsProductosApplication.class, args);
	}

}
