package com.nttdata.bootcamp.microservicio4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Microservicio4Application}<br/>
 * <b>Copyright</b>: &Copy; 2022 NTT DATA SAC. <br/>
 * <b>Company</b>: NTT DATA SAC. <br/>
 *
 * @author Yennyffer Lizana <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (YEN)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 11, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
@EnableReactiveMongoRepositories
public class Microservicio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio4Application.class, args);
	}

}
