
public class getSum {
	private Thread threadA;
	private Thread threadB;
	private Thread threadC;
	private Thread threadD;
	private int sum1=0;
	private int sum2=0;
	private int sum3=0;
	private int sum4=0;

	public getSum(){
		threadA=new Thread(new Runnable(){
				@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						threadB.join();
						for(int i=76;i<=100;i++){
							sum4+=i;
						}
						System.out.println("���ĸ�ִ�еĽ���:"+sum4);
						System.out.println("������ͽ����:"+(sum1+sum2+sum3+sum4));
					}catch(Exception e){
						e.printStackTrace();
					}
				}			
			}	
		});
		threadA.start();
		threadB=new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						threadC.join();
						for(int i=51;i<=75;i++){
							sum3+=i;
						}
						System.out.println("������ִ�еĽ���:"+sum3);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}	
		});
		threadB.start();		
		threadC=new Thread(new Runnable(){
			@Override
			public void run() {				
				synchronized(this){
					try{
						Thread.sleep(100);
						threadD.join();
						for(int i=26;i<=50;i++){
							sum2+=i;
						}
						System.out.println("�ڶ���ִ�еĽ���:"+sum2);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			
			}
		});
		threadC.start();
		threadD=new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						for(int i=1;i<=25;i++){
							sum1+=i;
						}
						System.out.println("��һ��ִ�еĽ���:"+sum1);

					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		threadD.start();				
			
		
	}


}
