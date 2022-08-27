package pl.cyber.trainees.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class PersonDTO {
    private final String imie;
    private final String nazwisko;
    private final String dataUrodzenia;
    private final String miasto;
    private final String plec;

    @Builder
    @ConstructorProperties({"imie", "nazwisko", "dataUrodzenia", "miasto", "plec"})
    public PersonDTO(final String imie, final String nazwisko, final String dataUrodzenia, final String miasto, final String plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.miasto = miasto;
        this.plec = plec;
    }
}
