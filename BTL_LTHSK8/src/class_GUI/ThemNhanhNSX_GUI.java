package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThemNhanhNSX_GUI extends JFrame implements ActionListener{
	private Box b,bTitle,bMaTen,bDiaChiSDT,bbtn,bError;
	private JLabel lblTitle,lblMa,lblTen,lblSDT,lblDiaChi;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi,txtError;
	private JButton btnThem,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconThem,iconXoaTrang;
	public ThemNhanhNSX_GUI() {
		setSize(800,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		iconThem = new ImageIcon(new ImageIcon("images/themNSX.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bMaTen = Box.createHorizontalBox();
		bDiaChiSDT = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bError = Box.createHorizontalBox();
		
		bTitle.add(lblTitle = new JLabel("THÊM NHÀ SẢN XUẤT"));	
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
		bbtn.add(btnThem = new JButton("Thêm"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblMa.setPreferredSize(new Dimension(110,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblTitle.setForeground(veryLightRed);
		btnThem.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtDiaChi.setBorder(null);
		txtSDT.setBorder(null);
		txtError.setBorder(null);
		txtError.setEditable(false);
		
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
		
	}
	public static void main(String[] args) {
		new ThemNhanhNSX_GUI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
