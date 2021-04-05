package database;

import com.google.inject.Inject;

public class Database {
    private DatabaseProvider databaseProvider;

    @Inject
    public Database(DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }
    public void makeConnection(){
        databaseProvider.dbConnect();
    }
}
