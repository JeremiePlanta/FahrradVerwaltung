package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {

    @Test
    void testeErstelleVerifizierungsCode(){

        //Arrange
        var gestellNummer = new GestellNummer("06744754");
        var fahrradDaten = new FahrradDaten(28, "Carbon", "Rennrad");
        var emailAdresse = new EmailAdresse("Sportler@speed.high");
        var objectUnderTest = new RegistrierungsDaten(gestellNummer, fahrradDaten, emailAdresse);
        var empfangeneDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();
        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, empfangeneDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierungsCode();

        //Assert
        assertEquals(1, empfangeneDomainEvents.size());
        //Note: A UUID actually a 128 bit value (2 long). To represent 128 bit into hex string there will be 128/4=32 char (each char is 4bit long). In string format it also contains 4 (-) that's why the length is 36.
        assertEquals(36, empfangeneDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }

}