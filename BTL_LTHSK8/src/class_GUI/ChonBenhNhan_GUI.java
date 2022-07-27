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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

import class_DAO.BenhNhan_DAO;
import class_Entity.BenhNhan;

public class ChonBenhNhan_GUI extends JFrame implements WindowListener,ActionListener,MouseListener{
	private Box b,bTK,bDanhSach,bTacVu;
	private Box bMaTen,bDiaChiGT,bbtn;
	private JLabel lblMa,lblTen;
	private JTextField txtMa,txtTen,txtTuoi;
	private JRadioButton radNam,radNu;
	private JButton btnTK,btnXoaTrang,btnChon,btnReload;
	private DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private String[] header = {"Mã Bệnh Nhân","Tên Bệnh Nhân","Giới Tính","Tuổi","Địa Chỉ","Số Điện Thoại"};
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private ImageIcon iconTim;
	private Box bgc;
	private Box bsdt;
	private JLabel lblsdt;
	private JTextField txtsdt;
	private JLabel lblns;
	private JLabel lbldc;
	private JTextField txtdc;
	private JLabel lblgc;
	private ImageIcon iconXoa,iconChon,iconApp,iconReload;
	private JPanel pTacVu;
	private JLabel lblGT;
	private ButtonGroup radGioiTinh;
	private DefaultTableCellRenderer cellRenderer;
	private BenhNhan_DAO bn_dao;
	public ChonBenhNhan_GUI() {
		bn_dao = new BenhNhan_DAO();
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconTim = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/xoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconChon = new ImageIcon(new ImageIcon("images/chon2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		
		b = Box.createVerticalBox();
		bTK = Box.createVerticalBox();
		bMaTen = Box.createHorizontalBox();
		bsdt = Box.createHorizontalBox();
		bDiaChiGT = Box.createHorizontalBox();
		bgc= Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDanhSach = Box.createHorizontalBox();
		bTacVu = Box.createHorizontalBox();
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		
		radNu = new JRadioButton("Nữ");
		radNam = new JRadioButton("Nam");
		radGioiTinh = new ButtonGroup();
		radGioiTinh.add(radNam);
		radGioiTinh.add(radNu);
		radNam.setSelected(true);
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Bệnh Nhân:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(30));
		bMaTen.add(lblTen = new JLabel("Tên Bệnh Nhân:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bsdt.add(Box.createHorizontalStrut(10));
		bsdt.add(lblsdt = new JLabel("Số điện thoại:"));
		bsdt.add(txtsdt = new JTextField());
		bsdt.add(Box.createHorizontalStrut(30));
		bsdt.add(lblGT = new JLabel("Giới Tính:"));
		bsdt.add(radNam);
		bsdt.add(radNu);
		bsdt.add(Box.createHorizontalStrut(60));
		bsdt.add(lblns = new JLabel("Tuổi:"));
		bsdt.add(txtTuoi = new JTextField());
		bsdt.add(Box.createHorizontalStrut(10));
		bDiaChiGT.add(Box.createHorizontalStrut(10));
		bDiaChiGT.add(lbldc = new JLabel("Địa chỉ:"));
		bDiaChiGT.add(txtdc = new JTextField());
		bDiaChiGT.add(Box.createHorizontalStrut(10));
		btnTK = new JButton("Tìm Kiếm");
		btnXoaTrang = new JButton("Xóa Trắng");
		bbtn.add(btnTK);
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang);
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnReload = new JButton());
		btnReload.setIcon(iconReload);
		btnTK.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		btnTK.setIcon(iconTim);
		btnXoaTrang.setIcon(iconXoa);
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtsdt.setBorder(null);
		txtdc.setBorder(null);
		txtTuoi.setBorder(null);
		
		int w = 100;
		int h = 24;
		lblMa.setPreferredSize(new Dimension(w,h));
		lblTen.setPreferredSize(new Dimension(w,h));
		lblsdt.setPreferredSize(new Dimension(w,h));
		lblGT.setPreferredSize(new Dimension(60,h));
		lblns.setPreferredSize(new Dimension(80,h));
		lbldc.setPreferredSize(new Dimension(w,h));		
		
		bTK.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm Bệnh Nhân"));
		pTacVu = new JPanel();
		pTacVu.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder,"Tác vụ"));
		bDanhSach.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Bệnh Nhân"));
		scroll.setPreferredSize(new Dimension(500,100));
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		bTacVu.add(pTacVu);
		scroll.setPreferredSize(new Dimension(940,330));
		
		pTacVu.add(btnChon = new JButton("Chọn Bệnh Nhân"));
		btnChon.setBackground(veryLightGreen);
		btnChon.setIcon(iconChon);
		
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bMaTen);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bsdt);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bDiaChiGT);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bbtn);
		bTK.add(Box.createVerticalStrut(10));
		
		bDanhSach.add(Box.createHorizontalStrut(10));
		bDanhSach.add(scroll);
		bDanhSach.add(Box.createHorizontalStrut(10));
		
		b.add(bTK);
		b.add(bDanhSach);
		b.add(bTacVu);
		
		add(b);
		setSize(new Dimension(900,500));
		setLocationRelativeTo(null);
		iconApp = new ImageIcon("images/iconApp.png");
		setIconImage(iconApp.getImage());
		
		taiDuLieuVaoTable();
		
		btnChon.addActionListener(this);
		this.addWindowListener(this);
		tbl.addMouseListener(this);
		btnXoaTrang.addActionListener(this);
		btnTK.addActionListener(this);
		btnReload.addActionListener(this);
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<6;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public void taiDuLieuVaoTable() {
		bn_dao = new BenhNhan_DAO();
		ArrayList<BenhNhan> dsbn = new ArrayList<BenhNhan>();
		dsbn = bn_dao.taiDSBenhNHan();
		for(BenhNhan bn : dsbn)
			model.addRow(new Object[] {
					bn.getMaBenhNhan(),bn.getTenBenhNhan(),bn.getGioiTinh(),bn.getTuoi(),bn.getDiaChi(),bn.getSdt()
			});
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnChon)) {
			int row = tbl.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn bệnh nhân nào !!!");
			else {
				String ma = model.getValueAt(row, 0).toString();
				ThemHoaDon_GUI.setBenhNhan(ma);
				Load.NV_GUI.setEnabled(true);
				this.setVisible(false);
			}
		}else if(obj.equals(btnXoaTrang)) {
			xoaTrangTextField();
		}else if(obj.equals(btnTK)) {
			try {
				timKiem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(obj.equals(btnReload)) {
			reloadTable();
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
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtsdt.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
	}
	public ArrayList<BenhNhan> timMa(ArrayList<BenhNhan> list, String maBN) {
		BenhNhan_DAO ds = new BenhNhan_DAO();
		ArrayList<BenhNhan> ls = ds.taiDSBenhNHan();
		Pattern pattern = Pattern.compile(".*" + maBN + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : ls) {
			Matcher matcher = pattern.matcher(bn.getMaBenhNhan().trim());
			if (matcher.matches()) {
				list.add(bn);
			}
		}
		return list;
	}
	
	public ArrayList<BenhNhan> timTen(ArrayList<BenhNhan> list, String tenBN) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		Pattern pattern = Pattern.compile(".*" + tenBN + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : list) {
			Matcher matcher = pattern.matcher(bn.getTenBenhNhan().trim());
			if (matcher.matches()) {
				ds.add(bn);
			}
		}
		return ds;
	}
	
	public ArrayList<BenhNhan> timSDT(ArrayList<BenhNhan> list, String sdt) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		Pattern pattern = Pattern.compile(".*" + sdt + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : list) {
			Matcher matcher = pattern.matcher(bn.getSdt().trim());
			if (matcher.matches()) {
				ds.add(bn);
			}
		}
		return ds;
	}
	
	public ArrayList<BenhNhan> timGT(ArrayList<BenhNhan> list, String gt) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		Pattern pattern = Pattern.compile(".*" + gt + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : list) {
			Matcher matcher = pattern.matcher(bn.getGioiTinh().trim());
			if (matcher.matches()) {
				ds.add(bn);
			}
		}
		return ds;
	}
	
	public ArrayList<BenhNhan> timTuoi(ArrayList<BenhNhan> list, String tuoi) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		Pattern pattern = Pattern.compile(".*" + tuoi + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : list) {
			Matcher matcher = pattern.matcher(String.valueOf(bn.getTuoi()).trim());
			if (matcher.matches()) {
				ds.add(bn);
			}
		}
		return ds;
	}
	
	public ArrayList<BenhNhan> timDiaChi(ArrayList<BenhNhan> list, String diaChi) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		Pattern pattern = Pattern.compile(".*" + diaChi + ".*", Pattern.CASE_INSENSITIVE);
		for (BenhNhan bn : list) {
			Matcher matcher = pattern.matcher(bn.getDiaChi().trim());
			if (matcher.matches()) {
				ds.add(bn);
			}
		}
		return ds;
	}
	public void timKiem() {
		String maBN = txtMa.getText().trim();
		String tenBN = txtTen.getText().trim();
		String sdt = txtsdt.getText().trim();
		String gioiTinh = (radNam.isSelected() ? "nam" : "nữ").trim();
		String tuoi = txtTuoi.getText().trim();
		String diaChi = txtdc.getText().trim();
		ArrayList<BenhNhan> ls = new ArrayList<BenhNhan>();
		timMa(ls, maBN);
		System.out.println(ls);
		ls = timTen(ls, tenBN);
		ls = timSDT(ls, sdt);
		ls = timGT(ls, gioiTinh);
		ls = timTuoi(ls, tuoi);
		ls = timDiaChi(ls, diaChi);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy bệnh nhân trong danh sách !!!");
		}
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		for (BenhNhan bn : ls) {
			model.addRow(new Object[] {
					bn.getMaBenhNhan(),bn.getTenBenhNhan(),bn.getGioiTinh(),bn.getTuoi(),bn.getDiaChi(),bn.getSdt()
			});
		}
	}
	public void reloadTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		taiDuLieuVaoTable();
	}
}
	

	
