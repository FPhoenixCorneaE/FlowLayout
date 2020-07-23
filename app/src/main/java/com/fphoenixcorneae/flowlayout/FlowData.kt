package com.fphoenixcorneae.flowlayout

data class FlowData(
    var name: String,
    var enable: Boolean = true
) : FlowItem {
    override fun getItemName(): CharSequence? {
        return name
    }

    override fun isEnable(): Boolean {
        return enable
    }
}