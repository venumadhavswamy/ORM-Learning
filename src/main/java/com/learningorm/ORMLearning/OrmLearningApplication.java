package com.learningorm.ORMLearning;

import com.learningorm.ORMLearning.entities.User;
import com.learningorm.ORMLearning.repositories.UserRepository;
import com.learningorm.ORMLearning.services.UserService;
import com.learningorm.ORMLearning.services.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearningApplication implements CommandLineRunner {
	//CommandLineRunner class provides a method run(). This method gets executed just after starting
	// the application i.e, it is called from SpringApplication.run() method
	//To access non-static methods, we use this method

	Logger logger = LoggerFactory.getLogger(OrmLearningApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		OrmLearningApplication app = new OrmLearningApplication();
		app.logger.info("main function starts");
		SpringApplication.run(OrmLearningApplication.class, args);
		app.logger.info("main function ends");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("CommandLineRunner.run() function starts");
		User user = new User();
		user.setAge(41);
		user.setCity("klad");
		user.setName("lonnf");
//		userService.saveUser(user);
		logger.info(""+userService.getAllUsers());
		logger.info(userService.getUser(1)+"");
		userService.updateUser(user,2);
		userService.deleteUser(3);
	}
}
