package edu.iu.otiwari.guitarservice.model;

public enum Builder {
    FENDER, GIBSON, MARTIN, COLLINS, OLSON, RYAN, PRS, ANY;

    public String toString() {
        switch(this) {
            case FENDER: return "Fender";
            case GIBSON: return "Gibson";
            case MARTIN: return "Martin";
            case COLLINS: return "Collins";
            case OLSON: return "Olson";
            case ANY: return "Any";
            default: return "Unspecified";
        }
    }
}
