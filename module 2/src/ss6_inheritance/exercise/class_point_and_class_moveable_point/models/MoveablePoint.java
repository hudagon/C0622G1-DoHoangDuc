package ss6_inheritance.exercise.class_point_and_class_moveable_point.models;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {}

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{getXSpeed(),getYSpeed()};
    }

    public MoveablePoint move() {
        super.setX(this.getX() + getXSpeed());
        super.setY(this.getY() + getYSpeed());
        return this;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + ")" + "," + " speed" + " = " +
                "(" + getXSpeed() + ", " + getYSpeed() + ")";
    }
}
