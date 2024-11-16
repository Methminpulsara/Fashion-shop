import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.table.*;



class ViweCustomer extends JFrame{
	
	
	
	private JButton relord ;
	private JButton back ;
	
	private JTable cus;
	private DefaultTableModel dtm ;
	
	
	
	
	
	ViweCustomer(){
		
		
		
		setSize(500,400);
		setTitle("viwe");
		setLocationRelativeTo (null);
		setDefaultCloseOperation(2);
		
		relord = new JButton("relord");
		back = new JButton("back");
		
		relord.setSize(10,10);
		back.setSize(10,10);
		
		JPanel btn= new JPanel (new FlowLayout(FlowLayout.CENTER));
		btn.add(relord);
		btn.add(back);
		add("South",btn);
		
		
		relord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				List customerList=new List(100,0.5);
				try{
					Scanner input=new Scanner(new File("Customer.txt"));
					while(input.hasNext()){
						String line=input.nextLine();
						String[] rowData=line.split(",");
						Customer c1=new Customer(rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]));
							customerList.add(c1);	
					}					
				}catch(IOException ex){
					
				}				
				dtm.setRowCount(0);
				for(int i=0; i<customerList.size();i++){
					Customer c1=customerList.get(i);
					Object[] rowData={c1.get_orderid(),c1.get_contactnumber(),c1.get_size_tshirts(),c1.get_qty(),c1.get_amount()};
					dtm.addRow(rowData);
				}
			}
		});
		
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

		
	String [] column = {"Order id ","Contact number","size","Qty","Amount"};	
	dtm = new DefaultTableModel (column,0);
	cus = new JTable (dtm);
	JScrollPane tablePane = new JScrollPane(cus);
	add("Center",tablePane);	
	
		
		
		
	}
	

}
