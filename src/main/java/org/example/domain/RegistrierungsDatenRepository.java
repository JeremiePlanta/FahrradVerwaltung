package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface RegistrierungsDatenRepository {

    List<RegistrierungsDaten>  getAll();

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(GestellNummer gestellNummer);

    RegistrierungsDaten get(GestellNummer gestellNummer);
}
