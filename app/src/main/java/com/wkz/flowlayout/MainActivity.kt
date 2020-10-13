package com.wkz.flowlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fphoenixcorneae.flowlayout.FlowItem
import com.fphoenixcorneae.flowlayout.FlowLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data: ArrayList<in FlowItem> = arrayListOf(
        FlowItem("我怀疑", false),
        FlowItem("你是", false),
        FlowItem("老司机！", false),
        FlowItem("我不是", false),
        FlowItem("我没有"),
        FlowItem("别瞎说啊"),
        FlowItem("认怂三连"),
        FlowItem("我错了"),
        FlowItem("别打我啊"),
        FlowItem("求求你了"),
        FlowItem("装了逼还想跑？"),
        FlowItem("来啊"),
        FlowItem("互相伤害啊"),
        FlowItem("我怀疑"),
        FlowItem("你是"),
        FlowItem("老司机！"),
        FlowItem("我不是"),
        FlowItem("我没有"),
        FlowItem("别瞎说啊"),
        FlowItem("认怂三连"),
        FlowItem("我错了"),
        FlowItem("别打我啊"),
        FlowItem("求求你了"),
        FlowItem("装了逼还想跑？"),
        FlowItem("来啊"),
        FlowItem("互相伤害啊"),
        FlowItem("我怀疑"),
        FlowItem("你是"),
        FlowItem("老司机！"),
        FlowItem("我不是"),
        FlowItem("我没有"),
        FlowItem("别瞎说啊"),
        FlowItem("认怂三连"),
        FlowItem("我错了"),
        FlowItem("别打我啊"),
        FlowItem("求求你了"),
        FlowItem("装了逼还想跑？"),
        FlowItem("来啊"),
        FlowItem("互相伤害啊"),
        FlowItem("我怀疑"),
        FlowItem("你是"),
        FlowItem("老司机！"),
        FlowItem("我不是"),
        FlowItem("我没有"),
        FlowItem("别瞎说啊"),
        FlowItem("认怂三连"),
        FlowItem("我错了"),
        FlowItem("别打我啊"),
        FlowItem("求求你了"),
        FlowItem("装了逼还想跑？"),
        FlowItem("来啊"),
        FlowItem("互相伤害啊"),
        FlowItem("我怀疑"),
        FlowItem("你是"),
        FlowItem("老司机！"),
        FlowItem("我不是"),
        FlowItem("我没有"),
        FlowItem("别瞎说啊"),
        FlowItem("认怂三连"),
        FlowItem("我错了"),
        FlowItem("别打我啊"),
        FlowItem("求求你了"),
        FlowItem("装了逼还想跑？"),
        FlowItem("来啊"),
        FlowItem("互相伤害啊")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFlNone.apply {
            mDatas = data
            mOnItemClickListener = object :
                FlowLayout.OnItemClickListener {
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
            mOnItemClickListener = object :
                FlowLayout.OnItemClickListener {
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
            mOnItemClickListener = object :
                FlowLayout.OnItemClickListener {
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