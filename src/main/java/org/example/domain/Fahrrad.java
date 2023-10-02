package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Fahrrad {
    private FahrradDaten fahrradDaten;
    private final GestellNummer gestellNummer;

    private final EmailAdresse emailAdresse;

    public Fahrrad(GestellNummer gestellNummer, FahrradDaten fahrradDaten, EmailAdresse emailAdresse) {
        this.gestellNummer = gestellNummer;
        this.fahrradDaten = fahrradDaten;
        this.emailAdresse = emailAdresse;

    }

    @SuppressWarnings("unused")
    public int getReifengroesse() {
        return fahrradDaten.reifengroesse();
    }
    @SuppressWarnings("unused")
    public String getRahmen() {
        return fahrradDaten.rahmen();
    }

    @SuppressWarnings("unused")
    public String getTyp() {
        return fahrradDaten.typ();
    }

    @SuppressWarnings("unused")
    @AggregateID
    public GestellNummer getGestellnummer() {
        return gestellNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrrad fahrrad = (Fahrrad) o;
        return Objects.equals(gestellNummer, fahrrad.gestellNummer);
    }
    public void aktualisiere(FahrradDaten fahrradDaten){
        this.fahrradDaten = fahrradDaten;
    }

}
