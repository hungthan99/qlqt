package class_Entity;

import java.sql.Date;

public class HoaDon {
	private String maHD;
	private NhanVien maNhanVien;
	private BenhNhan maBenhNhan;
	private Date ngayLap;
	private double thanhTien;
	private String ghiChu;
	
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, NhanVien maNhanVien, BenhNhan maBenhNhan, Date ngayLap, double thanhTien,
			String ghiChu) {
		super();
		this.maHD = maHD;
		this.maNhanVien = maNhanVien;
		this.maBenhNhan = maBenhNhan;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
		this.ghiChu = ghiChu;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public BenhNhan getMaBenhNhan() {
		return maBenhNhan;
	}
	public void setMaBenhNhan(BenhNhan maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNhanVien=" + maNhanVien + ", maBenhNhan=" + maBenhNhan + ", ngayLap="
				+ ngayLap + ", thanhTien=" + thanhTien + ", ghiChu=" + ghiChu + "]";
	}
	
	
}
