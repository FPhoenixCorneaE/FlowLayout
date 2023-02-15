package com.fphoenixcorneae.flowlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
    val datas2 = arrayListOf(
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
    val datas3 = arrayListOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        mFlSingle.apply {
            mDatas = datas2
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
        mFlMultiple.apply {
            mDatas = datas3
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
    }
}