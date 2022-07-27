package class_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.NhaSanXuat;
import class_Entity.NhanVien;

public class NhanVien_DAO {
	private ArrayList<NhanVien> nv_dao;
	public NhanVien_DAO() {
		nv_dao = new ArrayList<NhanVien>();
	}
	public ArrayList<NhanVien> taiDuLieuTuDB() {
		try {
			Connect_DB.connect();
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				String sdt = rs.getString(4);
				int tuoi = rs.getInt(5);
				String loai = rs.getString(6);
				String dc = rs.getString(7);
				NhanVien nv = new NhanVien(ma, ten, gt, sdt, tuoi, loai, dc);
				nv_dao.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv_dao;
	}
	public boolean themNhanVien(NhanVien nv) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into NhanVien values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setString(4, nv.getSdt());
			stmt.setInt(5, nv.getTuoi());
			stmt.setString(6,nv.getLoaiNV());
			stmt.setString(7, nv.getDiaChi());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaNhanVien(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from NhanVien where maNV = ?";
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
	public boolean suaNhanVien(NhanVien nv) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "update NhanVien set tenNV = ?, gioiTinh = ?, sdt = ?, tuoi = ?, loaiNV = ?, diaChi = ? where maNV = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getGioiTinh());
			stmt.setString(3, nv.getSdt());
			stmt.setInt(4, nv.getTuoi());
			stmt.setString(5, "NV");
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public NhanVien getNhanVien(String ma) {
		for(NhanVien t : nv_dao)
			if(t.getMaNV().trim().equals(ma.trim()))
				return t;
		return null;
	}
}
