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
public class CategoryDAO extends DAO {
    public ArrayList<Category> list() {
    ArrayList<Category> categorys = new ArrayList<>();
        try {
            xSql = "SELECT * from Category";
            ps = connection.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCid(rs.getInt("category_id"));
                category.setCname(rs.getString("category_name")) ;
                categorys.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }
}
