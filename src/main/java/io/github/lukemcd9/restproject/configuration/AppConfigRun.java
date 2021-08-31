package io.github.lukemcd9.restproject.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile(value = { "default", "dev" })
@Configuration
@ComponentScan(basePackages = "io.github.lukemcd9.restproject")
@EnableJpaRepositories(basePackages = { "io.github.lukemcd9.restproject.repository" })
public class AppConfigRun {
    
}
