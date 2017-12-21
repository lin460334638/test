
实验六 JAVA多线程

实验六--1 对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。

通过使用synchronized关键字来实现同步方法，已达到线程安全的目的。

	public static synchronized chocolateBoiler getInstance(){
		if(instance==null){
			instance=new chocolateBoiler();
		}
		return instance;
	}
	
![](https://github.com/lin460334638/test/raw/master/实验截图/Threadmain1.png)

实验六--2 利用4个线程分段求和1~100 

每个部分的求和过程用一个线程来表示。每个thread中调用前一个thread的join()方法来达到先求前一部分和的目的。

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
							System.out.println("第四个执行的进程:"+sum4);
							System.out.println("最后的求和结果是:"+(sum1+sum2+sum3+sum4));
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
							System.out.println("第三个执行的进程:"+sum3);
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
							System.out.println("第二个执行的进程:"+sum2);
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
							System.out.println("第一个执行的进程:"+sum1);

						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			});
			threadD.start();							
		}
	}

![](https://github.com/lin460334638/test/raw/master/实验截图/Threadmain2.png)
