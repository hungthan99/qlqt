package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

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

import class_DAO.NhanVien_DAO;
import class_Entity.NhanVien;

public class SuaThongTinNhanVien_GUI extends JFrame implements ActionListener,WindowListener{
	private Box b,bTK,bTitle,bMaTendiachi,bTuoiDiaChi,bbtn,berror;
	private JLabel lblMa,lblTen,lblGioiTinh,lblTuoi,lblDiaChi,lblsdt,lblTitle;
	private JRadioButton radnam,radnu;
	private ButtonGroup group;
	private JTextField txtTen,txtMa,txtTuoi,txtDiaChi,txtsdt,txterror;
	private JButton btnXoaTrang,btnSua;
	private ImageIcon iconXoaTrang,iconThem;
	private String[] header = {"Mã Nhân Viên","Tên Nhân Viên","Giới Tính","Số Điện Thoại","Tuổi","Địa Chỉ"};
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private NhanVien_DAO nv_dao;
	private String maNhanVien;
	public SuaThongTinNhanVien_GUI(String ma) {
		maNhanVien = ma;
		nv_dao = new NhanVien_DAO();
		iconThem = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTK = Box.createVerticalBox();
		bMaTendiachi = Box.createHorizontalBox();
		bTuoiDiaChi = Box.createHorizontalBox();
		bTitle = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		berror = Box.createHorizontalBox();
		radnam = new JRadioButton();
		radnu = new JRadioButton();
		group = new ButtonGroup();
		group.add(radnam);
		group.add(radnu);

		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblMa = new JLabel("Mã Nhân Viên:"));
		bMaTendiachi.add(txtMa = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblTen = new JLabel("Tên Nhân Viên:"));
		bMaTendiachi.add(txtTen = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblGioiTinh = new JLabel("Giới Tính:"));
		bMaTendiachi.add(radnam);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(radnu);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblTuoi = new JLabel("Tuổi"));
		bTuoiDiaChi.add(txtTuoi = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblsdt = new JLabel("Số Điện Thoại:"));
		bTuoiDiaChi.add(txtsdt = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bTuoiDiaChi.add(txtDiaChi = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		
		berror.add(Box.createHorizontalStrut(10));
		berror.add(txterror = new JTextField());
		berror.add(Box.createHorizontalStrut(10));
		
		bbtn.add(btnSua = new JButton("Thêm Nhân Viên"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		bTK.add(bMaTendiachi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bTuoiDiaChi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(berror);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bbtn);
		
		bTitle.add(lblTitle = new JLabel("SỬA THÔNG TIN NHÂN VIÊN"));
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,20));
		lblTitle.setForeground(veryLightRed);
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bTK);
		b.add(Box.createVerticalStrut(10));
		
		setSize(800,200);
		setLocationRelativeTo(null);
		add(b);
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(new Dimension(100,24));
		lblGioiTinh.setPreferredSize(new Dimension(100,24));
		lblTuoi.setPreferredSize(new Dimension(100,24));
		lblDiaChi.setPreferredSize(new Dimension(100,24));
		lblsdt.setPreferredSize(new Dimension(100,24));
		
		txtMa.setEditable(false);
		txtTen.setBorder(null);
		txtTuoi.setBorder(null);
		txtDiaChi.setBorder(null);
		txterror.setBorder(null);
		txterror.setEditable(false);
		txtsdt.setBorder(null);
		
		btnSua.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		
		btnSua.setBackground(veryLightGreen);
		btnXoaTrang.setBackground(veryLightRed);
		
		loadData();
		
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		this.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnSua)) {
			if(kiemTraDuLieuNhap()) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa nhân viên này !!!","Cảnh Báo",JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					NhanVien n = layDuLieuTuTextField();
					nv_dao = new NhanVien_DAO();
					nv_dao.taiDuLieuTuDB();
					if(nv_dao.suaNhanVien(n)) {
						ThemNhanVien_GUI.capNhatTable();
						DanhSachNhanVien_GUI.capNhatTable();
						Load.NV_GUI.setEnabled(true);
						this.setVisible(false);
					}
				}
			}
		}else if(obj.equals(btnXoaTrang)) {
			xoaRongTextField();
		}
		
	}
	public void loadData() {
		nv_dao = new NhanVien_DAO();
		nv_dao.taiDuLieuTuDB();
		NhanVien nvv = nv_dao.getNhanVien(maNhanVien);
		System.out.println(nvv.toString());
		txtMa.setText(maNhanVien);
		txtTen.setText(nvv.getTenNV());
		radnam.setSelected(true);
		if(nvv.getGioiTinh().trim().equals("nữ"))
			radnu.setSelected(true);
		txtTuoi.setText(String.valueOf(nvv.getTuoi()));
		txtsdt.setText(nvv.getSdt());
		txtDiaChi.setText(nvv.getDiaChi());
	}
	public NhanVien layDuLieuTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String gt = "nam";
		if(radnu.isSelected())
			gt = "nữ";
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtsdt.getText().trim();
		NhanVien nv = new NhanVien(ma,ten,gt,sdt,tuoi,"NV",diachi);
		return nv;
	}
	public boolean kiemTraDuLieuNhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String gt = "";
		String sdt = txtsdt.getText().trim();
		if(radnam.isSelected())
			gt = "nam";
		if(radnu.isSelected())
			gt = "nữ";
		if(ma.equals("")||ten.equals("")||diachi.equals("")||txtTuoi.getText().trim().equals("")||sdt.equals("")) {
			thongBao("Vui lòng nhập đầy đủ dữ liệu !!!", txtMa);
			return false;
		}
		if(!ma.matches("NV\\d{4}")) {
			thongBao("Mã nhân viên có dạng: 'NVxxxx', trong đó x là số !!!", txtMa);
			return false;
		}
		try {
			if(Integer.parseInt(txtTuoi.getText().trim()) < 18) {
				thongBao("Tuổi phải từ 18 trở lên !!!", txtTuoi);
				return false;
			}
		}catch (Exception e) {
			thongBao("Tuổi không hợp lệ !!!", txtTuoi);
			return false;
		}
		if(gt.equals("")) {
			thongBao("Bạn chưa chọn giới tính !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")) {
			thongBao("Số điện thoại không hợp lệ !!!", txtsdt);
			return false;
		}
		return true;
	}
	public void thongBao(String mess,JTextField txt) {
		txterror.setForeground(Color.RED);
		txterror.setText(mess);
		txt.requestFocus();
	}
	public void xoaRongTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtsdt.setText("");
		txtDiaChi.setText("");
		radnam.setSelected(true);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		Load.NV_GUI.setEnabled(true);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
