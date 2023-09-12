package br.com.kennedy.domain.entities;

public enum TypeOperation {
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL");
    private final String    value;
    TypeOperation(String value) {
        this.value = value;
    }

    public static TypeOperation fromValue(String value) {
        for (TypeOperation type : TypeOperation.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + TypeOperation.class.getName() + "." + value);
    }
    public String getValue() {
        return value;
    }
}