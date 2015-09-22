package org.crudpeople.external;

public enum ResultStatus {
    SUCCESS("success"),
    FAIL("fail"),
    WARNING("warning");

    private String style;

    private ResultStatus(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
