package daos;

import models.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaoClass implements DaoInterface<Menu> {

    @Override
    public Menu findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu WHERE id=" + id);

            if (rs.next()) {
                Menu user = new Menu();

                user.setId(rs.getInt("Id"));
                user.setChef(rs.getString("Chef"));
                user.setD_Name(rs.getString("D_Name"));
                user.setD_Ingredient(rs.getString("D_Ingredient"));
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
        user.setD_Ingredient(rs.getString("D_Ingredient"));
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

            List users = new ArrayList();

            while (rs.next()) {
                Menu user = extractUserFromResultSet(rs);
                users.add(user);
            }

            return users;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;
    }
    @Override
    public Menu update(Menu dto) {
        Connection connection = ConnectionFactory.getConnection();
        Menu user = new Menu();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE menu SET Chef=?, D_Name=? D_Ingredient=?, Price=?, Location=? WHERE Id=?");
//            ps.setInt(1, user.getId());
            ps.setString(1, dto.getChef());
            ps.setString(2, dto.getD_Name());
            ps.setString(3, dto.getD_Ingredient());
            ps.setInt(4, dto.getPrice());
            ps.setString(5, dto.getLocation());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();

            if (i == 1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }



    @Override
    public Menu create(Menu dto) {

        Connection connection = ConnectionFactory.getConnection();
        Menu user = new Menu();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, dto.getChef());
            ps.setString(2, dto.getD_Name());
            ps.setString(3, dto.getD_Ingredient());
            ps.setInt(4, dto.getPrice());
            ps.setString(5, dto.getLocation());
            int i = ps.executeUpdate();

            if (i == 1) {
                PreparedStatement ps1 = connection.prepareStatement("Select * From menu where Chef= ? and D_Name = ? and D_Ingredients = ? and Price = ? and Location =?");
                ps1.setString(1, dto.getChef());
                ps1.setString(2, dto.getD_Name());
                ps1.setString(3, dto.getD_Ingredient());
                ps1.setInt(4, dto.getPrice());
                ps1.setString(5, dto.getLocation());
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
//                    Menu user = new Menu();

                    user.setId(rs.getInt("Id"));
                    user.setChef(rs.getString("Chef"));
                    user.setD_Name(rs.getString("D_Name"));
                    user.setD_Ingredient(rs.getString("D_Ingredients"));
                    user.setPrice(rs.getInt("Price"));
                    user.setLocation(rs.getString("Location"));

                    return user;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
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
