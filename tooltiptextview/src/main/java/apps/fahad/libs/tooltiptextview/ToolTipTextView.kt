package apps.fahad.libs.tooltiptextview

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import apps.fahad.libs.tooltiptextview.databinding.LayoutToolTipTextViewBinding
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils


class ToolTipTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: LayoutToolTipTextViewBinding

    private var title: String? = null
    private var titleColor: Int? = null
    private var toolTipText: String? = null
    private var toolTipTextColor: Int? = null
    private var toolTipBackgroundColor: Int? = null
    private var titleFontSize: Float? = null
    private var toolTipImageViewSize: Float? = null
    private var toolTipImageResource: Int? = null
    private var fontFamily: Int? = null

    init {
        initialize(attrs)
    }

    private fun initialize(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ToolTipTextView, 0, 0)
        title = typedArray.getString(R.styleable.ToolTipTextView_title)
        toolTipText = typedArray.getString(R.styleable.ToolTipTextView_toolTipText)
        titleFontSize = typedArray.getDimension(R.styleable.ToolTipTextView_titleFontSize, 12.0f)
        toolTipImageViewSize =
            typedArray.getDimension(R.styleable.ToolTipTextView_toolTipImageViewSize, 16.0f)
        titleColor = typedArray.getColor(R.styleable.ToolTipTextView_titleColor, 0)
        toolTipTextColor = typedArray.getColor(R.styleable.ToolTipTextView_toolTipTextColor, 0)
        toolTipBackgroundColor =
            typedArray.getColor(R.styleable.ToolTipTextView_toolTipBackgroundColor, 0)
        fontFamily = typedArray.getResourceId(R.styleable.ToolTipTextView_android_fontFamily, 0)
        toolTipImageResource = typedArray.getResourceId(R.styleable.ToolTipTextView_toolTipImage,
            R.drawable.ic_baseline_info_24)
        typedArray.recycle()
        setupView()
    }

    private fun setupView() {
        binding = LayoutToolTipTextViewBinding.inflate(inflater, this, true)
        with(binding.imageViewTip) {
            toolTipImageResource?.let {
                setImageResource(it)
            }
            layoutParams = layoutParams.apply {
                this.height = toolTipImageViewSize?.toInt()!!
                this.width = toolTipImageViewSize?.toInt()!!
            }
        }
        with(binding.textView) {
            title?.let {
                text = it
            }
            titleColor?.let {
                setTextColor(it)
            }
            titleFontSize?.let {
                setTextSize(TypedValue.COMPLEX_UNIT_PX, it)
            }
            fontFamily?.let {
                if (it > 0) {
                    typeface = ResourcesCompat.getFont(context, it)
                }
            }
        }
        setupListeners()
    }

    private fun setupListeners() {
        binding.imageViewTip.setOnClickListener { v ->
            toolTipText?.let {
                val builder =
                    SimpleTooltip.Builder(context).anchorView(v).text(it).transparentOverlay(true)
                toolTipBackgroundColor?.let {
                    builder.backgroundColor(it)
                }
                toolTipBackgroundColor?.let {
                    builder.arrowColor(it)
                }
                toolTipTextColor?.let {
                    builder.textColor(it)
                }
                builder.arrowHeight(SimpleTooltipUtils.pxFromDp(10.0f))
                    .arrowWidth(SimpleTooltipUtils.pxFromDp(15.0f))
                builder.animated(true)
                builder.build().show()
            }
        }
    }
}