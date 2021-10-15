package com.example.fragmentsmesssage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentsmesssage.databinding.Fragment2Binding

class Fragment_2 : Fragment() {
    lateinit var binding: Fragment2Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataModel.messageFrag2.observe(activity as LifecycleOwner, {
            binding.tvFragment2.text = it
        })

        binding.btnMessageForActivity.setOnClickListener {
            dataModel.messageAct.value = "Hello for Activity with Fragment2"
        }
        binding.btnMessageForFrag1.setOnClickListener {
            dataModel.messageFrag1.value = "Hello for Fragment 1 with Fragment2"
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = Fragment_2()
    }
}