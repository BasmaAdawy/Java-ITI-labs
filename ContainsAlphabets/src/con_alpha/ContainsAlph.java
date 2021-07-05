package con_alpha;

public class ContainsAlph {
     public ContainsAlph() {}   //constructor
	
	 public static boolean is_alpha(String str){
	     if ((str != null) && (!str.equals("")) && (str.chars().allMatch(Character::isLetter))) 
		 return true;
	     else return false;
	    }

	

	public static void main(String[] args) {
		 String str1 = "helloBasma";
	     System.out.println("Input: " + str1);
	     System.out.println("Output: " + is_alpha(str1));
	     System.out.println("");
	     
	     String str2 = "4fun";
	     System.out.println("Input: " + str2);
	     System.out.println("Output: " + is_alpha(str2));
	     System.out.println("");
	     
	     String str3 = "";
	     System.out.println("Input: " + str3);
	     System.out.println("Output: " + is_alpha(str3));
	     System.out.println("");
	     
	     String str4 = null;
	     System.out.println("Input: " + str4);
	     System.out.println("Output: " + is_alpha(str4));
	}

}
