package classwork.chapter12;

public enum Language {
    HY("հայերեն"),
    RU("ռուսերեն"),
    ENG("անգլերեն");

    private String languageName;

    Language(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageName() {
        return languageName;
    }
}
