package br.com.ui.dialogs.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import br.com.ui.databinding.BaseBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val NOT_RESOURCE = -1

class BaseBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: BaseBottomSheetBinding
    private var title: CharSequence = ""
    private var description: CharSequence = ""

    @DrawableRes
    private var illustration: Int = NOT_RESOURCE

    @StringRes
    private var titleRes: Int = NOT_RESOURCE

    @StringRes
    private var descriptionRes: Int = NOT_RESOURCE

    private var buttonBuilder: ButtonBuilder? = null
    private var cancelButtonBuilder: ButtonBuilder? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        with(requireArguments()) {
            title = getCharSequence(TITLE, "")
            titleRes = getInt(TITLE_RES, NOT_RESOURCE)
            description = getCharSequence(DESCRIPTION, "")
            descriptionRes = getInt(DESCRIPTION_RES, NOT_RESOURCE)
            illustration = getInt(ILLU, NOT_RESOURCE)
            buttonBuilder = getParcelable(BUTTON)
            cancelButtonBuilder = getParcelable(CANCEL_BUTTON)
        }

        return BaseBottomSheetBinding.inflate(inflater, container, false).root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: BottomSheetDialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BaseBottomSheetBinding.bind(view)
        binding.setupView()
    }

    private fun BaseBottomSheetBinding.setupView() {
        tvTitle.setupText(title, titleRes)
        tvDescription.setupText(description, descriptionRes)
        imageView.setupIllustration(illustration)
        button.setupButton(buttonBuilder)
        cancelButton.setupButton(cancelButtonBuilder)
    }

    private fun Button.setupButton(button: ButtonBuilder?) {
        button?.let {
            val btnText = if (it.text == null) getString(it.textRes) else it.text
            val action: ActionListener = it.onClick ?: ActionListener { dismiss() }
            text = btnText
            setOnClickListener {
                action.execute()
            }
        } ?: run { isVisible = false }
    }

    private fun TextView.setupText(string: CharSequence, @StringRes stringRes: Int) {
        when {
            string.isEmpty() && stringRes == NOT_RESOURCE -> this.isVisible = false
            string.isEmpty() && stringRes != NOT_RESOURCE -> text = getString(stringRes)
            string.isNotEmpty() && stringRes == NOT_RESOURCE -> text = string
        }
    }

    private fun ImageView.setupIllustration(illustration: Int) {
        if(illustration != NOT_RESOURCE)
            this.setImageDrawable(resources.getDrawable(illustration))
    }

    companion object {
        const val TITLE = "TITLE"
        const val TITLE_RES = "TITLE_RES"
        const val DESCRIPTION = "SUBTITLE"
        const val DESCRIPTION_RES = "SUBTITLE_RES"
        const val ILLU = "ILLU"
        const val BUTTON = "BUTTON"
        const val CANCEL_BUTTON = "CANCEL_BUTTON"

        inline fun Fragment.baseBottomSheet(block: BottomSheetBuilder.() -> Unit) {
            val bottomSheet = BottomSheetBuilder().apply(block)
            BaseBottomSheet().apply {
                arguments = bundleOf(
                    TITLE to bottomSheet.title,
                    TITLE_RES to bottomSheet.titleRes,
                    DESCRIPTION to bottomSheet.description,
                    DESCRIPTION_RES to bottomSheet.descriptionRes,
                    ILLU to bottomSheet.illustration,
                    BUTTON to bottomSheet.button,
                    CANCEL_BUTTON to bottomSheet.cancelButton,
                )
                isCancelable = bottomSheet.isCancelable
            }.show(childFragmentManager, BaseBottomSheet::class.java.name)
        }
    }
}
