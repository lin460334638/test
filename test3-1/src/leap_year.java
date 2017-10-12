
public class leap_year {

	public static void main(String[] args) {
		int year;
		int n=0;
		for(year=1990;year<=2007;year++){			
			
			if(year%4==0&&year%100!=0||year%400==0){
				System.out.print(year+" ");
				n++;
				if(n%2==0){
					System.out.print('\n');
				}
			
			}
			
		}
	}

}
