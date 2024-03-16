package ru.borovkov.WellProcessing.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class WellDTO {

    @NotEmpty(message = "Поле не должно быть пустым!")
    @Size(min = 1, max = 30, message = "Номер скважины не должен превышать 30 символов!")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
