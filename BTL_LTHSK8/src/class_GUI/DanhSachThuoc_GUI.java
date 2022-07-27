package class_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableCell;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_Connection.Connect_DB;
import class_DAO.CT_HoaDon_DAO;
import class_DAO.HoaDon_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.Thuoc_DAO;
import class_Entity.CT_HoaDon;
import class_Entity.HoaDon;
import class_Entity.NhaSanXuat;
import class_Entity.Thuoc;

public class DanhSachThuoc_GUI extends JFrame implements ActionListener,MouseListener,WindowListener{
	private JPanel pDSThuoc,pTacVu;
	private JPanel pTimThuoc;
	private JPanel pTimL,pTimR;
	private Box bTKThuoc,bDSThuoc,bTKNhanh,bTKChiTiet,bBanNhieu,bBanItNhat,BDaHetHan,bMaThuoc,bTenThuoc,bDonViNgayHetHan,bNhaSXLoaiThuoc,bbtn;
	private JPanel pTblThuoc = new JPanel();
	private JRadioButton radThuocChuaBan,radDaHetHan;
	private JLabel lblMaThuoc,lblTenThuoc,lblDonVi,lblNgayHetHan,lblNhaSX,lblLoaiThuoc;
	private JTextField txtMaThuoc,txtTenThuoc,txtNgayHetHan,txtDonVi,txtLoai;
	private Border lineBlackBorder = BorderFactory.createLineBorder(Color.BLACK);
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private ButtonGroup gr;
	private static JComboBox<String> cbNSX;
	private Box bCen,bTacVu;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private Properties p;
	private static DefaultTableModel modeltbl;
	private JTable tbl;
	private JScrollPane scroll;
	private JButton btnTim,btnXoaTrang,btnSua,btnXoa,btnTKNhanh,btnThemSL,btnXemTT,btnReload;
	private ImageIcon iconTim,iconXoa,iconThem,iconXoaT,iconSua,iconXemTT,iconTimNhanh,iconReload;
	private static Thuoc_DAO dsThuoc ;
	private NhaSanXuat_DAO dsNCC;
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	private static ArrayList<Thuoc> arrThuoc;
	private String[] tblHeader = {"Mã Thuốc","Tên Thuốc","Đơn Vị","Ngày Sản Xuất","Ngày Hết Hạn","Nhà Sản Xuất",
			"Loại Thuốc","Số Lượng","Đơn Giá"}; 
	private DefaultTableCellRenderer cellRenderer;
	public void DanhSachThuoc(JPanel pCen) {
		iconTim = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconTimNhanh = new ImageIcon(new ImageIcon("images/TimKiem1.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		bCen = Box.createVerticalBox();
		pDSThuoc = new JPanel();
		pTimThuoc = new JPanel();
		pTimL = new JPanel();
		pTimR = new JPanel();
		bTKThuoc = Box.createHorizontalBox();
		bTKNhanh = Box.createVerticalBox();
		bTKChiTiet = Box.createVerticalBox();
		radThuocChuaBan = new JRadioButton("Thuốc Chưa Bán");
		radDaHetHan = new JRadioButton("Đã Hết Hạn");
		gr = new ButtonGroup();
		bMaThuoc = Box.createHorizontalBox();
		bTenThuoc = Box.createHorizontalBox();
		bDonViNgayHetHan = Box.createHorizontalBox();
		bNhaSXLoaiThuoc = Box.createHorizontalBox();
		modeltbl = new DefaultTableModel();
		bbtn = Box.createHorizontalBox();
		btnTim = new JButton("Tìm Kiếm");
		btnXoaTrang = new JButton("Xóa Trắng");
		btnTKNhanh = new JButton("Tìm Kiếm Nhanh");
		
		//Tim Kiem
		pTimThuoc.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm Thuốc"));
		bTKNhanh.setBorder(BorderFactory.createTitledBorder(lineBlackBorder, "Tìm Kiếm Nhanh"));
		bTKChiTiet.setBorder(BorderFactory.createTitledBorder(lineBlackBorder, "Tìm Kiếm Chi Tiết"));
		
		gr.add(radThuocChuaBan);
		gr.add(radDaHetHan);
		bTKNhanh.add(Box.createVerticalStrut(30));
		bTKNhanh.add(radThuocChuaBan);
		bTKNhanh.add(Box.createVerticalStrut(30));
		bTKNhanh.add(radDaHetHan);
		bTKNhanh.add(Box.createVerticalStrut(30));
		bTKNhanh.add(btnTKNhanh);
		bTKNhanh.add(Box.createVerticalStrut(10));
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		bMaThuoc.add(lblMaThuoc = new JLabel("Mã Thuốc:"));
		bMaThuoc.add(txtMaThuoc = new JTextField(61));
		bTenThuoc.add(lblTenThuoc = new JLabel("Tên Thuốc:"));
		bTenThuoc.add(txtTenThuoc = new JTextField());
		bDonViNgayHetHan.add(lblDonVi = new JLabel("Đơn Vị:"));
		bDonViNgayHetHan.add(txtDonVi = new JTextField());
		bDonViNgayHetHan.add(Box.createHorizontalStrut(10));
		bDonViNgayHetHan.add(lblNgayHetHan = new JLabel("Ngày Hết Hạn:"));
		bDonViNgayHetHan.add(datePicker);
		bNhaSXLoaiThuoc.add(lblNhaSX = new JLabel("Nhà Sản Xuất:"));
		bNhaSXLoaiThuoc.add(cbNSX = new JComboBox<>());
		bNhaSXLoaiThuoc.add(Box.createHorizontalStrut(10));
		bNhaSXLoaiThuoc.add(lblLoaiThuoc = new JLabel("Loại Thuốc:"));
		bNhaSXLoaiThuoc.add(txtLoai = new JTextField());
		bbtn.add(btnTim);
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang);
		btnTim.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		btnTim.setIcon(iconTim);
		btnXoaTrang.setIcon(iconXoa);
		
		int w = 100;
		int h = 24;
		btnTKNhanh.setIcon(iconTimNhanh);
		btnTKNhanh.setBackground(lightBlue);
		lblMaThuoc.setPreferredSize(new Dimension(w,h));
		lblTenThuoc.setPreferredSize(new Dimension(w,h));
		lblDonVi.setPreferredSize(new Dimension(w,h));
		lblNhaSX.setPreferredSize(new Dimension(w,h));
		lblNgayHetHan.setPreferredSize(new Dimension(w,h));
		lblLoaiThuoc.setPreferredSize(new Dimension(w,h));
		txtMaThuoc.setBorder(null);
		txtTenThuoc.setBorder(null);
		cbNSX.setBackground(Color.WHITE);
		datePicker.getJFormattedTextField().setBackground(Color.white);
		datePicker.getJFormattedTextField().setBorder(null);
		txtLoai.setBorder(null);
		txtDonVi.setBorder(null);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKChiTiet.add(bMaThuoc);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKChiTiet.add(bTenThuoc);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKChiTiet.add(bDonViNgayHetHan);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKChiTiet.add(bNhaSXLoaiThuoc);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKChiTiet.add(bbtn);
		bTKChiTiet.add(Box.createVerticalStrut(10));
		bTKThuoc.add(bTKNhanh);
		bTKThuoc.add(bTKChiTiet);
		pTimThuoc.add(bTKThuoc);
		//pDSThuoc.add(pTimThuoc);
		//bCen.add(pDSThuoc);
		bCen.add(pTimThuoc);
		//bCen.add(Box.createHorizontalStrut(30));
		pCen.add(bCen);
		
		btnXoaTrang.addActionListener(this);
		//Table
		modeltbl = new DefaultTableModel(tblHeader,0);
		tbl = new JTable(modeltbl);
		scroll = new JScrollPane(tbl);
		bDSThuoc = Box.createHorizontalBox();
		
		pDSThuoc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(lightBlue), "Danh Sách Thuốc"));
		scroll.setPreferredSize(new Dimension(940,260));
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		
		bDSThuoc.add(scroll);
		pDSThuoc.add(bDSThuoc);
		bCen.add(pDSThuoc);
		
		//Tac Vu
		pTacVu = new JPanel();
		bTacVu = Box.createHorizontalBox();
		btnXoa = new JButton("Xóa Thuốc");
		btnSua = new JButton("Sửa Thông Tin Thuốc");
		btnXemTT = new JButton("Xem Thông Tin Thuốc");
		btnThemSL = new JButton("Thêm Số Lượng");
		iconThem = new ImageIcon(new ImageIcon("images/ThemThuoc3.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaT = new ImageIcon(new ImageIcon("images/Xoa2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXemTT = new ImageIcon(new ImageIcon("images/XemTT.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		
		pTacVu.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tác Vụ"));
		btnXoa.setIcon(iconXoaT);
		btnSua.setIcon(iconSua);
		btnXemTT.setIcon(iconXemTT);
		btnThemSL.setIcon(iconThem);
		btnXoa.setBackground(veryLightRed);
		btnSua.setBackground(veryLightGreen);
		btnXemTT.setEnabled(false);
		btnThemSL.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		
		bTacVu.add(btnXoa);
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnSua);
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnXemTT);
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnReload = new JButton(""));
		pTacVu.add(bTacVu);
		bCen.add(pTacVu);
		btnReload.setIcon(iconReload);
		btnReload.setBackground(lightBlue);
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,### VND");
		
		dsThuoc = new Thuoc_DAO();
		dsNCC = new NhaSanXuat_DAO();
		Connect_DB.getInstance().connect();
		docDuLieuVaoBang();
		capNhatNCC();
		
		tbl.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemTT.addActionListener(this);
		btnTim.addActionListener(this);
		btnReload.addActionListener(this);
		btnTKNhanh.addActionListener(this);
	}
	
	public static void capNhatNCC() {
		cbNSX.removeAllItems();
		cbNSX.addItem("");
		NhaSanXuat_DAO ds = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> ls = ds.layTTNhaSanXuat();
		for (NhaSanXuat nsx : ls) {
			cbNSX.addItem(nsx.getMaNSX());
		}
		cbNSX.setSelectedItem("");
	}
	
	public static void docDuLieuVaoBang() {
		dsThuoc = new Thuoc_DAO();
		arrThuoc = new ArrayList<Thuoc>();
		arrThuoc = dsThuoc.layTTThuoc();
		for (Thuoc t : arrThuoc) {
			modeltbl.addRow(new Object[] {t.getMaThuoc(), t.getTenThuoc(), t.getDonVi(), 
					sdf.format(t.getNgaySX()), sdf.format(t.getNgayHH()),t.getNsx().getMaNSX(),
					t.getLoaiThuoc(), t.getSoLuong(), 
					df.format(t.getDonGia())});
		}
	}
	public void thuocHetHan() {
		while(modeltbl.getRowCount()>0)
			modeltbl.removeRow(0);
		dsThuoc = new Thuoc_DAO();
		ArrayList<Thuoc> ls = dsThuoc.layTTThuoc();
		ArrayList<Thuoc> lsHH = new ArrayList<Thuoc>();
		for (Thuoc t : ls) {
			if (t.getNgayHH().toLocalDate().compareTo(LocalDate.now()) < 0) {
				lsHH.add(t); 
			}
		}
		for (Thuoc hh : lsHH) {
			modeltbl.addRow(new Object[] {hh.getMaThuoc(), hh.getTenThuoc(), hh.getLoaiThuoc(), hh.getDonVi(), 
					sdf.format(hh.getNgaySX()), sdf.format(hh.getNgayHH()), hh.getSoLuong(), df.format(hh.getDonGia()),
					hh.getNsx().getMaNSX()});
		}
	}
	public void thuocChuaBan() {
		List<Thuoc> dsthuocChuaBan = new ArrayList<Thuoc>();
		Thuoc_DAO thDao = new Thuoc_DAO();
		CT_HoaDon_DAO ctDao = new CT_HoaDon_DAO();
		ArrayList<Thuoc> dsth = new ArrayList<Thuoc>();
		ArrayList<CT_HoaDon> dscthd1 = new ArrayList<CT_HoaDon>();
		dsth = thDao.layTTThuoc();
		dscthd1 = ctDao.layDuLieuTuDB();
		while(modeltbl.getRowCount()>0)
			modeltbl.removeRow(0);
		for(Thuoc t : dsth) {
			int f = 0;
			for(CT_HoaDon ct : dscthd1) {
				if(ct.getMaThuoc().getMaThuoc().trim().equals(t.getMaThuoc().trim()))
					f++;
			}
			if(f==0) {
				modeltbl.addRow(new Object[] {t.getMaThuoc().trim(), t.getTenThuoc(), t.getDonVi(), 
						sdf.format(t.getNgaySX()), sdf.format(t.getNgayHH()),t.getNsx().getMaNSX(),
						t.getLoaiThuoc(), t.getSoLuong(), 
						df.format(t.getDonGia())});
			}
		}
	}
	
	public void tim() {
		String maThuoc = txtMaThuoc.getText().trim();
		String tenThuoc = txtTenThuoc.getText().trim();
		String donVi = txtDonVi.getText().trim();
		String ngayHH = datePicker.getJFormattedTextField().getText().trim();
		String nsx = cbNSX.getSelectedItem().toString().trim();
		String loaiThuoc = txtLoai.getText().trim();
		ArrayList<Thuoc> ls = new ArrayList<Thuoc>();
		timMa(ls, maThuoc);
		System.out.println(ls);
		ls = timTen(ls, tenThuoc);
		ls = timDonVi(ls, donVi);
		ls = timNgayHH(ls, ngayHH);
		ls = timNhaSX(ls, nsx);
		ls = timLoaiThuoc(ls, loaiThuoc);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc trong danh sách !!!");
			while (modeltbl.getRowCount() > 0) {
				modeltbl.removeRow(0);
			}
		}
		deleteTable();
		for (Thuoc t : ls) {
			modeltbl.addRow(new Object[] {t.getMaThuoc().trim(), t.getTenThuoc(), t.getDonVi(), 
					sdf.format(t.getNgaySX()), sdf.format(t.getNgayHH()),t.getNsx().getMaNSX(),
					t.getLoaiThuoc(), t.getSoLuong(), 
					df.format(t.getDonGia())});
		}
	}
	
	public ArrayList<Thuoc> timMa(ArrayList<Thuoc> listThuoc, String maThuoc) {
		Thuoc_DAO ds = new Thuoc_DAO();
		ArrayList<Thuoc> ls = ds.layTTThuoc();
		Pattern pattern = Pattern.compile(".*" + maThuoc + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : ls) {
			Matcher matcher = pattern.matcher(t.getMaThuoc().trim());
			if (matcher.matches()) {
				listThuoc.add(t);
			}
		}
		return listThuoc;
	}
	
	public ArrayList<Thuoc> timTen(ArrayList<Thuoc> listThuoc, String tenThuoc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		Pattern pattern = Pattern.compile(".*" + tenThuoc + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : listThuoc) {
			Matcher matcher = pattern.matcher(t.getTenThuoc().trim());
			if (matcher.matches()) {
				ds.add(t);
			}
		}
		return ds;
	}
	
	public ArrayList<Thuoc> timDonVi(ArrayList<Thuoc> listThuoc, String donVi) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		Pattern pattern = Pattern.compile(".*" + donVi + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : listThuoc) {
			Matcher matcher = pattern.matcher(t.getDonVi().trim());
			if (matcher.matches()) {
				ds.add(t);
			}
		}
		return ds;
	}
	
	public ArrayList<Thuoc> timNgayHH(ArrayList<Thuoc> listThuoc, String ngayHH) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		Pattern pattern = Pattern.compile(".*" + ngayHH + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : listThuoc) {
			Matcher matcher = pattern.matcher(sdf.format(t.getNgayHH()).trim());
			if (matcher.matches()) {
				ds.add(t);
			}
		}
		return ds;
	}
	
	public ArrayList<Thuoc> timNhaSX(ArrayList<Thuoc> listThuoc, String nhaSX) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		Pattern pattern = Pattern.compile(".*" + nhaSX + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : listThuoc) {
			Matcher matcher = pattern.matcher(t.getNsx().getMaNSX().trim());
			if (matcher.matches()) {
				ds.add(t);
			}
		}
		return ds;
	}
	
	public ArrayList<Thuoc> timLoaiThuoc(ArrayList<Thuoc> listThuoc, String loaiThuoc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		Pattern pattern = Pattern.compile(".*" + loaiThuoc + ".*", Pattern.CASE_INSENSITIVE);
		for (Thuoc t : listThuoc) {
			Matcher matcher = pattern.matcher(t.getLoaiThuoc().trim());
			if (matcher.matches()) {
				ds.add(t);
			}
		}
		return ds;
	}
	
	public void deleteTable() {
		DefaultTableModel dm = (DefaultTableModel)tbl.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrang)) {
			txtMaThuoc.setText(null);
			txtTenThuoc.setText(null);
			datePicker.getJFormattedTextField().setText(null);
			txtDonVi.setText("");
			cbNSX.setSelectedIndex(0);
			txtLoai.setText("");
		}
		else if(obj.equals(btnXoa)) {
			int row = tbl.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần xóa!");
			} else {
				//btnXoa.setEnabled(true);
				if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thuốc này?", "Cảnh báo!", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String maThuoc = tbl.getValueAt(row, 0).toString();
					dsThuoc.xoaThuoc(maThuoc);
					modeltbl.removeRow(row);
					ThemThuocMoi_GUI.reloadTable();
				}
			}
		}else if(obj.equals(btnSua)) {
			int row = tbl.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần sửa !!!");
			else {
				String ma = modeltbl.getValueAt(row, 0).toString().trim();
				SuaThongTinThuoc_GUI t = new SuaThongTinThuoc_GUI(dsThuoc.getThuoc(ma));
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
		else if (obj.equals(btnTim)) {
			try {
				tim();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(obj.equals(btnReload)) {
			reloadData();
		}else if(obj.equals(btnXemTT)) {
			int row = tbl.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuốc !!!");
			} else {
					String maThuoc = tbl.getValueAt(row, 0).toString().trim();
					XemThongTinThuoc_GUI t = new XemThongTinThuoc_GUI(dsThuoc.getThuoc(maThuoc));
					t.setVisible(true);
					Load.NV_GUI.setEnabled(false);
			}
		}
		else if(obj.equals(btnTKNhanh)) {
			if(radDaHetHan.isSelected())
				thuocHetHan();
			if(radThuocChuaBan.isSelected()) {
				thuocChuaBan();
			}
		}
	}
	public static void reloadData() {
		while(modeltbl.getRowCount()>0)
			modeltbl.removeRow(0);
		capNhatNCC();
		docDuLieuVaoBang();
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
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			btnXemTT.setEnabled(true);
			btnXoa.setEnabled(true);
			btnSua.setEnabled(true);
		}
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
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
