package pl.cyber.trainees.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.junit.platform.commons.util.PackageUtils;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainees.demo.dto.IntegerListRequest;
import pl.cyber.trainees.demo.dto.OneStringRequest;
import pl.cyber.trainees.demo.dto.RownanieKwRequest;
import pl.cyber.trainees.demo.dto.StringRequest;
import pl.cyber.trainees.demo.service.BasicsService;
import pl.cyber.trainees.demo.service.KalkulatorService;

import java.util.List;


@RestController
@RequestMapping("/v1/basics")
@RequiredArgsConstructor
public class BasicController {
    private final KalkulatorService kalkulatorService;
    private final BasicsService basicsService;
        /*
        Zadanie 1
        Napisać zapytania dla prostego kalkulatora, który będzie obsługiwać 5 operacji
        (każda z nich powinna być oddzielnym zapytaniem restowym)
        Operacje:
        - dodawanie
        - odejmowanie
        - mnożenie
        - dzielenie
        - obliczenie reszty z dzielenia liczb
        Zwrócenie wyniku naszych operacji.
        Np.
        "/dodawanie/{a}"
        @PathVariable
         */

    @GetMapping("/dodawanie/{a}/{b}")
    public Integer getDodawanie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDodawanie(liczbaA, liczbaB);
    }

    @GetMapping("/dodawanieParams")
    public Integer getDodawanieParams(@RequestParam("a") final Integer liczbaA, @RequestParam("b") final Integer liczbaB) {
        return kalkulatorService.getDodawanie(liczbaA, liczbaB);

    }

    @GetMapping("/odejmowanie/{a}/{b}")
    public Integer getOdejmowanie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getOdejmowanie(liczbaA, liczbaB);
    }

    @GetMapping("/mnozenie/{a}/{b}")
    public Integer getMnozenie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getMnozenie(liczbaA, liczbaB);
    }

    @GetMapping("/dzielenie/{a}/{b}")
    public Integer getDzielenie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDzielenie(liczbaA, liczbaB);
    }

    @GetMapping("/reszta/{a}/{b}")
    public Integer getReszta(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getReszta(liczbaA, liczbaB);
    }

    /*
    Zadanie 2

     */
    @GetMapping("/liczba-pierwsza/{a}")
    public String czyLiczbaPierwsza(
            @PathVariable("a") final Integer liczbaA
    ) {
        return kalkulatorService.czyLiczbaPierwsza(liczbaA);
    }

    // zadanie 3
    // Napisz zapytanie restowe, którego zadaniem będzie wykonanie sklejenia dwóch
    // Stringów (przekazanych jako RequestBody) a następnie zwróci wynik.
    // POST/PUT

    @PostMapping("/sklejenie-stringow")
    public String getSklejenie(
            @RequestBody final StringRequest request
    ) {
        return basicsService.getSklejenie(request);
    }

    //    region Zadanie4
    //    /*Napisz zapytanie restowe, którego zadaniem będzie przyjęcie napisu  jako zdania
    //    (przekazanych jako RequestBody)
    //    Program powinien policzyć ilość wystąpień poszczególnych liter zdania i zwrócić
    //    odpowiednio przygotowane dane.
    //    Uwaga należy pominąć litery, których w zdaniu nie ma oraz wszystkie znaki puste.
    //    Przykład.
    //    Ala ma kota
    //    a - 4
    //    k - 1
    //    l - 1
    //    m - 1
    //    o - 1
    //    t - 1
    //    */

    @PostMapping("/zliczanie")
    public List<String> getWystapieniaLiterWZdaniu(
            @RequestBody final OneStringRequest request
    ) {
        return basicsService.getWystapieniaLiterWZdaniu(request);
    }
    /*
    zadanie 7
    Napisz program, w którym zostaną ...
     */

    @GetMapping("/suma-liczb")
    public String sumaLiczbPomiedzy(
            @RequestParam("a") final Integer a,
            @RequestParam("b") final Integer b
    ) {
        return basicsService.sumaLiczbPomiedzy(a, b);

    }

    //  zadanie 8

    @PostMapping("/liczby")
    public String zadanie8(
            @RequestBody final IntegerListRequest request
    ) {
        return basicsService.zadanie8(request);
    }

    //zad. 9
    @GetMapping("/rownanie-kwadratowe/{a}/{b}/{c}")
    public String rownanieKwadratowe(
    @PathVariable("a") final Integer a,
    @PathVariable("b") final Integer b,
    @PathVariable("c") final Integer c
    ){
        return kalkulatorService.rownanieKwadratowe(a,b,c);

    }
    //1,2,1
    //1,1 -2
    //1,1,1

    @PostMapping("/rownanie-kwadratowe-b")
    public String rownanieKwadratowe(
            @RequestBody final RownanieKwRequest request
            ) {
        return kalkulatorService.rownanieKwadratowe(request);
    }
    @PostMapping("/rownanie-kwadratowe-b-2miejsca")
    public String rownanieKwadratowe2miejsca(
            @RequestBody final RownanieKwRequest request
    ) {
        return kalkulatorService.rownanieKwadratowe(request);
    }
}

// get - pobieranie danych do geta nie stosujemy @ requestb0dy
// put  - wkładanie danuch
// post - aktualizowanie danych