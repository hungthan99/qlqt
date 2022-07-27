package class_DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.BenhNhan;

public class BenhNhan_DAO {
	private ArrayList<BenhNhan> bn_dao;
	public BenhNhan_DAO() {
		bn_dao = new ArrayList<BenhNhan>();
	}
	public ArrayList<BenhNhan> taiDSBenhNHan(){
		try {
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "select * from BenhNhan";
			Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(sql);
			while(r.next()) {
				String ma = r.getString(1);
				String ten = r.getString(2);
				String gt = r.getString(3);
				String sdt = r.getString(4);
				String diachi = r.getString(5);
				String ghichu = r.getString(6);
				int tuoi = r.getInt(7);
				BenhNhan bn = new BenhNhan(ma, ten, gt, sdt, diachi, tuoi, ghichu);
				bn_dao.add(bn);
			}
		}catch (Exception e) {
			
		}
		return bn_dao;
	}
	public boolean themBenhNhan(BenhNhan bn) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into BenhNhan values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bn.getMaBenhNhan());
			stmt.setString(2, bn.getTenBenhNhan());
			stmt.setString(3, bn.getGioiTinh());
			stmt.setString(4, bn.getSdt());
			stmt.setString(5, bn.getDiaChi());
			stmt.setString(6, bn.getGhiChu());
			stmt.setInt(7, bn.getTuoi());
			n = stmt.executeUpdate();
		} catch (Exception e) {
		}
		return n > 0;
	}
	public boolean xoaBenhNhan(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from BenhNhan where maBN = ?";
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
	public boolean suaBenhNhan(BenhNhan bn) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "update BenhNhan set tenBN = ?, gioiTinh = ?, sdt = ?, diaChi = ?, ghiChu = ?, tuoi = ? where maBN = ?";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bn.getTenBenhNhan());
			stmt.setString(2, bn.getGioiTinh());
			stmt.setString(3, bn.getSdt());
			stmt.setString(4, bn.getDiaChi());
			stmt.setString(5, bn.getGhiChu());
			stmt.setInt(6, bn.getTuoi());
			stmt.setString(7, bn.getMaBenhNhan());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public BenhNhan timBenhNhan(String ma) {
		for(int i =0;i<bn_dao.size();i++)
			if(bn_dao.get(i).getMaBenhNhan().equals(ma))
				return bn_dao.get(i);
		return null;
	}
}
