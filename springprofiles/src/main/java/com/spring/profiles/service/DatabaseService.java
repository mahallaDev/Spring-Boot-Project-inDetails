package com.spring.profiles.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.profiles.pojo.database;

@Service
public class DatabaseService {
    
    @Value("${spring.datasource.url}")
    public String databaseUrl;
    @Value("${spring.datasource.username}")
    public String databaseUsername;
    @Value("${spring.datasource.password}")
    public String databasePassword;

    @Profile("dev") 
    @Bean  //when we annotate with BEAN then at the runtimes spring container create the object and after adding the PROFILE annotation on Bean annotation ,if pofile is active then container will create the object for that 
    public void devEnvDatabaseBean()
    {
        System.out.println("Dev Environment URL");
        System.out.println("DEV URl:"+databaseUrl);
        System.out.println("DEV Username:"+databaseUsername);
        System.out.println("DEV Password:"+databasePassword);

        database database =new database();
        database.setPassword(databasePassword);
        database.setUrl(databaseUrl);
        database.setUsername(databaseUsername);

        System.out.println("Dev database URL:-"+database);
    }
@Profile("st2")
@Bean
    public void st2EnvDatabaseBean()
    {
        System.out.println("St2 Environment URL");
        System.out.println("St2 URl:"+databaseUrl);
        System.out.println("St2 Username:"+databaseUsername);
        System.out.println("St2 Password:"+databasePassword);

        database database =new database();
        database.setPassword(databasePassword);
        database.setUrl(databaseUrl);
        database.setUsername(databaseUsername);

        System.out.println("St2 database URL:-"+database);
    }

    
}
