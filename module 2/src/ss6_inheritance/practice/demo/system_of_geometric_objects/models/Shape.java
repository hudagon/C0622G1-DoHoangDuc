package ss6_inheritance.practice.demo.system_of_geometric_objects.models;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String isFilled() {
        if (this.filled) {
            return "filled";
        } else {
            return "not filled";
        }
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "A Shape with color of " + this.color + " and " + isFilled();
    }
}
