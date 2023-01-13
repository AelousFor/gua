package com.pancm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan
@SpringBootApplication
@EnableSwagger2
public class FortServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortServerApplication.class, args);
    }

}
