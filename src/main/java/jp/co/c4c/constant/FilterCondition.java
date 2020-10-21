package jp.co.c4c.constant;

public enum FilterCondition {

    SHIKAKU("1"),
    NYUMONSYO("2"),
    WEBKAIHATSU("3"),
    JIKOKEIHATSU("4"),
    GORAKU("5");

    private final String filterCond;

    FilterCondition(String filterCond) {
        this.filterCond = filterCond;
    }

    public String getFilterCond() {
        return filterCond;
    }
}
