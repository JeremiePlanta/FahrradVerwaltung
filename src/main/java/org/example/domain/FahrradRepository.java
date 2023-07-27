package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface FahrradRepository {

    List<Fahrrad> getAll();

    void remove(Fahrrad fahrrad);

    void add(Fahrrad fahrrad);
}
