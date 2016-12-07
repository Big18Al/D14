
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class videogamesdb {

    public static void main(String[] args) {
        final String QUERY = "select id, title, genre, "
                + "producer from VGTable";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/VideogameTable", "bill", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("title") + ", "
                        + rs.getString("genre") + ", "
                        + rs.getString("producer"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());

        }
    }
}
