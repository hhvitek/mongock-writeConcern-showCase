package mongock.writeConcern.w1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mongock.runner.springboot.EnableMongock;

@EnableMongock
@SpringBootApplication
public class W1Application {

	public static void main(String[] args) {
		SpringApplication.run(W1Application.class, args);
	}

}
