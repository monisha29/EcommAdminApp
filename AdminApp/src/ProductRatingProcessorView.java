import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


import Controller.ProductRatingProcessorController;
import Model.Comment;
import Model.Product;
import Model.ProductRatingProcessor;

public class ProductRatingProcessorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductRatingProcessorView frame = new ProductRatingProcessorView();
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
	public ProductRatingProcessorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewListOf = new JButton("View Rating Of Product");
		btnViewListOf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Product> list = Product.fetchAllProducts();
				System.out.println(" co : " +  list.size());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int count = 1;
				
				for(Product p : list)
				{
					//String co = Integer.parseInt(count).to;
					//System.out.println(p.body.toString());
					//System.out.println(c.sentiment);
					model.addRow(new Object[]{p.productId.toString(), p.productName.toString(),p.productRating});
					count++;
				}
			}
		});
		
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
				"ProductId", "ProductName" , "ProductRating"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btn_1 = new JButton("Compute Rating for a product");
		btn_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			int rowselected = table.getSelectedRow();
			System.out.println(rowselected);
		    String product =  table.getModel().getValueAt(rowselected,0).toString();
			System.out.println(product);
			ProductRatingProcessorController controller = new ProductRatingProcessorController();
		     String outcome= controller.generateRating(product);
			System.out.println(outcome);
			table.getModel().setValueAt(outcome,rowselected, 2);
			((AbstractTableModel) table.getModel()).fireTableDataChanged();
			//update document in mongodb using id 
			
			Product product1 = new Product();
		
			product1.productRating = outcome;
			
			//boolean updateCommentSentiment = ((SentimentProcessorController) controller).updateCommentSentiment(updatedComment);
			boolean updateProductRating = product1.updateProduct(product);
			if(updateProductRating==true)
				JOptionPane.showMessageDialog(null, "updated on database");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
				
		btn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		btn_1.setFont(new Font("Rockwell", Font.BOLD, 10));
		btn_1.setBounds(0, 216, 235, 33);
		contentPane.add(btn_1);
		
	
		
		JButton btnNewButton = new JButton("Compute Rating For All Product");
		btnNewButton.setBounds(237, 216, 174, 33);
		contentPane.add(btnNewButton);
	}
}