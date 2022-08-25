package models.creatures;
public class Person {
    private String name;
    private String birthday;
    private String gender;
    private int citizenIdentityNumber;
    private int phoneNumber;
    private String emailAddress;

    public Person() {}

    public Person(String name, String birthday, String gender, int citizenIdentityNumber, int phoneNumber, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.citizenIdentityNumber = citizenIdentityNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCitizenIdentityNumber() {
        return citizenIdentityNumber;
    }

    public void setCitizenIdentityNumber(int citizenIdentityNumber) {
        this.citizenIdentityNumber = citizenIdentityNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", IdNumber=" + citizenIdentityNumber +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
