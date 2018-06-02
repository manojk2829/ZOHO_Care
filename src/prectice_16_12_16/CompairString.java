package prectice_16_12_16;

public class CompairString {

	public static void main(String[] args) {
		String str1 = "Akash is a Good Boy";
				String str2 = "manojK";
				String str3 = "3rd String ";
				System.out.println(str1.equals(str2));
				System.out.println(str1.concat(str2));
				System.out.println(str1.concat(str2).charAt(14));
				System.out.println(str1.concat(str2).concat(str3).length());
				System.out.println(str1.concat(str2).toLowerCase());
				System.out.println(str1.concat(str2).toUpperCase());
				System.out.println(str1.indexOf('j'));
				System.out.println(str1.indexOf("Good"));
				System.out.println(str1.concat(str2).concat(str2).length());
				
				int i = 45;
				String  value = String.valueOf(i);
				System.out.println(value);
				
				String str_Number = "25";
				int j = Integer.parseInt(str_Number);
				System.out.println(j);
				
				System.out.println(str1.substring(5,15));
				System.out.println(str1.trim());
				
				
				String k = "2450";
				int value_Number = Integer.parseInt(k);
				System.out.println(value_Number);
				
				
				int l = 250;
				String num = String.valueOf(l);
				System.out.println(num);
				
				
				
	}

}
