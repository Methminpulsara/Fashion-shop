import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Demo extends JFrame{
	
	public static void main(String args[]){
		
	//CustomerCollection customerclass = new CustomerCollection();	
	
	
	JFrame f = new JFrame();
	f.setSize(300,400);
	f.setTitle("Fashion shop");
	f.setDefaultCloseOperation(3);
	f.setLocationRelativeTo(null);
	
	
	JLabel maintitel = new JLabel ("Fashion Shop");
	maintitel.setFont(new Font ("",3,30));
	maintitel.setHorizontalAlignment(JLabel.CENTER);
	f.add("North",maintitel);
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	
	
	JPanel butttonpanle = new JPanel (new GridLayout (8,1,3,3));
	
	// GET BUTTONS=======//
	
	b1 = new JButton ("Place Order");
	
	b3 = new JButton ("Search Order");
	b4 = new JButton ("Viwe Order");
	b5 = new JButton ("Upadate Order");
	b6 = new JButton ("Delete Order");
	b7 = new JButton ("Exit");
	
	
	
	b1.setFont(new Font("",1,10));
	
	b3.setFont(new Font("",1,10));
	b4.setFont(new Font("",1,10));
	b5.setFont(new Font("",1,10));
	b6.setFont(new Font("",1,10));
	b7.setFont(new Font("",1,10));
	
	
	JPanel b1_center = new JPanel (new FlowLayout(FlowLayout.CENTER));
	b1_center.add(b1);
	butttonpanle.add(b1_center);
	
	JPanel b3_center = new JPanel (new FlowLayout(FlowLayout.CENTER));
	b3_center.add (b3);
	butttonpanle.add(b3_center);
	
	JPanel b4_center = new JPanel(new FlowLayout(FlowLayout.CENTER));
	b4_center.add(b4);
	butttonpanle.add(b4_center);
	
	JPanel b5_center = new JPanel (new FlowLayout(FlowLayout.CENTER));
	b5_center.add (b5);
	butttonpanle.add(b5_center);
	
	JPanel b6_center = new JPanel(new FlowLayout(FlowLayout.CENTER));
	b6_center.add(b6);
	butttonpanle.add (b6_center);
	
	JPanel b7_center = new JPanel (new FlowLayout(FlowLayout.CENTER));
	b7_center.add (b7);
	butttonpanle.add(b7_center);
	
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			new AddCustomer().setVisible(true);  // customer collection class ek ywnw add customer class ekt 
		}
		
	});
	
	
	
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			new SearchOder().setVisible(true);
			
		}
		
	});
	
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			new ViweCustomer ().setVisible(true);
		}
	});
	
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			new UpdateCustomer().setVisible(true);
			
		}
		
	});
	
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			new DeleteCustomer().setVisible(true);
		}
	});
	
	b7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			System.out.println("Hy:");
			
		}
	});
	
	f.add(butttonpanle);
	f.setVisible(true);
		
	}
	
	
	
	}
	
class Demo1 {
	public static void main(String a[]){
	
		new AddCustomer().setVisible(true);	
	}
}
