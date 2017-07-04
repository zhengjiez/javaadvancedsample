import java.sql.*;

public class SimpleQuery {
   public static void main(String[] args) {
      Connection conn = null;
      try {
         String userName = "zhu";
         String password = "zhu";
         String url = "jdbc:mysql://localhost/test";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url, userName, password);

         // Use Statement object to formulate SQL.
         Statement stmt;

         // Store the data (collection).
         ResultSet rset;

         // Instantiate Statement object.
         stmt = conn.createStatement();

         rset = stmt.executeQuery("select * from films");

         while (rset.next()) {
            // Retrive the data.
            String title = rset.getString("title");
            int year = rset.getInt("year");
            String director = rset.getString("director");

            // Display the data.
            System.out.println("Title: " + title);
            System.out.println("Year: " + year);
            System.out.println("Director: " + director);
         }

         rset.close();
         conn.close();
      }
      catch (Exception e) {
         System.out.print("Error: " + e.toString());
      }
   }
}
