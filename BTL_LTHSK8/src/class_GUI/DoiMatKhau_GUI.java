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

public class DoiMatKhau_GUI extends JFrame implements WindowListener,ActionListener{
	private Box b,bTitle,bMKCu, bMKMoi1, bMKMoi2, bbtn, berror;
	private JLabel lblMKCu, lblMKMoi1, lblMKMoi2, lblTitle;
	private JPasswordField txtMKCu, txtMKMoi , txtMKMoi2;
	private JTextField txterror;
	private JButton btnXacNhan;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconXacNhan;
	private NhanVien_DAO nv_dao;
	private TaiKhoan_DAO tk_dao;
	private String maNhanVien;
	public DoiMatKhau_GUI(String maNV) {
		setSize(400,300);
		setLocationRelativeTo(null);
		
		maNhanVien = maNV;
		iconXacNhan = new ImageIcon(new ImageIcon("images/HT.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b= Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bMKCu = Box.createHorizontalBox();
		bMKMoi1 = Box.createHorizontalBox();
		bMKMoi2 = Box.createHorizontalBox();
		berror = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		
		bTitle.add(lblTitle = new JLabel("ĐỔI MẬT KHẨU"));
		bMKCu.add(Box.createHorizontalStrut(10));
		bMKCu.add(lblMKCu = new JLabel("Mật Khẩu Cũ:"));
		bMKCu.add(txtMKCu = new JPasswordField());
		bMKCu.add(Box.createHorizontalStrut(10));
		bMKMoi1.add(Box.createHorizontalStrut(10));
		bMKMoi1.add(lblMKMoi1 = new JLabel("Mật Khẩu Mới:"));
		bMKMoi1.add(txtMKMoi = new JPasswordField());
		bMKMoi1.add(Box.createHorizontalStrut(10));
		bMKMoi2.add(Box.createHorizontalStrut(10));
		bMKMoi2.add(lblMKMoi2 = new JLabel("Xác Nhận Mật Khẩu:"));
		bMKMoi2.add(txtMKMoi2 = new JPasswordField());
		bMKMoi2.add(Box.createHorizontalStrut(10));
		berror.add(Box.createHorizontalStrut(10));
		berror.add(txterror = new JTextField());
		berror.add(Box.createHorizontalStrut(10));
		bbtn.add(Box.createHorizontalStrut(10));
		bbtn.add(btnXacNhan = new JButton("Xác Nhận"));
		bbtn.add(Box.createHorizontalStrut(10));
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bMKCu);
		b.add(Box.createVerticalStrut(10));
		b.add(bMKMoi1);
		b.add(Box.createVerticalStrut(10));
		b.add(bMKMoi2);
		b.add(Box.createVerticalStrut(10));
		b.add(berror);
		b.add(Box.createVerticalStrut(10));
		b.add(bbtn);
		b.add(Box.createVerticalStrut(10));
		
		add(b);
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblTitle.setForeground(veryLightRed);
		lblMKCu.setPreferredSize(new Dimension(120,24));
		lblMKMoi1.setPreferredSize(lblMKCu.getPreferredSize());
		lblMKMoi2.setPreferredSize(lblMKCu.getPreferredSize());
		btnXacNhan.setIcon(iconXacNhan);
		
		txtMKCu.setBorder(null);
		txtMKMoi.setBorder(null);
		txtMKMoi2.setBorder(null);
		txterror.setBorder(null);
		txterror.setEditable(false);
		
		this.addWindowListener(this);
		btnXacNhan.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXacNhan)) {
			if(kiemTraCuPhapNhap()) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đổi mật khẩu !!!","Cảnh Báo",JOptionPane.YES_NO_OPTION);
				if(tl==JOptionPane.YES_OPTION) {
					TaiKhoan tk = new TaiKhoan(new NhanVien(maNhanVien), txtMKMoi2.getText().trim());
					if(tk_dao.suaTaiKhoan(tk)) {
						JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
						Load.NV_GUI.setEnabled(true);
						this.setVisible(false);
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
		Load.NV_GUI.setEnabled(true);;
		
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
	public boolean kiemTraCuPhapNhap() {
		if(txtMKCu.getText().trim().equals("")||txtMKMoi.getText().trim().equals("")||txtMKMoi2.getText().trim().equals("")) {
			thongBao("Vui lòng nhập đầy đủ dữ liệu !!!", txtMKCu);
			return false;
		}
		nv_dao = new NhanVien_DAO();
		tk_dao = new TaiKhoan_DAO();
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		dsnv = nv_dao.taiDuLieuTuDB();
		dstk = tk_dao.taiDuLieuTuDB();
		TaiKhoan tkk = tk_dao.getTaiKhoan(maNhanVien);
		if(!txtMKCu.getText().trim().equals(tkk.getMatKhau().trim())) {
			thongBao("Sai mật khẩu !!!", txtMKCu);
			return false;
		}
		if(!txtMKMoi.getText().trim().equals(txtMKMoi2.getText().trim())) {
			thongBao("Mật khẩu xác nhận không đúng !!!", txtMKMoi2);
			return false;
		}
		return true;
	}
	public void thongBao(String mess,JTextField txt) {
		txterror.setForeground(Color.RED);
		txterror.setText(mess);
		txt.requestFocus();
	}
}	
