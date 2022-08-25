// Driver Class
class Main
{
   public static void main(String args[])    
   {
       MySingleton a = MySingleton.getInstance();
       MySingleton b = MySingleton.getInstance();
       a.x = a.x + 10;
       a.y = 12;
       System.out.println("Value of a.x = " + a.x);
       System.out.println("Value of b.x = " + b.x);
       System.out.println(MySingleton.instance);
       System.out.println(MySingleton.y);
   }    
}
