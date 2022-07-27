package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_Connection.Connect_DB;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.Thuoc_DAO;
import class_Entity.NhaSanXuat;
import class_Entity.Thuoc;
import class_GUI.DanhSachThuoc_GUI.DateLabelFormatter;

public class ThemThuocMoi_GUI extends JFrame implements ActionListener,MouseListener{
	private Box b,bThem,bDanhSach;
	private Box bMa,bTen,bLoaiDonVi,bNgay,bSLDonGia,bNhaSX,bMoTa,bbtn,bError;
	private JLabel lblMa,lblTen,lblLoai,lblDonVi,lblNgaySX,lblNgayHH,lblSoLuong,lblDonGia,lblNhaSX,lblMoTa;
	private JTextField txtMa,txtTen,txtDonVi,txtLoai,txtSOLuong,txtDonGia,txtMoTa,txtError;
	private static JComboBox<String> cbbNhaSX;
	private JScrollPane scroll;
	private JTable tbl;
	private static DefaultTableModel model;
	private UtilDateModel modelHH;
	private UtilDateModel modelSX;
	private JDatePanelImpl pDateSX;
	private JDatePickerImpl dateSX;
	private Properties p;
	private JDatePanelImpl pDateHH;
	private JDatePickerImpl dateHH;
	private JButton btnThem,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private ImageIcon iconThem,iconXoaTrang;
	private String[] header = {"Mã Thuốc","Tên Thuốc","Đơn Vị","Ngày Sản Xuất","Ngày Hết Hạn","Nhà Sản Xuất","Loại Thuốc","Số Lượng","Đơn Giá"};
	private DefaultTableCellRenderer cellRenderer;
	private static Thuoc_DAO dsThuoc;
	private NhaSanXuat_DAO dsNCC;
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	
	public void ThemThuoc_GUI(JPanel pen) {
		//Them Thuoc
		b = Box.createVerticalBox();
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
		txtLoai.setPreferredSize(new Dimension(10,lblMa.getPreferredSize().height));
		dateSX.setPreferredSize(new Dimension(173,24));
		dateHH.setPreferredSize(new Dimension(163,24));
		lblDonVi.setPreferredSize(new Dimension(100,lblMa.getPreferredSize().height));
		lblNgayHH.setPreferredSize(new Dimension(100,24));
		lblDonGia.setPreferredSize(new Dimension(100,24));
		
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Thêm Thuốc"));
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
		btnThem.setIcon(iconThem);
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnXoaTrang.setBackground(veryLightRed);
		
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
				
		//Danh Sach Thuoc
		bDanhSach = Box.createHorizontalBox();
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		
		bDanhSach.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Thuốc"));
		scroll.setPreferredSize(new Dimension(940,230));
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		
		bDanhSach.add(Box.createHorizontalStrut(10));
		bDanhSach.add(scroll);
		bDanhSach.add(Box.createHorizontalStrut(10));
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,### VND");
		
		dsThuoc = new class_DAO.Thuoc_DAO();
		dsNCC = new NhaSanXuat_DAO();
		Connect_DB.getInstance().connect();
		docDuLieuVaoBang();
		capNhatNCC();
		
		b.add(bThem);
		b.add(Box.createVerticalStrut(10));
		b.add(bDanhSach);
		pen.add(b);
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tbl.addMouseListener(this);
		
		
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
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<9;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			if (txtMa.getText().equals("") || txtTen.getText().equals("") || dateSX.equals("") || dateHH.equals("") 
					|| txtSOLuong.getText().equals("") || txtDonGia.getText().equals("") || 
					txtMoTa.getText().equals("") || txtLoai.getText().equals("") || 
					txtDonVi.getText().equals("") || cbbNhaSX.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin vào form trước khi thêm!");
			} else {
				java.util.Date sx = (java.util.Date) dateSX.getModel().getValue();
				java.util.Date hh = (java.util.Date) dateHH.getModel().getValue();
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				String loai = txtLoai.getText();
				String donVi = txtDonVi.getText();
				int soLuong = Integer.parseInt(txtSOLuong.getText());
				double donGia = Double.parseDouble(txtDonGia.getText());
				NhaSanXuat nsx = new NhaSanXuat(cbbNhaSX.getSelectedItem().toString());
				String moTa = txtMoTa.getText();
				Thuoc t = new Thuoc(ma, ten, donVi, loai, donGia, new Date(sx.getYear(),sx.getMonth(),sx.getDate()),
						new Date(hh.getYear(),hh.getMonth(),hh.getDate()), soLuong, moTa, nsx);
				if(kiemTraDuLieuNhapVao()) {
					if (dsThuoc.themThuoc(t)) {
						reloadTable();
						DanhSachThuoc_GUI.reloadData();
					} else {
						JOptionPane.showMessageDialog(this, "Trùng mã! Yêu cầu nhập lại!");
						txtMa.selectAll();
						txtMa.requestFocus();
					}
				}
			}
		} else if (obj.equals(btnXoaTrang)) {
			xoaRongTextField();
		}	
	}
	public static void capNhatNCC() {
		NhaSanXuat_DAO ds = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> ls = ds.layTTNhaSanXuat();
		for (NhaSanXuat nsx : ls) {
			cbbNhaSX.addItem(nsx.getMaNSX());
		}
	}
	
	private static void docDuLieuVaoBang() {
		dsThuoc = new Thuoc_DAO();
		ArrayList<Thuoc> ls = dsThuoc.layTTThuoc();
		for (Thuoc t : ls) {
			model.addRow(new Object[] {t.getMaThuoc(), t.getTenThuoc(), t.getDonVi(), 
					sdf.format(t.getNgaySX()), sdf.format(t.getNgayHH()),t.getNsx().getMaNSX(),
					t.getLoaiThuoc(), t.getSoLuong(), 
					df.format(t.getDonGia())});
		}
	}
	public static void reloadTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		capNhatNCC();
		docDuLieuVaoBang();
	}
	private void xoaRongTextField() {
		txtMa.setText("");
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
	private boolean kiemTraDuLieuNhapVao() {
		if (txtMa.getText().matches("T\\d{4}") == false) {
			JOptionPane.showMessageDialog(this, "Mã nhập sai định dạng: Txxxx, với x là số!");
			txtMa.selectAll();
			txtMa.requestFocus();
			return false;
		}
		try {
			Integer.parseInt(txtSOLuong.getText());
			try {
				Double.parseDouble(txtDonGia.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "đơn giá phải nhập số!");
				txtDonGia.selectAll();
				txtDonGia.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "số lượng phải nhập số!");
			txtSOLuong.selectAll();
			txtSOLuong.requestFocus();
			return false;
		}
		return true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		Thuoc t = dsThuoc.getThuoc(tbl.getValueAt(row, 0).toString().trim()); 
		txtMa.setText(t.getMaThuoc());
		txtTen.setText(t.getTenThuoc());
		txtDonVi.setText(t.getDonVi());
		modelSX.setValue(t.getNgaySX());
		modelHH.setValue(t.getNgayHH());
		cbbNhaSX.setSelectedItem(t.getNsx().getMaNSX());
		txtLoai.setText(t.getLoaiThuoc());
		txtSOLuong.setText(String.valueOf(t.getSoLuong()));
		txtDonGia.setText(String.valueOf(t.getDonGia()));
		txtMoTa.setText(t.getGhiChu());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
