package br.com.ui.dialogs.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ui.R
import br.com.ui.databinding.BaseBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BaseBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: BaseBottomSheetBinding
    var title: Spannable? = null
    var description: Spannable? = null
    var button: (() -> Unit)? = null

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
        setCustomView()
    }

    private fun setCustomView() {
        with(binding) {
            tvTitle.text = title
            tvDescription.text = description
        }
    }

}