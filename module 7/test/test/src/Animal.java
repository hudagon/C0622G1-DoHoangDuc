public final class Animal {

    public void display() {
        System.out.println("this is Animal");
    }



}

class Cat {


    public void display() {
        System.out.println("This is Cat");
    }

    public void meow() {
        System.out.println("meow!");
    }


    public static void main(String[] args) {

        Animal ok = new Animal();

        ok.display();

    }


}

