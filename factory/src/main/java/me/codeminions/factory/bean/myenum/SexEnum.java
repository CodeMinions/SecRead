package me.codeminions.factory.bean.myenum;

public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    private int id;
    private String sex;

    public static SexEnum getSex(int id){
        for(SexEnum sex : SexEnum.values()){
            if (sex.getId() == id)
                return sex;
        }
        return null;
    }

    SexEnum(int id, String sex){
        this.id = id;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
