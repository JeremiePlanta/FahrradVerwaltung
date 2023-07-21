package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.FahrradRepository;
import org.example.applicationservice.FahrradVerwaltung;
import org.example.domainservice.StammdatenService;
import org.example.infrastructure.drivenadapter.persistence.FahrradRepositoryImpl;

import java.util.Properties;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                .bootstrap(StammdatenService.class).with(StammdatenService::initStammdaten)
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(FahrradVerwaltung.class)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}