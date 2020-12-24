import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {

	public static void main(String[] args) {


		List<Integer> list = new ArrayList<Integer>();	 //Sample Arrylist 
		for(int i = 0 ; i < 5 ; i++) {       
			list.add(i);
		}
		
		Iterator<Integer> itr = list.iterator();  //Method 1 to use Iterator traversing
		while(itr.hasNext()) {
			System.out.println("Method 1- Iterator Value :"+itr.next());
		}

		
		System.out.println(" ");
		
		
		
		class MyConsumer implements Consumer<Integer>{   //Method 2 - Traversing with Consumer Interface - inbuild interface
			public void accept(Integer t) {
				System.out.println("Method 2- Consumer implement Value :"+t);
			}
		}
		MyConsumer action = new MyConsumer();
		list.forEach(action);
		
		System.out.println(" ");
		
		                                                   //Method 3 - Traversing with  Anonymous Consumer Interface 
	    list.forEach(new Consumer<Integer>() {
		public void accept(Integer t) {
			System.out.println("Method 3- forEach anonymous class Value :"+t);
		}
	    });
		
	      
	    System.out.println(" ");  
	    
	Consumer<Integer> listAction = n-> {                                 //Method 4 Explict Lambda Function
		System.out.println("Method 4 : forEach Lambda impl Value :"+n);
	};
	list.forEach(listAction);
	
	
	System.out.println(" ");
	
	      list.forEach(n->{                                     //Method 5 Implicit Lambda Function *(IMPORTANT ONE)
	    	   System.out.println("Method 5 : forEach Lambda impl Value :"+n);
	      });
	      
	      System.out.println(" "); 
	      
	      
	                                                          //Method 6 : Implict Lambda Function to print double value.
	                                                            //Function<Integer,Double> - Predefined 
	      Function<Integer,Double> doubleFunction = Integer::doubleValue;
	      list.forEach(n->{
	    	  System.out.println("Method 6 : forEach Lambda double value :"+ doubleFunction.apply(n));
	      });

	      
	      System.out.println(" ");                                 //Method 7 : Implict Lambda Fucntion to check even
	                                                               //Predicate<Integer> - Predefined 
	      Predicate<Integer> isEvenFunction = n-> n%2 == 0;
	      list.forEach(n->{
	    	  System.out.println("Method 7 : forEach value to check even :"+isEvenFunction.test(n));
	      });
}
}
