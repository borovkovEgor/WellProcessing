package ru.borovkov.WellProcessing.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.borovkov.WellProcessing.dto.WellDTO;
import ru.borovkov.WellProcessing.models.Well;
import ru.borovkov.WellProcessing.services.WellService;
import ru.borovkov.WellProcessing.util.MeasurementErrorResponse;
import ru.borovkov.WellProcessing.util.MeasurementException;
import ru.borovkov.WellProcessing.util.WellValidator;

import static ru.borovkov.WellProcessing.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/wells")
public class WellControllers {
    private final WellService wellService;
    private final ModelMapper modelMapper;
    private final WellValidator wellValidator;

    @Autowired
    public WellControllers(WellService sensorService, ModelMapper modelMapper, WellValidator sensorValidator) {
        this.wellService = sensorService;
        this.modelMapper = modelMapper;
        this.wellValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid WellDTO wellDTO, BindingResult bindingResult) {
        Well wellToAdd = convertToWell(wellDTO);

        wellValidator.validate(wellToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        wellService.register(wellToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Well convertToWell(WellDTO wellDTO) {
        return modelMapper.map(wellDTO, Well.class);
    }
}
