package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import class_DAO.NhanVien_DAO;
import class_DAO.TaiKhoan_DAO;
import class_Entity.NhanVien;
import class_Entity.TaiKhoan;


public class TaoTaiKhoan_GUI extends JFrame implements WindowListener,ActionListener{
	private Box b,bTitle,bTK,bMK,bError,bbtn,bMK1;
	private JLabel lblTitle,lblTK,lblMK,lblMK1;
	private JTextField txtTK,txtError;
	private JPasswordField txtMK,txtMK1;
	private JButton btnTao;
	private ImageIcon iconXN;
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private NhanVien nhanVien;
	public TaoTaiKhoan_GUI(NhanVien nvv) {
		nhanVien = nvv;
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bTK = Box.createHorizontalBox();
		bMK = Box.createHorizontalBox();
		bMK1 = Box.createHorizontalBox();
		bError = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		iconXN = new ImageIcon(new ImageIcon("images/checkBlue.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		
		bTitle.add(lblTitle = new JLabel("Tạo Tài Khoản"));
		bTK.add(Box.createHorizontalStrut(10));
		bTK.add(lblTK = new JLabel("Tài Khoản:"));
		bTK.add(txtTK = new JTextField());
		bTK.add(Box.createHorizontalStrut(10));
		bMK.add(Box.createHorizontalStrut(10));
		bMK.add(lblMK = new JLabel("Mật Khẩu:"));
		bMK.add(txtMK = new JPasswordField());
		bMK.add(Box.createHorizontalStrut(10));
		bMK1.add(Box.createHorizontalStrut(10));
		bMK1.add(lblMK1 = new JLabel("Mật Khẩu:"));
		bMK1.add(txtMK1 = new JPasswordField());
		bMK1.add(Box.createHorizontalStrut(10));
		bError.add(Box.createHorizontalStrut(10));
		bError.add(txtError = new JTextField());
		bError.add(Box.createHorizontalStrut(10));
		bbtn.add(btnTao = new JButton("Xác Nhận"));
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bTK);
		b.add(Box.createVerticalStrut(10));
		b.add(bMK);
		b.add(Box.createVerticalStrut(10));
		b.add(bMK1);
		b.add(Box.createVerticalStrut(10));
		b.add(bError);
		b.add(Box.createVerticalStrut(10));
		b.add(bbtn);
		b.add(Box.createVerticalStrut(10));
		
		add(b);
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,20));
		lblTitle.setForeground(veryLightRed);
		btnTao.setBackground(veryLightGreen);
		lblTK.setPreferredSize(new Dimension(80,24));
		lblMK.setPreferredSize(lblTK.getPreferredSize());
		lblMK1.setPreferredSize(lblTK.getPreferredSize());
		btnTao.setIcon(iconXN);
		txtError.setBorder(null);
		txtError.setEditable(false);
		txtTK.setEditable(false);
		txtTK.setBackground(Color.WHITE);
		txtTK.setText(nhanVien.getMaNV());
		
		setSize(400,270);
		setLocationRelativeTo(null);
		
		this.addWindowListener(this);
		btnTao.addActionListener(this);
	}
	public boolean kiemTraDuLieuNhap() {
		if(txtMK.getText().trim().equals("")||txtMK1.getText().trim().equals("")) {
			thongBao("Vui lỏng nhập đầy đủ dữ liệu !!!", txtMK);
			return false;
		}
		if(!txtMK.getText().trim().equals(txtMK1.getText().trim())) {
			thongBao("Mật khẩu xác nhận không khớp !!!", txtMK1);
			return false;
		}
		return true;
	}
	public void thongBao(String mess,JTextField txt) {
		txtError.setForeground(Color.RED);
		txtError.setText(mess);
		txt.requestFocus();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnTao)) {
			if(kiemTraDuLieuNhap()) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn tạo nhân viên này !!!","Cảnh Báo",JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					TaiKhoan tk = new TaiKhoan(nhanVien, txtMK1.getText().trim());
					TaiKhoan_DAO tk_dao = new TaiKhoan_DAO();
					NhanVien_DAO nv_dao = new NhanVien_DAO();
					tk_dao.taiDuLieuTuDB();
					nv_dao.taiDuLieuTuDB();
					if(nv_dao.themNhanVien(nhanVien)) {
						if(tk_dao.themTaiKhoan(tk)) {
							JOptionPane.showMessageDialog(this, "Tạo nhân viên mới thành công ");
							Load.NV_GUI.setEnabled(true);
							ThemNhanVien_GUI.capNhatTable();
							ThemNhanVien_GUI.thanhCong("Thêm thành công một nhân viên");
							DanhSachNhanVien_GUI.capNhatTable();
							this.setVisible(false);
						}
					}
				}
			}
		}
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		Load.NV_GUI.setEnabled(true);
		ThemNhanVien_GUI.thanhCong("");
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
