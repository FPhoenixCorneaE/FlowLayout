# FlowLayout

流式布局
-------------------------------------------------------------------------

[![](https://jitpack.io/v/FPhoenixCorneaE/FlowLayout.svg)](https://jitpack.io/#FPhoenixCorneaE/FlowLayout)

<div align="center">
    <img src="https://github.com/FPhoenixCorneaE/FlowLayout/blob/master/preview/preview_flowlayout.png" width="320"/>
</div>


How to include it in your project:
--------------
**Step 1.** Add the JitPack repository to your build file

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    // 添加recyclerview依赖,否则会报错
    implementation "androidx.recyclerview:recyclerview:1.2.1"
    implementation 'com.github.FPhoenixCorneaE:FlowLayout:1.0.8'
}
```

-------------------------------------------------------------------------

### 特性
* 支持单选、多选、删除
* 是否激活、是否可点击
* 设置随机颜色、圆角、描边、背景、水波纹颜色、字体
* ......

### xml中使用

```xml

<com.fphoenixcorneae.flowlayout.FlowLayout android:id="@+id/mFlNone" android:layout_width="match_parent"
    android:layout_height="wrap_content" android:background="@android:color/holo_blue_light"
    app:flowLayoutCornerRadius="20dp" app:flowLayoutHorizontalSpacing="8dp" app:flowLayoutItemPaddingBottom="4dp"
    app:flowLayoutItemPaddingEnd="8dp" app:flowLayoutItemPaddingStart="8dp" app:flowLayoutItemPaddingTop="4dp"
    app:flowLayoutMaxSelectedCount="4" app:flowLayoutMode="none" app:flowLayoutNormalBgColor="@android:color/white"
    app:flowLayoutNormalStrokeColor="@android:color/holo_green_light" app:flowLayoutPaddingBottom="4dp"
    app:flowLayoutPaddingEnd="8dp" app:flowLayoutPaddingStart="8dp" app:flowLayoutPaddingTop="4dp"
    app:flowLayoutRandomTextColor="true" app:flowLayoutSelectedBgColor="@android:color/holo_purple"
    app:flowLayoutSelectedStrokeColor="@android:color/holo_orange_dark"
    app:flowLayoutSelectedTextColor="@android:color/holo_blue_dark" app:flowLayoutStrokeWidth="2dp"
    app:flowLayoutTextColor="@android:color/holo_green_light" app:flowLayoutTextFontFamily="@font/arial"
    app:flowLayoutTextSize="20sp" app:flowLayoutVerticalSpacing="4dp"
    app:layout_constraintBottom_toTopOf="@+id/mFlSingle" app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent" app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_chainStyle="packed" />
```

### FlowItem 数据

```kotlin
val datas1 = arrayListOf(
    FlowItem(name = "我怀疑", enabled = false),
    FlowItem(name = "你是", enabled = false),
    FlowItem(name = "老司机！", clickable = false),
    FlowItem(name = "我不是", clickable = false),
    FlowItem(name = "我没有", showDelete = true),
    FlowItem(name = "别瞎说啊", showDelete = true),
    FlowItem(name = "认怂三连", showDelete = true),
    FlowItem(name = "我错了", showDelete = true),
    FlowItem(name = "别打我啊", showDelete = true),
    FlowItem(name = "求求你了", showDelete = true),
    FlowItem(name = "装了逼还想跑？", showDelete = true),
    FlowItem(name = "来啊", showDelete = true),
    FlowItem(name = "互相伤害啊", showDelete = true),
)
```

### 代码中设置属性

```kotlin
mFlNone.apply {
    mDatas = datas1
    mOnItemClickListener = object :
        FlowLayout.OnItemClickListener {
        override fun onItemClick(
            item: FlowItem,
            position: Int,
            selectedData: List<FlowItem>,
        ) {
            Toast.makeText(
                this@MainActivity,
                "itemName:${item.name} position:${position}",
                Toast.LENGTH_SHORT
            ).show()
            Log.i(
                "OnItemClickListener",
                "itemName:${item.name} position:${position} isSelected:${item.selected} selectedData:$selectedData"
            )
        }

        override fun onDelete(
            item: FlowItem,
            position: Int,
            selectedData: List<FlowItem>,
        ) {
            Toast.makeText(
                this@MainActivity,
                "itemName:${item.name} position:${position}",
                Toast.LENGTH_SHORT
            ).show()
            Log.i(
                "OnItemClickListener",
                "itemName:${item.name} position:${position} selectedData:$selectedData"
            )
        }
    }
}
```