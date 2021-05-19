package com.example.nac2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.nac2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindings : FragmentHomeBinding
    private var answer = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        bindings = FragmentHomeBinding.inflate(inflater)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindings.input.setOnClickListener {
            val number1 = Integer.parseInt(bindings.number1.text.toString())
            val number2 = Integer.parseInt(bindings.number2.text.toString())

            answer = number1.plus(number2)
            val action = HomeFragmentDirections.actionHomeFragmentToResultFragment(answer)
                findNavController().navigate(action)
            }
        }
    }

