package br.com.first.presentation.subfeature

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import br.com.first.databinding.FragmentFirstBinding
import br.com.navigation.secondfeature.SecondFeatureNavigation
import br.com.ui.R
import br.com.ui.dialogs.bottomsheet.BaseBottomSheet.Companion.baseBottomSheet
import br.com.ui.widgets.cardsgrid.CardMenu
import org.koin.android.ext.android.inject

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val secondFeatureNavigation: SecondFeatureNavigation by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMenuItems()
    }

    private fun setMenuItems() {
        val list = mutableListOf<CardMenu>()
        list.add(CardMenu(title = "Item 1", subtitle = "Desc 1"))
        list.add(CardMenu(title = "Item 2", subtitle = "Desc 2"))
        list.add(CardMenu(title = "Item 3", subtitle = "Desc 3"))
        list.add(CardMenu(title = "Item 4", subtitle = "Desc 4"))
        list.add(CardMenu(title = "Item 5", subtitle = "Desc 5"))

        with(binding.cardsMenu) {
            setList(list)
            setOnClickItemListener { card, position ->
                when (position) {
                    0 -> secondFeatureNavigation.navigateToSecond(requireContext())
                    1 -> baseBottomSheet {
                        title = "titulo item 1".toSpannable()
                        description = Html.fromHtml(
                            "lorem ipsum <b>bla bla</b> bla",
                            Html.FROM_HTML_MODE_COMPACT
                        ).toSpannable()
                    }.show(childFragmentManager, FirstFragment::class.java.simpleName)
                    2 -> baseBottomSheet {
                        title = "titulo item".toSpannable()
                        description = Html.fromHtml(
                            "lorem ipsum <b>bla bla</b> bla",
                            Html.FROM_HTML_MODE_COMPACT
                        ).toSpannable()
                        button {
                            text = "Clique"
                            style = R.style.PrimaryBaseButton
                        }
                        button {
                            text = "teste"
                            style = R.style.SecondaryBaseButton
                            onClick =
                                { Toast.makeText(context, card.title, Toast.LENGTH_LONG).show() }
                        }

                    }.show(childFragmentManager, FirstFragment::class.java.simpleName)
                    else -> Toast.makeText(context, card.title, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}