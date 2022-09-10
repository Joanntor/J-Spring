package pl.cyber.trainees.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.IntegerListRequest;
import pl.cyber.trainees.demo.dto.LiteryDTO;
import pl.cyber.trainees.demo.dto.OneStringRequest;
import pl.cyber.trainees.demo.dto.StringRequest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BasicsService {

    public String getSklejenie(final StringRequest request) {
        return request.getStringPierwszy()+request.getStringDrugi();
    }
    public List<String> getWystapieniaLiterWZdaniu(final OneStringRequest request) {
        List<LiteryDTO> wystapienia = new ArrayList<>();
        Set<String> litery = new HashSet<>();
        List<String> wynik = new ArrayList<>();


        return null;
    }

    public String sumaLiczbPomiedzy(final Integer a, final Integer b) {
        Integer wynik = 0;

        if (a>b) {
            throw new RuntimeException("Wartość parametru a nie powinna być mniejsza od wartości b");
        }

        for (int i = a; i <=b; i++) {
            wynik += i;
        }
        return "Wynik dodawania liczb pomiędzy a: " + a + "oraz b:" + b + " to: " + wynik;
    }

    public String zadanie8(final IntegerListRequest request) {
        List<Integer> listaUjemnych = new ArrayList<>();
        Integer sumaDodatnich = 0;
        for (Integer element :
            request.getIntList() ) {
            if (element < 0) {
                listaUjemnych.add(element);
            } else {
                sumaDodatnich += element;
            }

        }
        return listaUjemnych + " oraz suma liiczb dodatnich wynosi: " + sumaDodatnich;
    }
}
