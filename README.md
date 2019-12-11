# XFrame
基于Retrofit+Okhttp+RxJava+RxAndroid+Glide+ARouter+DataBinding的快速开发安卓框架

为了在工作中，新建项目时能够快速实现开发，而不必从零开始搭建基本的框架，开发此库。
主要对基本的网络，路由和代码结构等做了封装。

依赖库说明：
网络和数据解析：retrofit+okHttp
com.squareup.retrofit2:retrofit:2.6.2
com.squareup.retrofit2:converter-gson:2.6.2
com.squareup.retrofit2:adapter-rxjava2:2.6.2
io.reactivex.rxjava2:rxandroid:2.1.1

路由：ARouter
implementation 'com.alibaba:arouter-api:1.5.0'
annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'

Banner框架：
implementation 'com.youth.homeBanner:homeBanner:1.4.10'

日志框架：Logger
implementation 'com.orhanobut:logger:2.2.0'

权限框架：EasyPermission

