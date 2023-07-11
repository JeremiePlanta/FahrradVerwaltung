package org.example.domain;

import java.util.List;

public interface FahrradRepository {

    List<Fahrrad> getAll();

    void remove(Fahrrad fahrrad);

    void add(Fahrrad fahrrad);
}
