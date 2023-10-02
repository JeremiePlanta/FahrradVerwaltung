package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.*;

import java.util.List;

@DomainService
public class StammdatenService {

    private final FahrradRepository fahrradRepository;

    public StammdatenService(FahrradRepository fahrradRepository){
        this.fahrradRepository = fahrradRepository;
    }

    public void initStammdaten(){
        final Fahrrad cross = new Fahrrad(new GestellNummer("32357545454"),new FahrradDaten(27,"Aluminium","Cross"), new EmailAdresse("dfgfdgd@.fgfdg.dfs"));
        final Fahrrad mtb = new Fahrrad(new GestellNummer("435436336"),new FahrradDaten(28,"Aluminium","MTB"),new EmailAdresse("dfgfdgd@.fgfdg.dfs"));
        final Fahrrad rennrad = new Fahrrad(new GestellNummer("352354455"),new FahrradDaten(28,"Carbon","Rennrad"),new EmailAdresse("dfgfdgd@.fgfdg.dfs"));

        List<Fahrrad> alleFahrraeder = fahrradRepository.getAll();

        if (!alleFahrraeder.contains(cross)){
            fahrradRepository.add(cross);
        }
        if (!alleFahrraeder.contains(mtb)){
            fahrradRepository.add(mtb);
        }
        if (!alleFahrraeder.contains(rennrad)){
            fahrradRepository.add(rennrad);
        }
        fahrradRepository
                .getAll()
                .forEach( element -> System.out.println(element.getGestellnummer()));
    }

}
