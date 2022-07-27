package class_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import class_Connection.Connect_DB;
import class_Entity.NhaSanXuat;
import class_Entity.Thuoc;

public class Thuoc_DAO {
	ArrayList<Thuoc> dsThuoc;
	public Thuoc_DAO() {
		dsThuoc = new ArrayList<Thuoc>();
	}
	public ArrayList<Thuoc> layTTThuoc() {
		try {
			//Connect_DB.connect();
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from Thuoc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String dv = rs.getString(3);
				String lt = rs.getString(4);
				double dg = rs.getDouble(5);
				Date ngaySX = rs.getDate(6);
				Date ngayHH = rs.getDate(7);
				NhaSanXuat nsx = new NhaSanXuat(rs.getString(8));
				int soLuong = rs.getInt(9);
				String ghiChu = rs.getString(10);
				Thuoc t = new Thuoc(ma, ten, dv, lt, dg, ngaySX, ngayHH, soLuong, ghiChu, nsx);
				dsThuoc.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}
	public boolean themThuoc(Thuoc t) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into Thuoc values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getDonVi());
			stmt.setString(4, t.getLoaiThuoc());
			stmt.setDouble(5, t.getDonGia());
			stmt.setDate(6, t.getNgaySX());
			stmt.setDate(7, t.getNgayHH());
			stmt.setString(8, t.getNsx().getMaNSX());
			stmt.setInt(9, t.getSoLuong());
			stmt.setString(10, t.getGhiChu());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaThuoc(String maThuoc) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from Thuoc where maThuoc = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maThuoc);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaTTThuoc(Thuoc t) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "update Thuoc set tenThuoc = ?, donVi = ?, loaiThuoc = ?, donGia = ?, ngaySX = ?, ngayHH = ?, maNSX = ?, soLuong = ?, ghiChu = ? where maThuoc = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTenThuoc());
			stmt.setString(2, t.getDonVi());
			stmt.setString(3, t.getLoaiThuoc());
			stmt.setDouble(4, t.getDonGia());
			stmt.setDate(5, t.getNgaySX());
			stmt.setDate(6, t.getNgayHH());
			stmt.setString(7, t.getNsx().getMaNSX());
			stmt.setInt(8, t.getSoLuong());
			stmt.setString(9, t.getGhiChu());
			stmt.setString(10, t.getMaThuoc());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public Thuoc getThuoc(String maThuoc) {
		for(int i =0;i<dsThuoc.size();i++) {
			if(dsThuoc.get(i).getMaThuoc().trim().equals(maThuoc))
				return dsThuoc.get(i);
		}
		return null;
	}
	public void themThuocVaoHoaDon(Thuoc t) {
		if(dsThuoc.contains(t)) {
			for(int i = 0 ; i < dsThuoc.size() ; i++) {
				if(dsThuoc.get(i).getMaThuoc().trim().equals(t.getMaThuoc().trim())) {
					int sl = dsThuoc.get(i).getSoLuong();
					dsThuoc.get(i).setSoLuong(sl+t.getSoLuong());
				}	
			}
		}else {
			dsThuoc.add(t);
		}
	}
	public void ghiNhoThuocDaThem(Thuoc t) {
		if(dsThuoc.contains(t)) {
			for(int i = 0 ; i < dsThuoc.size() ; i++) {
				if(dsThuoc.get(i).getMaThuoc().trim().equals(t.getMaThuoc().trim())) {
					int sl = dsThuoc.get(i).getSoLuong();
					dsThuoc.get(i).setSoLuong(t.getSoLuong());
				}	
			}
		}else {
			dsThuoc.add(t);
		}
	}
	public int getSize() {
		return dsThuoc.size();
	}
	public Thuoc getElement(int i) {
		return dsThuoc.get(i);
	}
	public double getDonGiaTuMa(String maThuoc) {
		for(Thuoc t : dsThuoc) {
			if(t.getMaThuoc().trim().equals(maThuoc))
				return t.getDonGia();
		}
		return 0;
	}
}
