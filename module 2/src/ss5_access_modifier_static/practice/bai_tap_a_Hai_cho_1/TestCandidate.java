package ss5_access_modifier_static.practice.bai_tap_a_Hai_cho_1;

public class TestCandidate {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("001", "A", "1/1/2000", 9, 4, 6);
        Candidate candidate2 = new Candidate("002", "B", "2/2/2000", 10, 8, 5);
        Candidate candidate3 = new Candidate("003", "C", "3/3/2000", 11, 4.5, 2);
        Candidate candidate4 = new Candidate("004", "D", "4/4/2000", 2,3,6);
        Candidate candidate5 = new Candidate("005", "E", "5/5/2000", 2,1,5);
        Candidate candidate6 = new Candidate("006", "F", "6/6/2000", 2,10,6);


        System.out.println(Candidate.display());
    }
}
