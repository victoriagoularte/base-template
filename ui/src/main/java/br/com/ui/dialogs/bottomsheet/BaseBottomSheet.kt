package br.com.ui.dialogs.bottomsheet

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.text.Spannable
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import br.com.ui.components.button.BaseButton
import br.com.ui.databinding.BaseBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BaseBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: BaseBottomSheetBinding
    var title: Spannable? = null
    var description: Spannable? = null
    var button: MutableList<BaseButton> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
    }

    inline fun button(block: BaseButton.Builder.() -> Unit) {
        val button = BaseButton.Builder(requireContext()).apply(block)

        binding.listButton.addView(
            BaseButton(requireContext(), null, button.style).apply {
                text = button.text
                setOnClickListener { button.onClick?.invoke() }
            }
        )

    }
    companion object {
        inline fun Activity.baseBottomSheet(block: BaseBottomSheet.() -> Unit) =
            BaseBottomSheet().apply(block)

        inline fun Fragment.baseBottomSheet(block: BaseBottomSheet.() -> Unit) =
            BaseBottomSheet().apply(block)
    }
}