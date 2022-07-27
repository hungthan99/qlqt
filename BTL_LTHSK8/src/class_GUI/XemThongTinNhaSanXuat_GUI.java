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

public class XemThongTinNhaSanXuat_GUI extends JFrame implements WindowListener{
	private Box b,bTitle,bMaTen,bDiaChiSDT;
	private JLabel lblTitle,lblMa,lblTen,lblSDT,lblDiaChi;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconThem,iconXoaTrang;
	private String maNSX;
	private NhaSanXuat_DAO nsx_dao;
	public XemThongTinNhaSanXuat_GUI(String ma) {
		setSize(600,200);
		setLocationRelativeTo(null);
		
		nsx_dao = new NhaSanXuat_DAO();
		maNSX = ma;
		iconThem = new ImageIcon(new ImageIcon("images/themNSX.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bMaTen = Box.createHorizontalBox();
		bDiaChiSDT = Box.createHorizontalBox();
		
		bTitle.add(lblTitle = new JLabel("XEM THÔNG TIN NHÀ SẢN XUẤT"));	
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
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblMa.setPreferredSize(new Dimension(110,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblTitle.setForeground(veryLightRed);
		
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtDiaChi.setBorder(null);
		txtSDT.setBorder(null);
		
		txtMa.setEditable(false);
		txtTen.setEditable(false);
		txtSDT.setEditable(false);
		txtDiaChi.setEditable(false);
		
		txtMa.setBackground(Color.WHITE);
		txtTen.setBackground(Color.WHITE);
		txtSDT.setBackground(Color.WHITE);
		txtDiaChi.setBackground(Color.WHITE);
		
		b.add(Box.createVerticalStrut(10));
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bMaTen);
		b.add(Box.createVerticalStrut(10));
		b.add(bDiaChiSDT);
		b.add(Box.createVerticalStrut(10));
		b.add(Box.createVerticalStrut(10));
		b.add(Box.createVerticalStrut(10));
		
		add(b);
		
		ArrayList<NhaSanXuat> ds = nsx_dao.layTTNhaSanXuat();
		
		loadData();
		
		this.addWindowListener(this);
		
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
