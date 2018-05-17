#### 字符串

`char a[10]={1,2,3,4,5,6,7,9}`
`sizeof(a)/sizeof(a[0])`
`char a[10]={0}`

* gets()、fgets()、puts(/*auto add \n*/)、fputs(/*no \n*/)
* strlen()------<string.h>/*besides len of \0*/
* strcat(a,b)-----/*put b to a*/
* strncat(a,b,num)----/*put num b to a*/
* strcmp(a,b)------/*compare a equals b */
* strncmp(a,b,num)-----/*compare num before*/
* strcpy(a,b)
* strncpy(a,b,num)
* prinf 、sprintf(print to char[])
* strchr---/*search sub str by char*/ 、strstr----/*search sub str by char[]*/
* strtok(char[] or NULL,"SYBOAL")-----/*like split*/
* atoi(a)-----/*Integer.valueof(s)*/
* atof(a)、atol(a)

#### 函数

* exit(0)
* ifdef、ifndef、define

#### 指针

* & 取址、
* const int *p //p是一个变量，可以改变指向
* int *const p  //p是一个常量，指向的地址不能变
* ip地址实际上是一个int值


#### struct

1. 内存对齐。长板效应，与长板对齐。--合理定义结构体成员变量，能减少内存开支
2. 以数组成员的类型对齐。
3. 结构体变量的地址就是首元素的地址
4. 结构体元素是有顺序的。
5. cpu处理int的效率最高，但是int比char多占内存。处理浮点类型更慢
6. 结构体内必须定义元素（c中必须，从c++中可以）
7. struct a= struct b;  结构体复制就是内存的/*拷贝*/ （如果有指针则为浅拷贝，memcpy进行深拷贝）
8. struct *p==========(*p).ele 与 p->ele含义相同
9. 结构体中的指针元素必须指向内存空间，否则为空指针无法进行赋值。
10. 结构体变量的指针元素。


#### union 

1. union元素公用一块内存空间
2. 修改任意一个元素的值，会影响其他元素的值]]]


#### typedef

1. 定义类型--可以简化代码
	typedef char PHONE;

#### 文件操作

1. FILE *fopen(const char *path,const char *mode);

mode:r（必须有可读权限，必须文件存在） r+  w(内容清空，如果文件不存在，创建文件)  w+

2. fclose(FILE *fp)
3. gec(mode为r)、putc(mode为w)--已追加的形式操作文件--文件结尾宏EOF(-1)
4. fputs、fgets 以字符串为单位
5. feof(*file)判断是否是结尾
6. fscanf:从文件中读取转义,fprintf：向文件中写入
7. stat函数可以知道一些文件的属性
8. fread、fwrite读写二进制文件（可以写copy文件的小例子）
9. fseek 改变读写位置指针--（快速生成超大文件的方法，指针后移∞大，读入一个字节即可，秒级生成超大文件）
10. ftell 指针当前位置。
11. fflush 刷新缓存区数据
12. remove,rename移除文件，文件重命名	

++++++++++++文件操作例子亲自动手写一下--复习以前的命令，没多少。

	1. 文件操作例子
	2. 命令行参数
	3. 字符串的几个命令
	4. 其他的几个
	













