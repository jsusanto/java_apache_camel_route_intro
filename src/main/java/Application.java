import org.apache.camel.main.Main;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        System.out.println("Done running!");
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run();
    }
}
