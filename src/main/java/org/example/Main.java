package org.example;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        FahrradVerwaltung fahrraeder = new FahrradVerwaltung();
        fahrraeder.add(new Fahrrad(28,"Carbon","Rennrad"));
        fahrraeder.add(new Fahrrad(27,"Aluminium","MTB"));
        fahrraeder.get().forEach(fahrrad -> System.out.println(fahrrad.getTyp()));
        fahrraeder.delete(new Fahrrad(27,"Aluminium","MTB"));
        fahrraeder.get().forEach(fahrrad -> System.out.println(fahrrad.getTyp()));

    }
}