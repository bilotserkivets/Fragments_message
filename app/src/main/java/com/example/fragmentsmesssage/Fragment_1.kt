package com.example.fragmentsmesssage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentsmesssage.databinding.Fragment1Binding

class Fragment_1 : Fragment() {
    lateinit var binding: Fragment1Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataModel.messageFrag1.observe(activity as LifecycleOwner, {
            binding.tvFragment1.text = it
        })

        binding.btnMessageForActivity.setOnClickListener {
            dataModel.messageAct.value = "Hello for Activity with Fragment1"
        }

        binding.btnMessageForFrag2.setOnClickListener {
            dataModel.messageFrag2.value = "Hello for Fragment 2 with Fragment1"
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_1()
    }
}