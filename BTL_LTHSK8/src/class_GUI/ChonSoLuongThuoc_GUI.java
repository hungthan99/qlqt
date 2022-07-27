package class_GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import class_DAO.Thuoc_DAO;
import class_Entity.Thuoc;

public class ChonSoLuongThuoc_GUI extends JFrame implements ActionListener,WindowListener{
	private Box b,b1,b2,b22,b3;
	private JLabel lblTitle,lblSoLuong;
	private JTextField txtSoLuong,txtError;
	private JButton btnThem;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Thuoc_DAO thuoc_dao;
	private int SL;
	public ChonSoLuongThuoc_GUI(int sluong) {
		SL = sluong;
		thuoc_dao = new Thuoc_DAO();
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b22 = Box.createHorizontalBox();
		
		b1.add(lblTitle = new JLabel("NHẬP SỐ LƯỢNG THUỐC"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblSoLuong = new JLabel("Số lượng:"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(txtSoLuong = new JTextField());
		b2.add(Box.createHorizontalStrut(10));
		b22.add(Box.createHorizontalStrut(10));
		b22.add(txtError = new JTextField());
		b22.add(Box.createHorizontalStrut(10));
		b3.add(btnThem = new JButton("Nhập"));
		
		b.add(Box.createVerticalStrut(10));
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b22);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		
		lblTitle.setForeground(veryLightRed);
		txtSoLuong.setBorder(null);
		btnThem.setBackground(veryLightGreen);
		txtError.setEditable(false);
		txtError.setBorder(null);
		
		add(b);
		setSize(300,170);
		setLocationRelativeTo(null);
		
		btnThem.addActionListener(this);
		this.addWindowListener(this);
		thuoc_dao.layTTThuoc();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			if(txtSoLuong.getText().trim().equals(""))
				thongBao("Bạn chưa nhập số lượng !!!");
			else {
				try {
					int soLuong = Integer.parseInt(txtSoLuong.getText().toString());
					if(SL - soLuong < 0)
						JOptionPane.showMessageDialog(this, "Thuốc không còn đủ số lượng !!!");
					else {
						Load.NV_GUI.setEnabled(true);
						this.setVisible(false);
					}
				} catch (Exception e2) {
					thongBao("Số lượng phải là số !!!");
				}
			}
		}
	}
	public void thongBao(String mess) {
		txtError.setForeground(Color.RED);
		txtError.setText(mess);
		txtSoLuong.requestFocus();
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
		Load.NV_GUI.setEnabled(true);
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
