ʵ����

FCFS�������ȷ����㷨
���Ƚ��������¼����ࣺ
class Task    ��������ID������ʱ�䣬����ʱ������Բ�������List����calulate_Time()�������ڴ��뿪ʼʱ�����������ʱ�䣬��תʱ��ʹ�Ȩ��תʱ�䡣gettaskArray()�������ڽ��ܴ��ļ��ж�ȡ���������ݲ����뵽list�С�

class file_oper  ����tasknum����������������ǳ�ʼ��Ϊ100����service[]����(���������ʼ��Ϊ{6,2,1,3,9})���ԡ� writefile()����ͨ��FileWrite���ļ�����д��(����ID������ʱ�䣬����ʱ��)���ݡ�   readfile()����ͨ��BufferedReader���ļ����ж�ȡ������һ����ά�����Թ�Task.gettaskArray()ʹ�á�

class single_queue ������һ��List����, S_queue()����ͨ��Task.gettaskArray()��ֵ���������list,Ȼ���list����FCFS�㷨�������ǽ�list�к�һ���Ŀ�ʼʱ�����ǰһ�������ʱ�䡣
showsingle_queue()������list����Ϣ�������

![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/������(FCFS).png)

class double_queue  ��������List����(list��list1��list2)���������зֱ�Ϊlist1��list2�� D_queue()����ͨ���Ƚ������������һ����������ʱ��������list��Ԫ�صĹ�����
showdouble_queue()������list1��list2����Ϣ�����

![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/˫����(FCFS).png)

SJF(����ҵ����)�㷨

class SJF_queue ��������List����(list��list1��list2)���������зֱ�Ϊlist1��list2�� Sin_queue()����������ʾ�����е������ԭ����ͨ��collections.sort()����ǰһ���������ʱ��֮ǰ����Ķ�����з���ʱ���ϵ����򣬲��÷���ʱ����̵Ŀ�ʼʱ�����ǰһ�������ʱ�䡣
Dou_queue()���� �ȱȽ������������һ����������ʱ�䣬�ĸ�����ɣ��ĸ��������Sin_queue()���Ƶ�SJF�㷨��
showsin_queue()��list1����Ϣ�������showdou_queue()��list2����Ϣ�������

![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/������(SJF).png)
![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/˫����1(SJF).png)
![](https://github.com/lin460334638/test/raw/master/ʵ���ͼ/˫����2(SJF).png)