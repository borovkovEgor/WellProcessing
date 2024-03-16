package ru.borovkov.WellProcessing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borovkov.WellProcessing.models.Well;
import ru.borovkov.WellProcessing.repositories.WellRepositories;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class WellService {

    private final WellRepositories wellRepositories;

    @Autowired
    public WellService(WellRepositories wellRepositories) {
        this.wellRepositories = wellRepositories;
    }

    public Optional<Well> findByNumber(String number) {
        return wellRepositories.findByNumber(number);
    }

    @Transactional
    public void register(Well well) {
        wellRepositories.save(well);
    }
}
