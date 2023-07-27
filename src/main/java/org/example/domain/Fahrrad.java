package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Fahrrad {
    private final int reifengroesse;
    private final String rahmen;
    private final String typ;

    private final String gestellnummer;

    public Fahrrad(int reifengroesse, String rahmen, String typ, String gestellnummer) {
        this.reifengroesse = reifengroesse;
        this.rahmen = rahmen;
        this.typ = typ;
        this.gestellnummer = gestellnummer;
    }

    @SuppressWarnings("unused")
    public int getReifengroesse() {
        return reifengroesse;
    }
    @SuppressWarnings("unused")
    public String getRahmen() {
        return rahmen;
    }

    @SuppressWarnings("unused")
    public String getTyp() {
        return typ;
    }

    @SuppressWarnings("unused")
    public String getGestellnummer() {
        return gestellnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrrad fahrrad = (Fahrrad) o;
        return reifengroesse == fahrrad.reifengroesse && Objects.equals(rahmen, fahrrad.rahmen) && Objects.equals(typ, fahrrad.typ) && Objects.equals(gestellnummer, fahrrad.gestellnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reifengroesse, rahmen, typ, gestellnummer);
    }
}
