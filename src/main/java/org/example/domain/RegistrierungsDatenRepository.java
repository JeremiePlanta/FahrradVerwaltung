package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrierungsDatenRepository {

    List<RegistrierungsDaten>  getAll();

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(GestellNummer gestellNummer);

    Optional<RegistrierungsDaten> get(GestellNummer gestellNummer);
}
