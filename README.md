# FlowLayout
流式布局，支持单选、多选、删除......
-------------------------------------------------------------------------

<div align="center">
    <img src="https://github.com/FPhoenixCorneaE/FlowLayout/blob/master/preview/preview_flowlayout.png" width="320"/>
</div>





-------------------------------------------------------------------------
### xml中使用
```xml
<com.fphoenixcorneae.flowlayout.FlowLayout
            android:id="@+id/mFlNone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/holo_blue_light"
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