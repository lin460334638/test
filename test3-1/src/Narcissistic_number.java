
public class Narcissistic_number {
	public static void main(String [] args){
		for(int i=100;i<=999;i++){
			int m1=i/100;
			int m2=i%100/10;
			int m3=i%10;
			if(Math.pow(m1,3)+Math.pow(m2,3)+Math.pow(m3,3)==i){
				System.out.println(i);
			}
		}
	}
}
