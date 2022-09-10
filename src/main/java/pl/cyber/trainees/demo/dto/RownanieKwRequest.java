package pl.cyber.trainees.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class RownanieKwRequest {
    private final Double a;
    private final Double b;
    private final Double c;

    @ConstructorProperties({"a", "b", "c"})
    public RownanieKwRequest(final Double a, final Double b, final Double c) {
        if (a == 0) {
            throw new RuntimeException("Paramter A jest rowny 0");

        }
        this.a =a;
        this.b = b;
        this.c = c;
    }
}
