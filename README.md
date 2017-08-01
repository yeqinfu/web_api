# web_api
my web api test for android app
这个服务端东西很杂，都是例子。有一个controller是对应 [环信android客户端](https://github.com/yeqinfu/hx-im) 的服务端。
里面有swaggerio呈现的api文档，可以提供测试访问（http://localhost/web_api/）
##### 关于环信
+ 注册接口，服务端向环信注册账号，存服务器操作，并返回相关信息
+ 登录接口，生成一个token而已，token 服务器维护，客户端根据返回自己登录环信
+ 查询在线用户，就是查询服务器在线的token用户相关信息而已
+ 模糊查询用户信息，返回一些环信id，用于客户端添加好友
+ 根目录sql可以导入数据表结构
that all
