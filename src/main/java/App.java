import com.google.inject.Guice;
import com.google.inject.Injector;
import database.Database;
import database.DatabaseModule;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DatabaseModule());
        Database database = injector.getInstance(Database.class);

        database.makeConnection();
    }
}
