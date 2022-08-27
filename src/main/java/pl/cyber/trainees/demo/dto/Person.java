package pl.cyber.trainees.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder   // stosuje się, gdy przenosimy jakieś dane
@RequiredArgsConstructor
public class Person {
    private final String imie;
    private final String nazwisko;
    private final String dataUrodzenia;
    private final String miasto;
    private final String plec;
}
