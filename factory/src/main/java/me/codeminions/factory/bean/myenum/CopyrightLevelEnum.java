package me.codeminions.factory.bean.myenum;

public enum CopyrightLevelEnum {
    PRIMARY(3, "初级"),
    SECONDARY(2, "次级"),
    SENIOR(1, "高级");

    private String info;
    int index;

    public static CopyrightLevelEnum getInfo(int index){
        for(CopyrightLevelEnum cr : CopyrightLevelEnum.values()) {
            if (cr.getIndex() == index)
                return cr;
        }
        return null;
    }

    CopyrightLevelEnum(int index, String info) {
        this.info = info;
        this.index = index;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
