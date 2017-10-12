
public class print_pattern {

	public static void main(String[] args) {
		int n=7;
		for(int i=1;i<=n/2+1;i++){
			
			for(int k=1;k<=n/2+1-i;k++){
				System.out.print(" ");
			}
				
			for(int j=1;j<=2*i-1;j++){
				System.out.print("*");
			}
			System.out.print('\n');
			
		}
		for(int i=1;i<=n/2;i++){
			for(int m=1;m<=i;m++){
				System.out.print(" ");
			}
			for(int x=1;x<=n-2*i;x++){
				System.out.print("*");
			}
			System.out.print('\n');
		}

	}

}
