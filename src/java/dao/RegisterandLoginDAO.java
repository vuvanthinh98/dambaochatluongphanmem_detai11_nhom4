/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.InterestRateDTO;
import model.PassWordEncoder;

/**
 *
 * @author NguyenDinhTien
 */
public class RegisterandLoginDAO extends ConnecJDBC {
    public static Account getAccount(String userName){
        Account account = new Account();
        String sql = "select * from account where UserName = '"+userName+"'";
        Connection conn = ConnecJDBC.getConn();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                account.setID(resultSet.getInt(1));
                account.setUserName(resultSet.getString(2));
                account.setPassWord(resultSet.getString(3));
                account.setFullName(resultSet.getString(4));
                account.setDateOfBirth(resultSet.getString(5));
                account.setAddress(resultSet.getString(6));
                account.setIDcard(resultSet.getString(7));
                account.setRole(resultSet.getString(8));
                account.setStatus(resultSet.getString(9));
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(WithdrawBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
//    public static void Register() throws NoSuchAlgorithmException {
//        Connection conn = ConnecJDBC.getConn();
//        List<InterestRateDTO> lists = new ArrayList<>();
//        String sql = "insert into account(UserName,PassWord,FullName,DateOfBirth,Address,IDcard,Role,Status) values(?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement prestm = conn.prepareStatement(sql);
//            prestm.setString(1, "admin");
//            prestm.setString(2, PassWordEncoder.encoder("admin"));
//            prestm.setString(4, "25/03/1997");
//            prestm.setString(3, "NguyenDinhTien");
//            prestm.setString(5, "HaNoi");
//            prestm.setString(6, "123456789");
//            prestm.setString(7, "Staff");
//            prestm.setString(8, "Active");
//            prestm.executeUpdate();
//            conn.close();
//            prestm.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
