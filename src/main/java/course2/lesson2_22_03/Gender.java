package course2.lesson2_22_03;

public enum Gender {
    MALE("M", 100),
    FEMALE("Ж", 60),
    OTHER("O", 80);

    private String shortName;
    private Integer weight;

    Gender(String shortName, Integer weight) {
        this.shortName = shortName;
        this.weight = weight;
    }

    public String getShortName() {
        return shortName;
    }

    public Integer getWeight() {
        return weight;
    }

    public Gender byShortName(String shortName) {
        for (Gender value : values()) {
            if (shortName.equals(value.getShortName())) {
                return value;
            }

        }return OTHER;
    }
}
