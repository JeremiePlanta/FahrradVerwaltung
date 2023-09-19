package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class FahrradVerwaltung {
    private final FahrradRepository fahrradVerwaltungsListe ;

    private final RegistrierungsDatenRepository registrierungsDatenRepository;

    public  FahrradVerwaltung(FahrradRepository fahrradRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.fahrradVerwaltungsListe = fahrradRepository;
        this.registrierungsDatenRepository = registrierungsDatenRepository;
    }
    public void add(GestellNummer gestellNummer, FahrradDaten fahrradDaten){
        fahrradVerwaltungsListe.add(new Fahrrad(gestellNummer, fahrradDaten));
    }
    public void delete(GestellNummer gestellNummer){
        fahrradVerwaltungsListe.remove(gestellNummer);
    }
    public List<GestellNummer> get(){
        return fahrradVerwaltungsListe.getAll()
                .stream()
                .map(Fahrrad::getGestellnummer)
                .toList();
    }
    public void registriere(GestellNummer gestellNummer, FahrradDaten fahrradDaten, EmailAdresse emailAdresse){
        registrierungsDatenRepository.add(new RegistrierungsDaten(gestellNummer, fahrradDaten, emailAdresse));
    }
    public void verifiziere(GestellNummer gestellNummer, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(gestellNummer);
        registrierungsDaten.verifiziere(verifizierungsCode);

        add(gestellNummer, registrierungsDaten.getFahrradDaten());
        registrierungsDatenRepository.remove(gestellNummer);
    }
}
