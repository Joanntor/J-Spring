package pl.cyber.trainees.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.junit.platform.commons.util.PackageUtils;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainees.demo.dto.*;
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
    ) {
        return kalkulatorService.rownanieKwadratowe(a, b, c);

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


// get - pobieranie danych do geta nie stosujemy @ requestb0dy
// put  - wkładanie danuch
// post - aktualizowanie danych

    /*
    Zadanie 10
    Za pomocą instrukcji pętli for dla danych wartości x zmieniających się od 0 do 10 obliczymy wartość funkcji y = 3x

     */
    @GetMapping("/zadanie10a")
    public String zadanie10a() {
        return kalkulatorService.zadanie10a();
    }

    // region zadanie 10b
    // Za pomocą instrukcji pętli do...while dla danych wartości x zmieniających się od 0 do 10
    // obliczymy wartość funkcji y = 3x

    @GetMapping("/zadanie10b")
    public String zadanie10b(){
        return kalkulatorService.zadanie10b();
    }

    // region zadanie 10c
    // Za pomocą instrukcji pętli while dla danych wartości x zmieniających się od 0 do 10
    // obliczymy wartość funkcji y = 3x

    @GetMapping("/zadanie10c")
    public String zadanie10c(){
        return kalkulatorService.zadanie10c();

    }

    // region Zadanie 11a
    /*
    Napisać program, który przy pomocy pętli for przekaże nam wyniki tabliczki mnożenia od 1 do 100
    Potrzebujemy 2 pętle for
    Parametr 1-10;
     */

    @GetMapping("/zadanie11a")
    public String zadanie11a(){
        return kalkulatorService.zadanie11a();

    }
    @GetMapping("/zadanie11aa")
    public String zadanie11aa(){
        return kalkulatorService.zadanie11aa();
    }

    // region Zadanie 11b
    /*
    Napisać program, który przy pomocy pętli do..while przekaże nam wyniki tabliczki mnożenia od 1 do 100
    Potrzebujemy 2 pętle do... while
    do {
    //ustawienie parametru do kolumny
    do{
    //mnożenie
    inkrementacja dla kolumny
    } while ()

    //new line
    //inkrementacja dla wierszy
    } while()
     */
    @GetMapping("/zadanie11b")
    public String zadanie11b(){
        return kalkulatorService.zadanie11b();
    }
// region Zadanie 11c
    /*
    Napisać program, który przy pomocy pętli while przekaże nam wyniki tabliczki mnożenia od 1 do 100
    Potrzebujemy 2 pętle while
    while (){ // wiersze
    //pierwotne ustawienie parametru dla kolumny
    while () {//kolumny
    }
    // new line
    //inkrementacja dla wierszy
    }
     */
    @GetMapping("/zadanie11c")
    public String zadanie11c(){
        return kalkulatorService.zadanie11c();
    }

    //region ZADANIE DOMOWE
   /*
 zadanie
   Proszę zadanie 10 (a, b, c) przerobić tak, aby można było z zewnątrz podać parametr x oraz parametr do kiedy nasza pętla ma się wykonywać
   Proszę aby nie wzorować się na dostępnych metodach.

  */

    @PostMapping("/zadanie10d")
    public String zadanie10d(@RequestBody IntegerRequest request) {
        return kalkulatorService.zadanie10d(request);
    }

    @PostMapping("/zadanie10e")
    public String zadanie10e(@RequestBody IntegerRequest request) {
        return kalkulatorService.zadanie10e(request);
    }
    @PostMapping("/zadanie10f")
    public String zadanie10f(@RequestBody IntegerRequest request) {
        return kalkulatorService.zadanie10f(request);


 /*


 Zadania dla chętnych:
 1)
 Napisz program, który oblicza wartość x z równania ax+b = c. Wartości a, b i c należy podać poprzez PathVariable, RequestParam lub RequestBody.
 Należy zabezpieczyć program na wypadek sytuacji, kiedy wprowadzona wartość 'a' będzie równa zero. Dla zmiennych a, b, c oraz x należy
 przyjąć format wyświetlania ich na ekranie z dokładnością do dwóch miejsc
 po przecinku

 new DecimalFormal("#,##0.00")
*/


        /*


 2)
 Napisz program, który za pomocą instrukcji (for, do ... while oraz while, tzn trzy różne rozwiązania)
 znajduje największą i najmniejszą liczbę ze zbioru 'n' wylosowanych liczb całkowitych od 0 do 100
 oraz oblicza średnią ze wszystkich wylosowanych liczb
   */

        @PostMapping("/zadanie12for")
                public String zadanie12for(@RequestBody IntegerRequest request) {
            return kalkulatorService.zadanie12for(request);
        }
}}
