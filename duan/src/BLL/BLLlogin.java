package BLL;

import DTO.DTONhanVien;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takemikazuchi
 */
public class BLLlogin {

    public static DTO.DTONhanVien nguoidung = new DTONhanVien();

    public static boolean Checklogin(String TaiKhoan, String MatKhau) {
        if (TaiKhoan.trim().length() < 1) {
            //Thông báo
            ThongBaoCanhBao.ThongBao("Tên đăng nhập chưa hợp lệ, vui lòng kiểm tra thông tin và đăng nhập lại", "Thông báo đăng nhập");
            return false;
        }
        if (MatKhau.trim().length() < 1) {
            ThongBaoCanhBao.ThongBao("Mật khẩu chưa hợp lệ, vui lòng kiểm tra thông tin và đăng nhập lại", "Thông báo đăng nhập");
            return false;
        }
        ResultSet rs = DAO.DAONhanVien.DangNhap(TaiKhoan, MatKhau);
        try {
            if (!rs.next()) {
                ThongBaoCanhBao.ThongBao("Tên đăng nhập hoặc mật khẩu không đúng, vui lòng kiểm tra thông tin và đăng nhập lại", "Thông báo");
                return false;
            } else {
                if (!rs.getString("matkhau").equals(MatKhau)) {
                    ThongBaoCanhBao.ThongBao("Mật khẩu không đúng, vui lòng kiểm tra thông tin và đăng nhập lại", "Thông báo");
                    return false;
                } else {

                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi câu lệnh SQL", "Thông báo lỗi");
            return false;
        }

        return true;

    }

}
