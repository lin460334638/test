实验五--1  基本IO操作

IO类的read()方法用于从键盘接收字节流写入到当前目录下的src.txt文件中，然后按回车终止输入。然后将输入流读入然后用FileOutputStream将字节流写入src.txt中。

![](https://github.com/lin460334638/test/raw/master/实验截图/基本io操作.png)

copyfile()将src.txt的内容读取并写入到dest.txt中。
    File inFile=new File("src.txt");
    File outFile=new File("dest.txt");
    FileInputStream in=new FileInputStream(inFile);            //FileInputStream用于读取src.txt文件
    FileOutputStream out=new FileOutputStream(outFile);        //FileOutputStream用于写入到dest.txt
    int c;
    while ((c =in.read()) != -1) {  
        out.write(c);  
        }  
    out.close(); 

![](https://github.com/lin460334638/test/raw/master/实验截图/基本io操作2.png)

printfile()方法用FileInputStream将dest.txt文件的内容读取，并用System.out.println（）输出到控制台