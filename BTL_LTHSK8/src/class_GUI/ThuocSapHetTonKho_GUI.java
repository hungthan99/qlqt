package class_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_Connection.Connect_DB;
import class_DAO.Thuoc_DAO;
import class_Entity.Thuoc;

public class ThuocSapHetTonKho_GUI extends JFrame implements ActionListener,ItemListener,MouseListener{
	private Box b,bTacVu,bTitle,bDanhSach,blbl;
	private JLabel lblTitle,lblSoLuong;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private JButton btnThemSL;
	private String[] header = {"Mã Thuốc","Tên Thuốc","Loại Thuốc","Đơn Vị","Ngày Sản Xuất","Ngày Hết Hạn","Số Lượng","Đơn Giá","Nhà Sản Xuất"};
	private Color lightBlue = new Color(51,204,255);
	private DefaultTableCellRenderer cellRenderer;
	private ImageIcon iconThem;
	private static JComboBox<String> cbbSoLuong;
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	private static Thuoc_DAO thuoc_dao;
	public void ThuocSapHetTonKho_GUI(JPanel pen) {
		b = Box.createVerticalBox();
		bTacVu = Box.createHorizontalBox();
		bTitle = Box.createHorizontalBox();
		bDanhSach = Box.createHorizontalBox();
		blbl = Box.createHorizontalBox();
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		cbbSoLuong = new JComboBox<String>();
		iconThem = new ImageIcon(new ImageIcon("images/themthuoc1.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		
		bTitle.add(lblTitle = new JLabel("THUỐC SẮP HẾT TỒN KHO"));
		blbl.add(lblSoLuong = new JLabel("Số Lượng Thuốc Bé Hơn:   "));
		blbl.add(cbbSoLuong);
		blbl.add(Box.createHorizontalStrut(770));
		bDanhSach.add(scroll);
		bTacVu.add(btnThemSL = new JButton("Nhập Thêm Số Lượng Thuốc"));
		
		lblTitle.setFont(new Font("Times New Roman",Font.BOLD,30));
		lblTitle.setForeground(veryLightRed);
		scroll.setPreferredSize(new Dimension(960,490));
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		btnThemSL.setIcon(iconThem);
		btnThemSL.setBackground(lightBlue);
		btnThemSL.setEnabled(false);
		
		cbbSoLuong.addItem("5");
		cbbSoLuong.addItem("10");
		cbbSoLuong.addItem("15");
		cbbSoLuong.addItem("20");
		cbbSoLuong.setBackground(Color.WHITE);
		
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(blbl);
		b.add(Box.createVerticalStrut(10));
		b.add(bDanhSach);
		b.add(Box.createVerticalStrut(10));
		b.add(bTacVu);
		
		pen.add(b);
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,###.00 VND");
		
		Connect_DB.getInstance().connect();
		docDuLieuVaoBang();
		
		cbbSoLuong.addItemListener(this);
		btnThemSL.addActionListener(this);
		tbl.addMouseListener(this);
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
	private static void docDuLieuVaoBang() {
		thuoc_dao = new Thuoc_DAO();
		ArrayList<Thuoc> ls = thuoc_dao.layTTThuoc();
		ArrayList<Thuoc> lsTK = new ArrayList<Thuoc>();
		for (Thuoc t : ls) {
			if (t.getSoLuong() < Integer.parseInt(cbbSoLuong.getSelectedItem().toString().trim())) {
				lsTK.add(t); 
			}
		}
		for (Thuoc hh : lsTK) {
			model.addRow(new Object[] {hh.getMaThuoc(), hh.getTenThuoc(), hh.getLoaiThuoc(), hh.getDonVi(), 
					sdf.format(hh.getNgaySX()), sdf.format(hh.getNgayHH()), hh.getSoLuong(), df.format(hh.getDonGia()),
					hh.getNsx().getMaNSX()});
		}
	}
	
	public static void reload() {
		while(model.getRowCount() > 0)
			model.removeRow(0);
		docDuLieuVaoBang();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = tbl.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuốc");
		}else {
			String ma = model.getValueAt(row, 0).toString().trim();
			Thuoc th = thuoc_dao.getThuoc(ma);
			NhapThemSoLuongThuoc_GUI t = new NhapThemSoLuongThuoc_GUI(th);
			t.setVisible(true);
			this.setEnabled(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		int row = cbbSoLuong.getSelectedIndex();
		if(row != -1)
			reload();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1)
			btnThemSL.setEnabled(true);
		else btnThemSL.setEnabled(false);
		
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
