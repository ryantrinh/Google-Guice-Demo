package database;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class DatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("JDBC"))
                .toInstance("jdbc:sql://localhost:123/database");
    }
}
