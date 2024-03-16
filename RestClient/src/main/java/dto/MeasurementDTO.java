package dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.borovkov.WellProcessing.models.Well;


public class MeasurementDTO {

    @NotNull
    private Float wellLevel;

    @NotNull
    private Float mineralization;

    @NotNull
    private Float temperature;

    @NotNull
    @Min(0)
    @Max(14)
    private Float pH;

    @NotNull
    private Float Na;

    @NotNull
    private Float Ca;

    @NotNull
    private Float Mg;

    @NotNull
    private Float SO4;

    @NotNull
    private Float HCO3;

    @NotNull
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

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }
}
