# 在线考试管理系统

## 概述

- 用于学生进行在线考试的系统

## 环境相关

- 开发环境
  - jdk 1.8 + IDEA + windows + Tomcat + MySql
- 技术栈
  - java + servlet + jsp +jdbc + mysql + html 

## 功能概述

- 登录注册
- 用户信息管理
- 试题管理
- 在线考试管理
- 成绩展示

## 开发文档

1. 用户信息管理模块

   - 功能
     1. 用户信息注册
     2. 用户信息查询
     3. 用户信息删除
     4. 用户信息更新
   - 实现流程
     1. 创建用户信息表
     2. 创建用户实体类User
     3. 创建数据库操作类UserDao
     4. 对数据库进行操作

2. 试题信息管理模块

   - 功能
     1. 添加试题
     2. 查询试题
     3. 删除试题
     4. 更新试题

   - 实现
     1. 创建试题信息表
     2. 实体类
     3. 操作类
     4. 对数据库进行操作

3. 随机出题

   - 功能描述：用户点击【参加考试】，系统【随机】提取四道考试题，交给用户
   - 实现：提取数据时使用rand()操作随机获取题目

4. 在线阅卷

   - 功能描述：根据用户答题情况给出分数
   - 实现
     1. 根据用户所提交的答案与正确答案比较得到用户的分数
     2. 将用户分数交给jsp做输出
    
     
部分代码：
![图片](https://github.com/user-attachments/assets/875fc4dc-12a4-4c64-82f6-2219fa39f3b5)
![图片](https://github.com/user-attachments/assets/109650ef-7006-42ef-be43-7b42a0fe5ea9)


效果图：
![图片](https://github.com/user-attachments/assets/0eafdf1e-3f2e-48a2-b73d-88d4247d24ae)

![图片](https://github.com/user-attachments/assets/64a2e6a1-610d-4766-b2b2-20bd5e64ec26)
![图片](https://github.com/user-attachments/assets/d14b63c7-6dde-4b70-8702-c59fc6edcb8c)

