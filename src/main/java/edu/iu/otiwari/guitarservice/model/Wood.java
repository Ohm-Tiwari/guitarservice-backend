package edu.iu.otiwari.guitarservice.model;

public enum Wood {
    PINE, BIRCH, MAHOGANY, MAPLE, CEDAR, ADIRONDACK, ALDER;

    public String toString() {
        switch(this) {
            case PINE: return "Pine";
            case BIRCH: return "Birch";
            case MAHOGANY: return "Mahogany";
            case MAPLE: return "Maple";
            case CEDAR: return "Cedar";
            case ADIRONDACK: return "Adirondack";
            case ALDER: return "Alder";
            default: return "Unspecified";
        }
    }
}
