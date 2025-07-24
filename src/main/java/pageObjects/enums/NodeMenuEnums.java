package pageObjects.enums;

public enum NodeMenuEnums {

    INPUT("Edit"),
    BUTTON("Click"),
    SELECT("Drop-Down"),
    ALERT("Dialog"),
    RADIO("Toggle"),
    WINDOW("Tabs"),
    ELEMENTS("Find Elements"),
    DRAG("AUI - 1"),
    DROP("AUI - 2"),
    SORT("AUI - 3"),
    MULTI_SELECT("AUI - 4"),
    WAITS("Timeout"),
    FORMS("All in One"),
    FILE("File management");

    private final String nodes;

    NodeMenuEnums(String nodes) {
        this.nodes = nodes;
    }

    public String getText() {
        return nodes;
    }
}
