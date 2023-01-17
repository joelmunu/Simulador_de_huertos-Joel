import com.simuladorhuerto.resources.Huerto;
import com.simuladorhuerto.threads.Consumidor;
import com.simuladorhuerto.threads.Granjero;

public class Main {
    public static void main(String[] args) {

        Huerto huerto = new Huerto(5);
        Granjero granjero1 = new Granjero("Lucas", 5, 10,huerto);
        Consumidor consumidor1 = new Consumidor("Pedro", 5, 5, huerto);

        granjero1.start();
        consumidor1.start();
    }
}