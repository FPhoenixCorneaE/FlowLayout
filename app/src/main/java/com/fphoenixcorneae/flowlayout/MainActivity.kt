package com.fphoenixcorneae.flowlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data: ArrayList<in FlowItem> = arrayListOf(
        FlowData("我怀疑", false),
        FlowData("你是", false),
        FlowData("老司机！", false),
        FlowData("我不是", false),
        FlowData("我没有"),
        FlowData("别瞎说啊"),
        FlowData("认怂三连"),
        FlowData("我错了"),
        FlowData("别打我啊"),
        FlowData("求求你了"),
        FlowData("装了逼还想跑？"),
        FlowData("来啊"),
        FlowData("互相伤害啊"),
        FlowData("我怀疑"),
        FlowData("你是"),
        FlowData("老司机！"),
        FlowData("我不是"),
        FlowData("我没有"),
        FlowData("别瞎说啊"),
        FlowData("认怂三连"),
        FlowData("我错了"),
        FlowData("别打我啊"),
        FlowData("求求你了"),
        FlowData("装了逼还想跑？"),
        FlowData("来啊"),
        FlowData("互相伤害啊"),
        FlowData("我怀疑"),
        FlowData("你是"),
        FlowData("老司机！"),
        FlowData("我不是"),
        FlowData("我没有"),
        FlowData("别瞎说啊"),
        FlowData("认怂三连"),
        FlowData("我错了"),
        FlowData("别打我啊"),
        FlowData("求求你了"),
        FlowData("装了逼还想跑？"),
        FlowData("来啊"),
        FlowData("互相伤害啊"),
        FlowData("我怀疑"),
        FlowData("你是"),
        FlowData("老司机！"),
        FlowData("我不是"),
        FlowData("我没有"),
        FlowData("别瞎说啊"),
        FlowData("认怂三连"),
        FlowData("我错了"),
        FlowData("别打我啊"),
        FlowData("求求你了"),
        FlowData("装了逼还想跑？"),
        FlowData("来啊"),
        FlowData("互相伤害啊"),
        FlowData("我怀疑"),
        FlowData("你是"),
        FlowData("老司机！"),
        FlowData("我不是"),
        FlowData("我没有"),
        FlowData("别瞎说啊"),
        FlowData("认怂三连"),
        FlowData("我错了"),
        FlowData("别打我啊"),
        FlowData("求求你了"),
        FlowData("装了逼还想跑？"),
        FlowData("来啊"),
        FlowData("互相伤害啊")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFlNone.apply {
            mDatas = data
            mOnItemClickListener = object : FlowLayout.OnItemClickListener {
                override fun onItemClick(
                    itemName: CharSequence?,
                    position: Int,
                    isSelected: Boolean,
                    selectedData: ArrayList<in FlowItem>
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
                    itemName: CharSequence?,
                    position: Int,
                    selectedData: ArrayList<in FlowItem>
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
                    itemName: CharSequence?,
                    position: Int,
                    isSelected: Boolean,
                    selectedData: ArrayList<in FlowItem>
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
                    itemName: CharSequence?,
                    position: Int,
                    selectedData: ArrayList<in FlowItem>
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
                    itemName: CharSequence?,
                    position: Int,
                    isSelected: Boolean,
                    selectedData: ArrayList<in FlowItem>
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
                    itemName: CharSequence?,
                    position: Int,
                    selectedData: ArrayList<in FlowItem>
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