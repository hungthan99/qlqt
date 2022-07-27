package class_Entity;

public class TaiKhoan {
	private NhanVien maNV;
	private String matKhau;
	
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(NhanVien maNV, String matKhau) {
		super();
		this.maNV = maNV;
		this.matKhau = matKhau;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maNV=" + maNV + ", matKhau=" + matKhau + "]";
	}
	
}
