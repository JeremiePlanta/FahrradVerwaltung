package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class FahrradVerwaltung {
    private final FahrradRepository fahrradVerwaltungsListe ;

    public  FahrradVerwaltung(FahrradRepository fahrradRepository){
        this.fahrradVerwaltungsListe = fahrradRepository;
    }
    public void add(Fahrrad fahrrad){
        fahrradVerwaltungsListe.add(fahrrad);
    }
    public void delete(Fahrrad fahrrad){
        fahrradVerwaltungsListe.remove(fahrrad);
    }
    public List<Fahrrad> get(){
        return fahrradVerwaltungsListe.getAll();
    }
}
