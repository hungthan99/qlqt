package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import class_DAO.BenhNhan_DAO;
import class_Entity.BenhNhan;

public class XemThongTinBenhNhan_GUI extends JFrame implements WindowListener{
	private Box b,bSua,bMaTen,bSDTGTNS,bGhiChu,bDiaChi,bTitle;
	private JLabel lblMa,lblTen,lblSDT,lblGT,lblNgaySinh,lblGhiChu,lblDiaChi,lblTitle;
	private JTextField txtMa,txtTen,txtsdt,txtGhiChu,txtDiaChi,txtTuoi,txtGioiTinh;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Color lightRed = new Color(204,0,0);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private String[] header = {"Mã Bệnh Nhân","Tên Bệnh Nhân","Giới Tính","Tuổi","Địa Chỉ","Số Điện Thoại"};
	private static BenhNhan_DAO bn_dao;
	private String maBN; 
	public XemThongTinBenhNhan_GUI(String ma) {
		this.maBN = ma;
		bn_dao = new BenhNhan_DAO();
		b = Box.createVerticalBox();
		bSua = Box.createVerticalBox();
		bMaTen = Box.createHorizontalBox();
		bSDTGTNS = Box.createHorizontalBox();
		bGhiChu = Box.createHorizontalBox();
		bDiaChi = Box.createHorizontalBox();
		bTitle = Box.createHorizontalBox();
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Bệnh Nhân:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(50));
		bMaTen.add(lblTen = new JLabel("Tên Bệnh Nhân:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(lblSDT = new JLabel("Số Điện Thoại:"));
		bSDTGTNS.add(txtsdt = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblGT = new JLabel("Giới Tính:"));
		bSDTGTNS.add(txtGioiTinh = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblNgaySinh = new JLabel("Tuổi"));
		bSDTGTNS.add(txtTuoi = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bDiaChi.add(Box.createHorizontalStrut(10));
		bDiaChi.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bDiaChi.add(txtDiaChi = new JTextField());
		bDiaChi.add(Box.createHorizontalStrut(10));
		bGhiChu.add(Box.createHorizontalStrut(10));
		bGhiChu.add(lblGhiChu = new JLabel("Ghi Chú:"));
		bGhiChu.add(txtGhiChu = new JTextField());
		bGhiChu.add(Box.createHorizontalStrut(10));
		txtMa.setEditable(false);
		txtTen.setEditable(false);
		txtsdt.setEditable(false);
		txtGioiTinh.setEditable(false);
		txtTuoi.setEditable(false);
		txtGhiChu.setEditable(false);
		txtDiaChi.setEditable(false);
		
		txtMa.setBackground(Color.WHITE);
		txtTen.setBackground(Color.WHITE);
		txtGioiTinh.setBackground(Color.WHITE);
		txtTuoi.setBackground(Color.WHITE);
		txtDiaChi.setBackground(Color.WHITE);
		txtsdt.setBackground(Color.WHITE);
		txtGhiChu.setBackground(Color.WHITE);
		
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtsdt.setBorder(null);
		txtDiaChi.setBorder(null);
		txtTuoi.setBorder(null);
		txtGhiChu.setBorder(null);
		txtGioiTinh.setBorder(null);
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblGhiChu.setPreferredSize(lblMa.getPreferredSize());
		
		bSua.add(Box.createVerticalStrut(10));
		bTitle.add(lblTitle = new JLabel("THÔNG TIN BỆNH NHÂN"));
		bSua.add(bTitle);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bMaTen);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bSDTGTNS);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bDiaChi);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bGhiChu);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(Box.createVerticalStrut(10));
		lblTitle.setForeground(veryLightRed);
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,20));
		
		b.add(bSua);
		
		add(b);
		setSize(750,250);
		setLocationRelativeTo(null);
		
		bn_dao.taiDSBenhNHan();
		taiDuLieuVaoTextField();
		this.addWindowListener(this);
		
	}
	public void taiDuLieuVaoTextField() {
		BenhNhan bn = bn_dao.timBenhNhan(maBN);
		txtMa.setText(bn.getMaBenhNhan());
		txtTen.setText(bn.getTenBenhNhan());
		txtsdt.setText(bn.getSdt());
		txtTuoi.setText(String.valueOf(bn.getTuoi()));
		txtDiaChi.setText(bn.getDiaChi());
		txtGhiChu.setText(bn.getGhiChu());
		txtGioiTinh.setText(bn.getGioiTinh());
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
