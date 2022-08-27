package pl.cyber.trainees.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter   // adnotacja, której zadaniem jest dodanie do klasy metod Getter dla jej parametrów
public class ImieDTO {
    private final String imie;

    @Builder  // adnotacja pomaga utworzyć obiekt bez wypełniania konstruktora
    @ConstructorProperties({"imie"})   // pomaga w budowaniu struktury pliku wynikowego JSON
    public ImieDTO(final String imie) {
        this.imie = imie;
    }
}      // jest to klasa w ramach restApi (?)
