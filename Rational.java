/*
Phase I:


Example of multiply:
Rational r = new Rational(2,3); //Stores the rational number 2/3
Rational s = new Rational(1,2); //Stores the rational number 1/2
r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½


Phase II:
	add
	Takes 1 Rational object (just like multiply) and adds it to the current rational number object
	Need not reduce
	subtract
	Works the same as add, except the operation is subtraction
	gcd
	Returns the gcd of the numerator and denominator
	Uses Euclid's algorithm (reuse your old code!)
	Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
	reduce
	Changes this Rational to one in reduced form (should use gcd)

Examples for add, reduce:
Rational r = new Rational(2,3); //Stores the rational number 2/3
Rational s = new Rational(1,2); //Stores the rational number 1/2
Rational t = new Rational(4,18); //Stores the rational number 4/18
r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2 
t.reduce(); //Changes t to 2/9


Phase III:
	Add a static gcd method that will take numerator and denominator inputs.
	Add a method called compareTo that...
	Takes a Rational as a parameter and compares it to the calling object
	Returns 0 if the two numbers are equal
	Returns a positive integer if the calling number is larger than the parameter
	Returns a negative integer if the calling number is smaller than the parameter


*/
public class Rational
{
	public int numerator, denominator;

	public Rational()
	{
		numerator = 0;
		denominator = 1;
	}
	public Rational(int inputNum, int inputDenom)
	{
		numerator = inputNum;
		denominator = inputDenom;
		if (denominator <= 0)
		{
			denominator = 1;
			numerator = 0;
			System.out.println("Error. Denominator cannot be less than or equal to 0.");
		}
	}
	public String toString()
	{
		return numerator + " / " + denominator;
	}
	public float floatValue()
	{
		return (float) ((float) numerator / (float) denominator);
	}
	public int getNumerator()
	{
		return numerator;
	}
	public int getDenominator()
	{
		return denominator;
	}
	public static int max(int a, int b)
	{
		if (a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	public static int min(int a, int b)
	{
		if (a > b)
		{
			return b;
		}
		else
		{
			return a;
		}
	}
	public static int gcdew (int a, int b)
	{
		int max_num = max(a,b);
		int min_num = min(a,b);
		while (max_num % min_num > 0)
		{
			int current_max_num = max_num;
			int current_min_num = min_num;
			int current_quan = 1;
			while ((current_max_num % (current_min_num * current_quan)) < (max_num % min_num))
			{
				current_quan += 1;
			}
			max_num = current_min_num;
			min_num = (current_max_num % (current_min_num * current_quan));
		}
		return min_num;
	}
	public void multiply (Rational inputNum)
	{
		numerator *= inputNum.getNumerator();
		denominator *= inputNum.getDenominator();
	}
	public void divide (Rational inputNum)
	{
		numerator *= inputNum.getDenominator();
		denominator *= inputNum.getNumerator();
	}
	public void add (Rational inputNum)
	{
		int oldDenom = denominator;
		numerator *= inputNum.getDenominator();
		denominator *= inputNum.getDenominator();
		numerator += (inputNum.getNumerator() * oldDenom);
	}
	public void subtract (Rational inputNum)
	{
		int oldDenom = denominator;
		numerator *= inputNum.getDenominator();
		denominator *= inputNum.getDenominator();
		numerator -= (inputNum.getNumerator() * oldDenom);
	}
	public int gcd()
	{
		return gcdew(numerator, denominator);
	}
	public void reduce()
	{
		int numberToReduceBy = gcd();
		numerator /= numberToReduceBy;
		denominator /= numberToReduceBy;
	}
	public int compareTo(Rational inputNum)
	{
		if ((inputNum.floatValue() - floatValue()) > 0)
			return 1;
		if (inputNum.floatValue() == floatValue())
			return 0;
		else
			return -1;
	}
	public static void main (String[] args)
	{
		/*
		Rational r = new Rational(2,3); //Stores the rational number 2/3
		Rational s = new Rational(1,2); //Stores the rational number 1/2
		r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
		System.out.println(r);
		System.out.println(s);
		*/
		Rational r = new Rational(2,3); //Stores the rational number 2/3
		Rational s = new Rational(1,2); //Stores the rational number 1/2
		Rational t = new Rational(4,18); //Stores the rational number 4/18
		r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2 
		t.reduce(); //Changes t to 2/9
		System.out.println(r);
		System.out.println(s);
		System.out.println(s.compareTo(t));
		

	}

}