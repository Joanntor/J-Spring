package pl.cyber.trainees.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //adnotacja do zbudowania obiektu w oparciu o konstruktor klasy
/*
new LiteryDTO ("a", 1);

LiteryDTO.builder()
.litera("a")
.ilosc(1)
.build()

litera -> a, jej ilosc -> 1
-------------------------------

new LiteryDTO("a", null);

 */
@AllArgsConstructor
public class LiteryDTO {

    private String litera;
    private Integer ilosc;

}
