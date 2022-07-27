package class_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.BenhNhan;
import class_Entity.NhaSanXuat;

public class NhaSanXuat_DAO {
	ArrayList<NhaSanXuat> dsNSX;
	public NhaSanXuat_DAO() {
		dsNSX = new ArrayList<NhaSanXuat>();
	}
	public ArrayList<NhaSanXuat> layTTNhaSanXuat() {
		try {
			//Connect_DB.connect();
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from NhaSanXuat";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				NhaSanXuat nsx = new NhaSanXuat(ma, ten, sdt, diaChi);
				dsNSX.add(nsx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNSX;
	}
	public boolean themNhaSanXuat(NhaSanXuat nsx) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into NhaSanXuat values (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nsx.getMaNSX());
			stmt.setString(2, nsx.getTenNSX());
			stmt.setString(3, nsx.getSdt());
			stmt.setString(4, nsx.getDiaChi());
			n = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return n > 0;
	}
	public boolean xoaNhaSanXuat(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from NhaSanXuat where maNSX = ?";
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
	public boolean suaNhaSanXuat(NhaSanXuat nsx) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "update NhaSanXuat set tenNSX = ?, sdt = ?, diaChi = ? where maNSX = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nsx.getTenNSX());
			stmt.setString(2, nsx.getSdt());
			stmt.setString(3, nsx.getDiaChi());
			stmt.setString(4, nsx.getMaNSX());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public NhaSanXuat getNhaSanXuat(String ma) {
		for(int i = 0; i<dsNSX.size();i++)
			if(dsNSX.get(i).getMaNSX().equals(ma))
				return dsNSX.get(i);
		return null;
	}
}
