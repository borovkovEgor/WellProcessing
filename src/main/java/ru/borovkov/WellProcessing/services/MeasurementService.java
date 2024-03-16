package ru.borovkov.WellProcessing.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borovkov.WellProcessing.models.Measurement;
import ru.borovkov.WellProcessing.repositories.MeasurementRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final WellService wellService;

    public MeasurementService(MeasurementRepository measurementRepository, WellService wellService) {
        this.measurementRepository = measurementRepository;
        this.wellService = wellService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void addMeasurement(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        measurement.setWell(wellService.findByNumber(measurement.getWell().getNumber()).get());

        measurement.setMeasurementDate(LocalDate.now());
    }
}
