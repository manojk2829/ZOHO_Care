package prectice_16_12_16;

public class PassByValueAndRefrence {
	int x;
	int y;
	public static void main(String[] args) {
	
		PassByValueAndRefrence pv = new PassByValueAndRefrence();
		pv.x=10;
		pv.y=20;
		System.out.println(pv.x +"------" + pv.y);
        swapValue(pv.x,pv.y);
        System.out.println(pv.x +"------" + pv.y);
        swapRefrence(pv);
        System.out.println(pv.x +"------" + pv.y);
	}
	
	public static void swapValue(int a,int b){
		int temp = a;    
		a=b;
		b=temp;	
	}
	
	public static void swapRefrence(PassByValueAndRefrence t){
		int temp = t.x;    
		t.x=t.y;
		t.y=temp;	
	}
}
