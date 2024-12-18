package enums;

public enum Tabs {

    ALL("All"),
    IMAGES("Images"),
    NEWS("News"),
    VIDEOS("Videos"),
    SHOPPING("Shopping"),
    WEB("Web"),
    MAPS("Maps"),
    MORE("More"),
    BOOKS("Books");

    private final String tab;

    Tabs(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }

}
