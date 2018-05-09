##### file attr

|       -       |  rwx  |  rwx  |  rwx   |
| :-----------: | :---: | :---: | :----: |
| d---file type | owner | group | others |

`chmod [u,g,o,a]+rwx [file name]` 

`chmod [0x] [file]`

#### Base cmd

* **ls    -alh**
* more
* mkdir 、rmdir<only empty dir>、rm -rf  *<remove all files>
* cal
* date
* ln <source file> <link file>
* ln -s  <source file> <link file>     -----soft
* cat
* **grep**  -v <show non-matching lines>  -i<ignore case>  -n<line number>
* **find** 
* cp
* mv  <!--rename 、move file-->
* file <!--show file type -->
* ps -aux
* top 
* kill [0-9]<!--9 kill pid absolutely-->
* tar -xvf  
* gzip




#### User Group

`chown [user] [file]` --user

`chgrp [user] [file] `--group

`useradd -d /home/sloven sloven -m -s /bin/bash`

* groupadd
* groupdel
* useradd -d  /home/sloven sloven -m -g GroupName
* userdel



**默认vi开启的时候，自动显示行号**
第一步，回到用户的主目录下，cd回车
第二步，回到主目录下，生成一个叫.vimrc的文件，文件名前面必须有个.
第三步，在.vimrc中输入set nu
第四步，保存退出.

* 原码、补码（内存存储的类型）、反码


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













































