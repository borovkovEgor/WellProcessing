package ru.borovkov.WellProcessing.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "measurement_date")
    private LocalDate measurementDate;

    @Column(name = "well_level")
    @NotNull
    private Float wellLevel;

    @Column(name = "mineralization")
    @NotNull
    private Float mineralization;

    @Column(name = "temperature")
    @NotNull
    private Float temperature;

    @Column(name = "ph")
    @NotNull
    @Min(0)
    @Max(14)
    private Float pH;

    @Column(name = "na")
    @NotNull
    private Float Na;

    @Column(name = "ca")
    @NotNull
    private Float Ca;

    @Column(name = "mg")
    @NotNull
    private Float Mg;

    @Column(name = "so4")
    @NotNull
    private Float SO4;

    @Column(name = "hco3")
    @NotNull
    private Float HCO3;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "well", referencedColumnName = "number")
    private Well well;

    public Float getWellLevel() {
        return wellLevel;
    }

    public void setWellLevel(Float wellLevel) {
        this.wellLevel = wellLevel;
    }

    public Float getMineralization() {
        return mineralization;
    }

    public void setMineralization(Float mineralization) {
        this.mineralization = mineralization;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getpH() {
        return pH;
    }

    public void setpH(Float pH) {
        this.pH = pH;
    }

    public Float getNa() {
        return Na;
    }

    public void setNa(Float na) {
        Na = na;
    }

    public Float getCa() {
        return Ca;
    }

    public void setCa(Float ca) {
        Ca = ca;
    }

    public Float getMg() {
        return Mg;
    }

    public void setMg(Float mg) {
        Mg = mg;
    }

    public Float getSO4() {
        return SO4;
    }

    public void setSO4(Float SO4) {
        this.SO4 = SO4;
    }

    public Float getHCO3() {
        return HCO3;
    }

    public void setHCO3(Float HCO3) {
        this.HCO3 = HCO3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }
}
