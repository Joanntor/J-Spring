package pl.cyber.trainees.demo.endpoint;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyber.trainees.demo.dto.ImieDTO;

@RestController  // adnotacja mówi serwerowi Springa, że w tym miejscu będą funkcjonalności REST API
@RequestMapping("/v1/first")
public class PierwszyController {        // zadaniem klasy komunikacja z zewnątrz. Tu się implementuje usługi restowe, czyli wszystkie linki, które będziemy używali w ramach aplikacji

    // HTTP metoda GET (get służy do pobierania informacji z serwera oraz wysłania ich do zewnętrznego systemu
    @GetMapping("/{imie}")
    public ImieDTO getImie (@PathVariable final String imie) {
    return ImieDTO.builder()
            .imie(imie)
            .build();
    }
}

