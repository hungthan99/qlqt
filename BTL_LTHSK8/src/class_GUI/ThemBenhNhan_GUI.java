package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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

public class ThemBenhNhan_GUI extends JFrame implements MouseListener,ActionListener{
	private Box b,bThem,bDS,bMaTen,bSDTGTNS,bGhiChu,bDiaChi,berror,bbtn;
	private JLabel lblMa,lblTen,lblSDT,lblGT,lblNgaySinh,lblGhiChu,lblDiaChi;
	private JTextField txtMa,txtTen,txtsdt,txtGhiChu,txterror,txtDiaChi,txtTuoi;
	private JRadioButton radNam,radNu;
	private JButton btnThem,btnXoaTrang;
	private JTable tbl;
	private static DefaultTableModel model;
	private JScrollPane scroll;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Color lightRed = new Color(204,0,0);
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private String[] header = {"M?? B???nh Nh??n","T??n B???nh Nh??n","Gi???i T??nh","Tu???i","?????a Ch???","S??? ??i???n Tho???i"};
	private ButtonGroup buttongroup;
	private ImageIcon iconThem,iconXoaTrang;
	private static BenhNhan_DAO bn_dao;
	public void ThemBenhNhan_GUI(JPanel panel) {
		bn_dao = new BenhNhan_DAO();
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconThem = new ImageIcon(new ImageIcon("images/ThemHD.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bThem = Box.createVerticalBox();
		bMaTen = Box.createHorizontalBox();
		bSDTGTNS = Box.createHorizontalBox();
		bGhiChu = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDS = Box.createHorizontalBox();
		bDiaChi = Box.createHorizontalBox();
		berror = Box.createHorizontalBox();
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("N???");
		buttongroup = new ButtonGroup();
		buttongroup.add(radNam);
		buttongroup.add(radNu);
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("M?? B???nh Nh??n:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(50));
		bMaTen.add(lblTen = new JLabel("T??n B???nh Nh??n:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(lblSDT = new JLabel("S??? ??i???n Tho???i:"));
		bSDTGTNS.add(txtsdt = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblGT = new JLabel("Gi???i T??nh:"));
		bSDTGTNS.add(radNam);
		bSDTGTNS.add(radNu);
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblNgaySinh = new JLabel("Tu???i"));
		bSDTGTNS.add(txtTuoi = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bDiaChi.add(Box.createHorizontalStrut(10));
		bDiaChi.add(lblDiaChi = new JLabel("?????a Ch???:"));
		bDiaChi.add(txtDiaChi = new JTextField());
		bDiaChi.add(Box.createHorizontalStrut(10));
		bGhiChu.add(Box.createHorizontalStrut(10));
		bGhiChu.add(lblGhiChu = new JLabel("Ghi Ch??:"));
		bGhiChu.add(txtGhiChu = new JTextField());
		bGhiChu.add(Box.createHorizontalStrut(10));
		berror.add(Box.createHorizontalStrut(10));
		berror.add(txterror = new JTextField());
		berror.add(Box.createHorizontalStrut(10));
		bbtn.add(btnThem = new JButton("Th??m B???nh Nh??n"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("X??a Tr???ng"));
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblGhiChu.setPreferredSize(lblMa.getPreferredSize());
		scroll.setPreferredSize(new Dimension(940,350));
		
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtsdt.setBorder(null);
		txtDiaChi.setBorder(null);
		txterror.setBorder(null);
		txterror.setEditable(false);
		txtTuoi.setBorder(null);
		txtGhiChu.setBorder(null);
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		btnThem.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder,"Th??m B???nh Nh??n"));
		bDS.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder,"Danh S??ch B???nh Nh??n"));
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bMaTen);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bSDTGTNS);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bDiaChi);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bGhiChu);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(berror);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bbtn);
		bThem.add(Box.createVerticalStrut(10));
		
		bDS.add(Box.createHorizontalStrut(10));
		bDS.add(scroll);
		bDS.add(Box.createHorizontalStrut(10));
		
		b.add(bThem);
		b.add(bDS);
		
		panel.add(b);
		
		taiDuLieuVaoTable();
		
		tbl.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}
	public static void taiDuLieuVaoTable() {
		bn_dao = new BenhNhan_DAO();
		ArrayList<BenhNhan> dsbn = new ArrayList<BenhNhan>();
		dsbn = bn_dao.taiDSBenhNHan();
		for(BenhNhan bn : dsbn)
			model.addRow(new Object[] {
					bn.getMaBenhNhan(),bn.getTenBenhNhan(),bn.getGioiTinh(),bn.getTuoi(),bn.getDiaChi(),bn.getSdt()
			});
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
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			txtMa.setText((String) model.getValueAt(row, 0));
			txtTen.setText((String) model.getValueAt(row, 1));
			radNam.setSelected(true);
			if(model.getValueAt(row, 2).toString().equals("n???"))
				radNu.setSelected(true);
			txtTuoi.setText(model.getValueAt(row, 3).toString());
			txtDiaChi.setText((String)model.getValueAt(row, 4));
			txtsdt.setText((String)model.getValueAt(row, 5));
			txtGhiChu.setText(bn_dao.timBenhNhan(model.getValueAt(row, 0).toString()).getGhiChu());
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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrang))
			xoaTrangTextField();
		if(obj.equals(btnThem)) {
			if(kiemTraCuuPhap()) {
				BenhNhan bn = layBenhNhanTuTextField();
				if(bn_dao.themBenhNhan(bn)) {
					/*model.addRow(new Object[] {
							bn.getMaBenhNhan(),bn.getTenBenhNhan(),bn.getGioiTinh(),bn.getTuoi(),bn.getDiaChi(),bn.getSdt()
					});*/
					DanhSachBenhNhan_GUI.reloadTable();
					reloadTable();
					thongBaoLoi("Th??m th??nh c??ng 1 b???nh nh??n", txtMa);
					txterror.setForeground(Color.BLUE);
					xoaTrangTextField();
				}else
					thongBaoLoi("Tr??ng m?? b???nh nh??n !!!", txtMa);
			}
		}
	}
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtsdt.setText("");
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
	}
	public boolean kiemTraCuuPhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String sdt = txtsdt.getText().trim();
		String tuoi = txtTuoi.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String ghichu = txtGhiChu.getText().trim();
		if(ma.equals("")||ten.equals("")||sdt.equals("")||tuoi.equals("")||diachi.equals("")||ghichu.equals("")) {
			thongBaoLoi("Vui l??ng nh???p ?????y ????? th??ng tin !!!", txtMa);
			return false;
		}
		if(!ma.matches("BN\\d{4}")) {
			thongBaoLoi("M?? B???nh Nh??n ph???i l??: 'BNxxxx', x l?? s??? !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")) {
			thongBaoLoi("S??? ??i???n tho???i kh??ng h???p l??? !!!", txtsdt);
			return false;
		}
		try {
			if(Integer.parseInt(tuoi) <= 0) {
				thongBaoLoi("Tu???i kh??ng h???p l??? !!!", txtTuoi);
				return false;
			}	
		} catch (Exception e) {
			thongBaoLoi("Tu???i kh??ng h???p l??? !!!", txtTuoi);
			return false;
		}
		if(!radNam.isSelected())
			if(!radNu.isSelected()) {
				thongBaoLoi("B???n ch??a ch???n gi???i t??nh !!!", txtsdt);
				return false;
			}
		return true;
	}
	public void thongBaoLoi(String mess, JTextField txt) {
		txterror.setForeground(Color.RED);
		txt.requestFocus();
		txterror.setText(mess);
	}
	public BenhNhan layBenhNhanTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String sdt = txtsdt.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim().toString());
		String diachi = txtDiaChi.getText().trim();
		String ghichu = txtGhiChu.getText().trim();
		String gt = "nam";
		if(radNu.isSelected())
			gt = "n???";
		BenhNhan bn = new BenhNhan(ma, ten, gt, sdt, diachi, tuoi, ghichu);
		return bn;
	}
	public static void reloadTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		taiDuLieuVaoTable();
	}
}
