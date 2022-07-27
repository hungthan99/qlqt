package class_GUI;

public class Load {
	public static Main_NhanVien NV_GUI;

	public static void load(String ma) {
		NV_GUI = new Main_NhanVien(ma);
		NV_GUI.setVisible(true);
	}
}

