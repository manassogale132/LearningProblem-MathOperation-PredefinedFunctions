
@FunctionalInterface                          
interface IMathFunction{
	int calculate(int a,int b);               //Only One Abstract method

	static void printResult(int a,int b,String function,IMathFunction fobj) {     // Static method in interface itself
		System.out.println("Result of "+function+" is "+fobj.calculate(a, b));
	}
}



public class IMathFunctionExample {
	
	
	public static void main(String[] args) {
		
		//function name object=()-> { // blk}
		//IMatchFunction obj=()-> { // blk of stmt...}
			
		IMathFunction add = (int a , int b) -> a+b;      //Expressions with parameters
		IMathFunction multiply = (x , y) -> x * y;
		IMathFunction divide = (int x , int y) -> x / y;
		IMathFunction substract =( int x , int y) -> x - y;
		
		System.out.println("Addition is = "+ add.calculate(10, 5));
		System.out.println("Multiplication is = "+ multiply.calculate(10, 5));
		System.out.println("Division is = "+ divide.calculate(10, 5));
		System.out.println("Substraction is = "+ substract.calculate(10, 5));

		System.out.println(" ");
		
		IMathFunction.printResult(4, 4, "Addition",add );
		IMathFunction.printResult(4, 4, "Multiplication",multiply );
		IMathFunction.printResult(4, 4, "Division",divide );
		IMathFunction.printResult(4, 4, "Substraction",substract );
	}
	
	

}
