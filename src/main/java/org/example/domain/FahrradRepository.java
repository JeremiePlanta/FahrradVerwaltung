package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FahrradRepository {

    List<Fahrrad> getAll();

    void remove(GestellNummer gestellNummer);

    void add(Fahrrad fahrrad);

    void update(Fahrrad fahrrad);

    Optional<Fahrrad> get(GestellNummer gestellNummer);

}
