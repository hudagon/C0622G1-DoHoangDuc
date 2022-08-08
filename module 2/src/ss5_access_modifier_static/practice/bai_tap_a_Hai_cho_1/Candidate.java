package ss5_access_modifier_static.practice.bai_tap_a_Hai_cho_1;

public class Candidate {
    private String code, name, birthday;
    private double score1, score2, score3;
    static String show = "";


    public Candidate(String code, String name, String birthday, double score1, double score2, double score3) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;

        if (score1 + score2 + score3 >= 15) {
            show += "Candidate{" +
                    "Mã số='" + code + '\'' +
                    ", Tên='" + name + '\'' +
                    ", Năm sinh='" + birthday + '\''+
                    "Điểm Toán=" + score1 +
                    ", Điểm Văn=" + score2 +
                    ", Điểm Anh=" + score3 +
                    '}' + "\n";
        }
    }

    static String display() {
        return show;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
//
//    public double getScore1() {
//        return score1;
//    }
//
//    public void setScore1(int score1) {
//        this.score1 = score1;
//    }
//
//    public double getScore2() {
//        return score2;
//    }
//
//    public void setScore2(int score2) {
//        this.score2 = score2;
//    }
//
//    public double getScore3() {
//        return score3;
//    }
//
//    public void setScore3(int score3) {
//        this.score3 = score3;
//    }
}
