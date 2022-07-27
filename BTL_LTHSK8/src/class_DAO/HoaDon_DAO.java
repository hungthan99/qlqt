package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import class_Connection.Connect_DB;
import class_Entity.BenhNhan;
import class_Entity.HoaDon;
import class_Entity.NhanVien;

public class HoaDon_DAO {
	private ArrayList<HoaDon> hd_dao;
	public HoaDon_DAO() {
		hd_dao = new ArrayList<HoaDon>();
	}
	public ArrayList<HoaDon> layDuLieuTuDB(){
		try {
			
			Connection con = Connect_DB.getInstance().getConnection();
			String sql = "Select * from HoaDon";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				Date ngay = rs.getDate(2);
				String ghichu = rs.getString(3);
				NhanVien maNV = new NhanVien(rs.getString(4));
				double thanhtien = rs.getDouble(5);
				BenhNhan maBN = new BenhNhan(rs.getString(6));
				HoaDon hd = new HoaDon(ma, maNV, maBN, ngay, thanhtien, ghichu);
				hd_dao.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hd_dao;
	}
	public boolean themHoaDon(HoaDon hd) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "insert into HoaDon values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHD());
			stmt.setDate(2, hd.getNgayLap());
			stmt.setString(3, hd.getGhiChu());
			stmt.setString(4, hd.getMaNhanVien().getMaNV());
			stmt.setDouble(5, hd.getThanhTien());
			stmt.setString(6, hd.getMaBenhNhan().getMaBenhNhan());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaHoaDon(String ma) {
		Connection con = Connect_DB.getInstance().getConnection();
		String sql = "delete from HoaDon where maHD = ?";
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
	public double layDoanhThuThang(LocalDate date) {
		double tongTien = 0;
		for(HoaDon hd : hd_dao) {
			LocalDate ngayLap = hd.getNgayLap().toLocalDate();
			if(date.getYear()==ngayLap.getYear() && date.getMonthValue() == ngayLap.getMonthValue()) {
				tongTien+=hd.getThanhTien();
			}
		}
		return tongTien;
	}
	public double layDoanhThuNgay(LocalDate date) {
		double tongTien = 0;
		for (HoaDon hd : hd_dao) {
			LocalDate ngayLap = hd.getNgayLap().toLocalDate();
			if(date.compareTo(ngayLap) == 0) {
				tongTien+=hd.getThanhTien();
			}
		}
		return tongTien;
	}
	public double layDoanhThuNam(LocalDate date) {
		double tongTien = 0;
		for(HoaDon hd : hd_dao) {
			LocalDate ngayLap = hd.getNgayLap().toLocalDate();
			if(date.getYear()==ngayLap.getYear()) {
				tongTien+=hd.getThanhTien();
			}
		}
		return tongTien;
	}
	public HoaDon getHoaDon(String ma) {
		for(HoaDon hd : hd_dao) {
			if(hd.getMaHD().trim().equals(ma.trim()))
				return hd;
		}
		return null;
	}
}	
