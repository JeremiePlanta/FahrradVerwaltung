package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.Fahrrad;
import org.example.domain.FahrradRepository;

import java.util.ArrayList;
import java.util.List;

public class FahrradRepositoryImpl implements FahrradRepository {

    private final List<Fahrrad> fahrradVerwaltungsListe = new ArrayList<>();

    @Override
    public List<Fahrrad> getAll() {
        return fahrradVerwaltungsListe;
    }

    @Override
    public void add(Fahrrad fahrrad) {
        this.fahrradVerwaltungsListe.add(fahrrad);
    }

    @Override
    public void remove(Fahrrad fahrrad) {
        this.fahrradVerwaltungsListe.remove(fahrrad);
    }
}
