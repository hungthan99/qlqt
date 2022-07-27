package class_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import class_DAO.NhanVien_DAO;
import class_Entity.NhanVien;

public class Main_NhanVien extends JFrame implements MouseListener,ActionListener{
	private JPanel pNorth,pWest,pNorthL,pNorthR,pWest_Menu;
	private JPanel pLoaiNV,pThuoc,pHoaDon,pBenhNhan,pThongKe,pNhanVien;
	private JLabel lblTitle,lblAvata,lblLoaiNV,lblThuoc,lblHoaDon,lblBenhNhan,lblThongKe,lblNhanVien;
	private JButton btnTK,btnDSThuoc,btnThemThuoc,btnDSHoaDOn,btnThemHD,btnDSBenhNhan,btnThemBN,btnTKCacNam,btnTKThang,btnTKNam;
	private JButton btnThuocHetHan,btnThuocSapHet,btnDSNSX,btnThemNSX,btnDSNHanVien,btnThemNhanVien;
	private ImageIcon iconAvata,iconApp,iconDSThuoc,iconThemThuoc,iconThuocHH,iconThuocHet,iconDSHD,iconThemHD,iconDSBN,iconThemBN,
	iconTKCacNam,iconTKThang,iconTKNam,iconMain,iconNSX,iconThemNSX,iconDSNV,iconThemNV;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Color lightRed = new Color(204,0,0);
	private Box bNorthL,bNorthR,bWest,bCen,bCenR;
	private JPopupMenu popTK;
	private JMenuItem xemTT;
	private JMenuItem doiMK;
	private JMenuItem dangXuat;
	private JPanel pCen;
	private JTabbedPane tab;
	private DanhSachThuoc_GUI dsThuoc_GUI;
	private ThemThuocMoi_GUI themThuocMoi_GUI;
	private ThuocHetHan_GUI thuocHetHan_GUI;
	private ThuocSapHetTonKho_GUI thuocSapHetTonKho_GUI;
	private DanhSachHoaDon_GUI dsHoaDon_GUI;
	private ThemHoaDon_GUI themHoaDon_GUI;
	private DanhSachBenhNhan_GUI dsBenhNhan_GUI;
	private ThemBenhNhan_GUI themBenhNhan_GUI;
	private ThemNhaSX_GUI themNhaSanXuat_GUI;
	private DanhSachNSX_GUI dsNhaSanXuat_GUI;
	private DoanhThuThang_GUI doanhThuThang_GUI;
	private DoanhThuNam_GUI doanhThuNam_GUI;
	private DoanhThuCacNam_GUI doanhThuCacNam_GUI;
	private DanhSachNhanVien_GUI danhSachNhanVien_GUI;
	private ThemNhanVien_GUI themNhanVien_GUI;
	private boolean isbtnDSThuoc,isbtnThemThuoc,isbtnThuocHetHan,isbtnThuocSapHet,isbtnDSHoaDon,isbtnThemHoaDon,isbtnDSBenhNhan,
	isbtnThemBenhNhan,isbtnTKCacNam,isbtnTKThang,isbtnTKNam,isbtnDSNSX,isbtnThemNSX,isbtnDSNhanVien,isbtnThemNV;
	private JPanel pDanhSachThuoc,pThemThuocMoi,pThuocHetHan,pThuocSapHet,pDSHoaDon,pThemHoaDon,pDSBenhNhan,pTKDoanhThuThang,
	pThemBenhNhan,pThemNhaSX,pDSNhaSanXuat,pTKDoanhThuNam,pTKDoanhThuCacNam,pDSNhanVien,pThemNhanVien;
	private NhanVien_DAO nv_dao;
	private String maNhanVienx;
	public Main_NhanVien(String maNV) {
		super("Quản Lý Nhà Thuốc");
		maNhanVienx = maNV;
		setSize(1280,730);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(getIconImage());
		iconMain = new ImageIcon("images/iconApp.png");
		setIconImage(iconMain.getImage());
		setLocationRelativeTo(null);
		
		nv_dao = new NhanVien_DAO();
		nv_dao.taiDuLieuTuDB();
		NhanVien nvi = nv_dao.getNhanVien(maNV);
		String loainv = nvi.getLoaiNV();
		
		
		pNorth = new JPanel();
		pNorthL = new JPanel();
		pNorthR = new JPanel();
		pLoaiNV = new JPanel();
		pThuoc = new JPanel();
		pHoaDon = new JPanel();
		pBenhNhan = new JPanel();
		pThongKe = new JPanel();
		pNhanVien = new JPanel();
		pWest = new JPanel();
		pWest_Menu = new JPanel();
		pCen = new JPanel();
		
		bNorthL = Box.createHorizontalBox();
		bNorthR = Box.createHorizontalBox();
		bWest = Box.createHorizontalBox();
		
		iconAvata = new ImageIcon(new ImageIcon("images/aaa.jpg").getImage().getScaledInstance(26, 26, Image.SCALE_AREA_AVERAGING));
		iconApp = new ImageIcon(new ImageIcon("images/iconApp.png").getImage().getScaledInstance(26, 26, Image.SCALE_AREA_AVERAGING));
		iconDSThuoc = new ImageIcon(new ImageIcon("images/thuoc2.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThemThuoc = new ImageIcon(new ImageIcon("images/themthuoc.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThuocHH = new ImageIcon(new ImageIcon("images/ThuocHetHan.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThuocHet = new ImageIcon(new ImageIcon("images/ThuocSapHet.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconDSHD = new ImageIcon(new ImageIcon("images/DSHD.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThemHD = new ImageIcon(new ImageIcon("images/ThemHD.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconDSBN = new ImageIcon(new ImageIcon("images/BenhNhan.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThemBN = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconTKCacNam = new ImageIcon(new ImageIcon("images/TKNam.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconTKThang = new ImageIcon(new ImageIcon("images/TKNgay.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconTKNam = new ImageIcon(new ImageIcon("images/TKThang.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconNSX = new ImageIcon(new ImageIcon("images/NSX.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThemNSX = new ImageIcon(new ImageIcon("images/themNSX.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconDSNV = new ImageIcon(new ImageIcon("images/dsnv.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		iconThemNV = new ImageIcon(new ImageIcon("images/addnv.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		
		lblTitle = new JLabel("QUAN LY NHA THUOC");
		lblAvata = new JLabel(iconAvata);
		if(loainv.equals("NV"))
			lblLoaiNV = new JLabel("NHÂN VIÊN");
		else
			lblLoaiNV = new JLabel("QUẢN LÝ");
		lblThuoc = new JLabel("Quản Lý Thuốc");
		lblHoaDon = new JLabel("Quản Lý Hóa Đơn");
		lblBenhNhan = new JLabel("Quản Lý Khách Hàng");
		lblThongKe = new JLabel("Thống Kê Doanh Thu");
		lblNhanVien = new JLabel("Quản Lý Nhân Viên");
		
		btnTK = new JButton(nvi.getTenNV() + " ▼");
		btnDSThuoc = new JButton("Tra Cứu Thuốc");
		btnThemThuoc = new JButton("Thêm Thuốc Mới");
		btnThuocHetHan = new JButton("Thuốc Hết Hạn");
		btnThuocSapHet = new JButton("Thuốc Sắp Hết Tồn Kho");
		btnDSHoaDOn = new JButton("Danh Sách Hóa Đơn");
		btnThemHD = new JButton("Lập Hóa Đơn");
		btnDSBenhNhan = new JButton("Danh Sách Bệnh Nhân");
		btnThemBN = new JButton("Thêm Bệnh Nhân");
		btnDSNSX = new JButton("Danh Sách Nhà Sản Xuất");
		btnThemNSX = new JButton("Thêm Nhà Sản Xuất");
		btnTKThang = new JButton("Doanh Thu Tháng");
		btnTKCacNam = new JButton("Danh Thu Các Năm");
		btnTKNam = new JButton("Doanh Thu Năm");
		btnDSNHanVien = new JButton("Danh Sách Nhân Viên");
		btnThemNhanVien = new JButton("Thêm Nhân Viên");
		
		popTK = new JPopupMenu("MenuTK");
		
		//==============================================pNorth======================================================
		pNorth.setBackground(veryLightGreen);
		pNorthL.setBackground(veryLightGreen);
		pNorthR.setBackground(veryLightGreen);
		lblTitle.setFont(new Font("Impact",Font.PLAIN,23));
		lblTitle.setForeground(veryLightRed);
		lblTitle.setIcon(iconApp);
		btnTK.setBorder(null);
		btnTK.setBackground(veryLightGreen);
		bNorthL.add(Box.createHorizontalStrut(30));
		bNorthL.add(lblTitle);
		bNorthR.add(lblAvata);
		bNorthR.add(Box.createHorizontalStrut(10));
		bNorthR.add(btnTK);
		bNorthR.add(Box.createHorizontalStrut(30));
		pNorthL.add(bNorthL);
		pNorthR.add(bNorthR);
		xemTT = new JMenuItem("Xem Thông Tin");
		doiMK = new JMenuItem("Đổi Mật Khẩu");
		dangXuat = new JMenuItem("Đăng Xuất");
		popTK.add(xemTT);
		popTK.add(doiMK);
		popTK.add(dangXuat);
		
		pNorth.setLayout(new BorderLayout());
		pNorth.add(pNorthL,BorderLayout.WEST);
		pNorth.add(pNorthR,BorderLayout.EAST);
		
		//==========================================pWest========================================================
		pThuoc.add(lblThuoc);
		lblThuoc.setBackground(lightBlue);
		isbtnDSThuoc = true;
		btnDSThuoc.setBackground(veryLightGreen);
		btnDSThuoc.setBorder(null);
		btnThemThuoc.setBackground(Color.WHITE);
		btnThemThuoc.setBorder(null);
		btnThuocHetHan.setBackground(Color.WHITE);
		btnThuocHetHan.setBorder(null);
		btnThuocSapHet.setBackground(Color.WHITE);
		btnThuocSapHet.setBorder(null);
		
		btnDSThuoc.setIcon(iconDSThuoc);
		btnThemThuoc.setIcon(iconThemThuoc);
		btnThuocHetHan.setIcon(iconThuocHH);
		btnThuocSapHet.setIcon(iconThuocHet);
		btnDSHoaDOn.setIcon(iconDSHD);
		btnThemHD.setIcon(iconThemHD);
		btnDSBenhNhan.setIcon(iconDSBN);
		btnThemBN.setIcon(iconThemBN);
		btnDSNSX.setIcon(iconNSX);
		btnThemNSX.setIcon(iconThemNSX);
		btnTKCacNam.setIcon(iconTKCacNam);
		btnTKThang.setIcon(iconTKThang);
		btnTKNam.setIcon(iconTKNam);
		btnDSNHanVien.setIcon(iconDSNV);
		btnThemNhanVien.setIcon(iconThemNV);
		
		btnDSThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		btnThuocHetHan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThuocSapHet.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSHoaDOn.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemHD.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSBenhNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemBN.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSNSX.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemNSX.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKCacNam.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKThang.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKNam.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSNHanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		
		pLoaiNV.setBackground(new Color(204,204,204));
		
		pThuoc.setPreferredSize(new Dimension(200,25));
		pThuoc.setLayout(new FlowLayout(FlowLayout.LEFT));
		pHoaDon.setLayout(new FlowLayout(FlowLayout.LEFT));
		pBenhNhan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pThongKe.setLayout(new FlowLayout(FlowLayout.LEFT));
		pNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT));
		pThuoc.setBackground(lightBlue);
		
		pLoaiNV.add(lblLoaiNV);
		pHoaDon.add(lblHoaDon);
		lblHoaDon.setBackground(lightBlue);
		btnDSHoaDOn.setBackground(Color.WHITE);
		btnDSHoaDOn.setBorder(null);
		btnThemHD.setBackground(Color.WHITE);
		btnThemHD.setBorder(null);
		pHoaDon.setPreferredSize(new Dimension(200,25));
		pHoaDon.setBackground(lightBlue);
		
		pBenhNhan.add(lblBenhNhan);
		lblBenhNhan.setBackground(lightBlue);
		btnDSBenhNhan.setBackground(Color.WHITE);
		btnDSBenhNhan.setBorder(null);
		btnThemBN.setBackground(Color.WHITE);
		btnThemBN.setBorder(null);
		btnDSNSX.setBackground(Color.WHITE);
		btnDSNSX.setBorder(null);
		btnThemNSX.setBackground(Color.WHITE);
		btnThemNSX.setBorder(null);
		pBenhNhan.setPreferredSize(new Dimension(200,25));
		pBenhNhan.setBackground(lightBlue);
		
		pHoaDon.add(lblHoaDon);
		lblHoaDon.setBackground(lightBlue);
		btnDSHoaDOn.setBackground(Color.WHITE);
		btnDSHoaDOn.setBorder(null);
		btnThemHD.setBackground(Color.WHITE);
		btnThemHD.setBorder(null);
		pHoaDon.setPreferredSize(new Dimension(200,25));
		pHoaDon.setBackground(lightBlue);
		
		pThongKe.add(lblThongKe);
		lblThongKe.setBackground(lightBlue);
		btnTKThang.setBackground(Color.WHITE);
		btnTKThang.setBorder(null);
		btnTKNam.setBackground(Color.WHITE);
		btnTKNam.setBorder(null);
		btnTKCacNam.setBackground(Color.WHITE);
		btnTKCacNam.setBorder(null);
		pThongKe.setPreferredSize(new Dimension(200,25));
		pThongKe.setBackground(lightBlue);
		
		pNhanVien.add(lblNhanVien);
		lblNhanVien.setBackground(lightBlue);
		btnDSNHanVien.setBackground(Color.WHITE);
		btnDSNHanVien.setBorder(null);
		btnThemNhanVien.setBackground(Color.WHITE);
		btnThemNhanVien.setBorder(null);
		pNhanVien.setPreferredSize(new Dimension(200,25));
		pNhanVien.setBackground(lightBlue);
		
		if(loainv.equals("NV")) {
			pWest_Menu.setLayout(new GridLayout(18,1,10,5));
		}else
			pWest_Menu.setLayout(new GridLayout(20,1,10,5));
		
		pWest_Menu.add(pLoaiNV);
		pWest_Menu.add(pThuoc);
		pWest_Menu.add(btnDSThuoc);
		pWest_Menu.add(btnThemThuoc);
		pWest_Menu.add(btnThuocHetHan);
		pWest_Menu.add(btnThuocSapHet);
		pWest_Menu.add(pHoaDon);
		pWest_Menu.add(btnDSHoaDOn);
		if(loainv.equals("NV")) {
			pWest_Menu.add(btnThemHD);
		}
		pWest_Menu.add(pBenhNhan);
		pWest_Menu.add(btnDSBenhNhan);
		pWest_Menu.add(btnThemBN);
		pWest_Menu.add(btnDSNSX);
		pWest_Menu.add(btnThemNSX);
		pWest_Menu.add(pThongKe);
		pWest_Menu.add(btnTKThang);
		pWest_Menu.add(btnTKNam);
		pWest_Menu.add(btnTKCacNam);
		if(loainv.equals("QL")) {
			pWest_Menu.add(pNhanVien);
			pWest_Menu.add(btnDSNHanVien);
			pWest_Menu.add(btnThemNhanVien);
		}
		bWest.add(Box.createHorizontalStrut(30));
		bWest.add(pWest_Menu);
		pWest.add(bWest);
		
		btnDSThuoc.addMouseListener(this);
		btnThemThuoc.addMouseListener(this);
		btnThuocHetHan.addMouseListener(this);
		btnThuocSapHet.addMouseListener(this);
		btnDSHoaDOn.addMouseListener(this);
		btnThemHD.addMouseListener(this);
		btnDSBenhNhan.addMouseListener(this);
		btnThemBN.addMouseListener(this);
		btnThemNSX.addMouseListener(this);
		btnDSNSX.addMouseListener(this);
		btnTKCacNam.addMouseListener(this);
		btnTKThang.addMouseListener(this);
		btnTKNam.addMouseListener(this);
		btnDSNHanVien.addMouseListener(this);
		btnThemNhanVien.addMouseListener(this);
		btnTK.addActionListener(this);
		btnDSThuoc.addActionListener(this);
		btnThemThuoc.addActionListener(this);
		btnThuocHetHan.addActionListener(this);
		btnThuocSapHet.addActionListener(this);
		btnDSHoaDOn.addActionListener(this);
		btnThemHD.addActionListener(this);
		btnDSBenhNhan.addActionListener(this);
		btnDSNSX.addActionListener(this);
		btnThemNSX.addActionListener(this);
		btnThemBN.addActionListener(this);
		btnTKCacNam.addActionListener(this);
		btnTKThang.addActionListener(this);
		btnTKNam.addActionListener(this);
		btnDSNHanVien.addActionListener(this);
		btnThemNhanVien.addActionListener(this);
		xemTT.addActionListener(this);
		doiMK.addActionListener(this);
		dangXuat.addActionListener(this);
		
		//==============================================pCen=================================================
		pCen = new JPanel();
		tab = new JTabbedPane();
		bCen = Box.createHorizontalBox();
		
		pDanhSachThuoc = new JPanel();
		dsThuoc_GUI = new DanhSachThuoc_GUI();
		dsThuoc_GUI.DanhSachThuoc(pDanhSachThuoc);
		
		pThemThuocMoi = new JPanel();
		themThuocMoi_GUI = new ThemThuocMoi_GUI();
		themThuocMoi_GUI.ThemThuoc_GUI(pThemThuocMoi);
		
		pThuocHetHan = new JPanel();
		thuocHetHan_GUI = new ThuocHetHan_GUI();
		thuocHetHan_GUI.ThuocHetHan_GUI(pThuocHetHan);
		
		pThuocSapHet = new JPanel();
		thuocSapHetTonKho_GUI = new ThuocSapHetTonKho_GUI();
		thuocSapHetTonKho_GUI.ThuocSapHetTonKho_GUI(pThuocSapHet);
		
		pDSHoaDon = new JPanel();
		dsHoaDon_GUI = new DanhSachHoaDon_GUI();
		dsHoaDon_GUI.DanhSachHoaDon_GUI(pDSHoaDon);
		
		pThemHoaDon = new JPanel();
		themHoaDon_GUI = new ThemHoaDon_GUI();
		themHoaDon_GUI.ThemHoaDon_GUI(pThemHoaDon,maNV);
		
		pDSBenhNhan = new JPanel();
		dsBenhNhan_GUI = new DanhSachBenhNhan_GUI();
		dsBenhNhan_GUI.DanhSachBenhNhan_GUI(pDSBenhNhan);
		
		pThemBenhNhan = new JPanel();
		themBenhNhan_GUI = new ThemBenhNhan_GUI();
		themBenhNhan_GUI.ThemBenhNhan_GUI(pThemBenhNhan);
		
		pThemNhaSX = new JPanel();
		themNhaSanXuat_GUI = new ThemNhaSX_GUI();
		themNhaSanXuat_GUI.ThemNhaSX_GUI(pThemNhaSX);
		
		pDSNhaSanXuat = new JPanel();
		dsNhaSanXuat_GUI = new DanhSachNSX_GUI();
		dsNhaSanXuat_GUI.DanhSachNSX_GUI(pDSNhaSanXuat);
		
		pTKDoanhThuThang = new JPanel();
		doanhThuThang_GUI = new DoanhThuThang_GUI();
		doanhThuThang_GUI.DoanhThuThang_GUI(pTKDoanhThuThang);
		
		pTKDoanhThuNam = new JPanel();
		doanhThuNam_GUI = new DoanhThuNam_GUI();
		doanhThuNam_GUI.DoanhThuNam_GUI(pTKDoanhThuNam);
		
		pTKDoanhThuCacNam = new JPanel();
		doanhThuCacNam_GUI = new DoanhThuCacNam_GUI();
		doanhThuCacNam_GUI.DoanhThuCacNam_GUI(pTKDoanhThuCacNam);
		
		pDSNhanVien = new JPanel();
		danhSachNhanVien_GUI = new DanhSachNhanVien_GUI();
		danhSachNhanVien_GUI.DanhSachNhanVien_GUI(maNhanVienx,pDSNhanVien);
		
		pThemNhanVien = new JPanel();
		themNhanVien_GUI = new ThemNhanVien_GUI();
		themNhanVien_GUI.ThemNhanVien_GUI(pThemNhanVien);
		
		pCen.add(bCen);
		
		tab.addTab("",pDanhSachThuoc);
		tab.add("",pThemThuocMoi);
		tab.add("",pThuocHetHan);
		tab.add("",pThuocSapHet);
		tab.add("",pDSHoaDon);
		tab.add("",pThemHoaDon);
		tab.add("",pDSBenhNhan);
		tab.add("",pThemBenhNhan);
		tab.add("",pDSNhaSanXuat);
		tab.add("",pThemNhaSX);
		tab.add("",pTKDoanhThuThang);
		tab.add("",pTKDoanhThuNam);
		tab.add("",pTKDoanhThuCacNam);
		tab.add("",pDSNhanVien);
		tab.add("",pThemNhanVien);
		
		bCen.add(tab);
		bCen.add(Box.createHorizontalStrut(28));
		tab.setBackground(Color.white);
		
		//An Tieu De Tab
		tab.setUI(new javax.swing.plaf.metal.MetalTabbedPaneUI(){
	        @Override
	        protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
	            if (false) {
	                return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
	            } else {
	                return 0;
	            }
	        }
	      protected void paintTabArea(Graphics g,int tabPlacement,int selectedIndex){}
	    });
		//
		add(pNorth,BorderLayout.NORTH);
		add(pWest,BorderLayout.WEST);
		add(pCen,BorderLayout.CENTER);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		e.getComponent().setBackground(veryLightGreen);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		setBackgoundTrue(veryLightGreen);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnTK)) {
			popTK.show(btnTK, 1, btnTK.getHeight());
		}
		if(obj.equals(btnDSThuoc)) {
			setAllbtnFalse();
			isbtnDSThuoc = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(0);
		}
		if(obj.equals(btnThemThuoc)) {
			setAllbtnFalse();
			isbtnThemThuoc = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(1);
		}
		if(obj.equals(btnThuocHetHan)) {
			setAllbtnFalse();
			isbtnThuocHetHan = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(2);
		}
		if(obj.equals(btnThuocSapHet)) {
			setAllbtnFalse();
			isbtnThuocSapHet = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(3);
		}
		if(obj.equals(btnDSHoaDOn)) {
			setAllbtnFalse();
			isbtnDSHoaDon = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(4);
		}
		if(obj.equals(btnThemHD)) {
			setAllbtnFalse();
			isbtnThemHoaDon = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(5);
		}
		if(obj.equals(btnDSBenhNhan)) {
			setAllbtnFalse();
			isbtnDSBenhNhan = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(6);
		}
		if(obj.equals(btnThemBN)) {
			setAllbtnFalse();
			isbtnThemBenhNhan = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(7);
		}
		if(obj.equals(btnDSNSX)) {
			setAllbtnFalse();
			isbtnDSNSX = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(8);
		}
		if(obj.equals(btnThemNSX)) {
			setAllbtnFalse();
			isbtnThemNSX = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(9);
		}
		if(obj.equals(btnTKThang)) {
			setAllbtnFalse();
			isbtnTKThang = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(10);
		}
		if(obj.equals(btnTKNam)) {
			setAllbtnFalse();
			isbtnTKNam = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(11);
		}
		if(obj.equals(btnTKCacNam)) {
			setAllbtnFalse();
			isbtnTKCacNam = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(12);
		}
		if(obj.equals(btnDSNHanVien)) {
			setAllbtnFalse();
			isbtnDSNhanVien = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(13);
		}
		if(obj.equals(btnThemNhanVien)) {
			setAllbtnFalse();
			isbtnThemNV = true;
			setBackgoundTrue(veryLightGreen);
			tab.setSelectedIndex(14);
		}
		if(obj.equals(xemTT)) {
			XemThongTinNhanVien_GUI t = new XemThongTinNhanVien_GUI(maNhanVienx,nv_dao.getNhanVien(maNhanVienx));
			t.setVisible(true);
			Load.NV_GUI.setEnabled(false);
		}
		if(obj.equals(doiMK)) {
			DoiMatKhau_GUI t = new DoiMatKhau_GUI(maNhanVienx);
			t.setVisible(true);
			Load.NV_GUI.setEnabled(false);
		}
		if(obj.equals(dangXuat)) {
			StartApp.dn_gui.setVisible(true);
			Load.NV_GUI.setVisible(false);
		}
	}
	public void setAllButtonMenuBackground(Color color) {
		btnDSThuoc.setBackground(color);
		btnThemThuoc.setBackground(color);
		btnThuocHetHan.setBackground(color);
		btnThuocSapHet.setBackground(color);
		btnDSHoaDOn.setBackground(color);
		btnThemHD.setBackground(color);
		btnDSBenhNhan.setBackground(color);
		btnThemBN.setBackground(color);
		btnDSNSX.setBackground(color);
		btnThemNSX.setBackground(color);
		btnTKCacNam.setBackground(color);
		btnTKThang.setBackground(color);
		btnTKNam.setBackground(color);
		btnDSNHanVien.setBackground(color);
		btnThemNhanVien.setBackground(color);
	}
	public void setAllbtnFalse() {
		isbtnDSThuoc = false;
		isbtnThemThuoc = false;
		isbtnThuocHetHan = false;
		isbtnThuocSapHet = false;
		isbtnDSHoaDon = false;
		isbtnThemHoaDon = false;
		isbtnDSBenhNhan = false;
		isbtnThemBenhNhan = false;
		isbtnDSNSX = false;
		isbtnThemNSX = false;
		isbtnTKCacNam = false;
		isbtnTKThang = false;
		isbtnTKNam = false;
		isbtnDSNhanVien = false;
		isbtnThemNV = false;
	}
	public void setBackgoundTrue(Color color) {
		setAllButtonMenuBackground(Color.WHITE);
		if(isbtnDSThuoc)
			btnDSThuoc.setBackground(color);
		if(isbtnThemThuoc)
			btnThemThuoc.setBackground(color);
		if(isbtnThuocHetHan)
			btnThuocHetHan.setBackground(color);
		if(isbtnThuocSapHet)
			btnThuocSapHet.setBackground(color);
		if(isbtnDSHoaDon)
			btnDSHoaDOn.setBackground(color);
		if(isbtnThemHoaDon)
			btnThemHD.setBackground(color);
		if(isbtnDSBenhNhan)
			btnDSBenhNhan.setBackground(color);
		if(isbtnThemBenhNhan)
			btnThemBN.setBackground(color);
		if(isbtnDSNSX)
			btnDSNSX.setBackground(color);
		if(isbtnThemNSX)
			btnThemNSX.setBackground(color);
		if(isbtnTKCacNam)
			btnTKCacNam.setBackground(color);
		if(isbtnTKThang)
			btnTKThang.setBackground(color);
		if(isbtnTKNam)
			btnTKNam.setBackground(color);
		if(isbtnDSNhanVien)
			btnDSNHanVien.setBackground(color);
		if(isbtnThemNV)
			btnThemNhanVien.setBackground(color);
	}
}
