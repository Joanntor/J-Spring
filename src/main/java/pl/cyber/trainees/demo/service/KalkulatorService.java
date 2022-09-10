package pl.cyber.trainees.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.RownanieKwRequest;

import java.text.DecimalFormat;
import java.util.Locale;

@Service
public class KalkulatorService {
    //metoda dodawania

    public Integer getDodawanie(final Integer a, final Integer b) {
        return a + b;
    }

    // metoda odejmowania
    public Integer getOdejmowanie(final Integer a, final Integer b) {
        return a - b;
    }

    // metoda mnożenia
    public Integer getMnozenie(final Integer a, final Integer b) {
        return a * b;
    }

    // metoda dzielenia
    public Integer getDzielenie(final Integer a, final Integer b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new RuntimeException("Nie dziel przez 0");

        }
    }
    // metoda obliczenia reszty z dzielenia liczb

    public Integer getReszta(final Integer a, final Integer b) {
        return a % b;
    }

    public String czyLiczbaPierwsza(final Integer a) {
        if (a < 2) {
            return "To nie jest liczba pierwsza!";
        }
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return "To nie jest liczba pierwsza!";
            }
        }
        return "To jest liczba pierwsza";
    }

    public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {
        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        if (a == 0) {
            return "To nie jest równanie kwadratowe";
        }
        delta = Double.valueOf(b * b - 4 * a * c);
        if (delta < 0) {
            return "Brak pierwiastków";
        } else {
            if (delta == 0) {
                x1 = Double.valueOf(-b / (2 * a));
                return "Jeden pierwiastek. Wynik: " + x1;
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                return "Dwa pierwiastki. Wynik x1: " + x1 + "x2 " + x2;
            }
        }
    }

    public String rownanieKwadratowe(final RownanieKwRequest request) {
        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;
        if (delta == 0) {
            x1 = -b / (2 * a);
            return "Jeden pierwiastek. Wynik: " + x1;
        } else if (delta < 0) {
            return "Brak pierwiastków";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + x1 + "x2: " + x2;
        }
    }

    public String rownanieKwadratowe2miejsca(final RownanieKwRequest request) {
        Locale englishLocale = Locale.ENGLISH;
        Locale polishLocale = Locale.forLanguageTag("pl-PL");

        Locale.setDefault(polishLocale);

        DecimalFormat df = new DecimalFormat("#,###.00");
        /*
        1.10
        "#,###.00" > 1,10

        1101.10
        "#,###.00" > 1 101,10
        #,###.00 >  1 101,10
           1.10
              #,###.0# >  1,10
                 1.1
                    #,###.0# >  1,1
                 1.1131421125
                     #,###.0# >  1,11
                         1.1161421125
                            #,###.0# >  1,12
                               1.1161421125
                                 #,###.0## >  1,116
                                     1101.10   #.# > 1101,1

                 1101.1
          #.0000 > 1101,1000    */


        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;
        if (delta == 0) {
            x1 = -b / (2 * a);
            return "Jeden pierwiastek. Wynik: " + df.format(x1);
        } else if (delta < 0) {
            return "Brak pierwiastków";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + df.format(x1) + "x2: " + df.format(x2);
        }
    }
// egzamin
    public String zadanie10a(){
     //   Integer y = 0;

/*        String result = "Program oblicza wartość funkcji y = 3x, dla x zmieniającego się od 0 do 10.\n";

        for(int x = 0; x <= 10; x++){
            y = 3*x;
            result += "x=" + x + "\t " + "y= " + y + "\n";

        }
        return result;*/

        // alternatywa ciekawostka, nie na teraz:

        Integer y = 0;

        StringBuilder result = new StringBuilder("Program oblicza wartość funkcji y = 3x, dla x zmieniającego się od 0 do 10.\n");

        for(int x = 0; x <= 10; x++){
            y = 3*x;
            result.append("x=").append(x).append("\t " ).append( "y= ").append(y).append("\n");

        }
        return result.toString();

    }

    public String zadanie10b(){
        Integer y = 0;
        Integer x = 0;
        String result = "Program oblicza wartość funkcji y = 3x, dla x zmieniającego się od 0 do 10"+
                "Za pomocą pętli do...while\n";
        do {
            y=3*x;
            result += "x = " + x + "\t" + "y = " +y + "\n";
            x++;
        } while (x<=10);
        return result;
    }

    public String zadanie10c() {
        Integer y = 0;
        Integer x = 0;

        String result = "Program oblicza wartość funkcji y = 3x, dla x zmieniającego się od 0 do 10. \n" +
                "Przy pomocy pętli while\n";

        while (x <= 10) {
            y = 3*x;
            result += "X = " + x + "\t" + "y = " + y + "\n";
            x++;
            // result += to to samo co result = result +
        }
        return result;
    }

    public String zadanie11a(){

        Integer n = 10;

        String result = "Program wyświetla wyniki tabliczki mnożenia " + "dla liczb od 1 do 100. \n \n ";

        for (int wiersz = 1; wiersz <= n; wiersz++) {
            for (int kolumna = 1; kolumna <= n; kolumna++) {
                result += wiersz*kolumna;
                result += "\t";
            }
            result += "\n";
        }
        return result;

        }

    public String zadanie11aa(){

        Integer w = 20;
        Integer k = 15;

        String result = "Program wyświetla wyniki tabliczki mnożenia " + "dla liczb od 1 do 100. \n \n ";

        for (int wiersz = 1; wiersz <= w; wiersz++) {
            for (int kolumna = 1; kolumna <= k; kolumna++) {
                result += wiersz*kolumna;
                result += "\t";
            }
            result += "\n";
        }
        return result;

    }

    public String zadanie11b() {

            Integer k = 10;
            Integer w = 20;
            Integer wiersz = 1;
            Integer kolumna = 1;

            String result = "Program wyświetla tabliczkę mnożenia dla liczb od 1 do 200. \n Przy użyciu pętli do " +
                    "... while" +
                    "\n\n";

            do {
                kolumna = 1;
                do {
                    result += wiersz * kolumna;
                    result += "\t";
                    kolumna ++;
                }while(kolumna <= k);
                result += "\n";
                wiersz ++;
            } while (wiersz <= w);

            return result;
        }

    public String zadanie11c() {
        Integer k = 10;
        Integer w = 20;
        Integer wiersz = 1;
        Integer kolumna = 1;

        String result = "Program wyświetla tabliczkę mnożenia " +
                "dla liczb od 1 do 200. \n Przy użyciu pętli while \n\n";

        while(wiersz <= w) {
            kolumna = 1;
            while(kolumna <= k){
                result += wiersz*kolumna;
                result += "\t";
                kolumna++;
            }
            result += "\n";
            wiersz++;
        }

        return result;
    }
}




