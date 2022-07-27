package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.CT_HoaDon;
import class_Entity.HoaDon;
import class_Entity.Thuoc;

public class CT_HoaDon_DAO {
	private ArrayList<CT_HoaDon> ct_hd_dao;
	public CT_HoaDon_DAO() {
		ct_hd_dao = new ArrayList<CT_HoaDon>();
	}
	public ArrayList<CT_HoaDon> layDuLieuTuDB(){
		try {
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from CT_HoaDon";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				HoaDon maHoaDon = new HoaDon(rs.getString(1));
				Thuoc maThuoc = new Thuoc(rs.getString(2));
				int sl = rs.getInt(3);
				double thanhTien = rs.getDouble(4);
				CT_HoaDon ct = new CT_HoaDon(maHoaDon, maThuoc, sl, thanhTien);
				ct_hd_dao.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct_hd_dao;
	}
	public boolean themChiTietHoaDon(CT_HoaDon cthd) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into CT_HoaDon values (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cthd.getMaHoaDon().getMaHD());
			stmt.setString(2, cthd.getMaThuoc().getMaThuoc());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getThanhTien());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaChiTietHoaDon(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from CT_HoaDon where maHD = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	/*public Double layTongTienTheoThang(LocalDate date) {
		double result = 0;
		for (CT_HoaDon chiTietHoaDon : ct_hd_dao) {	
			LocalDate ngayLap = chiTietHoaDon.get.toLocalDate();
			if(date.getYear()==ngayLap.getYear()&& date.getMonthValue()==ngayLap.getMonthValue()) {
				result += (chiTietHoaDon.getDonGia()*chiTietHoaDon.getSoLuong());
			}
		}
		return result;
	}*/
	/*public Double layTongTienTheoThang(int nam) {
		double tongTien = 0;
		for(CT_HoaDon ct : ct_hd_dao) {
			if(ct)
		}
	}*/
}
