package br.com.first.presentation.subfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.first.R
import br.com.first.databinding.ActivityFirstMainBinding
import br.com.first.databinding.FragmentFirstBinding
import br.com.ui.widgets.cardsgrid.CardMenu

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
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

        binding.cardsMenu.apply {
            setList(list)
            setOnClickItemListener{ card, _ ->
                Toast.makeText(context, card.title, Toast.LENGTH_LONG).show()
            }
        }


    }

}