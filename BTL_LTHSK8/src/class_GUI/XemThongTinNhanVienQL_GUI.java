package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import class_DAO.NhanVien_DAO;
import class_DAO.TaiKhoan_DAO;
import class_Entity.NhanVien;
import class_Entity.TaiKhoan;

public class XemThongTinNhanVienQL_GUI extends JFrame implements WindowListener,ActionListener{
	private Box b,bTK,bMaTendiachi,bTuoiDiaChi,bbtn,bTitle;
	private JLabel lblMa,lblTen,lblGioiTinh,lblTuoi,lblDiaChi,lblsdt,lblTitle,lblMatKhau;
	private JTextField txtTen,txtMa,txtTuoi,txtDiaChi,txtsdt,txtgt;
	private JPasswordField txtMatKhau;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private NhanVien nv;
	private JButton btnXemMK;
	private ImageIcon iconsee;
	private NhanVien_DAO nv_dao;
	private String maQuanLy;
	public XemThongTinNhanVienQL_GUI(String maNQL,NhanVien nvi) {
		maQuanLy = maNQL;
		nv = nvi;
		b = Box.createVerticalBox();
		bTK = Box.createVerticalBox();
		bMaTendiachi = Box.createHorizontalBox();
		bTuoiDiaChi = Box.createHorizontalBox();
		bTitle = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		iconsee = new ImageIcon(new ImageIcon("images/see.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		
		bTitle.add(lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,20));
		lblTitle.setForeground(Color.RED);
		
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblMa = new JLabel("Mã Nhân Viên:"));
		bMaTendiachi.add(txtMa = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblTen = new JLabel("Tên Nhân Viên:"));
		bMaTendiachi.add(txtTen = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblGioiTinh = new JLabel("Giới Tính:"));
		bMaTendiachi.add(txtgt = new JTextField());
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
		
		bTK.add(bMaTendiachi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bTuoiDiaChi);
		
		bbtn.add(Box.createHorizontalStrut(80));
		bbtn.add(lblMatKhau = new JLabel("Nhập mật khẩu quản lý của bạn để xem mật khẩu của nhân viên này :"));
		bbtn.add(Box.createHorizontalStrut(10));
		bbtn.add(txtMatKhau = new JPasswordField());
		bbtn.add(Box.createHorizontalStrut(10));
		bbtn.add(btnXemMK = new JButton("Xem Mật Khẩu"));
		bbtn.add(Box.createHorizontalStrut(80));
		btnXemMK.setIcon(iconsee);
		btnXemMK.setBackground(veryLightRed);
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bTK);
		b.add(Box.createVerticalStrut(10));
		b.add(bbtn);
		b.add(Box.createVerticalStrut(10));
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(new Dimension(100,24));
		lblGioiTinh.setPreferredSize(new Dimension(100,24));
		lblTuoi.setPreferredSize(new Dimension(100,24));
		lblDiaChi.setPreferredSize(new Dimension(100,24));
		lblsdt.setPreferredSize(new Dimension(100,24));
		
		txtMa.setEditable(false);
		txtTen.setEditable(false);
		txtgt.setEditable(false);
		txtsdt.setEditable(false);
		txtTuoi.setEditable(false);
		txtDiaChi.setEditable(false);
		
		txtMa.setBackground(Color.WHITE);
		txtTen.setBackground(Color.WHITE);
		txtgt.setBackground(Color.WHITE);
		txtsdt.setBackground(Color.WHITE);
		txtTuoi.setBackground(Color.WHITE);
		txtDiaChi.setBackground(Color.WHITE);
		
		add(b);
		setSize(900,200);
		setLocationRelativeTo(null);
		
		loadData();
		
		this.addWindowListener(this);
		btnXemMK.addActionListener(this);
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
	public void loadData() {
		txtMa.setText(nv.getMaNV());
		txtTen.setText(nv.getTenNV());
		txtgt.setText(nv.getGioiTinh());
		txtTuoi.setText(String.valueOf(nv.getTuoi()));
		txtsdt.setText(nv.getSdt());
		txtDiaChi.setText(nv.getDiaChi());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXemMK)) {
		}
		TaiKhoan_DAO tk_dao = new TaiKhoan_DAO();
		tk_dao.taiDuLieuTuDB();
		TaiKhoan tkql = tk_dao.getTaiKhoan(maQuanLy);
		if(txtMatKhau.getText().trim().equals(tkql.getMatKhau())) {
			TaiKhoan tknv = tk_dao.getTaiKhoan(nv.getMaNV().trim());
			JOptionPane.showMessageDialog(this, "Mật khẩu của nhân viên này là: "+tknv.getMatKhau());
		}else {
			JOptionPane.showMessageDialog(this, "Sai mật khẩu !!!");
		}
	}
}
