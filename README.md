# FlowLayout
流式布局，支持单选、多选、删除、是否可点击、是否可选中、设置随机颜色、圆角、描边、背景、水波纹颜色......
-------------------------------------------------------------------------

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
	implementation "androidx.recyclerview:recyclerview:1.1.0"
    implementation 'com.github.FPhoenixCorneaE:FlowLayout:1.0.6'
}
```

-------------------------------------------------------------------------
### xml中使用
```xml
<com.fphoenixcorneae.flowlayout.FlowLayout
            android:id="@+id/mFlNone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/holo_blue_light"
            app:flowLayoutClickable="false"
            app:flowLayoutCornerRadius="20dp"
            app:flowLayoutHorizontalSpacing="8dp"
            app:flowLayoutItemPaddingBottom="4dp"
            app:flowLayoutItemPaddingEnd="8dp"
            app:flowLayoutItemPaddingStart="8dp"
            app:flowLayoutItemPaddingTop="4dp"
            app:flowLayoutMaxSelectedCount="4"
            app:flowLayoutMode="none"
            app:flowLayoutNormalBgColor="@android:color/white"
            app:flowLayoutNormalStrokeColor="@android:color/holo_green_light"
            app:flowLayoutPaddingBottom="4dp"
            app:flowLayoutPaddingEnd="8dp"
            app:flowLayoutPaddingStart="8dp"
            app:flowLayoutPaddingTop="4dp"
            app:flowLayoutRandomTextColor="true"
            app:flowLayoutSelectedBgColor="@android:color/holo_purple"
            app:flowLayoutSelectedStrokeColor="@android:color/holo_orange_dark"
            app:flowLayoutSelectedTextColor="@android:color/holo_blue_dark"
            app:flowLayoutShowDelete="false"
            app:flowLayoutStrokeWidth="2dp"
            app:flowLayoutTextColor="@android:color/holo_green_light"
            app:flowLayoutTextFontFamily="@font/arial"
            app:flowLayoutTextSize="20sp"
            app:flowLayoutVerticalSpacing="4dp"
            app:layout_constraintBottom_toTopOf="@+id/mFlSingle"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_chainStyle="packed" />
```

### 数据需要实现FlowItem接口
```kotlin
data class FlowData(
    var name: String
) : FlowItem {
    override fun getItemName(): CharSequence? {
        return name
    }
}
```

### 代码中设置属性
```kotlin
mFlMultiple.apply {
            mDatas = data
            mOnItemClickListener = object : FlowLayout.OnItemClickListener {
                override fun onItemClick(
                    itemName: String,
                    position: Int,
                    isSelected: Boolean,
                    selectedData: ArrayList<String>
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "itemName:${itemName} position:${position}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i(
                        "OnItemClickListener",
                        "itemName:${itemName} position:${position} isSelected:${isSelected} selectedData:$selectedData"
                    )
                }

                override fun onDelete(
                    itemName: String,
                    position: Int,
                    selectedData: ArrayList<String>
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "itemName:${itemName} position:${position}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i(
                        "OnItemClickListener",
                        "itemName:${itemName} position:${position} selectedData:$selectedData"
                    )
                }
            }
        }
```