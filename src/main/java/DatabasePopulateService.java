import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static final String POPULATE_BD_SQL = "sql/populate_db.sql";

    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = Files.readString(Path.of(POPULATE_BD_SQL));
            statement.executeUpdate(sql);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
