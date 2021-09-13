
public class Test {   
  
    public static void main(String[] args) {
        int b = 5;
        int c = 8;

        int a;

        a = b++ + c++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        a = b++ + ++c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        a= ++b + c++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        a = ++b + ++c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    
    }
}


