package database;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DatabaseProviderImpl implements DatabaseProvider{

    @Inject @Named("JDBC")
    private String dbUrl;

    @Override
    public void dbConnect() {
        System.out.println(dbUrl);
    }
}
