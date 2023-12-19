package daos;

import com.sun.jdi.connect.Connector;
import models.Menu;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaoClass implements DaoInterface<Menu> {

    @Override
    public Menu findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if (rs.next()) {
                Menu user = new Menu();

                user.setId(rs.getInt("Id"));
                user.setChef(rs.getString("Chef"));
                user.setD_Name(rs.getString("D_Name"));
                user.setD_Ingredients(rs.getString("D_Ingredients"));
                user.setPrice(rs.getInt("Price"));
                user.setLocation(rs.getString("Location"));

                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private Menu extractUserFromResultSet(ResultSet rs) throws SQLException {
        Menu user = new Menu();

        user.setId(rs.getInt("Id"));
        user.setChef(rs.getString("Chef"));
        user.setD_Name(rs.getString("D_Name"));
        user.setD_Ingredients(rs.getString("D_Ingredients"));
        user.setPrice(rs.getInt("Price"));
        user.setLocation(rs.getString("Location"));

        return user;
    }

    @Override
    public List findAll() {

        Connection connection = ConnectionFactory.getConnection();
//        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu");

            Set users = new HashSet();

            while (rs.next()) {
                Menu user = extractUserFromResultSet(rs);
                users.add(user);
            }

            return (List) users;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;
    }



    @Override
    public T update(Menu dto) {
        Connection connection = ConnectionFactory.getConnection();
        Menu user = new Menu();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE menu SET Chef=?, D_Name=? D_Ingredients=?, Price=?, Location=? WHERE Id=?");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getChef());
            ps.setString(3, user.getD_Name());
            ps.setString(4, user.getD_Ingredients());
            ps.setInt(5, user.getPrice());
            ps.setString(6, user.getLocation());
            int i = ps.executeUpdate();

            if (i == 1) {
                return (T) Convert.ChangeType(value, typeof(T));;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;


    }



    @Override
    public T create(T dto) {

        Connection connection = ConnectionFactory.getConnection();
        Menu user = new Menu();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getChef());
            ps.setString(3, user.getD_Name());
            ps.setString(4, user.getD_Ingredients());
            ps.setInt(5, user.getPrice());
            ps.setString(6, user.getLocation());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(int id) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
