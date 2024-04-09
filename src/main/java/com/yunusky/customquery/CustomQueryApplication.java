package com.yunusky.customquery;

import com.yunusky.customquery.model.User;
import com.yunusky.customquery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomQueryApplication {

    public CustomQueryApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(CustomQueryApplication.class, args);
	}

	private final UserRepository userRepository;

	@Bean
	public CommandLineRunner loadDate() throws ParseException {
		return (args) -> {
			userRepository.deleteAll();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			List<User> users  = Arrays.asList(
					new User("yunus emre", true, 7500, sdf.parse("1992-04-11")),
					new User("abd", true, 5000, sdf.parse("1995-09-01")),
					new User("rümeysa", false, 7000, sdf.parse("2000-09-06")),
					new User("yavuz selim", true, 17500, sdf.parse("2006-08-11")),
					new User("özlem", false, 45000, sdf.parse("1986-08-12")),
					new User("cigdem", true, 6500, sdf.parse("1987-09-25"))
			);

			userRepository.saveAll(users);
		};
	}

}
