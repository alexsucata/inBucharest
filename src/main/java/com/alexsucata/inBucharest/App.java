package com.alexsucata.inBucharest;

import com.alexsucata.inBucharest.config.AppConfig;
import org.springframework.boot.SpringApplication;


public class App 
{

    public static void main( String[] args ) {

        SpringApplication.run(AppConfig.class, args);
    }
}
