# condition-flow-Engine

<p align="center">
    <a target="_blank" href="https://search.maven.org/search?q=condition-flow-engine">
        <img src="https://img.shields.io/maven-central/v/cn.hutool/hutool-all.svg?label=Maven%20Central" />
	</a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img src="https://img.shields.io/badge/JDK-8+-green.svg" /></a>
</p>

### 简介

``condition-flow-Engine`` 是一款小且简单的条件流引擎，通过对条件的封装实现重复条件复用，通过配置即可实现对条件的层层过滤。



工具的由来是自己在以往工作中碰到的一些实际业务场景即需要满足使用者的灵活配置，也需要在代码上实现更高的复用。简直就是解决程序中大堆``if else``判断的利器。

我可不仅仅是进行条件判断哦，通过流过滤实现数据筛选我依然可以哦，更多场景等你解锁哦！

### 引入

针对使用``SpringBoot``的用户进行极大关照，轻松引入starter即刻使用。

```xml
<dependency>
    <groupId>cn.wxingzou.conditionflowengine</groupId>
    <artifactId>spring-boot-starter-condition-flow-engine</artifactId>
    <version>2.0-RELEASE</version>
</dependency>
```



普通maven用户使用，只是需要自己进行几步初始化啦~，初始化流程<a href="">请戳我</a>

```xml
<dependency>
      <groupId>cn.wxingzou.conditionflowengine</groupId>
      <artifactId>condition-flow-Engine</artifactId>
      <version>2.0-RELEASE</version>
</dependency>
```



### 使用方法

概念解析：

- 条件：单个条件的实现
- 条件链：多个条件的汇总，通过条件间的参数流通将多个条件串起来。
- 条件流模板：管理条件链，提供方法调用调用条件链。


为大家提供 springboot demo 方便大家快速上手，<a target="_blank" href="https://gitee.com/Mwuxiaolin/condition-flow-engine-demo">DEMO</a>

wiki上线啦，<a href="https://github.com/Wu-XiaoLin/condition-flow-Engine/wiki">戳我</a>教你详细使用步骤。

### 使用场景

- 条件查询繁杂，大段条件判断代码耦合
- 条件重复，调用混乱，重复代码较多
- 需要可配置，要求高复用性。



#### 例子

为大家举一个我的使用案例哦

- 报表统计，以往项目某学校需要对老师进行各种条件报表统计，使用 sql 固然可以解决问题，但是在面临近百个不同字段，数十个重复的查询条件时先不说数据库性能问题，相信大家 sql 都会写懵逼的，维护起来更是头疼，于是通过程序来进行条件过滤将会是很好的选择，速度极快，配合可配置的过滤条件，重复条件只需要实现一次条件即可配置快速完成。
- 欢迎大家提交issue说出你的使用案例哦......
