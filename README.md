#### 摸鱼提醒

##### 1.访问
本地启动
访问 http://localhost:9099/index

Docker build
```shell
docker build -t slack:v1 .
docker run -d --name slack -p 9099:9099 slack:v1
```

##### 致谢：
[1] https://github.com/isee15/Lunar-Solar-Calendar-Converter