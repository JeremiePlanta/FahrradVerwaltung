package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Fahrrad;
import org.example.domain.FahrradRepository;
import org.example.domain.GestellNummer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@DrivenAdapter
public class FahrradRepositoryImpl implements FahrradRepository {

    private final List<Fahrrad> fahrradVerwaltungsListe = new ArrayList<>();
    private final IRepository<Fahrrad, GestellNummer> fahrradRepository;

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
    public void update(Fahrrad fahrrad) {
        this.fahrradRepository.update(fahrrad);
    }

    @Override
    public Optional<Fahrrad> get(GestellNummer gestellNummer) {
        return fahrradRepository.get(gestellNummer);
    }

    @Override
    public void remove(GestellNummer gestellNummer) {
        this.fahrradRepository.remove(gestellNummer);
    }
}
