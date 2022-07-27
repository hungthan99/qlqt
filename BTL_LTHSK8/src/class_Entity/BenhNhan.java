package class_Entity;

public class BenhNhan {
	private String maBenhNhan,tenBenhNhan,gioiTinh,sdt,diaChi;
	private int tuoi;
	private String ghiChu;
	
	public BenhNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenhNhan(String maBenhNhan) {
		super();
		this.maBenhNhan = maBenhNhan;
	}
	public BenhNhan(String maBenhNhan, String tenBenhNhan, String gioiTinh, String sdt, String diaChi, int tuoi,
			String ghiChu) {
		super();
		this.maBenhNhan = maBenhNhan;
		this.tenBenhNhan = tenBenhNhan;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
		this.ghiChu = ghiChu;
	}
	public String getMaBenhNhan() {
		return maBenhNhan;
	}
	public void setMaBenhNhan(String maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}
	public String getTenBenhNhan() {
		return tenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maBenhNhan == null) ? 0 : maBenhNhan.hashCode());
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
		BenhNhan other = (BenhNhan) obj;
		if (maBenhNhan == null) {
			if (other.maBenhNhan != null)
				return false;
		} else if (!maBenhNhan.equals(other.maBenhNhan))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BenhNhan [maBenhNhan=" + maBenhNhan + ", tenBenhNhan=" + tenBenhNhan + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", diaChi=" + diaChi + ", tuoi=" + tuoi + ", ghiChu=" + ghiChu + "]";
	}
	
	
}
