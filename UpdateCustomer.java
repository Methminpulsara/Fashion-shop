import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;


class UpdateCustomer extends JFrame{ 
		
		private  JLabel maintitel;
		
		private  JLabel Lorder;
		private  JLabel Lnumber;
		private  JLabel Lsize;
		private  JLabel Lqty;
		private  JLabel Lamount;
		//private  JLabel Lstatus;
		
		private JTextField Torder;
		private JTextField Tnumber;
		private JTextField Tsize;
		private JTextField Tqty;
		private JTextField Tamount;
		//private JTextField Tstaus;
		
		private JButton update;
		private JButton search;
		private JButton back;
		
		
		
		
		UpdateCustomer(){
			
			setSize(300,400);
			setLocationRelativeTo(null);
			setTitle("update customer");
			setDefaultCloseOperation(2);
			
//=====================TITELS================================

			maintitel = new JLabel ("Upadate Customer");
			maintitel.setFont(new Font("",2,30));
			maintitel.setHorizontalAlignment(JLabel.CENTER);
			add("North",maintitel);
						
			Lorder = new JLabel ("Order ID");
			Lnumber = new JLabel ("Contact Number");
			Lsize = new JLabel ("Size");
			Lqty = new JLabel ("QTy");
			Lamount = new JLabel ("Amount");
			//Lorder = new JLabel ("Status");
			
			Lorder.setFont(new Font("",2,15));
			Lnumber.setFont(new Font("",2,15));
			Lsize.setFont(new Font("",2,15));
			Lqty.setFont(new Font("",2,15));
			Lamount.setFont(new Font("",2,15));
			//Lstatus.setFont(new Font("",2,15));
			 
			JPanel lblpanel = new JPanel (new GridLayout(6,1)); 
			lblpanel.add(Lorder);
			lblpanel.add(Lnumber);
			lblpanel.add(Lsize);
			lblpanel.add(Lqty);
			lblpanel.add(Lamount);
			//lblpanel.add(Lstatus);
			 
			add("West",lblpanel); 
			 
			Torder = new JTextField(10);
			Tnumber = new JTextField(10);
			Tsize = new JTextField(10);
			Tqty = new JTextField(10);
			Tamount = new JTextField(10);
			//Tstaus = new JTextField(10);
			
			Torder.setFont(new Font("",1,10)); 
			Tnumber.setFont(new Font("",1,10)); 
			Tsize.setFont(new Font("",1,10)); 
			Tqty.setFont(new Font("",1,10)); 
			Tamount.setFont(new Font("",1,10)); 
		//	Tstaus.setFont(new Font("",1,10)); 
			
			JPanel textpanel= new JPanel (new GridLayout(6,1));
		
			JPanel center1 = new JPanel (new FlowLayout(FlowLayout.LEFT));
			JPanel center2 = new JPanel (new FlowLayout(FlowLayout.LEFT));
			JPanel center3 = new JPanel (new FlowLayout(FlowLayout.LEFT));
			JPanel center4 = new JPanel (new FlowLayout(FlowLayout.LEFT));
			JPanel center5 = new JPanel (new FlowLayout(FlowLayout.LEFT));
		//	JPanel center6 = new JPanel (new FlowLayout(FlowLayout.LEFT));
		
			center1.add(Torder);
			center2.add(Tnumber);
			center3.add(Tsize);
			center4.add(Tqty );
			center5.add(Tamount);
		//	center6.add(Tstaus);
		
			textpanel.add(center1);	
			textpanel.add(center2);	
			textpanel.add(center3);	
			textpanel.add(center4);	
			textpanel.add(center5);	
		//	textpanel.add(center6);	
		add("East",textpanel);
		
	
//========================BUTTONS=========================================//		
		
		update = new JButton("Upadte");
		search = new JButton("Search");
		back   = new JButton("Back");
			
		update.setFont(new Font("",1,10));
		search.setFont(new Font("",1,10));
		back.setFont(new Font("",1,10));
		
		update.setSize(10,10);
		search.setSize(10,10);
		back.setSize(10,10);
		
		JPanel btnpanel = new JPanel (new FlowLayout(FlowLayout.RIGHT));
		
		btnpanel.add(update);
		btnpanel.add(search);
		btnpanel.add(back);
		add("South",btnpanel);
		
		
		
//======================ADD ACTION LISTENER==============================

		
		
	update.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent evt){
			String order  = Torder.getText(); 
			String number = Tnumber.getText();
			String size   = Tsize.getText();
			int qty 	  = Integer.parseInt(Tqty.getText());
			double amount = Double.parseDouble(Tamount.getText());
			
			List customerList=new List(100,0.5);
				try{
					Scanner input=new Scanner(new File("Customer Detais Store.txt"));
					while(input.hasNext()){
						String line=input.nextLine();
						String[] rowData=line.split(",");
						if(rowData[0].equalsIgnoreCase(order)){
							Customer temp=new Customer(order,number,size,qty,amount);
							customerList.add(temp);
						}else{
							Customer c1=new Customer(rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]));
							customerList.add(c1);		
						}
					}					
					FileWriter fw=new FileWriter("Customer Detais Store.txt");
					for(int i=0; i<customerList.size(); i++){
						Customer c1=customerList.get(i);
						fw.write(c1.toString()+"\n");	
					}
					fw.close();
				}catch(IOException ex){
					
				}
			}
		});

	
	
	
	
	
	search.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent evt){
			String newline = null ;
			try{
				BufferedReader br = new BufferedReader (new FileReader("Customer Detais Store.txt"));
				String line = br.readLine();
				while(line !=null){
					String id = line.substring(0,8);
					if(id.equalsIgnoreCase(Torder.getText())){
						newline = line;
						break;
						}
						line= br.readLine();
						
				}
			}catch (IOException ex){
			}
				if(newline != null){
					String [] rowData = newline.split(",");
					Tnumber.setText(rowData[1]);
					Tsize.setText(rowData[2]);
					Tqty.setText(rowData[3]);
					Tamount.setText(rowData[4]);
				}else{
					JOptionPane.showMessageDialog(null,"Invalid ID");
				}
				
			
			
          
		
		}
	});
	
	back.addActionListener (new ActionListener(){
		public void actionPerformed (ActionEvent vet){
			dispose();
			
		}
	});
		
		
		
		
		
		
		}
		


}
