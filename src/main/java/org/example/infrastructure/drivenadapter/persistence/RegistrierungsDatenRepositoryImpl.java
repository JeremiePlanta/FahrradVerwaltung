package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.GestellNummer;
import org.example.domain.RegistrierungsDaten;
import org.example.domain.RegistrierungsDatenRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
@DrivenAdapter
public class RegistrierungsDatenRepositoryImpl implements RegistrierungsDatenRepository {

    private final IRepository<RegistrierungsDaten, GestellNummer> repository;

    public RegistrierungsDatenRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(RegistrierungsDaten.class, RegistrierungsDaten::getGestellNummer, properties);
    }


    @Override
    public List<RegistrierungsDaten> getAll() {
        return repository.get();
    }

    @Override
    public void add(RegistrierungsDaten registrierungsDaten) {
        repository.add(registrierungsDaten);
    }

    @Override
    public void remove(GestellNummer gestellNummer) {
        repository.remove(gestellNummer);
    }

    @Override
    public Optional<RegistrierungsDaten> get(GestellNummer gestellNummer) {
        return repository.get(gestellNummer);
    }
}
