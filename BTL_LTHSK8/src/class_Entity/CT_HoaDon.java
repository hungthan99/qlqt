package class_Entity;

public class CT_HoaDon {
	private HoaDon maHoaDon;
	private Thuoc maThuoc;
	private int soLuong;
	private double thanhTien;
	
	public CT_HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CT_HoaDon(Thuoc maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public CT_HoaDon(HoaDon maHoaDon, Thuoc maThuoc, int soLuong, double thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Thuoc getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		CT_HoaDon other = (CT_HoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CT_HoaDon [maHoaDon=" + maHoaDon + ", maThuoc=" + maThuoc.getMaThuoc() + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
}
