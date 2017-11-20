实验五--2 获取系统的文件树

file_tree类包含
public String path;
List<File> list1 = new ArrayList<File>();       //用于存放文件夹信息
List<File> list2 = new ArrayList<File>();       //用于存放文件信息
public void getdirectory()   利用Scanner类从控制台输入目录路径并赋值给path。(判断路径是否存在)
public void orderfile()   //将文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序
	Collections.sort(list1, new Comparator<File>(){                        //对list1的文件夹根据名字排序
				   @Override  
				   public int compare(File o1, File o2) {  
					   	Collator instance = Collator.getInstance(Locale.CHINA);     //**collator中文排序
					    return instance.compare(o1.getName(), o2.getName());
				   }  
			});
![](https://github.com/lin460334638/test/raw/master/实验截图/文件树1.png)

public void writefile()   //将目录信息写入到文本文件filesInfo.txt中     每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
		File fr = new File("filesInfo.txt");
		String info="";
		try{
			FileWriter out = new FileWriter(fr);
			for(File f:list1){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(f.lastModified());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
				info=f.getName()+"    "+formatter.format(cal.getTime())+'\n';    //无法直接+'\n'实现换行，所以用String.format("%s%n",info)
				out.write(String.format("%s%n",info));                     
			}
			for(File f:list2){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(f.lastModified());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
				info=f.getName()+"    "+formatter.format(cal.getTime())+"    "+f.length()/1024f+"KB";
				out.write(String.format("%s%n",info));
			}
			out.close();

![](https://github.com/lin460334638/test/raw/master/实验截图/文件树2.png)