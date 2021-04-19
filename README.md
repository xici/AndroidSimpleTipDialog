# 示例
![avatar](/readme/demo.gif)

# 用法

## Gradle引入

### Add the JitPack repository to your build file
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

### Add the dependency
```
dependencies {
    implementation 'com.github.xici:AndroidSimpleTipDialog:1.0.0'
}
```

## 代码使用

### 默认用法

你可以使用定制化程度高的原生Builder。
```java
SimpleTipDialog.Builder builder = SimpleTipDialog.Builder.builder()
    .title("Your title")
    .mainTip("Main tip message")
    .subTip("Sub tip message")
    .leftBtnTxt("Left btn")
    .rightBtnTxt("Right Btn")
    .leftClickListener(new SimpleTipDialog.OnClickListener() {
        @Override
        public void onClick(SimpleTipDialog dialog) {
            //your code,do not forget call dismisss();
            dialog.dismiss();
        }
    })
    .rightClickListener(new SimpleTipDialog.OnClickListener() {
        @Override
        public void onClick(SimpleTipDialog dialog) {
            //your code,do not forget call dismisss();
            dialog.dismiss();
        }
    })
    .build();
SimpleTipDialog dialog = new SimpleTipDialog(context, builder);
dialog.show();
```

### 常用的对话框样式

我们也提供了一些常见的提示框在<code>BuilderFactory</code>.

+ newSucessBuilder: 成功提示;
+ newInfoBuilder: 普通提示;
+ newWarnBuilder: 提示提示;
+ newErrorBuilder: 错误提示;

### Builder支持的所有属性

| 属性                    | 释义                                                          |
|:-----------------------|:--------------------------------------------------------------|
| title                  | 对话框标题                                                      |
| titleColor             | 标题文本字体颜色                                                |
| mainTip                | 主提示信息                                                      |
| mainTipColor           | 主提示信息文本字体颜色                                           |
| subTip                 | 副提示信息（设置为空时不展示，主要用于温馨提示）                     |
| subTipClor             | 父提示信息文本颜色                                               |
| showLeftBtn            | 是否展示左边按钮（默认为true，最大支持两个按钮）                    |
| leftBtnTxt             | 左边按钮文本                                                    |
| leftBtnBgColor         | 左边按钮背景色                                                  |
| leftBtnColor           | 左边按钮文本文字字体颜色                                          |
| leftClickListener      | 左边按钮点击事件（不设置默认dismiss()，设置后需手动调用dissmisss()） |
| rightBtnTxt            | 右边按钮文本                                                    |
| rightBtnBgColor        | 右边按钮背景色                                                  |
| rightBtnColor          | 右边按钮文本文字字体颜色                                          |
| rightClickListener     | 右边按钮点击事件（不设置默认dismiss()，设置后需手动调用dissmisss()） |
| showCloseBtn           | 是否展示右上角关闭按钮（默认true）                                |
| cancelable             | 是否支持返回键关闭Dialog（默认true）                              |
| canceledOnTouchOutside | 点击除Dialog其他空白处是否关闭Dialog（默认true）                   |

# 许可

```
Copyright 2019, xici

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```