# RecordVideo
Android仿微信拍摄、录制视频，以及视频播放（基于JCameraView和GSYVideoPlayer）

### 引入权限
```
<uses-permission android:name="android.permission.FLASHLIGHT" />
<uses-feature android:name="android.hardware.camera" />
<uses-feature android:name="android.hardware.camera.autofocus" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

### 引入依赖
```
//视频录制
implementation 'cjt.library.wheel:camera:1.1.9'
//视频播放
api('com.shuyu:GSYVideoPlayer:6.0.1') {
    exclude group: 'com.android.support:appcompat-v7:27.0.0'
}
api('com.shuyu:gsyVideoPlayer-java:6.0.1') {
    exclude group: 'com.android.support:appcompat-v7:27.0.0'
}
api('com.shuyu:GSYVideoPlayer-exo2:6.0.1') {
    exclude group: 'com.android.support:appcompat-v7:27.0.0'
}
```
![Image text](https://img-blog.csdnimg.cn/2019041215041778.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMyMDkwMTg1,size_16,color_FFFFFF,t_70)
```
maven {
    url 'https://dl.bintray.com/cjt/maven'
}
```
