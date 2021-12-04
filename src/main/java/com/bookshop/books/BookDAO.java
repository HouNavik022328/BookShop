/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.books;

import com.bookshop.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VODUCMINH
 */
public class BookDAO {
    public List<BookDTO> getAllBook() throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblbook ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    list.add(new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public List<BookDTO> getAllBookTop3() throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblbook "
                            + " LIMIT 3";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    list.add(new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public BookDTO getProduct(String ID) throws SQLException {
        BookDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblbook "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");

                    product = new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity);
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return product;
    }
    
    public List<Category> getCategory() throws SQLException {
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblcategory ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    int ID = Integer.parseInt(rs.getString("ID"));
                    String name = rs.getString("name");
                    
                    
                    list.add(new Category(ID, name));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    
    public List<Type> getType() throws SQLException {
        List<Type> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tbltype ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    int ID = Integer.parseInt(rs.getString("typeID"));
                    String name = rs.getString("name");
                    
                    
                    list.add(new Type(ID, name));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public List<Type> getType3() throws SQLException {
        List<Type> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tbltype "
                            + " LIMIT 3";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    int ID = Integer.parseInt(rs.getString("typeID"));
                    String name = rs.getString("name");
                    
                    
                    list.add(new Type(ID, name));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public List<BookDTO> getBookWithCate(int categoryID) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblbook "
                            + " WHERE categoryID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    list.add(new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public List<BookDTO> getBookWithType(int typeID) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM tblbook "
                            + " WHERE typeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, typeID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    list.add(new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public BookDTO getProductForCart(String ID) throws SQLException {
        BookDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM tblbook "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    product = new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity);
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return product;
    }
    
    public boolean minusProduct(String productID, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "UPDATE tblbook"
                            + " SET quantity = ? "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, getProductQuantity(productID) - quantity);
                stm.setString(2, productID);
                check = stm.executeUpdate() > 0;
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return check;
    }
    
    public int getProductQuantity(String productID) throws SQLException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT quantity"
                            + " FROM tblbook "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    quantity = Integer.parseInt(rs.getString("quantity"));
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return quantity;
    }
    
    public List<BookAdmin> getAllProduct() throws SQLException {
        List<BookAdmin> list = new ArrayList<>();
        BookDAO dao = new BookDAO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM tblbook";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    int price = Integer.parseInt(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String categoryID = dao.convertCategoryName(Integer.parseInt(rs.getString("categoryID")));
                    String typeID = dao.convertTypeName(Integer.parseInt(rs.getString("typeID")));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    
                    list.add(new BookAdmin(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public String convertCategoryName(int categoryID) throws SQLException {
        String categoryName = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT name"
                            + " FROM tblcategory "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    categoryName = rs.getString("name");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return categoryName;
    }
    
    public String convertTypeName(int typeID) throws SQLException {
        String typeName = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT name"
                            + " FROM tbltype "
                            + " WHERE typeID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, typeID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    typeName = rs.getString("name");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return typeName;
    }
    
    public boolean insertProduct(BookDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                
                String sql = "INSERT INTO tblbook(ID, name, image, price, quantity, description, typeID, categoryID, createDate, author) "
                            + "VALUES(?,?,?,?,?,?,?,?,?, ?)";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getID());
                stm.setString(2, product.getName());
                stm.setString(3, product.getImage());
                stm.setDouble(4, product.getPrice());
                stm.setInt(5, product.getQuantity());
                stm.setString(6, product.getDescription());
                stm.setInt(7, product.getTypeID());
                stm.setInt(8, product.getCategoryID());
                stm.setString(9, product.getCreateDate());
                stm.setString(10, product.getAuthor());
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateProduct(BookDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblbook "
                            + " SET categoryID=?, name=?, price=?, description=?, image=?, quantity=?, typeID=?, author=? "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                
                stm.setInt(1, product.getCategoryID());
                stm.setString(2, product.getName());
                stm.setDouble(3, product.getPrice());
                stm.setString(4, product.getDescription());
                stm.setString(5, product.getImage());
                stm.setInt(6, product.getQuantity());
                stm.setInt(7, product.getTypeID());
                stm.setString(8, product.getAuthor());
                stm.setString(9, product.getID());
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return check;
    }
    
    public boolean deleteProduct(String productId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "DELETE FROM tblbook WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productId);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return check;
    }
    
}
