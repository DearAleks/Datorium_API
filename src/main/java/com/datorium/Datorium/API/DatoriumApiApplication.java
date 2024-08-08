package com.datorium.Datorium.API;

import com.datorium.Datorium.API.DTOs.Book;
import com.datorium.Datorium.API.DTOs.Credentials;
import com.datorium.Datorium.API.DTOs.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
//@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) { //Main class is the only thing supposed to be here right now. Also authorizations, dependencies
		SpringApplication.run(DatoriumApiApplication.class, args);
	}
}
