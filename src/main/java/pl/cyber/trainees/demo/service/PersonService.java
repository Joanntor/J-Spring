package pl.cyber.trainees.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.Person;
import pl.cyber.trainees.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.List;

@Service // Spring wie, że może jej używać do defoultowego konstruktora, aby powołać go do życia
@RequiredArgsConstructor
public class PersonService {
    private List<Person> personList = new ArrayList<>();
    public void createPerson (final PersonRequest request) {
        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }
}
