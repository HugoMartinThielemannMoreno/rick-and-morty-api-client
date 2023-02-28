package com.mobdev.rickandmorty.apiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Api client application.
 *
 * @author HugoMartinThielemannMoreno
 */
@SpringBootApplication
@EnableFeignClients
public class ApiClientApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiClientApplication.class, args);
    }

}
