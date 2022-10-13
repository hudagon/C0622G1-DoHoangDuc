package model.model;

public class Member {
    private int id;
    private String idCard;
    private String name;
    private String birthday;
    private int idFamily;

    public Member() {
    }

    public Member(int id, String idCard, String name, String birthday, int idFamily) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.birthday = birthday;
        this.idFamily = idFamily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idFamily=" + idFamily +
                '}';
    }
}
