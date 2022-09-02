package pl.cyber.trainees.demo.dto;

import lombok.*;

@Getter
@Builder   // stosuje się, gdy przenosimy jakieś dane
@RequiredArgsConstructor
@AllArgsConstructor // mówi aplikacji, aby utworzyła konstruktor ze wszystkich paramtrów dostępnych z obiektu
public class Person {
    private final String imie;
    private final String nazwisko;
    private final String dataUrodzenia;
    @Setter
    private String miasto;
    private final String plec;
}
