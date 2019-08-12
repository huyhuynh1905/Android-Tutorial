# Android-Tutorial
## Các thư viện được sử dụng trong khoá:

1. Volley Android
>     dependencies {  
> 	   		implementation 'com.android.volley:volley:1.1.1'  
>     }
---
2. Nodes socket.io
>     dependencies {  
> 	    		implementation 'io.socket:socket.io-client:1.0.0'   
>     }
---
3. Thư viện xử lí ảnh Picaso
>     dependencies {  
> 	    		implementation 'com.squareup.picasso:picasso:2.5.2'   
>     }
---
4. Retrofit
>     dependencies {  
> 	    		implementation 'com.squareup.retrofit2:retrofit:2.1.0'
>           implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
>     }
---
5. QRcode với Zxing [Source](https://github.com/journeyapps/zxing-android-embedded) :
* Thêm thư viện vào: 
```
dependencies {
    implementation 'com.journeyapps:zxing-android-embedded:3.6.0'
    implementation 'com.android.support:appcompat-v7:25.3.1'
}
```
* Kích hoạt trong Mainifest:
```
<application android:hardwareAccelerated="true" ... >
```
* Thêm activity này vào để chỉnh cho camera quét hình vuông:
```
<activity
		android:name="com.journeyapps.barcodescanner.CaptureActivity"
		android:screenOrientation="fullSensor"
		tools:replace="screenOrientation" />
```
