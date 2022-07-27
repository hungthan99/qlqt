package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_Connection.Connect_DB;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.Thuoc_DAO;
import class_Entity.NhaSanXuat;
import class_Entity.Thuoc;

public class XemThongTinThuoc_GUI extends JFrame implements WindowListener{
	private Box bThem,bDanhSach,bMa,bTen,bLoaiDonVi,bNgay,bSLDonGia,bNhaSX,bMoTa,bbtn,bTitle;
	private JLabel lblMa,lblTen,lblLoai,lblDonVi,lblNgaySX,lblNgayHH,lblSoLuong,lblDonGia,lblNhaSX,lblMoTa,lblTitle;
	private JTextField txtMa,txtTen,txtDonVi,txtLoai,txtSOLuong,txtDonGia,txtMoTa,txtNgaySX,txtNgayHH,txtNSX;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private NhaSanXuat_DAO dsNCC;
	private Thuoc_DAO dsThuoc;
	private Thuoc thuoc;
	private Thuoc thuoc_moi;
	public XemThongTinThuoc_GUI(Thuoc thuoc) {
		this.thuoc = thuoc;
		bThem = Box.createVerticalBox();
		bDanhSach = Box.createVerticalBox();
		bMa = Box.createHorizontalBox();
		bTen = Box.createHorizontalBox();
		bLoaiDonVi = Box.createHorizontalBox();
		bNgay = Box.createHorizontalBox();
		bSLDonGia = Box.createHorizontalBox();
		bNhaSX = Box.createHorizontalBox();
		bMoTa = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		
		bMa.add(Box.createHorizontalStrut(10));
		bMa.add(lblMa = new JLabel("Mã Thuốc:"));
		bMa.add(txtMa = new JTextField());
		bMa.add(Box.createHorizontalStrut(10));
		bTen.add(Box.createHorizontalStrut(10));
		bTen.add(lblTen = new JLabel("Tên Thuốc:"));
		bTen.add(txtTen = new JTextField());
		bTen.add(Box.createHorizontalStrut(10));
		bLoaiDonVi.add(Box.createHorizontalStrut(10));
		bLoaiDonVi.add(lblLoai = new JLabel("Loại Thuốc:"));
		bLoaiDonVi.add(txtLoai = new JTextField());
		bLoaiDonVi.add(Box.createHorizontalStrut(30));
		bLoaiDonVi.add(lblDonVi = new JLabel("Đơn Vị:"));
		bLoaiDonVi.add(txtDonVi = new JTextField());
		bLoaiDonVi.add(Box.createHorizontalStrut(10));
		bNgay.add(Box.createHorizontalStrut(10));
		bNgay.add(lblNgaySX = new JLabel("Ngày Sản Xuất:"));
		bNgay.add(txtNgaySX = new JTextField());
		bNgay.add(Box.createHorizontalStrut(30));
		bNgay.add(lblNgayHH = new JLabel("Ngày Hết Hạn:"));
		bNgay.add(txtNgayHH = new JTextField());
		bNgay.add(Box.createHorizontalStrut(10));
		bSLDonGia.add(Box.createHorizontalStrut(10));
		bSLDonGia.add(lblSoLuong = new JLabel("Số Lượng:"));
		bSLDonGia.add(txtSOLuong = new JTextField(1));
		bSLDonGia.add(Box.createHorizontalStrut(28));
		bSLDonGia.add(lblDonGia = new JLabel("Đơn Giá:"));
		bSLDonGia.add(txtDonGia = new JTextField());
		bSLDonGia.add(Box.createHorizontalStrut(10));
		bNhaSX.add(Box.createHorizontalStrut(10));
		bNhaSX.add(lblNhaSX = new JLabel("Nhà Sản Xuất"));
		bNhaSX.add(txtNSX = new JTextField());
		bNhaSX.add(Box.createHorizontalStrut(10));
		bNhaSX.add(Box.createHorizontalStrut(10));
		bMoTa.add(Box.createHorizontalStrut(10));
		bMoTa.add(lblMoTa = new JLabel("Mô Tả:"));
		bMoTa.add(txtMoTa = new JTextField());
		bMoTa.add(Box.createHorizontalStrut(10));
		
		lblMa.setPreferredSize(new Dimension(90,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblLoai.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySX.setPreferredSize(new Dimension(90,26));
		lblSoLuong.setPreferredSize(lblMa.getPreferredSize());
		lblNhaSX.setPreferredSize(lblMa.getPreferredSize());
		lblMoTa.setPreferredSize(lblMa.getPreferredSize());
		txtLoai.setPreferredSize(new Dimension(10,lblMa.getPreferredSize().height));
		lblDonVi.setPreferredSize(new Dimension(100,lblMa.getPreferredSize().height));
		lblNgayHH.setPreferredSize(new Dimension(100,24));
		lblDonGia.setPreferredSize(new Dimension(100,24));
		
		bThem.setPreferredSize(new Dimension(960,350));
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtLoai.setBorder(null);
		txtLoai.setBackground(Color.WHITE);
		txtDonVi.setBorder(null);
		txtSOLuong.setBorder(null);
		txtDonGia.setBorder(null);
		txtMoTa.setBorder(BorderFactory.createEmptyBorder());
		txtMoTa.setBackground(Color.WHITE);
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bTitle = Box.createHorizontalBox());
		bTitle.add(lblTitle = new JLabel("XEM THÔNG TIN THUỐC"));
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,25));
		lblTitle.setForeground(veryLightRed);
		
		txtMa.setEditable(false);
		txtTen.setEditable(false);
		txtDonVi.setEditable(false);
		txtLoai.setEditable(false);
		txtSOLuong.setEditable(false);
		txtDonGia.setEditable(false);
		txtNgaySX.setEditable(false);
		txtNgayHH.setEditable(false);
		txtMoTa.setEditable(false);
		txtNSX.setEditable(false);
		
		txtMa.setBackground(Color.WHITE);
		txtTen.setBackground(Color.WHITE);
		txtDonVi.setBackground(Color.WHITE);
		txtLoai.setBackground(Color.WHITE);
		txtSOLuong.setBackground(Color.WHITE);
		txtDonGia.setBackground(Color.WHITE);
		txtNgaySX.setBackground(Color.WHITE);
		txtNgayHH.setBackground(Color.WHITE);
		txtMoTa.setBackground(Color.WHITE);
		txtNSX.setBackground(Color.WHITE);
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bMa);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bTen);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bLoaiDonVi);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bNgay);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bSLDonGia);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bNhaSX);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bMoTa);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bbtn);
		bThem.add(Box.createVerticalStrut(10));
				
		add(bThem);
		
		setSize(800,400);
		setLocationRelativeTo(null);
		
		
		dsNCC = new NhaSanXuat_DAO();
		dsThuoc = new Thuoc_DAO();
		Connect_DB.getInstance().connect();
		loadData();
		
		this.addWindowListener(this);
		
	}
	public void loadData() {
		txtMa.setText(thuoc.getMaThuoc());
		txtTen.setText(thuoc.getTenThuoc());
		txtLoai.setText(thuoc.getLoaiThuoc());
		txtDonVi.setText(thuoc.getDonVi());
		txtNgaySX.setText(thuoc.getNgaySX().toString());
		txtNgayHH.setText(thuoc.getNgayHH().toString());
		txtSOLuong.setText(String.valueOf(thuoc.getSoLuong()));
		txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
		txtNSX.setText(thuoc.getNsx().getMaNSX());
		txtMoTa.setText(thuoc.getGhiChu());
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
