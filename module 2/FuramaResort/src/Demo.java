import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("hello");
        set.add("hello1");

       for (String x : set) {
           set.remove(x);
           System.out.println(x);
       }
        System.out.println(set.size());
    }
}
