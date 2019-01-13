# CommunityManagementSystem
## 社团管理系统
很早之前学习时的第一个项目，sql文件丢失了，手动写了几个，如需要达到理想的界面展示，需要手动添加一些数据。

### 背景
> 是为了迎合学校“百团大战”(一种每年都有的社团迎新活动)，为社团迎新开发的管理系统。方便学生浏览申请参加各种社团，同时方便管理者对各社团发送通知，下发文件等管理。


### 运行环境
* JDK1.7编写
* Eclipse( Neon.3 Release (4.6.3)) windows下
* Tomcat v8.5
* Mysql 5.5


### 使用技术
* Java servlet & jsp
* Mysql 数据库
* c3p0连接池
* JavaScript & jQuery
* 使用bootstrap搭建前端展示界面


### 实现的功能
- 前端展示
  - 普通用户登录、注册。保证用户名唯一性，不可重复。
  - 登录前可以查看各种分类的社团的概要，简介等信息，还有最近各社团将要举行的各种活动的时间地点，活动标题等活动公告。
  - 登录后可以查看、修改个人信息、密码等。
- 管理员登录后台后，后台登录URL [http://localhost/shetuan/admin_login.jsp]
  - 用户管理，添加用户(根据账号修改普通用户的密码或权限)，更新当前账号密码、查看用户列表(可以查看用户详细信息及加入或创建的社团信息，可对用户的个人信息进行修改、删除)。
  - 社团管理，添加社团，查看社团列表(可以查看某一个社团的具体信息，进行编辑或删除)，查看社团活动信息(可以查看社团活动详情，进行编辑或删除)。
  - 审核管理，创建社团审批，创办活动审批。
  - 社联新闻，添加社联新闻，更新社联新闻。


### 运行截图

普通用户登录界面

![登录界面](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/login.jpg)

普通用户注册界面

![注册界面](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/regist.jpg)

未登录前主界面展示

![主界面](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/main.jpg)

未登录前社团概要

![界面展示0](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/introduction0.jpg)

![界面展示1](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/introduction1.jpg)

![界面展示2](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/introduction2.jpg)

![界面展示3](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/introduction3.jpg)

未登录前社团活动公告

![公告](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/notes.jpg)

登录后个人信息修改

![个人信息修改](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/after_login_info.jpg)

登录后查看社团详细信息

![社团信息](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/after_login_Cinfo.jpg)


后台登录界面

![后台主界面](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/admin_main.jpg)

![后台登录界面](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/admin_login.jpg)

用户管理界面

![添加用户](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/adduser.jpg)

![更新当前密码](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/updatepass.jpg)

![用户列表](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/userlist.jpg)

社团管理界面

![添加社团](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/addcommunity.jpg)

![社团列表](https://github.com/jelly54/CommunityManagementSystem/blob/master/screenshot/communitylist.jpg)