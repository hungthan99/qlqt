package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import class_Entity.BenhNhan;
import class_Entity.CT_HoaDon;
import class_Entity.HoaDon;
import class_Entity.NhanVien;
import class_Entity.Thuoc;
import class_GUI.DanhSachThuoc_GUI.DateLabelFormatter;

public class ThemHoaDon_GUI extends JFrame implements ActionListener{
	private Box b,bThem,bbtn,bbtn1;
	private Box bh1HD;
	private Box bh2HD,bh3HD,bh33HD;
	private Box bh4HD,bh6HD,bDSTT,bDS,bTT;
	private JLabel lblMaHD,lblGhiChu,lblThanhTien,lblDonVi;
	private JTextField txtMaHD;
	private JLabel lblNgayLapHD;
	private JTextField txtGhiChu,txtNgayLap,txterror;
	private JLabel lblMaNV;
	private JLabel lblMaBN;
	private static DefaultTableModel mdlHoaDon;
	private JTable tblHoaDon;
	private JScrollPane scrollHD;
	private JTextField txtNV;
	private static JTextField txtBenhNhan,txtThanhTien;
	private Box bh5HD;
	private JButton btnThem,btnChonBN,btnXoaTrang,btnChinhSua;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private ImageIcon iconThem,iconXoaTrang,iconChon,iconChinhSua;
	private DefaultTableCellRenderer cellRenderer;
	private static HoaDon_DAO hd_dao;
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	private static DecimalFormat df1;
	private static ArrayList<CT_HoaDon> ds_cthd;
	private static Thuoc_DAO thuoc_dao;
	private static ArrayList<Thuoc> dsthuoc;
	private static CT_HoaDon_DAO cthd_dao;
	private java.sql.Date ngaylapp;
	public void ThemHoaDon_GUI(JPanel panel,String maNV) {
		hd_dao = new HoaDon_DAO();
		ds_cthd = new ArrayList<CT_HoaDon>();
		iconChon = new ImageIcon(new ImageIcon("images/Chon.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconThem = new ImageIcon(new ImageIcon("images/ThemHD.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconChinhSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bThem = Box.createVerticalBox();
		bh1HD = Box.createHorizontalBox();
		bh2HD = Box.createHorizontalBox();
		bh4HD = Box.createHorizontalBox();
		bh3HD = Box.createHorizontalBox();
		bh33HD = Box.createHorizontalBox();
		bh5HD = Box.createHorizontalBox();
		bh6HD = Box.createHorizontalBox();
		bbtn = Box.createVerticalBox();
		bbtn1 = Box.createHorizontalBox();
		bDSTT = Box.createVerticalBox();
		bDS = Box.createHorizontalBox();
		bTT = Box.createHorizontalBox();
		bh1HD.add(Box.createHorizontalStrut(10));
		bh1HD.add(lblMaHD = new JLabel("Mã Hóa Đơn: "));
		lblMaHD.setPreferredSize(new Dimension(100, 25));
		bh1HD.add(txtMaHD = new JTextField(14));
		bh1HD.add(Box.createHorizontalStrut(30));
		bh1HD.add(lblNgayLapHD = new JLabel("Ngày Lập: "));
		lblNgayLapHD.setPreferredSize(lblMaHD.getPreferredSize());
		bh1HD.add(txtNgayLap = new JTextField());
		bh1HD.add(Box.createHorizontalStrut(10));
		
		bh2HD.add(Box.createHorizontalStrut(10));
		bh2HD.add(lblMaBN = new JLabel("Bệnh Nhân: "));
		bh2HD.add(txtBenhNhan = new JTextField());
		bh2HD.add(btnChonBN = new JButton("Chọn Bệnh Nhân"));
		bh2HD.add(Box.createHorizontalStrut(30));
		bh2HD.add(lblMaNV = new JLabel("Nhân Viên Lập: "));
		bh2HD.add(txtNV = new JTextField());
		bh2HD.add(Box.createHorizontalStrut(10));
		
		bh3HD.add(Box.createHorizontalStrut(10));
		bh3HD.add(lblGhiChu = new JLabel("Ghi Chú:"));
		bh3HD.add(txtGhiChu = new JTextField());
		bh3HD.add(Box.createHorizontalStrut(10));
		lblGhiChu.setPreferredSize(new Dimension(100,24));
		txtGhiChu.setBorder(null);
		
		bh33HD.add(Box.createHorizontalStrut(10));
		bh33HD.add(txterror = new JTextField());
		bh33HD.add(Box.createHorizontalStrut(10));
		
		lblMaNV.setPreferredSize(lblNgayLapHD.getPreferredSize());
		lblMaBN.setPreferredSize(lblMaNV.getPreferredSize());
		String[] TitleHoaDon = {"Mã Thuốc", "Tên Thuốc", "Số Lượng", "Thành Tiền"};
		mdlHoaDon = new DefaultTableModel(TitleHoaDon, 0);
		tblHoaDon = new JTable(mdlHoaDon);
		tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollHD = new JScrollPane(tblHoaDon);
		setColorHeaderTable(lightBlue);
		
		bh4HD.add(Box.createHorizontalStrut(30));
		bh4HD.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		btnXoaTrang.setIcon(iconXoaTrang);
		btnXoaTrang.setBackground(veryLightRed);
		txtMaHD.setBorder(null);
		txtMaHD.setBackground(Color.WHITE);
		btnChonBN.setIcon(iconChon);
		btnChonBN.setBackground(lightBlue);
		txtNV.setBackground(Color.WHITE);
		txtNgayLap.setBackground(Color.WHITE);
		txterror.setEditable(false);
		txterror.setBorder(null);
		txtBenhNhan.setEditable(false);
		txtBenhNhan.setBackground(Color.WHITE);
		
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		bh5HD.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Mặt Hàng"));
		scrollHD.setPreferredSize(new Dimension(940,250));
		scrollHD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		bbtn1.add(btnThem = new JButton("Lập Hóa Đơn"));
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(btnChinhSua = new JButton("Chỉnh Sửa Danh Sách"));
		btnThem.setBackground(lightBlue);
		btnChinhSua.setBackground(veryLightGreen);
		btnThem.setIcon(iconThem);
		btnChinhSua.setIcon(iconChinhSua);
		
		bbtn.add(Box.createVerticalStrut(10));
		bbtn.add(bbtn1);
		bbtn.add(Box.createVerticalStrut(10));
		
		bh6HD.add(bbtn);
		
		bh6HD.setBorder(lineLightBlueBorder);
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bh1HD);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bh2HD);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bh3HD);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bh33HD);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bh4HD);
		bThem.add(Box.createVerticalStrut(10));
		
		bh5HD.add(Box.createHorizontalStrut(10));
		bh5HD.add(bDSTT);
		bh5HD.add(Box.createHorizontalStrut(10));
		bDS.add(scrollHD);
		bTT.add(Box.createHorizontalStrut(650));
		bTT.add(lblThanhTien = new JLabel("Thành Tiền:"));
		lblThanhTien.setPreferredSize(lblMaHD.getPreferredSize());
		bTT.add(txtThanhTien = new JTextField());
		bTT.add(lblDonVi = new JLabel("   VNĐ"));
		bDSTT.add(bDS);
		bDSTT.add(Box.createVerticalStrut(8));
		bDSTT.add(bTT);
		bDSTT.add(Box.createVerticalStrut(8));
		txtThanhTien.setBackground(Color.WHITE);
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,### VND");
		df1 = new DecimalFormat("#,###");
		
		txtNV.setText(maNV);
		txtNV.setEditable(false);
		txtNgayLap.setEditable(false);
		txtThanhTien.setEditable(false);
		
		/*LocalDate now = LocalDate.now();
		//Date datenow = (Date) now;
		txtNgayLap.setText(now.toString());*/
		
		long millis=System.currentTimeMillis();
		ngaylapp = new java.sql.Date(millis);
		txtNgayLap.setText(sdf.format(ngaylapp));
		
		b.add(bThem);
		b.add(bh5HD);
		b.add(Box.createVerticalStrut(8));
		b.add(bh6HD);
		
		panel.add(b);
		
		btnChinhSua.addActionListener(this);
		btnChonBN.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThem.addActionListener(this);
		
		dsthuoc = new ArrayList<Thuoc>();
		ds_cthd = new ArrayList<CT_HoaDon>();
		
		
		
		reLoad();
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<4;i++){

            //i is the column of the table header
            TableColumn column = tblHoaDon.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public static void reLoad() {
		thuoc_dao = new Thuoc_DAO();
		dsthuoc = new ArrayList<Thuoc>();
		dsthuoc = thuoc_dao.layTTThuoc();
		hd_dao = new HoaDon_DAO();
		hd_dao.layDuLieuTuDB();
		cthd_dao = new CT_HoaDon_DAO();
		cthd_dao.layDuLieuTuDB();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnChinhSua)) {
			ChonThuoc_GUI t = new ChonThuoc_GUI(ds_cthd);
			t.setVisible(true);
			Load.NV_GUI.setEnabled(false);
		}else if(obj.equals(btnChonBN)) {
			ChonBenhNhan_GUI t = new ChonBenhNhan_GUI();
			t.setVisible(true);
			Load.NV_GUI.setEnabled(false);
		}else if(obj.equals(btnXoaTrang))
			xoaTrangTextField();
		else if(obj.equals(btnThem)) {
			if(mdlHoaDon.getRowCount()==0)
				JOptionPane.showMessageDialog(this, "Bạn chưa thêm mặt hàng nào vào hóa đơn");
			else {
				if(kiemTraDuLieuNhap()) {
					List<Thuoc> ds1 = new ArrayList<Thuoc>();
					for(Thuoc t : dsthuoc) {
						for(CT_HoaDon ct1 : ds_cthd) {
							if(t.getMaThuoc().trim().equals(ct1.getMaThuoc().getMaThuoc().trim())) {
								if(!ds1.contains(t))
									ds1.add(t);
							}
						}
					}
					for(Thuoc tt : ds1) {
						for(CT_HoaDon ct : ds_cthd) {
							if(tt.getMaThuoc().trim().equals(ct.getMaThuoc().getMaThuoc().trim())) {
								int sl = tt.getSoLuong();
								tt.setSoLuong(sl-ct.getSoLuong());
							}
						}
					}
					HoaDon h = layDuLieuTuTextField();
					if(hd_dao.themHoaDon(h)) {
						int n = 0;
						for(CT_HoaDon ctc : ds_cthd) {
							ctc.setMaHoaDon(h);
							if(!cthd_dao.themChiTietHoaDon(ctc))
								n++;
						}
						int m = 0;
						if(n==0) {
							for(Thuoc t : ds1) {
								if(!thuoc_dao.suaTTThuoc(t))
									m++;
							}
							if(m==0) {
								ThemThuocMoi_GUI.reloadTable();
								DanhSachThuoc_GUI.reloadData();
								DanhSachHoaDon_GUI.reLoadData();
								ThuocHetHan_GUI.reload();
								ThuocSapHetTonKho_GUI.reload();
								reLoad();
								thongBao("Lập hóa đơn thành công !!!", txtMaHD);
								xoaRongTextField();
								txtThanhTien.setText("");
								txterror.setForeground(Color.BLUE);
								while(mdlHoaDon.getRowCount()>0)
									mdlHoaDon.removeRow(0);
								ds_cthd = new ArrayList<CT_HoaDon>();
							}
						}
					}else {
						thongBao("Trùng mã hóa đơn !!!", txtMaHD);
					}
				}
			}
		}
		
	}
	public void taiDuLieuVaoBang() {
		hd_dao = new HoaDon_DAO();
		ArrayList<HoaDon> ds = hd_dao.layDuLieuTuDB();
		for(HoaDon h : ds)
			mdlHoaDon.addRow(new Object[] {
					h.getMaHD(),sdf.format(h.getNgayLap()),h.getMaNhanVien().getMaNV(),
					h.getMaBenhNhan().getMaBenhNhan(),df.format(h.getThanhTien())
			});
	}
	public void reLoadData() {
		while(mdlHoaDon.getRowCount()>0)
			mdlHoaDon.removeRow(0);
		taiDuLieuVaoBang();
	}
	public static void setBenhNhan(String ma) {
		txtBenhNhan.setText(ma);
	}
	public void xoaTrangTextField() {
		txtMaHD.setText("");
		txtBenhNhan.setText("");
		txtGhiChu.setText("");
	}
	public static void taiDuLieuVaoTable(ArrayList<CT_HoaDon> cthd) {
		while(mdlHoaDon.getRowCount()>0) 
			mdlHoaDon.removeRow(0);
		ds_cthd = new ArrayList<CT_HoaDon>();
		ds_cthd = cthd;
		for(CT_HoaDon hdd : ds_cthd) {
			for(Thuoc th : dsthuoc) {
				if(th.getMaThuoc().trim().equals(hdd.getMaThuoc().getMaThuoc().trim())) {
					hdd.setThanhTien(hdd.getSoLuong() * th.getDonGia());
				}
			}
		}
		for(CT_HoaDon hd : ds_cthd) {
			mdlHoaDon.addRow(new Object[] {
					hd.getMaThuoc().getMaThuoc(),hd.getMaThuoc().getTenThuoc(),hd.getSoLuong(),df.format(hd.getThanhTien())
			});
		}
		double thanhTien = 0;
		for(CT_HoaDon hddd : ds_cthd) {
			thanhTien+=hddd.getThanhTien();
		}
		txtThanhTien.setText(String.valueOf(thanhTien));
	}
	public void thongBao(String mess, JTextField txt) {
		txterror.setForeground(Color.RED);
		txterror.setText(mess);
		txt.requestFocus();
	}
	public boolean kiemTraDuLieuNhap() {
		if(txtMaHD.getText().trim().equals("")) {
			thongBao("Bạn chưa nhập mã hóa đơn !!!", txtMaHD);
			return false;
		}
		if(txtGhiChu.getText().trim().equals("")) {
			thongBao("Hãy ghi chú gì đó cho hóa đơn !!!", txtGhiChu);
			return false;
		}
		if(txtBenhNhan.getText().trim().equals("")) {
			thongBao("Bạn chưa chọn bệnh nhân !!!", txtMaHD);
			return false;
		}
		if(!txtMaHD.getText().trim().matches("HD\\d{4}")) {
			thongBao("Mã hóa đơn có dạng: 'HDxxxx', trong đó x là số !!!", txtBenhNhan);
			return false;
		}
		return true;
	}
	public HoaDon layDuLieuTuTextField() {
		String ma = txtMaHD.getText().trim();
		String ghichu = txtGhiChu.getText().trim();
		NhanVien nv = new NhanVien(txtNV.getText().trim());
		double thanhTien = Double.parseDouble(txtThanhTien.getText().trim().toString());
		BenhNhan bn = new BenhNhan(txtBenhNhan.getText().trim());
		HoaDon hd = new HoaDon(ma, nv, bn, ngaylapp, thanhTien, ghichu);
		return hd;
	}
	public void xoaRongTextField() {
		txtMaHD.setText("");
		txtBenhNhan.setText("");
		txtGhiChu.setText("");
	}
}
