package org.example.domain;

import java.util.Objects;

public class Fahrrad {
    private final int reifengroesse;
    private final String rahmen;
    private final String typ;

    public Fahrrad(int reifengroesse, String rahmen, String typ) {
        this.reifengroesse = reifengroesse;
        this.rahmen = rahmen;
        this.typ = typ;
    }

    @SuppressWarnings("unused")
    public int getReifengroesse() {
        return reifengroesse;
    }
    @SuppressWarnings("unused")
    public String getRahmen() {
        return rahmen;
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrrad fahrrad = (Fahrrad) o;
        return reifengroesse == fahrrad.reifengroesse && Objects.equals(rahmen, fahrrad.rahmen) && Objects.equals(typ, fahrrad.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reifengroesse, rahmen, typ);
    }
}
