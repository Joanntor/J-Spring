package pl.cyber.trainees.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;
import java.util.List;

@Getter
public class IntegerListRequest {
        private final List<Integer>  intList;

@ConstructorProperties({"intList"})
        public IntegerListRequest(final List<Integer> intList) {
            this.intList = intList;
        }
    }

