# spring-security-demo

基于spring security、oauth2.0、jwt实现的安全认证

基于B站上的学习视频，创建的一个示例学习工程，将学习过程记录下来

视频链接：https://www.bilibili.com/video/BV1gb4y1b7XE?p=9&vd_source=52c097a4b5862f45d48da4416c18c444



## 实现的功能点

- 实现自定义login

- 登录成功之后的处理

- 自定义登录时的参数名

- 自定义登录成功之后的处理

- 自定义登录失败之后的处理

## 测试

### 授权码模式

1.获取授权码
http://localhost:8080/oauth/authorize?response_type=code&client_id=client001&redirect_uri=https://www.bilibili.com/&scopes=all

2.登录输入账号密码

3.获取token
认证方式：basic auth
http://localhost:8080/oauth/token?code=nRbLPa&grant_type=authorization_code&client_id=client001&redirect_uri=https://www.bilibili.com/&scopes=all

4.获取资源
认证方式：bearer token
http://localhost:8080/user/info

### 密码模式
认证方式：basic auth
http://localhost:8080/oauth/token?grant_type=password&username=admin&password=123&scops=all&redirect_uri=https://www.bilibili.com/

