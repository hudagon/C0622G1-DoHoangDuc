public class Dog extends Animal implements ITalkable {

    private String specificFeature = "Can smell really good!";

    @Override
    public String talk() {
        return "hello world, i am scoopy doo";
    }
}
