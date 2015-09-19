package operations;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseSource {

    public static DataSource getMySQLDataSource() {

        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setServerName("localhost");
        mysqlDS.setDatabaseName("pharmacy");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("");
        return mysqlDS;
    }

}
