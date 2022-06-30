/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author Tuan Phong
 */
public class CategoryDAO extends MyDAO {

    /**
     * Do Tuan Phong: lay het cac category tu database
     *
     * @return ArrayList<Category>
     */
    public ArrayList<Category> listAllCategory() {
        ArrayList<Category> categorys = new ArrayList<>();
        try {
            xSql = "SELECT * from Category";
            ps = connection.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCid(rs.getInt("category_id"));
                category.setCname(rs.getString("category_name"));
                categorys.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }

    /**
     * Do Tuan Phong insert a category to database
     *
     * @param category
     */
    public void insert(Category category) {
        try {
            xSql = "INSERT INTO [category]\n"
                    + "           ([category_name])\n"
                    + "     VALUES\n"
                    + "           (?)";
            ps = connection.prepareStatement(xSql);
            ps.setString(1, category.getCname());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        /**
     * Do Tuan Phong update a category to database
     *
     * @param category
     */

    public void update(Category category) {

        try {
            xSql = "UPDATE [category]\n"
                    + "   SET [category_name] = ?\n"
                    + " WHERE [category_id]= ?";
            ps = connection.prepareStatement(xSql);
            ps.setString(1, category.getCname());
            ps.setInt(2, category.getCid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Do Tuan Phong delete a category to database
     *
     * @param categoryId
     */
    public void delete(int categoryId) {
        try {
            xSql = "DELETE FROM [category]\n"
                    + "WHERE category_id = ?";
            ps = connection.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
