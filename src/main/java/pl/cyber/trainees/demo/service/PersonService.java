package pl.cyber.trainees.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.Person;
import pl.cyber.trainees.demo.dto.PersonDTO;
import pl.cyber.trainees.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.List;

@Service // Spring wie, że może jej używać do defoultowego konstruktora, aby powołać go do życia
@RequiredArgsConstructor
public class PersonService {
    private List<Person> personList = new ArrayList<>();
    public void createPerson (final PersonRequest request) {
        // validator
        walidujOsobe(request);

        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }

    private void walidujOsobe(final PersonRequest request) {
        boolean czyIstnieje = false;
        for (Person element: personList){
            if(element.getImie().equals(request.getImie())
            && element.getNazwisko().equals(request.getNazwisko())
            && element.getDataUrodzenia().equals(request.getDataUrodzenia())
            ) {
                czyIstnieje = true;
            }
        }
        if (czyIstnieje) {
            throw new RuntimeException("Taka osoba już ostnieje");
        }
    }


    public PersonDTO getPerson(final PersonRequest request) {
        for (Person element: personList) {
            if(element.getImie().equals(request.getImie()) && element.getNazwisko().equals(request.getNazwisko()) && element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                return PersonDTO.builder()
                        .imie(element.getImie())
                        .nazwisko(element.getNazwisko())
                        .miasto(element.getMiasto())
                        .dataUrodzenia(element.getDataUrodzenia())
                        .plec(element.getPlec())
                        .build();
            }
        }
        return PersonDTO.builder().build();
    }

    public void updatePerson(final PersonRequest request) {
        for (Person element: personList) {
            if (element.getImie().equals(request.getImie())
                && element.getNazwisko().equals(request.getNazwisko())
                && element.getDataUrodzenia().

        }
    }
}
