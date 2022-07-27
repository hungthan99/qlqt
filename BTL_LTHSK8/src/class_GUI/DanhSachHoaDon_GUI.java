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
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_DAO.CT_HoaDon_DAO;
import class_DAO.HoaDon_DAO;
import class_DAO.Thuoc_DAO;
import class_Entity.CT_HoaDon;
import class_Entity.HoaDon;
import class_Entity.Thuoc;
import class_GUI.DanhSachThuoc_GUI.DateLabelFormatter;

public class DanhSachHoaDon_GUI extends JFrame implements MouseListener,ActionListener {
	private Box b,btk;
	private Box bh1HD;
	private Box bh2HD;
	private Box bh3HD;
	private JLabel lblMaHD;
	private JTextField txtMaHD;
	private JLabel lblNgayLapHD;
	private JTextField txtGhiChu;
	private JLabel lblMaNV;
	private JLabel lblMaBN;
	private static DefaultTableModel mdlHoaDon;
	private JTable tblHoaDon;
	private JScrollPane scrollHD;
	private JTextField txtNV,txtBenhNhan;
	private Box bh4HD;
	private Box bh5HD;
	private JButton btnTim,btnXoa,btnXemTT,btnXoaTrang,btnReload;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private ImageIcon iconTim,iconSua,iconXoa,iconXemTT,iconChon,iconXoaTrang,iconReload;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private Properties p;
	private DefaultTableCellRenderer cellRenderer;
	private static HoaDon_DAO hd_dao;
	private static CT_HoaDon_DAO cthd_dao;
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	public void DanhSachHoaDon_GUI(JPanel panel) {
		hd_dao = new HoaDon_DAO();
		iconTim = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/Xoa2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXemTT = new ImageIcon(new ImageIcon("images/XemTT.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconChon = new ImageIcon(new ImageIcon("images/Chon.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		btk = Box.createVerticalBox();
		bh1HD = Box.createHorizontalBox();
		bh2HD = Box.createHorizontalBox();
		bh3HD = Box.createHorizontalBox();
		bh4HD = Box.createHorizontalBox();
		bh5HD = Box.createHorizontalBox();
		bh1HD.add(Box.createHorizontalStrut(10));
		bh1HD.add(lblMaHD = new JLabel("Mã Hóa Đơn: "));
		lblMaHD.setPreferredSize(new Dimension(100, 25));
		bh1HD.add(txtMaHD = new JTextField());
		bh1HD.add(Box.createHorizontalStrut(30));
		bh1HD.add(lblNgayLapHD = new JLabel("Ngày Lập: "));
		lblNgayLapHD.setPreferredSize(lblMaHD.getPreferredSize());
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		bh1HD.add(datePicker);
		bh1HD.add(Box.createHorizontalStrut(10));
		datePicker.getJFormattedTextField().setPreferredSize(new Dimension(333,25));
		bh2HD.add(Box.createHorizontalStrut(10));
		bh2HD.add(lblMaNV = new JLabel("Nhân Viên Lập: "));
		lblMaNV.setPreferredSize(lblNgayLapHD.getPreferredSize());
		bh2HD.add(txtNV = new JTextField());
		bh2HD.add(Box.createHorizontalStrut(30));
		bh2HD.add(lblMaBN = new JLabel("Bệnh Nhân: "));
		lblMaBN.setPreferredSize(lblMaNV.getPreferredSize());
		bh2HD.add(txtBenhNhan = new JTextField());
		bh2HD.add(Box.createHorizontalStrut(10));
		String[] TitleHoaDon = {"Mã Hóa Đơn", "Ngày Lập Hóa Đơn", "Mã Nhân Viên", "Mã Bệnh Nhân","Thành Tiền"};
		mdlHoaDon = new DefaultTableModel(TitleHoaDon, 0);
		tblHoaDon = new JTable(mdlHoaDon);
		tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollHD = new JScrollPane(tblHoaDon);
		setColorHeaderTable(lightBlue);
		btnTim = new JButton("Tìm Kiếm");
		btnTim.setIcon(iconTim);
		bh3HD.add(btnTim);
		bh3HD.add(Box.createHorizontalStrut(30));
		bh3HD.add(btnXoaTrang = new JButton("Xóa Trắng"));
		btnXoaTrang.setIcon(iconXoaTrang);
		btnXoaTrang.setBackground(veryLightRed);
		btnTim.setBackground(lightBlue);
		bh5HD.add(Box.createHorizontalStrut(240));
		bh5HD.add(btnXoa = new JButton("Xóa Hóa Đơn"));
		bh5HD.add(Box.createHorizontalStrut(10));
		bh5HD.add(btnXemTT = new JButton("Xem Chi Tiết Hóa Đơn"));
		bh5HD.add(Box.createHorizontalStrut(10));
		bh5HD.add(btnReload = new JButton());
		bh5HD.add(Box.createHorizontalStrut(240));
		btnXoa.setIcon(iconXoa);
		btnXemTT.setIcon(iconXemTT);
		btnXoa.setBackground(veryLightRed);
		btnXemTT.setBackground(lightBlue);
		btnXoa.setEnabled(false);
		btnXemTT.setEnabled(false);
		txtMaHD.setBorder(null);
		txtMaHD.setBackground(Color.WHITE);
		datePicker.getJFormattedTextField().setBorder(null);
		datePicker.getJFormattedTextField().setBackground(Color.WHITE);
		txtNV.setBorder(null);
		txtBenhNhan.setBorder(null);
		btnReload.setIcon(iconReload);
		
		btk.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		bh4HD.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Hóa Đơn"));
		bh5HD.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tác Vụ"));
		scrollHD.setPreferredSize(new Dimension(940,380));
		scrollHD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		btk.add(Box.createVerticalStrut(10));
		btk.add(bh1HD);
		btk.add(Box.createVerticalStrut(10));
		btk.add(bh2HD);
		btk.add(Box.createVerticalStrut(10));
		btk.add(bh3HD);
		btk.add(Box.createVerticalStrut(10));
		
		bh4HD.add(Box.createHorizontalStrut(10));
		bh4HD.add(scrollHD);
		bh4HD.add(Box.createHorizontalStrut(10));
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,### VND");
		
		b.add(btk);
		b.add(bh4HD);
		b.add(bh5HD);
		
		panel.add(b);
		
		taiDuLieuVaoBang();
		
		btnXemTT.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		tblHoaDon.addMouseListener(this);
		btnXoaTrang.addActionListener(this);
		btnReload.addActionListener(this);
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
        for(int i=0;i<5;i++){

            //i is the column of the table header
            TableColumn column = tblHoaDon.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public static void taiDuLieuVaoBang() {
		hd_dao = new HoaDon_DAO();
		ArrayList<HoaDon> ds = hd_dao.layDuLieuTuDB();
		for(HoaDon h : ds)
			mdlHoaDon.addRow(new Object[] {
					h.getMaHD(),sdf.format(h.getNgayLap()),h.getMaNhanVien().getMaNV(),h.getMaBenhNhan().getMaBenhNhan(),df.format(h.getThanhTien())
			});
		cthd_dao = new CT_HoaDon_DAO();
		cthd_dao.layDuLieuTuDB();
	}
	public static void reLoadData() {
		while(mdlHoaDon.getRowCount()>0)
			mdlHoaDon.removeRow(0);
		taiDuLieuVaoBang();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTim)) {
			try {
				timKiem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(obj.equals(btnXoa)) {
			int row = tblHoaDon.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn !!!");
			else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa hóa đơn này !!!","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(tl==JOptionPane.YES_OPTION) {
					String ma = mdlHoaDon.getValueAt(row, 0).toString();
					if(cthd_dao.xoaChiTietHoaDon(ma)) {
						if(hd_dao.xoaHoaDon(ma)) {
							reLoadData();
							ThemHoaDon_GUI.reLoad();
						}
					}
				}
			}
		}else if(obj.equals(btnXemTT)){
			int row = tblHoaDon.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn !!!");
			else {
				String ma = mdlHoaDon.getValueAt(row, 0).toString().trim();
				XemThongTinHoaDon_GUI t = new XemThongTinHoaDon_GUI(ma);
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
		if(obj.equals(btnXoaTrang)) {
			txtBenhNhan.setText("");
			txtGhiChu.setText("");
			txtMaHD.setText("");
			txtNV.setText("");
		}
		if(obj.equals(btnReload)) {
			reLoadData();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblHoaDon.getSelectedRow();
		if(row != -1) {
			btnXoa.setEnabled(true);
			btnXemTT.setEnabled(true);
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
	
	public void timKiem() {
		String maHD = txtMaHD.getText().trim();
		String ngayLap = datePicker.getJFormattedTextField().getText().trim();
		String nhanVien = txtNV.getText().trim();
		String benhNhan = txtBenhNhan.getText().trim();
		ArrayList<HoaDon> ls = new ArrayList<HoaDon>();
		timMa(ls, maHD);
		System.out.println(ls);
		ls = timNgayLap(ls, ngayLap);
		ls = timNhanVien(ls, nhanVien);
		ls = timBenhNhan(ls, benhNhan);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn trong danh sách !!!");
			while (mdlHoaDon.getRowCount() > 0) {
				mdlHoaDon.removeRow(0);
			}
		}
		deleteTable();
		for (HoaDon hd : ls) {
			mdlHoaDon.addRow(new Object[] {
					hd.getMaHD(),sdf.format(hd.getNgayLap()),hd.getMaNhanVien().getMaNV(),hd.getMaBenhNhan().getMaBenhNhan(),df.format(hd.getThanhTien())
			});
		}
	}
	
	public ArrayList<HoaDon> timMa(ArrayList<HoaDon> list, String maHD) {
		HoaDon_DAO ds = new HoaDon_DAO();
		ArrayList<HoaDon> ls = ds.layDuLieuTuDB();
		Pattern pattern = Pattern.compile(".*" + maHD + ".*", Pattern.CASE_INSENSITIVE);
		for (HoaDon hd : ls) {
			Matcher matcher = pattern.matcher(hd.getMaHD().trim());
			if (matcher.matches()) {
				list.add(hd);
			}
		}
		return list;
	}
	
	public ArrayList<HoaDon> timNgayLap(ArrayList<HoaDon> list, String ngayLapHD) {
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		Pattern pattern = Pattern.compile(".*" + ngayLapHD + ".*", Pattern.CASE_INSENSITIVE);
		for (HoaDon hd : list) {
			Matcher matcher = pattern.matcher(sdf.format(hd.getNgayLap()).trim());
			if (matcher.matches()) {
				ds.add(hd);
			}
		}
		return ds;
	}
	
	public ArrayList<HoaDon> timNhanVien(ArrayList<HoaDon> list, String nhanVien) {
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		Pattern pattern = Pattern.compile(".*" + nhanVien + ".*", Pattern.CASE_INSENSITIVE);
		for (HoaDon hd : list) {
			Matcher matcher = pattern.matcher(hd.getMaNhanVien().getMaNV().trim());
			if (matcher.matches()) {
				ds.add(hd);
			}
		}
		return ds;
	}
	
	public ArrayList<HoaDon> timBenhNhan(ArrayList<HoaDon> list, String benhNhan) {
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		Pattern pattern = Pattern.compile(".*" + benhNhan + ".*", Pattern.CASE_INSENSITIVE);
		for (HoaDon hd : list) {
			Matcher matcher = pattern.matcher(hd.getMaBenhNhan().getMaBenhNhan().trim());
			if (matcher.matches()) {
				ds.add(hd);
			}
		}
		return ds;
	}
	
	public void deleteTable() {
		DefaultTableModel dm = (DefaultTableModel)tblHoaDon.getModel();
		dm.getDataVector().removeAllElements();
	}
}
