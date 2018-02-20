package de.nordakademie.defecttracker.model;


public enum DefectStatus {

    CREATED("Angelegt"),
    IN_PROCESS("In Bearbeitung"),
    RESOLVED("Behoben"),
    REJECTED("Abgelehnt"),
    REOPENED("Wiedereröffnet"),
    CLOSED("Geschlossen");

    private final String name;

    DefectStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}