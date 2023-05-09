package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S05T01N01RoyoTerolMarinaApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01RoyoTerolMarinaApplication.class, args);
	}

}
