package cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineStarter {
    public static void main(String[] args) {
        SpringApplication.run(CommandLineStarter.class, args);
    }
}
