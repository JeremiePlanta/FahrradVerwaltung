package org.example.domain;


import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;

@Aggregate
public class RegistrierungsDaten {

    private final GestellNummer gestellNummer;
    private final FahrradDaten fahrradDaten;
    private final EmailAdresse emailAdresse;

    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(GestellNummer gestellNummer, FahrradDaten fahrradDaten, EmailAdresse emailAdresse) {
        this.gestellNummer = gestellNummer;
        this.fahrradDaten = fahrradDaten;
        this.emailAdresse = emailAdresse;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
    }

    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if(this.verifizierungsCode != verifizierungsCode){
            throw new UngueltigerVerifizierungsCode();
        }
    }
    public void sendVerifizierungsCode(){
        publish(new VerifizierungsCodeVerschickt(emailAdresse, verifizierungsCode));
    }
    @AggregateID
    public GestellNummer getGestellNummer() {
        return gestellNummer;
    }

    public FahrradDaten getFahrradDaten() {
        return fahrradDaten;
    }

    public EmailAdresse getEmailAdresse() {
        return emailAdresse;
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }
}
