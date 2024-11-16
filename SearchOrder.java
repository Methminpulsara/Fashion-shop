import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;


class SearchOder extends JFrame{
	private JLabel maintitel;
	
	private JLabel Lorder;
	private JLabel Lnumber;
	private JLabel Lsize;
	private JLabel Lqty;
	private JLabel Lamount;
	
	private JTextField Torder;
	private JTextField Tnumber;
	private JTextField Tsize;
	private JTextField Tqty;
	private JTextField Tamount;
	
	
	//private JTextField Tstatus;
	//private JLabel Lstatus;
	
	
	private JButton search;
	private JButton back;
	
	
	SearchOder(){
		
		setSize(300,400);
		setTitle("Fashion shop");
		setDefaultCloseOperation(1);
		setLocationRelativeTo(null);
		
		//============main titel ===============
		
		maintitel = new JLabel("Search Order");
		maintitel.setFont(new Font("",2,20));
		maintitel.setHorizontalAlignment(JLabel.CENTER);
		add("North",maintitel);
		
		
		
//=================================LABELS==================================
		JPanel lblpanel = new JPanel (new GridLayout(6,1));
		//Lstatus = new JLabel("Status");
		//Lstatus.setFont(new Font("",1,15));
		
		Lorder = new JLabel ("Order ID");
		Lnumber = new JLabel ("Contact Number");
		Lsize = new JLabel ("Size");
		Lqty = new JLabel ("Qty");
		Lamount = new JLabel ("Amount");
		
		
		Lorder.setFont(new Font("",2,15));
		Lnumber.setFont(new Font("",2,15));
		Lsize.setFont(new Font("",2,15));
		Lqty.setFont(new Font("",2,15));
		Lamount.setFont(new Font("",2,15));
		
		
		lblpanel.add(Lorder);
		lblpanel.add(Lnumber);
		lblpanel.add(Lsize);
		lblpanel.add(Lqty);
		lblpanel.add(Lamount);
		//lblpanel.add(Lstatus);
		
		
		add("West",lblpanel);


 //==========================TextFields====================================
		
		JPanel textpanel = new JPanel (new GridLayout(6,1));
		
		Torder = new JTextField(15);
		Tnumber = new JTextField(15);
		Tsize  = new JTextField(15);
		Tqty = new JTextField(15);
		Tamount = new JTextField(15);
													//	Tstatus = new JTextField(10);
		
		Torder.setFont(new Font ("",1,10));
		Tnumber.setFont(new Font ("",1,10));
		Tsize.setFont(new Font ("",1,10));
		Tqty.setFont(new Font ("",1,10));
		Tamount.setFont(new Font ("",1,10));
												//Tstatus.setFont(new Font ("",1,10));
					//Tstatus.setEditable(false);
		
		
		JPanel t_center1= new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel t_center2= new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel t_center3= new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel t_center4= new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel t_center5= new JPanel (new FlowLayout (FlowLayout.CENTER));
													//JPanel t_center6= new JPanel (new FlowLayout (FlowLayout.CENTER));
		
		t_center1.add(Torder);
		t_center2.add(Tnumber);
		t_center3.add(Tsize);
		t_center4.add(Tqty);
		t_center5.add(Tamount);
													//	t_center6.add(Tstatus);
		
		textpanel.add(t_center1);
		textpanel.add(t_center2);
		textpanel.add(t_center3);
		textpanel.add(t_center4);
		textpanel.add(t_center5);
													//textpanel.add(t_center6);
		
		add(textpanel);	
		
			
			
//================================BUTTONS==================================================================================
			
			
			JPanel btnpanel = new JPanel(new FlowLayout (FlowLayout.RIGHT));
			search = new JButton("Search");
			search.setSize(10,10);
			search.setFont(new Font("",1,10));
			btnpanel.add(search);

			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt){
					String newline = null;
				
					try {
						BufferedReader br = new BufferedReader(new FileReader("Customer Detais Store.txt"));
						String line = br.readLine();

						while(line != null){
							String id = line.substring(0, 8);
							if(id.equalsIgnoreCase(Torder.getText())){
								newline = line;
								break;
							
							}
							line=br.readLine();
						
						}
						
					} catch (IOException ex) {
					
					}

					if(newline != null){
						String [] rowData = newline.split(",");
						Tnumber.setText(rowData[1]);
						Tsize.setText(rowData[2]);
						Tqty.setText(rowData[3]);
						Tamount.setText(rowData[4]);

					}else{
						JOptionPane.showMessageDialog(null, "Not Found !");
					}

				}	
			});


			
			
			
			back = new JButton ("Back");
			back.setFont (new Font("",1,10));
			back.setSize(10,10);
			btnpanel.add(back);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					dispose();
					
					
				}
				
			});


			Tnumber.setEditable(false);
			Tsize.setEditable(false);
			Tqty.setEditable(false);
			Tamount.setEditable(false);
			
			add("South",btnpanel);
			
			
			Torder.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					List customerList = new List(100,0.5);
					
					try{
						Scanner input = new Scanner (new File("Customer Detais Store.txt"));
						String line = null;
						
						while(input.hasNext()){
							line =input.nextLine();
							String [] rowData = line.split(",");
							Customer c1 = new Customer (rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]));
							customerList.add(c1);
						}
						
					}catch(IOException ex){}
					
					Customer c1 = null;
					for(int i =0; i<customerList.size(); i++){
						 c1 =  customerList .get(i);
						if(c1.get_orderid().equalsIgnoreCase(Torder.getText())){
							break;
						}
						
					}
					if(c1!=null){
						Tnumber.setText(c1.get_contactnumber());
						Tsize.setText(c1.get_size_tshirts());
						Tqty.setText(""+c1.get_qty());
						Tamount.setText(""+c1.get_amount());
					}else{
						JOptionPane.showMessageDialog(null,"Invalid Id");
					}
				}
				
			});
			
	} 
	
	
	
	
	
	
}
