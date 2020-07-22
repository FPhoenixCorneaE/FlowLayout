package com.fphoenixcorneae.flowlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = arrayListOf(
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "我怀疑",
        "你是",
        "老司机！",
        "我不是",
        "我没有",
        "别瞎说啊",
        "认怂三连",
        "我错了",
        "别打我啊",
        "求求你了",
        "一脚伸过去"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFlNone.apply {
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
        mFlSingle.apply {
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
    }
}