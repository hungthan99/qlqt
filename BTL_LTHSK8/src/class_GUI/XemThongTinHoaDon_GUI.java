package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class XemThongTinHoaDon_GUI extends JFrame implements WindowListener{
	private Box b,bThem,bbtn,bbtn1,bTitle;
	private Box bh1HD;
	private Box bh2HD,bh3HD;
	private Box bh4HD,bh6HD,bDSTT,bDS,bTT;
	private JLabel lblMaHD,lblGhiChu,lblThanhTien,lblDonVi,lblTitle;
	private JTextField txtMaHD;
	private JLabel lblNgayLapHD;
	private JTextField txtGhiChu,txtNgayLap;
	private JLabel lblMaNV;
	private JLabel lblMaBN;
	private DefaultTableModel mdlHoaDon;
	private JTable tblHoaDon;
	private JScrollPane scrollHD;
	private JTextField txtNV;
	private JTextField txtBenhNhan,txtThanhTien;
	private Box bh5HD;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private DefaultTableCellRenderer cellRenderer;
	private SimpleDateFormat sdf;
	private DecimalFormat df;
	private DecimalFormat df1;
	private String MaHoaDon;
	public XemThongTinHoaDon_GUI(String maHD) {
		MaHoaDon = maHD;
		bTitle = Box.createHorizontalBox();
		b = Box.createVerticalBox();
		bThem = Box.createVerticalBox();
		bh1HD = Box.createHorizontalBox();
		bh2HD = Box.createHorizontalBox();
		bh4HD = Box.createHorizontalBox();
		bh3HD = Box.createHorizontalBox();
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
		bh2HD.add(Box.createHorizontalStrut(30));
		bh2HD.add(lblMaNV = new JLabel("Nhân Viên Lập: "));
		bh2HD.add(txtNV = new JTextField());
		bh2HD.add(Box.createHorizontalStrut(10));
		
		bh3HD.add(Box.createHorizontalStrut(10));
		bh3HD.add(lblGhiChu = new JLabel("Ghi Chú:"));
		bh3HD.add(txtGhiChu = new JTextField());
		bh3HD.add(Box.createHorizontalStrut(10));
		lblGhiChu.setPreferredSize(new Dimension(100,24));
		
		lblMaNV.setPreferredSize(lblNgayLapHD.getPreferredSize());
		lblMaBN.setPreferredSize(lblMaNV.getPreferredSize());
		String[] TitleHoaDon = {"Mã Thuốc", "Tên Thuốc", "Số Lượng", "Thành Tiền"};
		mdlHoaDon = new DefaultTableModel(TitleHoaDon, 0);
		tblHoaDon = new JTable(mdlHoaDon);
		tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollHD = new JScrollPane(tblHoaDon);
		setColorHeaderTable(lightBlue);
		
		txtMaHD.setBackground(Color.WHITE);
		txtNV.setBackground(Color.WHITE);
		txtNgayLap.setBackground(Color.WHITE);
		txtMaHD.setEditable(false);
		txtGhiChu.setEditable(false);
		txtGhiChu.setBackground(Color.WHITE);
		txtBenhNhan.setEditable(false);
		txtBenhNhan.setBackground(Color.WHITE);
		
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		bh5HD.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Mặt Hàng"));
		scrollHD.setPreferredSize(new Dimension(940,420));
		scrollHD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		bThem.add(bh4HD);
		bThem.add(Box.createVerticalStrut(10));
		
		bh5HD.add(Box.createHorizontalStrut(10));
		bh5HD.add(bDSTT);
		bh5HD.add(Box.createHorizontalStrut(10));
		bDS.add(scrollHD);
		bTT.add(Box.createHorizontalStrut(500));
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
		
		txtNV.setEditable(false);
		txtNgayLap.setEditable(false);
		txtThanhTien.setEditable(false);
		
		b.add(bTitle);
		bTitle.add(lblTitle = new JLabel("HÓA ĐƠN"));
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblTitle.setForeground(veryLightRed);
		b.add(bThem);
		b.add(bh5HD);
		b.add(Box.createVerticalStrut(8));
		
		setSize(800,720);
		setLocationRelativeTo(null);
		add(b);
		
		this.addWindowListener(this);
		
		loadData();
		
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
	public void loadData() {
		HoaDon_DAO hd_dao = new HoaDon_DAO();
		CT_HoaDon_DAO cthd_dao = new CT_HoaDon_DAO();
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		ArrayList<CT_HoaDon> dscthd = new ArrayList<CT_HoaDon>();
		dshd = hd_dao.layDuLieuTuDB();
		dscthd = cthd_dao.layDuLieuTuDB();
		
		HoaDon hd = hd_dao.getHoaDon(MaHoaDon);
		txtMaHD.setText(hd.getMaHD());
		txtNgayLap.setText(sdf.format(hd.getNgayLap()));
		txtBenhNhan.setText(hd.getMaBenhNhan().getMaBenhNhan());
		txtNV.setText(hd.getMaNhanVien().getMaNV());
		txtGhiChu.setText(hd.getGhiChu());
		txtThanhTien.setText(df1.format(hd.getThanhTien()));
		
		List<CT_HoaDon> dscthd1 = new ArrayList<CT_HoaDon>();
		
		for(CT_HoaDon ct : dscthd) {
			if(ct.getMaHoaDon().getMaHD().trim().equals(MaHoaDon))
				mdlHoaDon.addRow(new Object[] {
						ct.getMaThuoc().getMaThuoc(),ct.getMaThuoc().getTenThuoc(),ct.getSoLuong(),df.format(ct.getThanhTien())
				});
		}
		
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
