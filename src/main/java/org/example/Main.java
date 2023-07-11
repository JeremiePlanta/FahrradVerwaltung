package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.Fahrrad;
import org.example.domain.FahrradVerwaltung;
import org.example.infrastructure.drivenadapter.persistence.FahrradRepositoryImpl;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        FahrradVerwaltung fahrraeder = new FahrradVerwaltung(new FahrradRepositoryImpl());
        fahrraeder.add(new Fahrrad(28,"Carbon","Rennrad"));
        fahrraeder.add(new Fahrrad(27,"Aluminium","MTB"));
        fahrraeder.get().forEach(fahrrad -> System.out.println(fahrrad.getTyp()));
        fahrraeder.delete(new Fahrrad(27,"Aluminium","MTB"));
        fahrraeder.get().forEach(fahrrad -> System.out.println(fahrrad.getTyp()));
        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(FahrradVerwaltung.class)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}