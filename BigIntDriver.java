//Milind Pathiyal
//BigInt Driver


public class BigIntDriver
{
   static public void go() 
   {
       BigInt a = new BigInt("-123456789");
       BigInt b = new BigInt("987654321");
       BigInt c = new BigInt("2016");
       BigInt d = new BigInt("59");
       BigInt e = new BigInt("5080");
       BigInt f = new BigInt("109");
       System.out.println("Absolute value: " + a.abs());
       String str1 = "Both values are equal: ";
       String str2 = "First Value is greater: ";
       String str3 = "Second value is greater: ";
       String str4 = "The answer is: ";
       if( a.compareTo(b) == 0 )
        System.out.print( str1 );
       else if( a.compareTo(b) == 1 )
        System.out.print( str2 );
       else if( a.compareTo(b) == -1 )
        System.out.print( str3 );
       System.out.print(a.compareTo(b));
       System.out.println();
       System.out.println(str4 + c.addHelper(d));
       System.out.println(str4 + e.subtractHelper(f));
       BigInt answer = new BigInt(2);
       for(int i = 0; i < 62; i++)
       {
           answer = answer.addHelper(answer);
       }
       System.out.println("Board answer: " + answer);
   }
}

/*
BigIntDriver.go()
Absolute value: 123456789
Second value is greater: -1
The answer is: 2075
The answer is: 4971
Board answer: 9223372036854775808
 */