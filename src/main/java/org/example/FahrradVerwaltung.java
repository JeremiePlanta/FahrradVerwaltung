package org.example;

import java.util.ArrayList;
import java.util.List;

public class FahrradVerwaltung {
    private final List<Fahrrad> fahrradVerwaltungsListe = new ArrayList<>();

    public void add(Fahrrad fahrrad){
        fahrradVerwaltungsListe.add(fahrrad);
    }
    public void delete(Fahrrad fahrrad){
        fahrradVerwaltungsListe.remove(fahrrad);
    }
    public List<Fahrrad> get(){
        return fahrradVerwaltungsListe;
    }
}
