package edu.iu.otiwari.guitarservice.model;

public enum Type {
    ACOUSTIC, ELECTRIC, ANY;

    public String toString() {
        switch(this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            case ANY: return "Any";
            default: return "Unspecified";
        }
    }
}
