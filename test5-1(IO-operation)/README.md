ʵ����--1  ����IO����

IO���read()�������ڴӼ��̽����ֽ���д�뵽��ǰĿ¼�µ�src.txt�ļ��У�Ȼ�󰴻س���ֹ���롣Ȼ������������Ȼ����FileOutputStream���ֽ���д��src.txt�С�

![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/����io����.png)

copyfile()��src.txt�����ݶ�ȡ��д�뵽dest.txt�С�
    File inFile=new File("src.txt");
    File outFile=new File("dest.txt");
    FileInputStream in=new FileInputStream(inFile);            //FileInputStream���ڶ�ȡsrc.txt�ļ�
    FileOutputStream out=new FileOutputStream(outFile);        //FileOutputStream����д�뵽dest.txt
    int c;
    while ((c =in.read()) != -1) {  
        out.write(c);  
        }  
    out.close(); 

![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/����io����2.png)

printfile()������FileInputStream��dest.txt�ļ������ݶ�ȡ������System.out.println�������������̨