package notifier;

public class ConsoleNotifierService implements NotifierService {

    @Override
    public void notify(String message) {
        System.out.println("CONSOLE: " + message);
    }
}
