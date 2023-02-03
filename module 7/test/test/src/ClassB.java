public class ClassB extends ClassA {

    public void saySomething(String message, String message1) {
        System.out.println(message + message1);
    }

    public static void main(String[] args) {

        ClassB B = new ClassB();

        /* Tính kế thừa thể hiện ở việc B kế thừa lại thuộc tính country ở A*/
        System.out.println(B.country);
//        --> VietNam

        /* Tính đa hình thể hiện ở việc ClassB định nghĩa lại phương thức trùng tên ở Class A là
           saySomething nhưng khác về danh sách tham số theo cơ chế override */
        B.saySomething("hello", "world");
//        --> helloworld

    }

}
