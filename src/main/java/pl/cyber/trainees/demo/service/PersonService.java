package pl.cyber.trainees.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.KluczSortowaniaenum;
import pl.cyber.trainees.demo.dto.Person;
import pl.cyber.trainees.demo.dto.PersonDTO;
import pl.cyber.trainees.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.Comparator;
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

    public PersonDTO getPersonParms(final String imie, final String nazwisko) {
        return null;
    }

    public void updatePerson(final PersonRequest request) {
    }

    public List<PersonDTO> zadanie12(final KluczSortowaniaenum klucz) {
        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person ele:
             personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());
        }

        // if.else-if/else

        if (klucz.equals(KluczSortowaniaenum.DATA)) {
            resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
        } else if (klucz.equals(KluczSortowaniaenum.IMIE)) {
            resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
        } else if (klucz.equals(KluczSortowaniaenum.NAZWISKO)) {
            resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
        } else if (klucz.equals(KluczSortowaniaenum.MIASTO)) {
            resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));

        }

        // switch (napiszemy na 2 sposoby)




        return resultPersonList;
    }

    //   public void updatePerson(final PersonRequest request) {
  //      for (Person element: personList) {
  //          if (element.getImie().equals(request.getImie())
  //              && element.getNazwisko().equals(request.getNazwisko())
   //             && element.getDataUrodzenia().



    // switch (napiszemy na 2 sposoby)
    public List<PersonDTO> zadanie12b(final KluczSortowaniaenum klucz) {
        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person ele:
                personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());
        }

       switch (klucz) {
           case DATA:
               resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
                break;
           case IMIE:
               resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
                break;
           case MIASTO:
               resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
                break;
           case NAZWISKO:
               resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
               break;

        }
        return resultPersonList;
    }

    public List<PersonDTO> zadanie12c(final KluczSortowaniaenum klucz) {
        List<PersonDTO> resultPersonList = new ArrayList<>();

        for (Person ele:
                personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());
        }

        switch (klucz) {
            case DATA -> resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
            case IMIE -> resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
            case MIASTO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
            case NAZWISKO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
        }
        return resultPersonList;
    }



}

