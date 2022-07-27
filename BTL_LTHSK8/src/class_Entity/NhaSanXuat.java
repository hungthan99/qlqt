package class_Entity;

public class NhaSanXuat {
	private String maNSX;
	private String tenNSX;
	private String sdt;
	private String diaChi;
	public NhaSanXuat() {
		
	}
	public NhaSanXuat(String maNSX) {
		this.maNSX = maNSX;
	}
	public NhaSanXuat(String maNSX, String tenNSX, String sdt, String diaChi) {
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public String getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNSX == null) ? 0 : maNSX.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NhaSanXuat))
			return false;
		NhaSanXuat other = (NhaSanXuat) obj;
		if (maNSX == null) {
			if (other.maNSX != null)
				return false;
		} else if (!maNSX.equals(other.maNSX))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhaSanXuat [maNSX=" + maNSX + ", tenNSX=" + tenNSX + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}
}
