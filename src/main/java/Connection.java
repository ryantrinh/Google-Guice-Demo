import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class Connection {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ConnectionModule());

        JDBCConnect jdbcConnect = injector.getInstance(JDBCConnect.class);

        jdbcConnect.makeConnection();


    }
}

class JDBCConnect {
    private String dbUrl;

    @Inject
    public JDBCConnect(@Named("JDBC") String dbUrl) {
        this.dbUrl = dbUrl;
    }

    void makeConnection(){
        System.out.println(dbUrl);
    }
}

class ConnectionModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("JDBC"))
                .toInstance("jdbc:mysql://localhost:5326/emp");
    }
}
