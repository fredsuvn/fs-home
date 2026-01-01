# 项目规则

## 基本规则

- 这个文件是项目整体规则；
- 每个模块都可以有自己的规则文件，若有，则在模块目录下的.ai/module_rules.md文件；
- 模块的规则可以覆盖项目的规则；

## 技术规则

- 本项目不使用spring技术栈，而是使用：
  - fs：作为通用基础库，包括依赖注入功能，在core模块的`space.sunqian.fsh.starter.FshDemo`类中有示例；
  - Tomcat：作为web容器，需要注意的是项目通过jar直接启动，而不是war包在Tomcat容器中启动；
  - H2 Database：作为项目的数据库；
  - Thymeleaf：使用该端模板引擎来开发前端页面；
  - 项目根目录下的asset/js中包含的js为公共第三方js库，用于前端开发；
- 代码要遵守一定的规范，尤其要注意.editorconfig，.gitattributes，和.gitignore三个文件中定义的规则；
- 代码要有一定的注释，尤其是在复杂的业务代码中，且注释要使用英文；

## 项目概述

- 项目有四个大模块，根包名是，`space.sunqian.fsh`：
  - 项目依赖（fsh-dependencies）：一个pom项目，包含所有项目的依赖；
  - 项目核心（fsh-core）：项目的核心功能，其他模块都依赖于此模块，包名是`space.sunqian.fsh.core`；
  - 项目启动器（fsh-starter）：项目的启动器，用来启动项目，包名是`space.sunqian.fsh.starter`；
  - 项目应用（fsh-app）：严格的来说，这是一个模块集合，包名是`space.sunqian.fsh.apps`，里面的每个子目录（子模块）都是一个项目的应用，应用的包名是
    `space.sunqian.fsh.apps.应用名`，应用里的.ai/app_rules.md文件定义了应用的规则；
- 这个项目是一个用于家庭NAS的项目，包括以下几个功能：
  - 用户体系：统一管理项目的租户，用户，群组，权限等；
  - 应用体系：项目可以看成是一个应用平台，各种不同的应用（fsh-app中的）都可以在应用管理页面中管理、跳转；
  - 主页：主页主题部分是一个搜索框，还包括收藏夹、应用快捷方式等功能，可编辑；