package com.fphoenixcorneae.flowlayout

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.os.Parcelable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.FontRes
import androidx.annotation.IntDef
import androidx.annotation.Keep
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import kotlinx.parcelize.Parcelize
import java.io.Serializable

/**
 * @desc：流式布局
 * @date：2020-07-20 13:32
 */
class FlowLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RecyclerView(context, attrs, defStyleAttr) {

    /**
     * 模式：单选、多选、无样式
     */
    @Target(
        AnnotationTarget.CLASS,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.PROPERTY
    )
    @IntDef(value = [Mode.SINGLE, Mode.MULTIPLE, Mode.NONE])
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class Mode {
        companion object {
            const val NONE = 0
            const val SINGLE = 1
            const val MULTIPLE = 2
        }
    }

    /**
     * Item点击监听器
     */
    interface OnItemClickListener {
        /**
         * 点击Item
         */
        fun onItemClick(
            item: FlowItem,
            position: Int,
            selectedData: List<FlowItem>,
        )

        /**
         * 点击删除图标
         */
        fun onDelete(
            item: FlowItem,
            position: Int,
            selectedData: List<FlowItem>,
        ) {
        }
    }

    /**
     * 流式布局数据
     */
    var mDatas: List<FlowItem> = listOf()

    /**
     * 流式布局适配器
     */
    private lateinit var mAdapter: Adapter<ViewHolder>

    /**
     * Item点击监听器
     */
    var mOnItemClickListener: OnItemClickListener? = null

    /**
     * 模式：默认为[Mode.NONE]
     */
    @Mode
    var mMode = Mode.NONE
        set(@Mode value) {
            field = @Mode value
        }

    /**
     * 多选模式下,最大选择数量,默认5个
     */
    var mMaxSelectedCount = 5

    /**
     * 圆角半径
     */
    var mCornerRadius = 0f

    /**
     * 随机文字颜色、文字颜色、选中的文字颜色、文字大小、文字字体
     */
    var mRandomTextColor = false

    @ColorInt
    var mTextColor = Color.DKGRAY

    @ColorInt
    var mSelectedTextColor = Color.BLACK
    var mTextSize = 16f

    @FontRes
    var mTextFontFamilyRes = 0

    /**
     * 背景颜色、选中的背景颜色
     */
    var mNormalBgColor = Color.WHITE
    var mSelectedBgColor = Color.MAGENTA

    /**
     * 描边宽度、描边颜色、选中的描边颜色
     */
    var mStrokeWidth = 0f
    var mNormalStrokeColor = Color.CYAN
    var mSelectedStrokeColor = Color.YELLOW

    /**
     * Item:左边内边距、上边内边距、右边内边距、下边内边距
     */
    var mItemPaddingStart = 4f
    var mItemPaddingTop = 2f
    var mItemPaddingEnd = 4f
    var mItemPaddingBottom = 2f

    /**
     * 左边内边距、上边内边距、右边内边距、下边内边距
     */
    var mPaddingStart = 8f
    var mPaddingTop = 4f
    var mPaddingEnd = 8f
    var mPaddingBottom = 4f

    /**
     * 垂直线间距离、水平线间距离
     */
    var mVerticalSpacing = 4f
    var mHorizontalSpacing = 8f

    /**
     * 水波纹颜色
     */
    var mRippleColor = Color.DKGRAY

    init {
        obtainStyledAttr(attrs, context)
        initLayout(context)
    }

    private fun initLayout(context: Context) {
        // 设置内边距
        setPadding(
            mPaddingStart.toInt(),
            mPaddingTop.toInt(),
            mPaddingEnd.toInt(),
            mPaddingBottom.toInt()
        )
        setHasFixedSize(true)
        isNestedScrollingEnabled = false
        setItemViewCacheSize(200)
        overScrollMode = OVER_SCROLL_NEVER
        // 伸缩布局管理器
        layoutManager = FlexboxLayoutManager(context).apply {
            // 按正常方向换行
            flexWrap = FlexWrap.WRAP
            // 主轴为水平方向，起点在左端
            flexDirection = FlexDirection.ROW
            // 定义项目在副轴轴上如何对齐
            alignItems = AlignItems.CENTER
            // 多个轴对齐方式
            justifyContent = JustifyContent.FLEX_START
        }
        // 适配器
        mAdapter = object : Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val itemView = ConstraintLayout(parent.context).apply {
                    id = View.generateViewId()
                }
                return FlowLayoutViewHolder(itemView)
            }

            override fun getItemCount(): Int {
                return mDatas.size
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                (holder as FlowLayoutViewHolder).apply {
                    val flowItem = mDatas[bindingAdapterPosition]
                    val itemName = flowItem.name
                    val enabled = flowItem.enabled
                    val clickable = flowItem.clickable
                    val selected = flowItem.selected
                    contentView.let {
                        it.isEnabled = enabled
                        it.isSelected = selected
                        it.alpha = if (enabled) 1f else .4f
                        if (clickable) {
                            // item点击
                            it.clickNoRepeat {
                                when (mMode) {
                                    // 单选模式
                                    Mode.SINGLE -> {
                                        val lastSelectedPosition = getSelectedPosition().firstOrNull()
                                        resetSelectedState(bindingAdapterPosition)
                                        mAdapter.notifyItemChanged(bindingAdapterPosition)
                                        lastSelectedPosition?.let {
                                            mAdapter.notifyItemChanged(it)
                                        }
                                        mOnItemClickListener?.onItemClick(
                                            flowItem,
                                            bindingAdapterPosition,
                                            getSelectedData()
                                        )
                                    }
                                    // 多选模式
                                    Mode.MULTIPLE -> {
                                        when {
                                            getSelectedCount() < mMaxSelectedCount -> {
                                                // 当前已选择数少于设置的最大选择数
                                                toggleSelectedState(bindingAdapterPosition)
                                                mAdapter.notifyItemChanged(bindingAdapterPosition)
                                                mOnItemClickListener?.onItemClick(
                                                    flowItem,
                                                    bindingAdapterPosition,
                                                    getSelectedData()
                                                )
                                            }
                                            it.isSelected -> {
                                                // 该选项是已选中状态,再次点击变为未选中状态
                                                toggleSelectedState(bindingAdapterPosition)
                                                mAdapter.notifyItemChanged(bindingAdapterPosition)
                                                mOnItemClickListener?.onItemClick(
                                                    flowItem,
                                                    bindingAdapterPosition,
                                                    getSelectedData()
                                                )
                                            }
                                            else -> {
                                                // 已达到设置最大可选中数目
                                                Toast.makeText(
                                                    getContext(),
                                                    "最多只能选中${mMaxSelectedCount}个！",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                    // 无样式
                                    Mode.NONE -> {
                                        mOnItemClickListener?.onItemClick(
                                            flowItem,
                                            bindingAdapterPosition,
                                            getSelectedData()
                                        )
                                    }
                                }
                            }
                        }
                    }
                    tvText.apply {
                        text = itemName
                        if (mRandomTextColor) {
                            setTextColor(getRandomColor())
                        } else {
                            setTextColor(if (selected) mSelectedTextColor else mTextColor)
                        }
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize)
                        paint.isFakeBoldText = selected
                    }
                    ivDelete.let {
                        it.isEnabled = enabled
                        it.isVisible = flowItem.showDelete
                        when {
                            selected -> it.setTintColor(mSelectedTextColor)
                            else -> it.setTintColor(mTextColor)
                        }
                        if (clickable) {
                            it.clickNoRepeat {
                                // 删除选项
                                mDatas = mDatas.toMutableList().apply { removeAt(bindingAdapterPosition) }
                                mOnItemClickListener?.onDelete(
                                    flowItem,
                                    bindingAdapterPosition,
                                    getSelectedData()
                                )
                                mAdapter.notifyItemRemoved(bindingAdapterPosition)
                                // 删除后重新测量宽高
                                requestLayout()
                            }
                        }
                    }
                }
            }
        }
        adapter = mAdapter
    }

    /**
     * 重置选择状态
     */
    fun resetSelectedState(selectedPosition: Int) {
        mDatas.forEachIndexed { index, item ->
            item.selected = selectedPosition == index
        }
    }

    /**
     * 切换选择状态
     */
    fun toggleSelectedState(position: Int) {
        mDatas[position].let {
            it.selected = !it.selected
        }
    }

    /**
     * 获取选择的数量
     */
    fun getSelectedCount(): Int {
        return getSelectedData().size
    }

    /**
     * 获取选择的数据
     */
    fun getSelectedData(): List<FlowItem> {
        return mDatas.filter { it.selected }
    }

    /**
     * 获取选择的下标
     */
    fun getSelectedPosition(): List<Int> {
        return getSelectedData().flatMapIndexed { _, item ->
            listOf(mDatas.indexOf(item))
        }
    }

    /**
     * 流式布局 ViewHolder
     */
    @SuppressLint("ObsoleteSdkInt")
    private inner class FlowLayoutViewHolder(itemView: View) : ViewHolder(itemView) {
        val contentView = ConstraintLayout(itemView.context)
        val tvText = TextView(itemView.context)
        val ivDelete = ImageView(itemView.context)

        init {
            val rootView = itemView as ConstraintLayout
            // 显示文字
            tvText.apply {
                id = View.generateViewId()
                layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topToTop = rootView.id
                    startToStart = rootView.id
                    bottomToBottom = rootView.id
                    endToStart = ivDelete.id
                    horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
                }
                gravity = Gravity.CENTER
                if (mTextFontFamilyRes != 0 && !isInEditMode) {
                    // 字体
                    typeface = ResourcesCompat.getFont(itemView.context, mTextFontFamilyRes)
                }
            }
            // 删除图标
            ivDelete.apply {
                id = View.generateViewId()
                layoutParams = ConstraintLayout.LayoutParams(
                    mTextSize.toInt(),
                    mTextSize.toInt()
                ).apply {
                    topToTop = tvText.id
                    startToEnd = tvText.id
                    bottomToBottom = tvText.id
                    endToEnd = rootView.id
                    marginStart = mItemPaddingStart.toInt()
                    setPadding((mTextSize / 8).toInt())
                }
                setImageResource(R.drawable.flowlayout_ic_delete)
            }
            // 内容容器
            contentView.apply {
                id = View.generateViewId()
                layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    startToStart = rootView.id
                    topToTop = rootView.id
                    endToEnd = rootView.id
                    bottomToBottom = rootView.id
                    // 设置水平、垂直线间距离
                    marginStart = mHorizontalSpacing.toInt()
                    topMargin = mVerticalSpacing.toInt()
                    marginEnd = mHorizontalSpacing.toInt()
                    bottomMargin = mVerticalSpacing.toInt()
                }
                // 设置item内边距
                setPadding(
                    mItemPaddingStart.toInt(),
                    mItemPaddingTop.toInt(),
                    mItemPaddingEnd.toInt(),
                    mItemPaddingBottom.toInt()
                )
                // 背景
                background = when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                        RippleDrawable(
                            ColorStateList.valueOf(mRippleColor),
                            getContentViewBackground(),
                            getContentViewBackground()
                        )
                    }
                    else -> {
                        getContentViewBackground()
                    }
                }
                removeAllViews()
                addView(tvText)
                addView(ivDelete)
            }
            // itemView
            rootView.apply {
                removeAllViews()
                addView(contentView)
            }
        }

        /**
         * 获取内容视图背景
         */
        private fun getContentViewBackground(): Drawable {
            return StateListDrawable().apply {
                addState(
                    intArrayOf(-android.R.attr.state_selected),
                    GradientDrawable().apply {
                        setColor(mNormalBgColor)
                        cornerRadius = mCornerRadius
                        setStroke(mStrokeWidth.toInt(), mNormalStrokeColor)
                    }
                )
                addState(
                    intArrayOf(android.R.attr.state_selected),
                    GradientDrawable().apply {
                        setColor(mSelectedBgColor)
                        cornerRadius = mCornerRadius
                        setStroke(mStrokeWidth.toInt(), mSelectedStrokeColor)
                    }
                )
            }
        }
    }

    /**
     * 获得xml中设置的属性
     */
    private fun obtainStyledAttr(attrs: AttributeSet?, context: Context) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout)
        mMode = typedArray.getInt(
            R.styleable.FlowLayout_flowLayoutMode,
            mMode
        )
        mMaxSelectedCount = typedArray.getInt(
            R.styleable.FlowLayout_flowLayoutMaxSelectedCount,
            mMaxSelectedCount
        )
        mCornerRadius = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutCornerRadius,
            dp2px(mCornerRadius)
        )
        mRandomTextColor = typedArray.getBoolean(
            R.styleable.FlowLayout_flowLayoutRandomTextColor,
            mRandomTextColor
        )
        mTextColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutTextColor,
            mTextColor
        )
        mSelectedTextColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutSelectedTextColor,
            mSelectedTextColor
        )
        mTextSize = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutTextSize,
            sp2px(mTextSize)
        )
        mTextFontFamilyRes = typedArray.getResourceId(
            R.styleable.FlowLayout_flowLayoutTextFontFamily,
            mTextFontFamilyRes
        )
        mNormalBgColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutNormalBgColor,
            mNormalBgColor
        )
        mSelectedBgColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutSelectedBgColor,
            mSelectedBgColor
        )
        mStrokeWidth = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutStrokeWidth,
            dp2px(mStrokeWidth)
        )
        mNormalStrokeColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutNormalStrokeColor,
            mNormalStrokeColor
        )
        mSelectedStrokeColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutSelectedStrokeColor,
            mSelectedStrokeColor
        )
        mItemPaddingStart = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutItemPaddingStart,
            dp2px(mItemPaddingStart)
        )
        mItemPaddingTop = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutItemPaddingTop,
            dp2px(mItemPaddingTop)
        )
        mItemPaddingEnd = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutItemPaddingEnd,
            dp2px(mItemPaddingEnd)
        )
        mItemPaddingBottom = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutItemPaddingBottom,
            dp2px(mItemPaddingBottom)
        )
        mPaddingStart = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutPaddingStart,
            dp2px(mPaddingStart)
        )
        mPaddingTop = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutPaddingTop,
            dp2px(mPaddingTop)
        )
        mPaddingEnd = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutPaddingEnd,
            dp2px(mPaddingEnd)
        )
        mPaddingBottom = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutPaddingBottom,
            dp2px(mPaddingBottom)
        )
        mVerticalSpacing = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutVerticalSpacing,
            dp2px(mVerticalSpacing)
        )
        mHorizontalSpacing = typedArray.getDimension(
            R.styleable.FlowLayout_flowLayoutHorizontalSpacing,
            dp2px(mHorizontalSpacing)
        )
        mRippleColor = typedArray.getColor(
            R.styleable.FlowLayout_flowLayoutRippleColor,
            mRippleColor
        )
        typedArray.recycle()
    }

    /**
     * dp转换为px
     */
    private fun dp2px(dpValue: Float): Float {
        val scale = resources.displayMetrics.density
        return dpValue * scale + 0.5f
    }

    /**
     * sp转换为px
     */
    private fun sp2px(spValue: Float): Float {
        val scale = resources.displayMetrics.scaledDensity
        return spValue * scale + 0.5f
    }
}

/**
 * Item数据
 */
@Keep
@Parcelize
open class FlowItem(
    /** item名称 */
    var name: CharSequence?,
    /** 是否激活 */
    var enabled: Boolean = true,
    /** 是否可点击的 */
    var clickable: Boolean = true,
    /** 是否被选中 */
    var selected: Boolean = false,
    /** 是否显示删除图标 */
    var showDelete: Boolean = false,
) : Parcelable, Serializable

/**
 * 对图标进行着色
 * @param tintColor 着色的颜色值
 */
private fun ImageView.setTintColor(
    @ColorInt tintColor: Int,
) {
    // 获取此drawable的共享状态实例
    val wrappedDrawable = drawable.getCanTintDrawable()
    // 进行着色
    DrawableCompat.setTint(wrappedDrawable, tintColor)
    setImageDrawable(wrappedDrawable)
}

/**
 * 获取可以进行tint的Drawable
 * 对原drawable进行重新实例化  newDrawable()
 * 包装  warp()
 * 可变操作 mutate()
 * @return 可着色的drawable
 */
private fun Drawable.getCanTintDrawable(): Drawable {
    // 获取此drawable的共享状态实例
    val state = constantState
    // 对drawable 进行重新实例化、包装、可变操作
    return DrawableCompat.wrap(state?.newDrawable() ?: this)
        .mutate()
}

/**
 * Return the random color.
 *
 * @param supportAlpha True to support alpha, false otherwise.
 * @return the random color
 */
private fun getRandomColor(supportAlpha: Boolean = false): Int {
    val high =
        when {
            supportAlpha -> (Math.random() * 0x100).toInt() shl 24
            else -> -0x1000000
        }
    return high or (Math.random() * 0x1000000).toInt()
}

private var lastClickTime = 0L

/**
 * 防止重复点击事件 默认0.5秒内不可重复点击
 * @param interval 时间间隔 默认0.5秒
 * @param action   执行方法
 */
private fun View.clickNoRepeat(
    interval: Long = 500,
    action: (view: View) -> Unit,
) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && currentTime - lastClickTime < interval) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        action(it)
    }
}
