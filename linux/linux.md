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
第四步，保存退出



















































