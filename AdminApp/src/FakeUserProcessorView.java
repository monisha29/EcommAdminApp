import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FakeUserProcessorView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FakeUserProcessorView frame = new FakeUserProcessorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FakeUserProcessorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewListOf = new JButton("View List Of Users");
		btnViewListOf.setFont(new Font("Rockwell", Font.BOLD, 13));
		
		
		
		
		btnViewListOf.setBounds(0, 11, 434, 36);
		contentPane.add(btnViewListOf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 401, 147);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Id", "User Name", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnComputerStatusOf = new JButton("Computer status of user");
		btnComputerStatusOf.setFont(new Font("Rockwell", Font.BOLD, 10));
		btnComputerStatusOf.setBounds(0, 216, 235, 33);
		contentPane.add(btnComputerStatusOf);
		
		JButton btnComputeStatusOf = new JButton("Compute status of all users");
		btnComputeStatusOf.setFont(new Font("Rockwell", Font.BOLD, 11));
		btnComputeStatusOf.setBounds(239, 216, 195, 33);
		contentPane.add(btnComputeStatusOf);
	}
}
