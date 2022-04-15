package com.bracketbalance.main;

public class BracketBalance {
	
	public static int findNextIndex(char a, String portion)
	{
		int index = 1;
		int nbra = 0;
		int nbrclose = 0;
		char close ;
		if (a == '(')
			close = ')';
		else
		 {
			if (a == '[')
				close = ']';
			else
				return 0;
		 }
			
		
		while (index <portion.length())
		{
			if (portion.charAt(index) == close)
			{
				nbrclose ++;
			  if ( nbrclose >nbra)
				return index;			  
			}
			else
			{
				if (portion.charAt(index) == a)
					nbra++;
			}
				
				index++;
		}
		
		
		return 0;
		
	}
	
	public static boolean check(String input ) {
		
		int split = 0;
		String A = null;
		String B = null;
		
		if (input == null || input.length() <2 || input.length()%2 != 0)
			return false;
		
		if ( input.length() == 2)
		{
			if ( input.charAt(0)  == '(' && input.charAt(input.length()-1)  == ')' ) 
			{
				return true;
			}
			else 
			{
				if (input.charAt(0)  == '[' && input.charAt(input.length()-1)  == ']') 
				{
				   return true;	
				}
				else 
				{
					return false;
				}
			}			
		}
		else
		{
			
			if ( (input.charAt(0)  == '(' && input.charAt(input.length()-1)  == ')')
					|| (input.charAt(0)  == '[' && input.charAt(input.length()-1)  == ']')) 
			{
				A = null;
				B = null;
				split = findNextIndex (input.charAt(1),input.substring(1, input.length() -1));
				if (split == 0)
					return false;
				A = input.substring(1, split+2);
				System.out.println (split);
				System.out.println (A);
				
				if (input.length() -1 > split+2)
				B = input.substring(split+2, input.length() -1);
				
				System.out.println (B);
				if (B != null)
				  return (check(A)  && check(B));
				else
				  return (check(A));	
			}	
			else
				return false;
		}
	
	}

	public static void main(String[] args) {
		// (()) , (()[]), [()()], (()[()])
        // if A AND B are correct, then (A) AND (AB) are correct
		String input = null;
		if (args.length > 0)
			input = args[0];
		
			
		  if (check (input) ) 
		  System.out.println(String.format("input %s is correct", input));
		  else 
		  System.out.println(String.format("input %s is incorrect", input));
	}

}
