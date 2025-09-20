import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class data {
    public static void main(String args[])
    {
        String url="jdbc:mysql://localhost:3306/phone_database";
        String uname="root";
        String pass="yashgupta1301";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con=DriverManager.getConnection(url,uname,pass);
            Statement st=con.createStatement();
            Statement st2=con.createStatement();
            ResultSet rs=st.executeQuery("select * from phones");

            while (rs.next()) {
                int id=rs.getInt(1);
                String brand=rs.getString(3);
                String price=rs.getString(2);
                System.out.println(id+"  "+brand+"   "+price);
            }

            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
