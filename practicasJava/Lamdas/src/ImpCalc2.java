
public class ImpCalc2 {
	public int operateBinary(int a, int b, ICalc2 op) {
        return op.operation(a, b);
    }
	public static void main(String... args) {
	     
		ImpCalc2 myApp = new ImpCalc2();
        ICalc2 addition = (a, b) -> a + b;
        ICalc2 subtraction = (a, b) -> a - b;
        ICalc2 multiplication = (a, b) -> a * b;
        ICalc2 division = (a, b) -> a / b;
        System.out.println("20 + 2 = "+myApp.operateBinary(20, 2, addition));
        System.out.println("20 - 2 = "+myApp.operateBinary(20, 2, subtraction));
        System.out.println("20 * 2 = "+myApp.operateBinary(20, 2, multiplication));
        System.out.println("20 / 2 = "+myApp.operateBinary(20, 2, division));
    }
}
