package org.example.domainservice;

import org.example.domain.Fahrrad;
import org.example.domain.FahrradRepository;

import java.util.List;

public class StammdatenService {
    private static final Fahrrad cross = new Fahrrad(27,"Aluminium","Cross");
    private static final Fahrrad mtb = new Fahrrad(27,"Aluminium","MTB");
    private static final Fahrrad rennrad = new Fahrrad(28,"Carbon","Rennrad");

    private final FahrradRepository fahrradRepository;

    public StammdatenService(FahrradRepository fahrradRepository){
        this.fahrradRepository = fahrradRepository;
    }

    public void initStammdaten(){
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
                .forEach( element -> System.out.println(element.getTyp()));
    }

}
