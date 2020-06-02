package com.sylpi.dbmapping;

import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class DbMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbMappingApplication.class, args);
	}


}
