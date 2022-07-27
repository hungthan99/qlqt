package class_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.NhanVien;
import class_Entity.TaiKhoan;

public class TaiKhoan_DAO {
	private ArrayList<TaiKhoan> tk_dao;
	public TaiKhoan_DAO() {
		tk_dao = new ArrayList<TaiKhoan>();
	}
	public ArrayList<TaiKhoan> taiDuLieuTuDB(){
		try {
			Connect_DB.connect();
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from TaiKhoan";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getString(1));
				String mk = rs.getString(2);
				TaiKhoan tk = new TaiKhoan(nv, mk);
				tk_dao.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk_dao;
	}
	public boolean themTaiKhoan(TaiKhoan tk) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into TaiKhoan values (?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tk.getMaNV().getMaNV());
			stmt.setString(2, tk.getMatKhau());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaTaiKhoan(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from TaiKhoan where maNV = ?";
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
	public boolean suaTaiKhoan(TaiKhoan tk) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "update TaiKhoan set matKhau = ? where maNV = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tk.getMatKhau());
			stmt.setString(2, tk.getMaNV().getMaNV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public TaiKhoan getTaiKhoan(String ma) {
		for(TaiKhoan tk : tk_dao)
			if(tk.getMaNV().getMaNV().trim().equals(ma.trim()))
				return tk;
		return null;
	}
}
