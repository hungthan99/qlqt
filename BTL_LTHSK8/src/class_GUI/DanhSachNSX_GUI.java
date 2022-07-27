package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import class_DAO.HoaDon_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_Entity.HoaDon;
import class_Entity.NhaSanXuat;

public class DanhSachNSX_GUI extends JFrame implements ActionListener,MouseListener{
	private Box b,bbtn,bTimKiem,bDS,bTacVu,bMaTen;
	private JLabel lblMa,lblTen;
	private JTextField txtMa,txtTen;
	private JButton btnTK,btnXoaTrang,btnXoa,btnSua,btnXemTT,btnReload;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconTK,iconXoaTrang,iconXoa,iconSua,iconXemTT,iconReload;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private String[] header = {"Mã Nhà Sản Xuất","Tên Nhà Sản Xuất","Số Điện Thoại","Địa Chỉ"};
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private static NhaSanXuat_DAO nsx_dao;
	public void DanhSachNSX_GUI(JPanel pen){
		nsx_dao = new NhaSanXuat_DAO();
		iconReload = new ImageIcon(new ImageIcon("images/reload.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/Xoa2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXemTT = new ImageIcon(new ImageIcon("images/XemTT.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconTK = new ImageIcon(new ImageIcon("images/TimKiem.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bbtn = Box.createHorizontalBox();
		bTimKiem = Box.createVerticalBox();
		bDS = Box.createHorizontalBox();
		bTacVu = Box.createHorizontalBox();
		bMaTen = Box.createHorizontalBox();
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Nhà Sản Xuất:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblTen = new JLabel("Tên Nhà Sản Xuất:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bbtn.add(btnTK = new JButton("Tìm"));
		btnTK.addActionListener(this);
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		lblMa.setPreferredSize(new Dimension(110,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		btnTK.setIcon(iconTK);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnTK.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		bTimKiem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tìm Kiếm"));
		bDS.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Nhà Sản Xuất"));
		bTacVu.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Tác Vụ"));
		
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		setColorHeaderTable(lightBlue);
		scroll.setPreferredSize(new Dimension(940,420));
		
		bTimKiem.add(Box.createVerticalStrut(10));
		bTimKiem.add(bMaTen);
		bTimKiem.add(Box.createVerticalStrut(10));
		bTimKiem.add(bbtn);
		bTimKiem.add(Box.createVerticalStrut(10));
		
		bDS.add(Box.createHorizontalStrut(10));
		bDS.add(scroll);
		bDS.add(Box.createHorizontalStrut(10));
		
		bTacVu.add(Box.createHorizontalStrut(212));
		bTacVu.add(btnXoa = new JButton("Xóa"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnSua = new JButton("Chỉnh Sửa Thông Tin"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnXemTT = new JButton("Xem Thông Tin"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnReload = new JButton());
		bTacVu.add(Box.createHorizontalStrut(212));
		
		btnXoa.setIcon(iconXoa);
		btnSua.setIcon(iconSua);
		btnXemTT.setIcon(iconXemTT);
		btnReload.setIcon(iconReload);
		btnXoa.setBackground(veryLightRed);
		btnSua.setBackground(veryLightGreen);
		btnXemTT.setBackground(lightBlue);
		
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnXemTT.setEnabled(false);
		
		b.add(bTimKiem);
		b.add(Box.createHorizontalStrut(10));
		b.add(bDS);
		b.add(Box.createHorizontalStrut(10));
		b.add(bTacVu);
		
		
		pen.add(b);
		
		taiDuLieuVaoBang();
		
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemTT.addActionListener(this);
		btnReload.addActionListener(this);
		tbl.addMouseListener(this);
		btnTK.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà sản xuất !!!");
			}else {
				String ma = model.getValueAt(row, 0).toString();
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhà sản xuất này !!!", "Cảnh Báo !!!",JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					if(nsx_dao.xoaNhaSanXuat(ma)) {
						reLoadTable();
						ThemNhaSX_GUI.reLoadTable();
					}else {
						JOptionPane.showMessageDialog(this, "Không thể xoa !!! Trước tiên, bạn phải xóa tất cả thuốc của nhà sản xuất này !!!");
					}
				}
			}
		}
		if(obj.equals(btnSua)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà sản xuất !!!");
			}else {
				String ma = model.getValueAt(row, 0).toString();
				System.out.println(ma);
				SuaThongTinNhaSanXuat_GUI t = new SuaThongTinNhaSanXuat_GUI(ma);
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
		if(obj.equals(btnReload)) {
			reLoadTable();
		}
		if(obj.equals(btnXemTT)) {
			int row = tbl.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà sản xuất !!!");
			}else {
				String ma = model.getValueAt(row, 0).toString();
				System.out.println(ma);
				XemThongTinNhaSanXuat_GUI t = new XemThongTinNhaSanXuat_GUI(ma);
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		}
		if (obj.equals(btnTK)) {
			try {
				timKiem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(obj.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtTen.setText("");
		}
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<4;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public static void taiDuLieuVaoBang() {
		nsx_dao = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> dsnsx = nsx_dao.layTTNhaSanXuat();
		for(NhaSanXuat n : dsnsx)
			model.addRow(new Object[]{
					n.getMaNSX(),n.getTenNSX(),n.getSdt(),n.getDiaChi()
			});
		
	}
	public static void reLoadTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		taiDuLieuVaoBang();
	}
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			btnXoa.setEnabled(true);
			btnSua.setEnabled(true);
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
		String maNSX = txtMa.getText().trim();
		String tenNSX = txtTen.getText().trim();
		ArrayList<NhaSanXuat> ls = new ArrayList<NhaSanXuat>();
		timMa(ls, maNSX);
		System.out.println(ls);
		ls = timTen(ls, tenNSX);
		if (ls.size() == 0) {
			//JOptionPane.showMessageDialog(this, "Không tìm thấy nhà sản xuất trong danh sách !!!");
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
		}
		deleteTable();
		for (NhaSanXuat nsx : ls) {
			model.addRow(new Object[]{
					nsx.getMaNSX(),nsx.getTenNSX(),nsx.getSdt(),nsx.getDiaChi()
			});
		}
	}
	
	public ArrayList<NhaSanXuat> timMa(ArrayList<NhaSanXuat> list, String maNSX) {
		NhaSanXuat_DAO ds = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> ls = ds.layTTNhaSanXuat();
		Pattern pattern = Pattern.compile(".*" + maNSX + ".*", Pattern.CASE_INSENSITIVE);
		for (NhaSanXuat nsx : ls) {
			Matcher matcher = pattern.matcher(nsx.getMaNSX().trim());
			if (matcher.matches()) {
				list.add(nsx);
			}
		}
		return list;
	}
	
	public ArrayList<NhaSanXuat> timTen(ArrayList<NhaSanXuat> list, String tenNSX) {
		ArrayList<NhaSanXuat> ds = new ArrayList<NhaSanXuat>();
		Pattern pattern = Pattern.compile(".*" + tenNSX + ".*", Pattern.CASE_INSENSITIVE);
		for (NhaSanXuat nsx : list) {
			Matcher matcher = pattern.matcher(nsx.getTenNSX().trim());
			if (matcher.matches()) {
				ds.add(nsx);
			}
		}
		return ds;
	}
	
	public void deleteTable() {
		DefaultTableModel dm = (DefaultTableModel)tbl.getModel();
		dm.getDataVector().removeAllElements();
	}
	
}

