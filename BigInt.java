//Milind Pathiyal
//BigInt 

import java.util.*;
public class BigInt implements Number
{
    private ArrayList<Integer> digits;
    private boolean isNegative;
    public BigInt(){}
    //Pre:variables must exist
    //Post:creates a string of BigInt
    public String toString() 
    {
        String result = new String();
        if(isNegative) 
        {
            result += "-";
        }
        for(int i = digits.size()-1; i >= 0; i--)
        {
            result += "" + digits.get(i);
        }
        return result;
    }
    //Pre:varables must exist
    //Post:signals when to stop loop
    public BigInt(String input)
    {
        digits = new ArrayList<Integer>();
        int stopAt;
        if(input.charAt(0) != '-')
        {
            isNegative = false;
            stopAt = 0;
        }
        else
        {
            isNegative = true;
            stopAt = 1;
        }
        for (int i = input.length()-1; i >= stopAt; i--) 
        {
            digits.add(new Integer((int)(input.charAt(i) - '0')));
        }
    }
    //Pre:none
    //Post:creates a BigInt
    public BigInt(BigInt input) 
    {
        for(int i=0; i<input.digits.size(); i++) 
        {
            digits.add(input.digits.get(i));
        }
    }
    //Pre:variables must exist
    //Post return absolute value of any given value
    public BigInt abs() 
    {
        if(isNegative)
        {
            isNegative = false;
            BigInt result = new BigInt(toString());
            isNegative = true;
            return result;
        }
        return this;
    }
    //Pre:variables must exist
    //Post:return comparison of the two numbers --> figure size
    public int compareToHelper(BigInt other) 
    {
        if(digits.size() == other.digits.size())
        {
            for(int i = digits.size() - 1; i >= 0; i--)
            {
                if(digits.get(i) > other.digits.get(i))
                {
                    return 1;
                }
                else if(digits.get(i) < other.digits.get(i))
                {
                    return -1;
                }
            }
            return 0;
        }
        else if(digits.size() > other.digits.size()) 
        {
            return 1;
        }
        else 
        {
            return -1;
        }
    }
    //Pre:variables must exist
    //Post:returns comparison of the two numbers --> positive & negative sign
    public int compareTo(Number num) 
    {
        BigInt other = (BigInt)num;
        if (other.isNegative) 
        {
            if(!isNegative)
            {
                return 1;
            }
            else
            {
                other.isNegative = false;
                int newBig = compareToHelper(other);
                return newBig;
            }
        }
        else
        {
            if(isNegative)
            {
                return -1;
            }
            else
            {
                return compareToHelper(other);
            }
        }
    }
    //Pre:variables must exist
    //Post:transforms int to BigInt
    public BigInt(int input) 
    {
        digits = new ArrayList<Integer>();
        isNegative = false;
        if (input < 0)
            isNegative = true;
        int i = 0;
        while (input >= 1) {
            digits.add(i, new Integer((input%10)));
            input /= 10;
            i++;
        }
    }
    
    public Number multiply(Number num){return null;}
    public Number divide(Number num){return null;}
    
    //Pre:variables must exist
    //Post:adds two numbers
      public BigInt addHelper(BigInt other)
    {
        BigInt newBig = new BigInt(0);
        int carry = 0;
        int bigger = 0;
        if(this.digits.size() > other.digits.size())
            bigger = this.digits.size();
        else
            bigger = other.digits.size();
        for(int i  = 0; i < bigger; i++)
        {
            int added = carry;
            if(i < this.digits.size())
                added += this.digits.get(i);
            if(i < other.digits.size())
                added += other.digits.get(i);
            if(added < 10)
            {
                newBig.digits.add(added);
                carry = 0;
            }
            else
            {
                carry = 1;
                newBig.digits.add(added%10);
            }
        }
        if(carry == 1)
            newBig.digits.add(carry);
        return newBig;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Number add(Number num)
    {   
        BigInt newBig = (BigInt)num;
        if(!this.isNegative)
        {
            if(newBig.isNegative)
            {
                return this.subtractHelper(newBig);
            }
        
            else 
            {
                return this.addHelper(newBig);
            }
        }
        else 
        {
            if(!newBig.isNegative)
            {
                return newBig.subtractHelper(this);
            }
            else
            {
                BigInt result = this.addHelper(newBig);
                newBig.isNegative = false;
                return result;
            }
        }
    }
   
    public Number subtract(Number num)
    {
        BigInt newBig = (BigInt)num;
        if(!this.isNegative)
        {
            if(newBig.isNegative)
            {
                return this.addHelper(newBig);
            }
            else 
            {
                return this.subtractHelper(newBig);
            }
        }
        else
        {
            if(!newBig.isNegative)
            {
                return newBig.addHelper(this);
            }
            else
            {
                BigInt result = this.subtractHelper(newBig);
                result.isNegative = true;
                return result;
            }
        }
    }

    //pre: variables must be valid and this must be greater than other and all variables must be greater than zero
    //post: subtracts two positive bigInts
    public BigInt subtractHelper(BigInt other)
    {
        BigInt newBig = new BigInt(0);
        int bigNum = 0;
        int smallNum = 0;
        boolean carryOver = false;
        for (int i=0; i < this.digits.size(); i++)
        {
            bigNum = this.digits.get(i);
            if (i < other.digits.size())
            {
                smallNum = other.digits.get(i);
                if (bigNum - smallNum > 0)
                {
                    if(carryOver)
                    {
                        bigNum -= 1;
                        carryOver = false;
                    }
                    newBig.digits.add(i, bigNum - smallNum);
                }
                else
                { 
                    if (carryOver)
                    {
                        bigNum += 9; 
                    }
                    else
                    {
                        carryOver = true;
                        bigNum += 10;
                    }
                    newBig.digits.add(i, bigNum - smallNum);
                }
            }
            else
            {
                smallNum = 0;
                if (carryOver)
                {
                     if (bigNum != 0)
                     {
                        bigNum -= 1;
                        carryOver = false;
                     }
                     else
                     {
                        bigNum = 9;
                        carryOver = true;
                     }
                }
                newBig.digits.add(i, bigNum - smallNum);
            }
       }
       return newBig;
    }

    //pre: none
    //post: removes zeroes 
     public void trimZeros()
    {
        boolean foundNonZero = false;
        int i = digits.size() - 1;
        if(digits.get(i) == 0)
        {
            digits.remove(i);
            while(i > 1 && !foundNonZero)
            {
                i--;
                if(digits.get(i) != 0)
                {
                    foundNonZero = true;
                }
                else
                {
                    digits.remove(i);
                }
            }
        }
    }
}
/*
BigIntDriver.go()
Absolute value: 123456789
Second value is greater: -1
The newBig is: 2075
The newBig is: 4971
 */
