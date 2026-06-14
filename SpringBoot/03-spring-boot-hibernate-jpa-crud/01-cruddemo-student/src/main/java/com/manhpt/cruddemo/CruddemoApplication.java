package com.manhpt.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		/**
		 * CommandLineRunner sẽ chạy sau khi Spring Boot application context đã khởi tạo xong, tức là:
		 *
		 * 			- Spring Boot start
		 * 			- Spring container tạo beans
		 * 			- Dependency Injection hoàn tất (@Autowired, constructor injection...)
		 * 			- @Bean, @Service, @Repository, @Component được tạo xong
		 * 			- Sau đó mới chạy CommandLineRunner
		 *
		 * thường dùng để: seed dữ liệu db, test code nhanh ,
		 * chạy logic khởi tạo ( đọc config, load cache, call api, tạo folder)
		 *
		 *
		 *
		 * NÓ là 1 functional interface:
		 *
		 * public interface CommandLineRunner {
		 *
		 *     void run(String... args) throws Exception;
		 * }
		 * */
		return runner -> System.out.println("Hello World");
	}
}
