package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_DAO.HoaDon_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.NhanVien_DAO;
import class_DAO.TaiKhoan_DAO;
import class_Entity.BenhNhan;
import class_Entity.HoaDon;
import class_Entity.NhaSanXuat;
import class_Entity.NhanVien;

public class DanhSachNhanVien_GUI extends JFrame implements ActionListener,MouseListener{
	private JLabel lblnam,lblnu;
	private Box b,bTK,bDS,bTacVu,bMaTendiachi,bbtn;
	private JLabel lblMa,lblTen,lblGioiTinh;
	private JRadioButton radnam,radnu;
	private ButtonGroup group;
	private JTextField txtTen,txtMa;
	private JButton btnTK,btnXoaTrang,btnSua,btnXoa,btnXemTT,btnReload;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private ImageIcon iconTK,iconXoaTrang,iconXoa,iconSua,iconXemTT,iconReload;
	private String[] header = {"Mã Nhân Viên","Tên Nhân Viên","Số Điện Thoại","Tuổi","Địa Chỉ"};
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private static NhanVien_DAO nv_dao;
	private String maNguoiQuanLy;
	public static XemThongTinNhanVien_GUI xemtt_gui;
	public void DanhSachNhanVien_GUI(String maNQL,JPanel pen) {
		nv_dao = new NhanVien_DAO();
		maNguoiQuanLy = maNQL;
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/Xoa2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXemTT = new ImageIcon(new ImageIcon("images/XemTT.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconTK = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTK = Box.createVerticalBox();
		bMaTendiachi = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDS = Box.createHorizontalBox();
		bTacVu = Box.createHorizontalBox();
		radnam = new JRadioButton();
		radnu = new JRadioButton();
		group = new ButtonGroup();
		group.add(radnam);
		group.add(radnu);
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblMa = new JLabel("Mã Nhân Viên:"));
		bMaTendiachi.add(txtMa = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblTen = new JLabel("Tên Nhân Viên:"));
		bMaTendiachi.add(txtTen = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblGioiTinh = new JLabel("Giới Tính:"));
		bMaTendiachi.add(lblnam = new JLabel("Nam"));
		bMaTendiachi.add(radnam);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblnu = new JLabel("Nữ"));
		bMaTendiachi.add(radnu);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		
		bbtn.add(btnTK = new JButton("Tìm Kiếm"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		bDS.add(Box.createHorizontalStrut(10));
		bDS.add(scroll);
		bDS.add(Box.createHorizontalStrut(10));
		
		bTacVu.add(Box.createHorizontalStrut(140));
		bTacVu.add(btnSua = new JButton("Sửa Thông Tin Nhân Viên"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnXoa = new JButton("Xóa Nhân Viên"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnXemTT = new JButton("Xem Thông Tin Nhân Viên"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnReload = new JButton());
		bTacVu.add(Box.createHorizontalStrut(140));
		
		bTK.add(bMaTendiachi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bbtn);
		
		b.add(bTK);
		b.add(Box.createVerticalStrut(10));
		b.add(bDS);
		b.add(Box.createVerticalStrut(10));
		b.add(bTacVu);
	
		pen.add(b);
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(new Dimension(100,24));
		lblGioiTinh.setPreferredSize(new Dimension(100,24));
		
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		
		btnTK.setIcon(iconTK);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnSua.setIcon(iconSua);
		btnXoa.setIcon(iconXoa);
		btnXemTT.setIcon(iconXemTT);
		btnReload.setIcon(iconReload);
		
		btnTK.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		btnSua.setBackground(veryLightGreen);
		btnXoa.setBackground(veryLightRed);
		btnXemTT.setBackground(lightBlue);
		
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scroll.setPreferredSize(new Dimension(940,430));
		bTK.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		bDS.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Nhân Viên"));
		bTacVu.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tác Vụ"));
		
		taiDuLieuVaoTable();
		
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemTT.addActionListener(this);
		tbl.addMouseListener(this);
		btnReload.addActionListener(this);
		btnTK.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào !!!");
			}else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này !!!", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					String ma = model.getValueAt(row, 0).toString().trim();
					HoaDon_DAO hd_dao = new HoaDon_DAO();
					ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
					dshd = hd_dao.layDuLieuTuDB();
					int f = 0;
					for(HoaDon hd : dshd) {
						if(hd.getMaNhanVien().getMaNV().trim().equals(ma.trim()))
							f++;
					}
					if(f==0) {
						TaiKhoan_DAO tk_dao = new TaiKhoan_DAO();
						tk_dao.taiDuLieuTuDB();
						if(tk_dao.xoaTaiKhoan(ma)) {
							if(nv_dao.xoaNhanVien(ma)) {
								capNhatTable();
								ThemNhanVien_GUI.capNhatTable();
							}
						}
					}else {
						JOptionPane.showMessageDialog(this, "Bạn phải xóa tất cả các hóa đơn được lập bởi nhân viên này trước !!!");
					}
				}
			}
		}
		if(obj.equals(btnSua)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào !!!");
			}else {
				String ma = model.getValueAt(row, 0).toString().trim();
				SuaThongTinNhanVien_GUI t = new SuaThongTinNhanVien_GUI(ma);
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
		if (obj.equals(btnTK)) {
			try {
				timKiem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(obj.equals(btnReload)) {
			capNhatTable();
		}
		if(obj.equals(btnXoaTrang)) {
			xoaRongTextField();
		}
		if(obj.equals(btnXemTT)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào !!!");
			}else {
				String ma = model.getValueAt(row, 0).toString().trim();
				NhanVien nv = nv_dao.getNhanVien(ma);
				XemThongTinNhanVienQL_GUI xemtt_gui = new XemThongTinNhanVienQL_GUI(maNguoiQuanLy,nv);
				xemtt_gui.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<5;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public static void taiDuLieuVaoTable() {
		nv_dao = new NhanVien_DAO();
		ArrayList<NhanVien> dsnv = nv_dao.taiDuLieuTuDB();
		for(NhanVien nv : dsnv)
			if(nv.getLoaiNV().trim().equals("NV")) {
				model.addRow(new Object[] {
						nv.getMaNV(),nv.getTenNV(),nv.getSdt(),nv.getTuoi(),nv.getDiaChi()
				});
			}
	}
	public static void capNhatTable() {
		while(model.getRowCount()>0) {
			model.removeRow(0);
		}
		taiDuLieuVaoTable();
	}
	public void xoaRongTextField() {
		txtMa.setText("");
		txtTen.setText("");
		radnam.setSelected(false);
		radnu.setSelected(false);
	}
	public ArrayList<NhanVien> timMa(ArrayList<NhanVien> list, String maNV) {
		NhanVien_DAO ds = new NhanVien_DAO();
		ArrayList<NhanVien> ls = ds.taiDuLieuTuDB();
		Pattern pattern = Pattern.compile(".*" + maNV + ".*", Pattern.CASE_INSENSITIVE);
		for (NhanVien nv : ls) {
			Matcher matcher = pattern.matcher(nv.getMaNV().trim());
			if (matcher.matches()) {
				list.add(nv);
			}
		}
		return list;
	}
	
	public ArrayList<NhanVien> timTen(ArrayList<NhanVien> list, String tenNV) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		Pattern pattern = Pattern.compile(".*" + tenNV + ".*", Pattern.CASE_INSENSITIVE);
		for (NhanVien nv : list) {
			Matcher matcher = pattern.matcher(nv.getTenNV().trim());
			if (matcher.matches()) {
				ds.add(nv);
			}
		}
		return ds;
	}
	public ArrayList<NhanVien> timGT(ArrayList<NhanVien> list, String gt) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		Pattern pattern = Pattern.compile(".*" + gt + ".*", Pattern.CASE_INSENSITIVE);
		for (NhanVien nv : list) {
			Matcher matcher = pattern.matcher(nv.getGioiTinh().trim());
			if (matcher.matches()) {
				ds.add(nv);
			}
		}
		return ds;
	}
	public void timKiem() {
		String maNV = txtMa.getText().trim();
		String tenNV = txtTen.getText().trim();
		String gioiTinh = (radnam.isSelected() ? "nam" : "nữ").trim();
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		timMa(ls, maNV);
		ls = timTen(ls, tenNV);
		ls = timGT(ls, gioiTinh);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy nhà sản xuất trong danh sách !!!");
		}
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		for (NhanVien nv : ls) {
			if(nv.getLoaiNV().trim().equals("NV")) {
				model.addRow(new Object[] {
						nv.getMaNV(),nv.getTenNV(),nv.getSdt(),nv.getTuoi(),nv.getDiaChi()
				});
			}
		}
	}
}
