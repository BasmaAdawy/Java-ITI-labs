package betterPack;

import java.util.function.BiPredicate;

public class Better {

	public static String betterString(String s1, String s2,BiPredicate<String,String>p) {
		boolean res = p.test(s1, s2);
		if (res == true) return s1;
		else return s2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String str1 ="hello";
     String str2 = "newhello";
     String longer = betterString(str1,str2, (s1,s2)-> s1.length() > s2.length());
     System.out.println(longer + " is longer");
	}

}
