实验三--2

（1）JAVA访问权限修饰符的掌握
  test_class.java定义了类 a和aa分别为public的成员变量和成员函数, b和bb分别为private的成员变量和成员函数, c和cc分别为protected类型的成员变量和成员函数, d和dd分别为default类型的成员变量和成员函数。
  test_class2.java实例化对象并进行测试


![](https://github.com/lin460334638/test/raw/master/实验截图/JAVA访问权限修饰符的掌握.png)



（2）单例模式——使用单例模式完成下面描述的类
  chocolateBoilder.java用单例模式定义了chocolateBoilder
  singleton.java对类实例化
  hoc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoilerChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。private boolean empty;private boolean boiled;ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为falsepublic void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。isEmpty和isBoiled方法来获取empty和boiled标志位的值

![](https://github.com/lin460334638/test/raw/master/实验截图/单例模式chocolateBoilder.png)