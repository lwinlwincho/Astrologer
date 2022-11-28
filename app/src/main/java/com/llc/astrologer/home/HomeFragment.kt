package com.llc.astrologer.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.llc.astrologer.R
import com.llc.astrologer.databinding.FragmentHomeBinding
import com.llc.astrologer.databinding.FragmentMaharBoteBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMaharBote.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToMaharBoteFragment()
            findNavController().navigate(action)
        }
        binding.btnMaharboteThetyout.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToMaharBoteThetYoutFragment()
            findNavController().navigate(action)
        }
        binding.btnJosarr.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToJosarrFragment()
            findNavController().navigate(action)
        }
        binding.btnThetYout.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToThetYoutFragment()
            findNavController().navigate(action)
        }
        binding.btnTwelve.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToMaharBoteFragment()
            findNavController().navigate(action)
        }

    }
}