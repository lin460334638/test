
public class score {
	
	public static void ToGradeScore(int a[]){
		for(int i=0;i<a.length;i++){
			if(a[i]>=90&&a[i]<=100)
				System.out.println(a[i]+"�ɼ��ȼ�Ϊ����");
			if(a[i]>=80&&a[i]<=89)
				System.out.println(a[i]+"�ɼ��ȼ�Ϊ����");
			if(a[i]>=70&&a[i]<=79)
				System.out.println(a[i]+"�ɼ��ȼ�Ϊ����");
			if(a[i]>=60&&a[i]<=69)
				System.out.println(a[i]+"�ɼ��ȼ�Ϊ������");
			if(a[i]>=0&&a[i]<=59)
				System.out.println(a[i]+"�ɼ��ȼ�Ϊ��������");
		}
	}
	public static void main(String[] args) {
		
		int arr[]={78,58,96,35,61,75,92};
		ToGradeScore(arr);
	}

}
