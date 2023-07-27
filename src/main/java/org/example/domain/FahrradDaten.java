package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record FahrradDaten(int reifengroesse, String rahmen, String typ) {
}
