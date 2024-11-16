class List{

		private Customer [] customer_array;
		private int next_index;
		private int ini_size;
		private double load_Fact; 
		
		
		List (int ini_size  , double load_Fact){   // mn array ekt dena size ekh 
			
			this.ini_size  = ini_size ;
			this.load_Fact = load_Fact;
			customer_array = new Customer [ini_size];   // mama dena size ekt thmyi array ek hadenne 
			
			next_index = 0;
			
		
		}
		
		public void add(Customer customer){    // add  to LAST
			if(next_index >= customer_array.length){
				//extend_array();
			}
			customer_array [next_index++]=customer;			
		}
		
		
		public void addFirst(Customer customer){
			if(next_index>=customer_array.length){
				extend_array();
			}
			for(int i= next_index-1 ; i>=0 ; i++){
				customer_array [i+1] = customer_array [i];
			}
			customer_array[0]= customer;
		
		}
		
		
		public void add(int index , Customer customer){
			if(index >=0 && index < next_index){
				for (int i = next_index-1 ; i>=index ; i--){
					customer_array [i+1] = customer_array[i];
				}
				customer_array[index] = customer;
				next_index++;
			}
		}
		
		
		
		
		public void extend_array(){
			Customer [] temp_customer = new Customer [customer_array.length+(int)customer_array.length];
			for(int i =0; i<customer_array.length; i++){
				temp_customer [i] =  customer_array [i];
 			}
 			customer_array = temp_customer;
		
		}
		
		public boolean isEmpty(){
			return next_index<=0;
		}
		
		public int size(){
			return next_index;
		}
		
		public Customer get(int index){
			
			if(isEmpty()){
				return null;
			}
			return customer_array[index];
			
		}
		
		
	
	
		
}


