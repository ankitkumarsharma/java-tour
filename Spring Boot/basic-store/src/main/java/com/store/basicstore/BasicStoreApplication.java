package com.store.basicstore;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicStoreApplication {
    public static void main(String[] args) {
        // Configuration of DotEnv
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        dotenv.entries().forEach((dotenvEntry ->
                System.setProperty(dotenvEntry.getKey(), dotenvEntry.getValue()))
        );
        SpringApplication.run(BasicStoreApplication.class, args);
    }

}
