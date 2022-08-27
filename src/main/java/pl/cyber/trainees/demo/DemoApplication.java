package pl.cyber.trainees.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // adnotacja, której zadaniem jest uruchomienie aplikacji springowej
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);  // to tego momentu linie kodu nie mogą być zmodyfikowane

    }
}
