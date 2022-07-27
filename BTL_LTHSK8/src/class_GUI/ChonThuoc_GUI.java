package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_DAO.CT_HoaDon_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.Thuoc_DAO;
import class_Entity.CT_HoaDon;
import class_Entity.NhaSanXuat;
import class_Entity.Thuoc;

public class ChonThuoc_GUI extends JFrame implements WindowListener,ActionListener,MouseListener{
	private JPanel p;
	private Box b,bTim,bMaTen,bLoaiNSX,bbtn,bDSThuoc,bbtn1,bHDThuoc;
	private JLabel lblMaThuoc,lblTenThuoc,lblLoaiThuoc,lblNhaXS,lblSoLuong;
	private JTextField txtMa,txtTen,txtLoai,txtSoLuong;
	private JComboBox cbbNhaSX;
	private DefaultTableModel modelDS;
	private DefaultTableModel modelThuocDaThem;
	private JButton btnThem,btnXoa,btnXoaTrang,btnHT,btnTim,btnXoaAll,btnReload;
	private JTable tblDS;
	private JTable tblThuocDaThem;
	private JScrollPane scrDS,scrHoaDon;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconTim,iconXoaTrang,iconThemThuoc,iconThem,iconXoa,iconHT,iconXoaAll,iconReload;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private String[] header = {"Mã Thuốc","Tên Thuốc","Đơn Vị","Ngày Sản Xuất","Ngày Hết Hạn","Nhà Sản Xuất",
			"Loại Thuốc","Số Lượng","Đơn Giá"};
	private String[] header1 = {"Mã Thuốc","Tên Thuốc","Số Lượng","Đơn Giá"};
	private DefaultTableCellRenderer cellRenderer;
	private Thuoc_DAO thuoc_dao;
	private ArrayList<Thuoc> dsThuoc,dsThuocTrongHD,dsThuocDaThem;
	private NhaSanXuat_DAO nsx_dao;
	private SimpleDateFormat sdf;
	private DecimalFormat df;
	private ArrayList<CT_HoaDon> dscthd;
	public ChonThuoc_GUI(ArrayList<CT_HoaDon> cthddd) {
		setTitle("Thêm Thuốc Vảo Hóa Đơn");
		setSize(1000,720);
		setLocationRelativeTo(null);
		
		iconTim = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconThemThuoc = new ImageIcon(new ImageIcon("images/themthuoc1.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconThem = new ImageIcon(new ImageIcon("images/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/remove.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconHT = new ImageIcon(new ImageIcon("images/HT.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconXoaAll = new ImageIcon(new ImageIcon("images/xoaall.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		p = new JPanel();
		b = Box.createVerticalBox();
		bTim = Box.createVerticalBox();
		bMaTen = Box.createHorizontalBox();
		bLoaiNSX = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDSThuoc = Box.createHorizontalBox();
		bbtn1 = Box.createHorizontalBox();
		bHDThuoc = Box.createHorizontalBox();
		modelDS = new DefaultTableModel(header,0);
		modelThuocDaThem = new DefaultTableModel(header1,0);
		tblDS = new JTable(modelDS);
		tblThuocDaThem = new JTable(modelThuocDaThem);
		scrDS = new JScrollPane(tblDS);
		scrHoaDon = new JScrollPane(tblThuocDaThem);
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMaThuoc = new JLabel("Mã Thuốc:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(30));
		bMaTen.add(lblTenThuoc = new JLabel("Tên Thuốc:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bLoaiNSX.add(Box.createHorizontalStrut(10));
		bLoaiNSX.add(lblLoaiThuoc = new JLabel("Loại Thuốc:"));
		bLoaiNSX.add(txtLoai = new JTextField());
		bLoaiNSX.add(Box.createHorizontalStrut(30));
		bLoaiNSX.add(lblNhaXS = new JLabel("Nhà Sản Xuất:"));
		bLoaiNSX.add(cbbNhaSX = new JComboBox());
		bLoaiNSX.add(Box.createHorizontalStrut(10));
		bbtn.add(btnTim = new JButton("Tìm Thuốc"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnReload = new JButton());
		btnReload.setIcon(iconReload);
		
		bDSThuoc.add(Box.createHorizontalStrut(10));
		bDSThuoc.add(scrDS);
		bDSThuoc.add(Box.createHorizontalStrut(10));
		
		bbtn1.add(Box.createHorizontalStrut(130));
		bbtn1.add(lblSoLuong = new JLabel("Số Lượng:"));
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(txtSoLuong = new JTextField());
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(btnThem = new JButton("Thêm"));
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(btnXoa = new JButton("Xóa"));
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(btnXoaAll = new JButton("Xóa Tất Cả"));
		bbtn1.add(Box.createHorizontalStrut(30));
		bbtn1.add(btnHT = new JButton("Hoàn Tất"));
		bbtn1.add(Box.createHorizontalStrut(130));
		
		txtSoLuong.setPreferredSize(new Dimension(100,24));
		
		bHDThuoc.add(Box.createHorizontalStrut(10));
		bHDThuoc.add(scrHoaDon);
		bHDThuoc.add(Box.createHorizontalStrut(10));
		
		scrDS.setPreferredSize(new Dimension(940,230));
		scrHoaDon.setPreferredSize(new Dimension(940,230));
		scrDS.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrHoaDon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bDSThuoc.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder,"Danh Sách Thuốc"));
		bHDThuoc.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder,"Chi Tiết Hóa Đơn"));
		bTim.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		lblMaThuoc.setPreferredSize(new Dimension(80,24));
		lblTenThuoc.setPreferredSize(lblMaThuoc.getPreferredSize());
		lblLoaiThuoc.setPreferredSize(lblMaThuoc.getPreferredSize());
		lblNhaXS.setPreferredSize(lblMaThuoc.getPreferredSize());
		cbbNhaSX.setPreferredSize(new Dimension(200,24));
		btnTim.setIcon(iconTim);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnThem.setIcon(iconThem);
		btnXoa.setIcon(iconXoa);
		btnXoaAll.setIcon(iconXoaAll);
		btnHT.setIcon(iconHT);
		setColorHeaderTable(lightBlue, tblDS);
		setColorHeaderTable1(lightBlue, tblThuocDaThem);
		
		bTim.add(bMaTen);
		bTim.add(Box.createVerticalStrut(10));
		bTim.add(bLoaiNSX);
		bTim.add(Box.createVerticalStrut(10));
		bTim.add(bbtn);
		bTim.add(Box.createVerticalStrut(5));
		
		b.add(bTim);
		b.add(bDSThuoc);
		b.add(Box.createVerticalStrut(5));
		b.add(bbtn1);
		b.add(bHDThuoc);
		
		p.add(b);
		add(p);
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,###.00 VND");
		
		addWindowListener(this);
		
		thuoc_dao = new Thuoc_DAO();
		dsThuoc = new ArrayList<Thuoc>();
		dsThuocTrongHD = new ArrayList<Thuoc>();
		
		dsThuoc = thuoc_dao.layTTThuoc();
		dscthd = new ArrayList<CT_HoaDon>();
		nsx_dao = new NhaSanXuat_DAO();
		taiNSXVaoCBB();
		taiDuLieuVaoBang();
		
		for(CT_HoaDon ct : cthddd) {
			Object rows[] = {ct.getMaThuoc().getMaThuoc(),ct.getMaThuoc().getTenThuoc(),ct.getSoLuong(),ct.getThanhTien()};
			modelThuocDaThem.addRow(rows);
		}
			
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnHT.addActionListener(this);
		btnXoaAll.addActionListener(this);
		btnReload.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoaTrang.addActionListener(this);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			themThuoc();
		}
		if(obj.equals(btnXoa)) {
			xoaThuocKhoiDanhSach();
		}
		if(obj.equals(btnHT)) {
			if(hoanThanh()) {
				ThemHoaDon_GUI.taiDuLieuVaoTable(dscthd);
				Load.NV_GUI.setEnabled(true);
				this.setVisible(false);
			}
		}
		if(obj.equals(btnReload)) {
			reLoad();
		}
		if(obj.equals(btnXoaAll)) {
			xoaRongDSHD();
		}
		else if (obj.equals(btnTim)) {
			try {
				tim();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(obj.equals(btnXoaTrang)) {
			xoaRongTextField();
		}
	}
	public void xoaRongTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtLoai.setText("");
		cbbNhaSX.setSelectedIndex(0);
	}
	public void taiDuLieuVaoBang() {
		for(int i = 0 ; i < dsThuoc.size() ; i ++) {
			Thuoc t = dsThuoc.get(i);
			modelDS.addRow(new Object[] {
					t.getMaThuoc(),t.getTenThuoc(),t.getDonVi(),sdf.format(t.getNgaySX()),sdf.format(t.getNgayHH()),
					t.getNsx().getMaNSX(),t.getLoaiThuoc(),t.getSoLuong(),df.format(t.getDonGia())
			});
		}
	}
	public void themThuoc() {
		int row = tblDS.getSelectedRow();
		if(row == -1)
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuốc !!!");
		else {
			try {
				String ma = modelDS.getValueAt(row, 0).toString().trim();
				int sl = Integer.parseInt(txtSoLuong.getText().trim());
				Thuoc th = new Thuoc();
				for(Thuoc t : dsThuoc)
					if(t.getMaThuoc().trim().equals(ma))
						th = t;
				Object rows[] = {th.getMaThuoc(),th.getTenThuoc(),sl,th.getDonGia()};
				modelThuocDaThem.addRow(rows);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ !!!");
			}
		}
	}
	public void Hien(boolean b) {
		if(b) {
			this.setEnabled(true);
		}else this.setEnabled(false);
		
	}
	public void reLoad() {
		while(modelDS.getRowCount()>0)
			modelDS.removeRow(0);
		taiDuLieuVaoBang();
	}
	public void taiNSXVaoCBB() {
		cbbNhaSX.addItem("");
		ArrayList<NhaSanXuat> dsnsx = new ArrayList<NhaSanXuat>();
		dsnsx = nsx_dao.layTTNhaSanXuat();
		for(NhaSanXuat n : dsnsx) {
			cbbNhaSX.addItem(n.getMaNSX());
		}
	}
	public void xoaRongDSHD() {
		while(modelThuocDaThem.getRowCount()>0)
			modelThuocDaThem.removeRow(0);
	}
	public void xoaThuocKhoiDanhSach() {
		int row = tblThuocDaThem.getSelectedRow();
		if(row == -1)
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuốc !!!");
		else {
			modelThuocDaThem.removeRow(row);
		}
		
	}
	public boolean hoanThanh() {
		dscthd = new ArrayList<CT_HoaDon>();
		for(int i = 0 ; i < modelThuocDaThem.getRowCount() ; i++) {
			String maThuoc = modelThuocDaThem.getValueAt(i, 0).toString().trim();
			String ten = modelThuocDaThem.getValueAt(i, 1).toString().trim();
			int soluong = Integer.parseInt(modelThuocDaThem.getValueAt(	i, 2).toString().trim());
			CT_HoaDon ct = new CT_HoaDon(new Thuoc(maThuoc, ten), soluong);
			dscthd.add(ct);
		}
		for(Thuoc t : dsThuoc) {
			int sluong = t.getSoLuong();
			for(CT_HoaDon hd : dscthd) {
				if(hd.getMaThuoc().getMaThuoc().trim().equals(t.getMaThuoc().trim()))
					sluong = sluong - hd.getSoLuong();
			}
			if(sluong < 0) {
				JOptionPane.showMessageDialog(this, "Thuốc "+t.getTenThuoc()+" không đủ số lượng !!!");
				return false;
			}
		}
		return true;
	}
	public void setColorHeaderTable(Color color,JTable tbll) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<9;i++){

            //i is the column of the table header
            TableColumn column = tbll.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public void setColorHeaderTable1(Color color,JTable tbll) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<4;i++){

            //i is the column of the table header
            TableColumn column = tbll.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
	public void tim() {
		String maThuoc = txtMa.getText().trim();
		String tenThuoc = txtTen.getText().trim();
		String nsx = cbbNhaSX.getSelectedItem().toString().trim();
		String loaiThuoc = txtLoai.getText().trim();
		ArrayList<Thuoc> ls = new ArrayList<Thuoc>();
		timMa(ls, maThuoc);
		System.out.println(ls);
		ls = timTen(ls, tenThuoc);
		ls = timNhaSX(ls, nsx);
		ls = timLoaiThuoc(ls, loaiThuoc);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc trong danh sách !!!");
		}
		while (modelDS.getRowCount() > 0) 
			modelDS.removeRow(0);
		for (Thuoc t : ls) {
			modelDS.addRow(new Object[] {t.getMaThuoc().trim(), t.getTenThuoc(), t.getDonVi(), 
					sdf.format(t.getNgaySX()), sdf.format(t.getNgayHH()),t.getNsx().getMaNSX(),
					t.getLoaiThuoc(), t.getSoLuong(), 
					df.format(t.getDonGia())});
		}
	}
}
