package database;

import com.google.inject.ImplementedBy;

@ImplementedBy(DatabaseProviderImpl.class)
public interface DatabaseProvider {

    void dbConnect();
}
