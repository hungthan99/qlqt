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

public class SuaThongTinThuoc_GUI extends JFrame implements ActionListener,WindowListener{
	private Box bThem,bDanhSach,bMa,bTen,bLoaiDonVi,bNgay,bSLDonGia,bNhaSX,bMoTa,bbtn,bError,bTitle;
	private ImageIcon iconThem,iconXoaTrang,iconError,iconThemNSX;
	private JLabel lblMa,lblTen,lblLoai,lblDonVi,lblNgaySX,lblNgayHH,lblSoLuong,lblDonGia,lblNhaSX,lblMoTa,lblTitle;
	private JTextField txtMa,txtTen,txtDonVi,txtLoai,txtSOLuong,txtDonGia,txtMoTa,txtError;
	private JComboBox<String> cbbNhaSX;
	private UtilDateModel modelHH;
	private UtilDateModel modelSX;
	private JDatePanelImpl pDateSX;
	private JDatePickerImpl dateSX;
	private Properties p;
	private JDatePanelImpl pDateHH;
	private JDatePickerImpl dateHH;
	private JButton btnSua,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private NhaSanXuat_DAO dsNCC;
	private Thuoc_DAO dsThuoc;
	private Thuoc thuoc;
	private Thuoc thuoc_moi;
	public SuaThongTinThuoc_GUI(Thuoc thuoc) {
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
		iconThem = new ImageIcon(new ImageIcon("images/themthuoc1.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconThemNSX = new ImageIcon(new ImageIcon("images/icon.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		bError = Box.createHorizontalBox();
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		modelSX = new UtilDateModel();
		pDateSX = new JDatePanelImpl(modelSX, p);
		dateSX = new JDatePickerImpl(pDateSX, new DateLabelFormatter());
		modelHH = new UtilDateModel();
		pDateHH = new JDatePanelImpl(modelHH, p);
		dateHH = new JDatePickerImpl(pDateHH, new DateLabelFormatter());
		
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
		bNgay.add(dateSX);
		bNgay.add(Box.createHorizontalStrut(30));
		bNgay.add(lblNgayHH = new JLabel("Ngày Hết Hạn:"));
		bNgay.add(dateHH);
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
		bNhaSX.add(cbbNhaSX = new JComboBox<String>());
		bNhaSX.add(Box.createHorizontalStrut(10));
		bMoTa.add(Box.createHorizontalStrut(10));
		bMoTa.add(lblMoTa = new JLabel("Mô Tả:"));
		bMoTa.add(txtMoTa = new JTextField());
		bMoTa.add(Box.createHorizontalStrut(10));
		bError.add(Box.createHorizontalStrut(10));
		bError.add(txtError = new JTextField());
		bError.add(Box.createHorizontalStrut(10));
		bbtn.add(btnSua = new JButton("Sửa Thông Tin Thuốc"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		
		lblMa.setPreferredSize(new Dimension(90,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblLoai.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySX.setPreferredSize(new Dimension(90,26));
		lblSoLuong.setPreferredSize(lblMa.getPreferredSize());
		lblNhaSX.setPreferredSize(lblMa.getPreferredSize());
		lblMoTa.setPreferredSize(lblMa.getPreferredSize());
		txtLoai.setPreferredSize(new Dimension(10,lblMa.getPreferredSize().height));
		dateSX.setPreferredSize(new Dimension(173,24));
		dateHH.setPreferredSize(new Dimension(163,24));
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
		cbbNhaSX.setBackground(Color.WHITE);
		txtMoTa.setBorder(BorderFactory.createEmptyBorder());
		txtMoTa.setBackground(Color.WHITE);
		txtError.setBorder(null);
		txtError.setEditable(false);
		btnSua.setIcon(iconThem);
		btnSua.setBackground(veryLightGreen);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnXoaTrang.setBackground(veryLightRed);
		
		
		dateHH.getJFormattedTextField().setBackground(Color.white);
		dateSX.getJFormattedTextField().setBackground(Color.white);
		dateHH.getJFormattedTextField().setBorder(null);
		dateSX.getJFormattedTextField().setBorder(null);
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bTitle = Box.createHorizontalBox());
		bTitle.add(lblTitle = new JLabel("SỬA THÔNG TIN THUỐC"));
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,25));
		lblTitle.setForeground(veryLightRed);
		txtMa.setEditable(false);
		
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
		bThem.add(bError);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bbtn);
		bThem.add(Box.createVerticalStrut(10));
				
		add(bThem);
		
		setSize(1000,400);
		setLocationRelativeTo(null);
		
		
		dsNCC = new NhaSanXuat_DAO();
		dsThuoc = new Thuoc_DAO();
		Connect_DB.getInstance().connect();
		capNhatNCC();
		loadData();
		
		btnSua.addActionListener(this);
		this.addWindowListener(this);
		btnXoaTrang.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnSua)) {
			java.util.Date sx = (java.util.Date) dateSX.getModel().getValue();
			java.util.Date hh = (java.util.Date) dateHH.getModel().getValue();
			String ma = txtMa.getText().trim();
			String ten = txtTen.getText().trim();
			String loai = txtLoai.getText().trim();
			String donVi = txtDonVi.getText().trim();
			int soLuong = Integer.parseInt(txtSOLuong.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			NhaSanXuat nsx = new NhaSanXuat(cbbNhaSX.getSelectedItem().toString());
			String moTa = txtMoTa.getText();
			thuoc_moi = new Thuoc(ma, ten, donVi, loai, donGia, new Date(sx.getYear(),sx.getMonth(),sx.getDate()),
					new Date(hh.getYear(),hh.getMonth(),hh.getDate()), soLuong, moTa, nsx);
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa thông tin thuốc !!!", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
			if(tl == JOptionPane.YES_OPTION) {
				if(dsThuoc.suaTTThuoc(thuoc_moi)) {
					ThemThuocMoi_GUI.reloadTable();
					DanhSachThuoc_GUI.reloadData();
					ThuocHetHan_GUI.reload();
					ThuocSapHetTonKho_GUI.reload();
					Load.NV_GUI.setEnabled(true);
					this.dispose();
				}
				else {
					System.out.println("Không sua dc");
				}
			}
		}else if(obj.equals(btnXoaTrang))
			xoaRongTextField();
	}
	private void capNhatNCC() {
		NhaSanXuat_DAO ds = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> ls = ds.layTTNhaSanXuat();
		for (NhaSanXuat nsx : ls) {
			cbbNhaSX.addItem(nsx.getMaNSX());
		}
	}
	public void loadData() {
		txtMa.setText(thuoc.getMaThuoc());
		txtTen.setText(thuoc.getTenThuoc());
		txtLoai.setText(thuoc.getLoaiThuoc());
		txtDonVi.setText(thuoc.getDonVi());
		modelSX.setValue(thuoc.getNgaySX());
		modelHH.setValue(thuoc.getNgayHH());
		txtSOLuong.setText(String.valueOf(thuoc.getSoLuong()));
		txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
		cbbNhaSX.setSelectedItem(thuoc.getNsx().getMaNSX());
		txtMoTa.setText(thuoc.getGhiChu());
	}
	public class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "dd-MM-yyyy";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}
	}
	private void xoaRongTextField() {
		txtTen.setText("");
		txtLoai.setText("");
		txtDonVi.setText("");
		dateHH.equals("");
		txtSOLuong.setText("");
		txtDonGia.setText("");
		cbbNhaSX.setSelectedItem("");
		txtMoTa.setText("");
		txtTen.setText("");
		
	}
	public Thuoc getThuocMoi() {
		return thuoc_moi;
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
