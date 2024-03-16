package ru.borovkov.WellProcessing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.borovkov.WellProcessing.models.Well;
import ru.borovkov.WellProcessing.services.WellService;

@Component
public class WellValidator implements Validator {

    private final WellService wellService;

    @Autowired
    public WellValidator(WellService wellService) {
        this.wellService = wellService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Well.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Well well = (Well) o;

        if (wellService.findByNumber(well.getNumber()).isPresent())
            errors.rejectValue("number", "Скважина с таким номером уже есть!");
    }
}
