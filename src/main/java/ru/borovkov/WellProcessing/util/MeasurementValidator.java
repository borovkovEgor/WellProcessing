package ru.borovkov.WellProcessing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.borovkov.WellProcessing.models.Measurement;
import ru.borovkov.WellProcessing.services.WellService;

@Component
public class MeasurementValidator implements Validator {

    private final WellService wellService;

    @Autowired
    public MeasurementValidator(WellService wellService) {
        this.wellService = wellService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Measurement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Measurement measurement = (Measurement) o;

        if (measurement.getWell() == null) {
            return;
        }

        if (wellService.findByNumber(measurement.getWell().getNumber()).isEmpty())
            errors.rejectValue("well", "Скважины с таким номером нет!");
    }
}
