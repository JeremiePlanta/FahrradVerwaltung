package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Fahrrad;
import org.example.domain.FahrradRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FahrradRepositoryImpl implements FahrradRepository {

    private final List<Fahrrad> fahrradVerwaltungsListe = new ArrayList<>();
    private final IRepository<Fahrrad,String> fahrradRepository;

    public FahrradRepositoryImpl(Properties properties){
        this.fahrradRepository = RepositoryManager.getRepository(Fahrrad.class, Fahrrad::getGestellnummer,properties);
    }
    @Override
    public List<Fahrrad> getAll() {
        return fahrradRepository.get();
    }

    @Override
    public void add(Fahrrad fahrrad) {
        this.fahrradRepository.add(fahrrad);
    }

    @Override
    public void remove(Fahrrad fahrrad) {
        this.fahrradRepository.remove(fahrrad.getGestellnummer());
    }
}
