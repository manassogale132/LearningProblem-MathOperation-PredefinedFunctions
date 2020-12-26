import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {

	public static void main(String[] args) {


		List<Integer> list = new ArrayList<>();	 //Sample Arrylist 
		for(int i = 0 ; i < 5 ; i++) {       
			list.add(i);
		}
		
		Iterator<Integer> itr = list.iterator();  //Method 1 to use Iterator traversing
		while(itr.hasNext()) {
			System.out.println("Method 1 : Iterator Value :"+itr.next());
		}

		
		System.out.println(" ");
		
		
		
		class MyConsumer implements Consumer<Integer>{   //Method 2 - Traversing with Consumer Interface - inbuild interface
			public void accept(Integer t) {
				System.out.println("Method 2 : Consumer implement Value :"+t);
			}
		}
		MyConsumer action = new MyConsumer();
		list.forEach(action);
		
		System.out.println(" ");
		
		                                                   //Method 3 - Traversing with  Anonymous Consumer Interface 
	    list.forEach(new Consumer<Integer>() {
		public void accept(Integer t) {
			System.out.println("Method 3 : forEach anonymous class Value :"+t);
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
	      Predicate<Integer> isEvenFunction = (n)-> n%2 == 0;
	      list.forEach(n->{
	    	  System.out.println("Method 7 : forEach value to check even :"+isEvenFunction.test(n));
	      });
	      
	      
	      
	      System.out.println("  ");
	      
	      //Method 8 : Processing the Stream
	      
	     list.stream().forEach(n->{
	    	 System.out.println("Method 8 : Stream forEach Value :"+n);
	     });
	     
	     System.out.println(" ");
	   
	     
	     //Method 9 : Process the Stream , apply operations on stream and store the result
	     
	     List<Double> streamList = list.stream()
	                               .filter(isEvenFunction)
	                               .peek(n ->  System.out.println("Method 9 : Peek value is :"+n) )
	                               .map(doubleFunction)
	                               .collect(Collectors.toList());
	                               
	     System.out.println("Method 9 : Print double list using filter,map,collect "+streamList);
	     
	     
	     System.out.println(" ");
	     
	     
	     //Method 10 : Listing the first Even
	     
	     Integer first = list.stream()
	    		         .filter(isEvenFunction)
	    		         .peek(n ->  System.out.println("Method 10 : Peek value is :"+n) )
	    		         .findFirst()
	    		         .orElse(null);
	     System.out.println("Method 10 : First Even :"+first);
	     
	     
	     System.out.println(" ");
	     
	     
	   //Method 11 : Minimum Even Numbers
	     
	     Integer min = list.stream()
	    		       .filter(isEvenFunction)
	    		       .min((n1, n2) -> n1-n2)
	    		       .orElse(null);
	     
	     System.out.println("Method 11 : Min Even :"+min);  
	     
	     
	     System.out.println(" ");
	     
 //Method 12 : Maximum Even Numbers
	     
	     Integer max = list.stream()
	    		       .filter(isEvenFunction)
	    		       .max((n1, n2) -> n1-n2)
	    		       .orElse(null);
	     
	     System.out.println("Method 12 : Max Even :"+max);
	     
	     System.out.println(" ");
	     
//Method 13 : Maximum Even Numbers
	     
	     Integer sum = list.stream()
	    		      .reduce(0, Integer::sum);
	  long count = list.stream().count();
	     
	     System.out.println("Method 13 : Avg of "+sum+"/"+count+" = "+sum/count);	     
	
	     
	     System.out.println(" ");
	     
//Method 14 : Checking all even, single even or non are divisible by 6.
	     
	     boolean allEven = list.stream().allMatch(isEvenFunction);
	     boolean oneEven = list.stream().anyMatch(isEvenFunction);
	     
	     System.out.println("Method 14 : is Even :"+allEven);
	     System.out.println("Method 14 : one Even :"+oneEven);
}
}
