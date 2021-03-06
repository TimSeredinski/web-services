package by.bsu.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan
@Import(RabbitConfiguration.class)
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

}