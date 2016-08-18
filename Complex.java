//Milind Pathiyal
//ComplexNumber uses inputed number to calculate desired methods

public class Complex implements Number
{
    private int num1;
    private int num2;
    public Complex()
    {
        num1 = 0;
        num2 = 0;
    }
    public Complex(int num1, int num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }
    public Number divide(Number otherNumber)
    {
        return null;
    }
    public String print()
    {
        return num1 + " + " + num2 + "i";
    }
    public int compareTo(Number otherNumber)
    {
        Complex other = (Complex)(otherNumber);
        if ((Math.sqrt(this.num1 * this.num1 + this.num2 * this.num2)) == (Math.sqrt(other.num1 * other.num1 + other.num2 * other.num2)))
            return 0;
        else if((Math.sqrt(this.num1 * this.num1 + this.num2 * this.num2)) > (Math.sqrt(other.num1 * other.num1 + other.num2 * other.num2)))
            return -1;
        else
        {
            return 1;
        }
    }
    public Number multiply(Number otherNumber)
    {
        Complex answer = new Complex();
        Complex other = (Complex)(otherNumber);
        answer.num1 = (this.num1 * other.num1) + (this.num2 * other.num2 * -1);
        answer.num2 = (this.num1 * other.num2) + (other.num1 * this.num2);
        return answer;
    }
    public Number add(Number otherNumber)
    {
        Complex answer = new Complex();
        Complex other = (Complex)(otherNumber);
        answer.num1 = (this.num1 + other.num1);
        answer.num2 = (this.num2 + other.num2);
        return answer;
    }
    public Number subtract(Number otherNumber)
    {
        Complex answer = new Complex();
        Complex other = (Complex)(otherNumber);
        answer.num1 = (this.num1 - other.num1);
        answer.num2 = (this.num2 - other.num2);
        return answer;
    }
}
/*
Enter 1 to enter a complex number for a, 2 to enter a Fraction
1
Enter the num1 and imaginary number for your complex number
5
3
Enter 1 to enter a complex number for b, 2 to enter a Fraction
1
Enter the num1 and imaginary number for your complex number
3
2
a = 5 + 3i and b = 3 + 2i

Welcome to the number calculator
To set number a,                press 1
To set number b,                press 2
To compare a to b,              press 3
To multiply a * b,              press 4
To divide a / b,                press 5
To add a + b,                   press 6
To subtract a - b,              press 7
To quit,                    press 0
4
a * b = 9 + 19i

Welcome to the number calculator
To set number a,                press 1
To set number b,                press 2
To compare a to b,              press 3
To multiply a * b,              press 4
To divide a / b,                press 5
To add a + b,                   press 6
To subtract a - b,              press 7
To quit,                    press 0
3
5 + 3i > 3 + 2i
*/

