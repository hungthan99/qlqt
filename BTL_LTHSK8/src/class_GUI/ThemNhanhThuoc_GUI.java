package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_GUI.ThemThuocMoi_GUI.DateLabelFormatter;

public class ThemNhanhThuoc_GUI extends JFrame implements ActionListener,WindowListener{
	private JPanel panel;
	private Box bThem;
	private Box bMa,bTen,bLoaiDonVi,bNgay,bSLDonGia,bNhaSX,bMoTa,bbtn,bError;
	private JLabel lblMa,lblTen,lblLoai,lblDonVi,lblNgaySX,lblNgayHH,lblSoLuong,lblDonGia,lblNhaSX,lblMoTa;
	private JTextField txtMa,txtTen,txtDonVi,txtSOLuong,txtDonGia,txtMoTa,txtError;
	private JButton btnThem,btnXoaTrang;
	private JComboBox<String> cbbLoai,cbbNhaSX;
	private UtilDateModel modelHH;
	private UtilDateModel modelSX;
	private JDatePanelImpl pDateSX;
	private JDatePickerImpl dateSX;
	private Properties p;
	private JDatePanelImpl pDateHH;
	private JDatePickerImpl dateHH;
	private ImageIcon iconThem,iconXoaTrang,iconThemNSX;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private JButton btnThemNSX;
	public ThemNhanhThuoc_GUI() {
		setTitle("Thêm Thuốc Mới");
		setSize(800,400);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		bThem = Box.createVerticalBox();
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
		bLoaiDonVi.add(cbbLoai = new JComboBox<String>());
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
		bNhaSX.add(btnThemNSX = new JButton("Thêm Nhà Sản Xuất"));
		bNhaSX.add(Box.createHorizontalStrut(10));
		bNhaSX.add(Box.createHorizontalStrut(10));
		bMoTa.add(Box.createHorizontalStrut(10));
		bMoTa.add(lblMoTa = new JLabel("Mô Tả:"));
		bMoTa.add(txtMoTa = new JTextField());
		bMoTa.add(Box.createHorizontalStrut(10));
		bError.add(Box.createHorizontalStrut(10));
		bError.add(txtError = new JTextField());
		bError.add(Box.createHorizontalStrut(10));
		bbtn.add(btnThem = new JButton("Thêm Thuốc"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		
		lblMa.setPreferredSize(new Dimension(90,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblLoai.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySX.setPreferredSize(new Dimension(90,26));
		lblSoLuong.setPreferredSize(lblMa.getPreferredSize());
		lblNhaSX.setPreferredSize(lblMa.getPreferredSize());
		lblMoTa.setPreferredSize(lblMa.getPreferredSize());
		cbbLoai.setPreferredSize(new Dimension(270,lblMa.getPreferredSize().height));
		dateSX.setPreferredSize(new Dimension(173,24));
		dateHH.setPreferredSize(new Dimension(163,24));
		lblDonVi.setPreferredSize(new Dimension(100,lblMa.getPreferredSize().height));
		lblNgayHH.setPreferredSize(new Dimension(100,24));
		lblDonGia.setPreferredSize(new Dimension(100,24));
		
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Thêm Thuốc"));
		bThem.setPreferredSize(new Dimension(780,350));
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		cbbLoai.setBackground(Color.WHITE);
		txtDonVi.setBorder(null);
		txtSOLuong.setBorder(null);
		txtDonGia.setBorder(null);
		cbbNhaSX.setBackground(Color.WHITE);
		txtMoTa.setBorder(BorderFactory.createEmptyBorder());
		txtMoTa.setBackground(Color.WHITE);
		txtError.setBorder(null);
		txtError.setEditable(false);
		btnThem.setIcon(iconThem);
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnXoaTrang.setBackground(veryLightRed);
		btnThemNSX.setBackground(lightBlue);
		btnThemNSX.setIcon(iconThemNSX);
		
		dateHH.getJFormattedTextField().setBackground(Color.white);
		dateSX.getJFormattedTextField().setBackground(Color.white);
		dateHH.getJFormattedTextField().setBorder(null);
		dateSX.getJFormattedTextField().setBorder(null);
		
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
		
		panel.add(bThem);
		add(panel);
		
		btnThem.addActionListener(this);
		addWindowListener(this);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			//System.exit(0);
		}
		
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

}
