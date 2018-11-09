# uploader
SpringBoot文件上传组件

## 使用方法

* 在SpringBoot配置类上添加注解`@EnableUploader`即可。

* 上传url为`/upload/type`。其中type为文件类型，便于分类存储。既可以多文件也可以单文件。

    * type=1：普通文件。
    
    * type=2：图片文件。
    
    * type=3：附件。
    
* file表单 `name` 属性为 `file`

```html
<input multiple name="file" type="file">
```
    
* 返回Json格式

```json
{
  //状态："success" 或 "failure"
  "status": "success",
  //出错原因
  "reason": null,
  //上传成功图片url
  "urls": [
    "/2018/11/9/22/4145b5fb-869b-4be1-95d8-de3635ec1529.jpg",
    "/2018/11/9/22/23d5538c-6edc-400f-95cc-c3d9c5fae99b.jpg",
    "/2018/11/9/22/b22cafa7-9d87-458f-93dd-c86069858489.jpg"
  ]
}
```
    
## 属性设置

```properties
  #图片文件存储目录
  xin.uploader.image-path=C:/Users/XINDQ/Desktop/upload/image
  #普通文件存储目录
  xin.uploader.common-file-path=C:/Users/XINDQ/Desktop/upload/file
  #附件存储目录
  xin.uploader.attachment-path=C:/Users/XINDQ/Desktop/upload/attachment
  #子目录策略，用于减少一个文件夹里的文件数：可选year;month;day;hour
  xin.uploader.child-path-strategy=hour
```
