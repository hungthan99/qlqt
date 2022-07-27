package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import class_DAO.HoaDon_DAO;

public class DoanhThuCacNam_GUI extends JFrame implements ItemListener,ActionListener{
	private Box b,bTitle,bNgayThang,bChart;
	private String TitleChart;
	private JTextField txtError;
	private JLabel lblTitle,lblTitleChart,lblNam1, lblNam2;
	private JComboBox<Integer> cbbNam1,cbbNam2;
	private static DefaultCategoryDataset dataset;
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconXem;
	private JButton btnXem;
	private Color lightBlue = new Color(51,204,255);
	private HoaDon_DAO hd_dao;
	public void DoanhThuCacNam_GUI(JPanel panel) {
		hd_dao = new HoaDon_DAO();
		iconXem = new ImageIcon(new ImageIcon("images/TKNam.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bNgayThang = Box.createHorizontalBox();
		bChart = Box.createHorizontalBox();
		cbbNam1 = new JComboBox();
		cbbNam2 = new JComboBox();
		JFreeChart pieChart = createChart();
		ChartPanel chartPanel = new ChartPanel(pieChart);
		addComboboxNam();
		LocalDate date = LocalDate.now();
		
		bTitle.add(lblTitle = new JLabel("DOANH THU CÁC NĂM"));
		bNgayThang.add(Box.createHorizontalStrut(150));
		bNgayThang.add(lblNam1 = new JLabel("Danh Thu Từ Năm:"));
		bNgayThang.add(cbbNam1);
		bNgayThang.add(lblNam2 = new JLabel("Đến Năm:"));
		bNgayThang.add(cbbNam2);
		bNgayThang.add(btnXem = new JButton("Xem Biểu Đồ"));
		bNgayThang.add(Box.createHorizontalStrut(150));
		bChart.add(chartPanel);
		String ChartTitle = "Biểu Đồ Thống Kê Doanh Từ Năm"+cbbNam1.getSelectedItem()+"Đến Năm"+cbbNam2.getSelectedItem();
		
		chartPanel.setBackground(Color.WHITE);
		lblTitle.setForeground(veryLightRed);
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,30));
		btnXem.setIcon(iconXem);
		btnXem.setBackground(lightBlue);
		cbbNam1.setBackground(Color.WHITE);
		cbbNam2.setBackground(Color.WHITE);
		
		chartPanel.setPreferredSize(new Dimension(900,500));
		
		
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bNgayThang);
		b.add(Box.createVerticalStrut(10));
		b.add(bChart);
		
		panel.setBackground(Color.WHITE);
		panel.add(b);
		
		cbbNam1.addItemListener(this);
		cbbNam2.addItemListener(this);
		btnXem.addActionListener(this);
		
		hd_dao.layDuLieuTuDB();
	}
	public JFreeChart createChart() {
		JFreeChart barChart = ChartFactory.createBarChart("Biểu Đồ Thống Kê Doanh Năm", "Năm", "Doanh thu(VND)",
				createDataset(), PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	private CategoryDataset createDataset() {
		dataset = new DefaultCategoryDataset();
		return dataset;
	}
	public void addComboboxNam() {
		LocalDate date = LocalDate.now();
		for (int i = date.getYear(); i >= 2017; i--) {
			cbbNam1.addItem(i);
			cbbNam2.addItem(i);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXem)) {
			loadData();
		}
		
	}
	public void loadData() {
		while(dataset.getRowCount()>0)
			dataset.removeRow(0);
		int year1 = (int) cbbNam1.getSelectedItem();
		int year2 = (int) cbbNam2.getSelectedItem();
		if(year1 > year2) {
			JOptionPane.showMessageDialog(this, "Năm bắt đầu phải bé hơn năm kết thúc !!!");
		}else {
			for (int i = year1; i <= year2; i++) {
				LocalDate date = LocalDate.of(i, 1, 1);
				double tien = hd_dao.layDoanhThuNam(date);
				dataset.addValue(tien, "DoanhThu", i + "");
			}
		}
	}
}

