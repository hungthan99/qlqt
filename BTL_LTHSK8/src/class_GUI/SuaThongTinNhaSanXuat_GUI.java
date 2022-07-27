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
import javax.swing.JTextField;

import class_DAO.NhaSanXuat_DAO;
import class_Entity.NhaSanXuat;

public class SuaThongTinNhaSanXuat_GUI extends JFrame implements ActionListener,WindowListener{
	private Box b,bTitle,bMaTen,bDiaChiSDT,bbtn,bError;
	private JLabel lblTitle,lblMa,lblTen,lblSDT,lblDiaChi;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi,txtError;
	private JButton btnSua,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconThem,iconXoaTrang;
	private String maNSX;
	private NhaSanXuat_DAO nsx_dao;
	public SuaThongTinNhaSanXuat_GUI(String ma) {
		setSize(800,250);
		setLocationRelativeTo(null);
		
		nsx_dao = new NhaSanXuat_DAO();
		maNSX = ma;
		iconThem = new ImageIcon(new ImageIcon("images/themNSX.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bMaTen = Box.createHorizontalBox();
		bDiaChiSDT = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bError = Box.createHorizontalBox();
		
		bTitle.add(lblTitle = new JLabel("SỬA THÔNG TIN NHÀ SẢN XUẤT"));	
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Nhà Sản Xuất:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblTen = new JLabel("Tên Nhà Sản Xuất:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(lblSDT = new JLabel("Số Điện Thoại:"));
		bDiaChiSDT.add(txtSDT = new JTextField());
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bDiaChiSDT.add(txtDiaChi = new JTextField());
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bError.add(Box.createHorizontalStrut(10));
		bError.add(txtError = new JTextField());
		bError.add(Box.createHorizontalStrut(10));
		bbtn.add(btnSua = new JButton("Sửa"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblMa.setPreferredSize(new Dimension(110,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblTitle.setForeground(veryLightRed);
		btnSua.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnSua.setBackground(veryLightGreen);
		btnXoaTrang.setBackground(veryLightRed);
		txtTen.setBorder(null);
		txtDiaChi.setBorder(null);
		txtSDT.setBorder(null);
		txtError.setBorder(null);
		txtError.setEditable(false);
		
		txtMa.setEditable(false);
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bMaTen);
		b.add(Box.createVerticalStrut(10));
		b.add(bDiaChiSDT);
		b.add(Box.createVerticalStrut(10));
		b.add(bError);
		b.add(Box.createVerticalStrut(10));
		b.add(bbtn);
		b.add(Box.createVerticalStrut(10));
		
		add(b);
		
		ArrayList<NhaSanXuat> ds = nsx_dao.layTTNhaSanXuat();
		
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
				NhaSanXuat n = layNSXTuTextField();
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa thông tin nhà sản xuất này !!!", "Cảnh Báo !!!", JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					if(nsx_dao.suaNhaSanXuat(n)) {
						DanhSachNSX_GUI.reLoadTable();
						ThemNhaSX_GUI.reLoadTable();
						Load.NV_GUI.setEnabled(true);
						this.setVisible(false);
					}	
				}
			}
		}else if(obj.equals(btnXoaTrang))
			xoaTrangTextField();
	}
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
	}
	public NhaSanXuat layNSXTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		NhaSanXuat nsx = new NhaSanXuat(ma, ten, sdt, diachi);
		return nsx;
	}
	public void thongBao(String mess, JTextField txt) {
		txtError.setForeground(Color.RED);
		txtError.setText(mess);
		txt.requestFocus();
	}
	public boolean kiemTraDuLieuNhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		if(ma.equals("")||ten.equals("")||sdt.equals("")||diachi.equals("")) {
			thongBao("Vui lòng nhập đầy đủ thông tin !!!", txtMa);
			return false;
		}
		if(!ma.matches("NSX\\d{4}")) {
			thongBao("Mã nhà sản xuất có dạng: 'NSXxxxx', x là số !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")){
				thongBao("Số điện thoại không hợp lệ !!!", txtSDT);
				return false;
		}
		return true;
	}
	public void loadData() {
		NhaSanXuat nsx = nsx_dao.getNhaSanXuat(maNSX);
		txtMa.setText(nsx.getMaNSX());
		txtTen.setText(nsx.getTenNSX());
		txtSDT.setText(nsx.getSdt());
		txtDiaChi.setText(nsx.getDiaChi());
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
