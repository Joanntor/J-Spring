package pl.cyber.trainees.demo.dto;

import lombok.Getter;

@Getter
public class OneStringRequest {
    private final String value;

    public OneStringRequest(final String value) {
        if(value == null || value.length() == 0){
            throw new RuntimeException("Nie podano zdania. ");
        }
        this.value = value;
    }
}
