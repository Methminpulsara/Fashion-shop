import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


	

class AddCustomer extends JFrame{
	int price=0;
	private JLabel maintitel;
	
	private JLabel order;
	private JLabel number;
	private JLabel size;
	private JLabel qty;
	private JLabel amount; 	
	
	private JTextField Torder;
	private JTextField Tnumber;
	private JTextField Tsize;
	private JTextField Tqty;
	private JTextField Tamount;
	
	private JButton add;
	private JButton back;
	private JButton cancel;
	
	
	
	AddCustomer(){
	
	setSize(300,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(2);
	setTitle("Fashion shop");
	
	maintitel = new JLabel ("Add Customer  ");
	maintitel.setHorizontalAlignment(JLabel.CENTER);
	maintitel.setFont(new Font ("",2,30));	
	add("North",maintitel);

	order = new JLabel("Order ID");
	number = new JLabel("Contact Number");
	size = new JLabel("Size (xs,s,m,l,xl,xxl)");
	qty = new JLabel("Qty");
	amount = new JLabel("Amount");
	
	order.setFont(new Font("",2,15));
	number.setFont(new Font("",2,15));
	size.setFont(new Font("",2,15));
	qty.setFont(new Font("",2,15));
	amount.setFont(new Font("",2,15));

	JPanel lblpanele = new JPanel(new GridLayout(6,1));
	lblpanele.add(order);
	lblpanele.add(number);
	lblpanele.add(size);
	lblpanele.add(qty);
	lblpanele.add(amount);
	
	add("West",lblpanele);
	
	
	
	Torder = new JTextField(10);
	Tnumber = new JTextField(10);
	Tsize = new JTextField(10);
	Tqty = new JTextField(10);
	Tamount = new JTextField(10);
	
	Torder.setFont(new Font ("",1,10));
	Tnumber.setFont(new Font ("",1,10));
	Tsize.setFont(new Font ("",1,10));
	Tqty.setFont(new Font ("",1,10));
	Tamount.setFont(new Font ("",1,10));
	
	
	JPanel textpanel = new JPanel (new GridLayout(6,1));
	JPanel t1 = new JPanel(new FlowLayout (FlowLayout.RIGHT));
	JPanel t2 = new JPanel(new FlowLayout (FlowLayout.RIGHT));
	JPanel t3 = new JPanel(new FlowLayout (FlowLayout.RIGHT));
	JPanel t4 = new JPanel(new FlowLayout (FlowLayout.RIGHT));
	JPanel t5 = new JPanel(new FlowLayout (FlowLayout.RIGHT));
	
	t1.add(Torder);
	t2.add(Tnumber);
	t3.add(Tsize);
	t4.add(Tqty);
	t5.add(Tamount);
	
	textpanel.add(t1);
	textpanel.add(t2);
	textpanel.add(t3);
	textpanel.add(t4);
	textpanel.add(t5);
	
	add(textpanel);
	
	
// =================Buttons==============================//	
	
	JPanel btnpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));	
	add= new JButton ("Add customer");
	add.setFont(new Font ("",1,10));
	add.setSize(10,10);
	
	add.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent evt){
			
			//===== input krna deta tika veriable tikkt gnnw 
			
			String order_id = Torder.getText();
			String number   = Tnumber.getText();
			String size  	= Tsize.getText();
			int qty     	= Integer.parseInt(Tqty.getText());
			double amount 	= Double.parseDouble(Tamount.getText());
			
			
			if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("XS") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L") ||	size.equalsIgnoreCase("XL") || size.equalsIgnoreCase("XXL")){
			
			double price = size.equalsIgnoreCase("xs")?600:size.equalsIgnoreCase("s")?800:size.equalsIgnoreCase("m")?900:size.equalsIgnoreCase("l")?1000:size.equalsIgnoreCase("xl")?1100:1200;
			
			amount = qty*price;
			
			// Customer c1 = new Customer(order_id,number,size,qty,amount);   //======= ee tika customer class ekt ywnw
			try{
				FileWriter fw = new FileWriter("Customer Detais Store.txt",true); // true = appendable
				fw.write(order_id+","+number+","+size+","+qty+","+amount+"\n");
				fw.flush();
				fw.close();
				
				JOptionPane.showMessageDialog(null,"Added !");
				
				Torder.setText(generateCustomerId());
				Tnumber.setText("");
				Tsize.setText("");
				Tqty.setText("");
				Tamount.setText("0");	
			
			}catch(IOException ex){
			
			}
			
			
			
			
			
			
			
				
			
			}else{
				JOptionPane.showMessageDialog(null,"Invalid Size");
			}
			
			
		
		}
		
	});
	btnpanel.add(add);
	
		Torder.setEditable(false);
		Torder.setText(generateCustomerId());
	
	
	
	Tamount.setText("0");
	
	
	cancel = new JButton("Cancel");
	cancel.setSize(10,10);
	cancel.setFont(new Font("",1,10));
	btnpanel.add(cancel);
	cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
	});
	
	back = new JButton("Back");
	back.setSize(10,10);
	back.setFont(new Font("",1,10));
	btnpanel.add(back);
	back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			dispose();
		}
	});	
	
	
	
	
	add("South",btnpanel);
	
	
	
	}
	
	private String generateCustomerId(){
		String lastLine=null;
		try{
			BufferedReader br=new BufferedReader(new FileReader("Customer Detais Store.txt"));
			String line=br.readLine();
			while(line!=null){
				lastLine=line;
				line=br.readLine();
			}
		}catch(IOException ex){
			
		}
		if(lastLine==null){
			return "ODR#0001";
		}else{
			int lastIdNumber=Integer.parseInt(lastLine.substring(4,8));
			System.out.println(lastIdNumber);
			return String.format("ODR#%04d",lastIdNumber+1);
			
		}
	}

	
	
	
	
	
	
	
}
