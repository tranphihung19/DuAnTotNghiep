/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
/**
 *
 * @author admin
 */
public class DAONhanVien {
    
    public static ResultSet DangNhap(String TaiKhoan, String MatKhau) {

       String sql = "Select * from NhanVien where TaiKhoan='" +TaiKhoan+ "' and MatKhau='" +MatKhau+ "'";
        ResultSet rs = DBConection.executeQuery(sql);
        return rs;
    }
}
