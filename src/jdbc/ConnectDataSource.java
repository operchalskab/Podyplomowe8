package jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDataSource {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setURL("operchal");
        ds.setServerName("morfeusz.wszib.edu.pl");
        ds.setPortNumber(1433);
        ds.setDatabaseName("operchal");
        ds.setPassword("Marden099");

        String sql = "select * from Person.Contact"; // tutaj wpisać dane z mojej bazy

        try(Connection con = ds.getConnection(); Statement stmt = con.createStatement()){

            ResultSet rs = stmt.executeQuery(sql);

            String topicBody;
            int id;
            while (rs.next()) {
                if ((topicBody = rs.getString("topicBody")) != null){
                    id = rs.getInt("ID");
                    System.out.println(id + " - " + topicBody);
                }
            }

    } catch (SQLException e){
            System.out.println("Problemy z bazą danych: " + e.getMessage());
        }
        }
}
