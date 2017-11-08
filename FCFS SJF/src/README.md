实验四

FCFS（先来先服务）算法
首先建立了以下几个类：
class Task    包含任务ID，到达时间，服务时间等属性并定义了List对象，calulate_Time()方法用于传入开始时间来计算完成时间，周转时间和带权周转时间。gettaskArray()方法用于接受从文件中读取出来的数据并传入到list中。

class file_oper  包含tasknum（这里根据题意我们初始化为100），service[]数组(根据题意初始化为{6,2,1,3,9})属性。 writefile()方法通过FileWrite对文件进行写入(任务ID，到达时间，服务时间)数据。   readfile()方法通过BufferedReader对文件进行读取并返回一个二维数组以供Task.gettaskArray()使用。

class single_queue 包含了一个List对象, S_queue()方法通过Task.gettaskArray()赋值对象数组给list,然后对list进行FCFS算法，方法是将list中后一个的开始时间等于前一个的完成时间。
showsingle_queue()方法将list的信息打出来。

![](https://github.com/lin460334638/test/raw/master/实验截图/单队列(FCFS).png)

class double_queue  包含三个List对象(list，list1，list2)，两个队列分别为list1，list2。 D_queue()方法通过比较两个队列最后一个对象的完成时间来决定list中元素的归属。
showdouble_queue()方法将list1，list2的信息打出来

![](https://github.com/lin460334638/test/raw/master/实验截图/双队列(FCFS).png)

SJF(短作业优先)算法

class SJF_queue 包含三个List对象(list，list1，list2)，两个队列分别为list1，list2。 Sin_queue()方法用于演示单队列的情况，原理是通过collections.sort()对在前一个对象完成时间之前到达的对象进行服务时间上的排序，并让服务时间最短的开始时间等于前一个的完成时间。
Dou_queue()方法 先比较两个队列最后一个对象的完成时间，哪个先完成，哪个便进行与Sin_queue()相似的SJF算法。
showsin_queue()将list1的信息打出来，showdou_queue()将list2的信息打出来。

![](https://github.com/lin460334638/test/raw/master/实验截图/单队列(SJF).png)
![](https://github.com/lin460334638/test/raw/master/实验截图/双队列1(SJF).png)
![](https://github.com/lin460334638/test/raw/master/实验截图/双队列2(SJF).png)