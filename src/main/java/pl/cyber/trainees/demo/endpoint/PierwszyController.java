package pl.cyber.trainees.demo.endpoint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainees.demo.dto.ImieDTO;
import pl.cyber.trainees.demo.dto.PersonDTO;
import pl.cyber.trainees.demo.dto.PersonRequest;
import pl.cyber.trainees.demo.service.PersonService;
@Slf4j // zamiast sout
@RestController  // adnotacja mówi serwerowi Springa, że w tym miejscu będą funkcjonalności REST API
@RequiredArgsConstructor
@RequestMapping("/v1/first")
public class PierwszyController {        // zadaniem klasy komunikacja z zewnątrz. Tu się implementuje usługi restowe, czyli wszystkie linki, które będziemy używali w ramach aplikacji

    private final PersonService service;
    // HTTP metoda GET (get służy do pobierania informacji z serwera oraz wysłania ich do zewnętrznego systemu
    @GetMapping("/{imie}")
    public ImieDTO getImie (@PathVariable final String imie) {
    return ImieDTO.builder()
            .imie(imie)
            .build();
    }
    @PutMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPerson(@RequestBody final PersonRequest request) {
        log.info("Dokonuję utworzenia Osoby");
        service.createPerson(request);

    }

    // zadanie
    // utworzyć 2 obiekty:
    //1. PersonDTO, który będzie przekazywany dla użytkownika
    // 2. Person jako obiekt wewnętrzny aplikacji (wykorzystywany tylko przez naszą aplikację)
   // GET (@GetMapping), PUT (@PutMapping), POST (@PostMapping)
   // PersonRequest
    // Utworzyć metody REST do tworzenia użytkownika, zmiany jego danych oraz jego pobierania
    // Imie, nazwisko, date urodzenia, miasto zamieszkania, płeć
    @GetMapping("/person")
    public PersonDTO getPerson(@RequestBody final PersonRequest request) {
        return service.getPerson(request);
    }
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@RequestBody final PersonRequest request) {
        log.info("Dokonuje aktualizacji Osoby");
        service.updatePerson(request);

    }

}

