package notifier;

public class EmailNotifierService implements NotifierService {

    @Override
    public void notify(String message) {
        System.out.println("EMAIL: " + message);
    }
}
