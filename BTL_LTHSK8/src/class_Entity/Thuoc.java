package class_Entity;

import java.sql.Date;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private String donVi;
	private String loaiThuoc;
	private double donGia;
	private Date ngaySX;
	private Date ngayHH;
	private int soLuong;
	private String ghiChu;
	private NhaSanXuat nsx;
	
	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Thuoc(String maThuoc) {
		super();
		this.maThuoc = maThuoc;
	}
	
	public Thuoc(String maThuoc, String tenThuoc) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
	}
	public Thuoc(String maThuoc, String tenThuoc, double donGia, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	public Thuoc(String maThuoc, String tenThuoc, String donVi, String loaiThuoc, double donGia, Date ngaySX,
			Date ngayHH, int soLuong, String ghiChu, NhaSanXuat nsx) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donVi = donVi;
		this.loaiThuoc = loaiThuoc;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.nsx = nsx;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getLoaiThuoc() {
		return loaiThuoc;
	}
	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Date getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(Date ngaySX) {
		this.ngaySX = ngaySX;
	}
	public Date getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(Date ngayHH) {
		this.ngayHH = ngayHH;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public NhaSanXuat getNsx() {
		return nsx;
	}
	public void setNsx(NhaSanXuat nsx) {
		this.nsx = nsx;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equals(other.maThuoc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", donVi=" + donVi + ", loaiThuoc=" + loaiThuoc
				+ ", donGia=" + donGia + ", ngaySX=" + ngaySX + ", ngayHH=" + ngayHH + ", soLuong=" + soLuong
				+ ", ghiChu=" + ghiChu + ", nsx=" + nsx + "]";
	}
	
}
