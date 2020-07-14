import java.util.List;

public class Example {


    int a = 10;

    public static void main(String[] args) {

        home h = new home();
        String name = "";
        Boolean b;

        b = ishome(h, name);
    }


    private static Boolean ishome(home h, String name) {

        System.out.println(h);
        System.out.println(name);

        if(h.getName() == name) {
            return true;
        }

        return false;
    }


}
