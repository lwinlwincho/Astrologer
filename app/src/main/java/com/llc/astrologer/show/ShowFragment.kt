package com.llc.astrologer.show

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.llc.astrologer.MainActivity
import com.llc.astrologer.R
import com.llc.astrologer.databinding.FragmentHomeBinding
import com.llc.astrologer.databinding.FragmentMaharBoteBinding
import com.llc.astrologer.databinding.FragmentShowBinding

class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding!!

    private val args: ShowFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text=args.about

        binding.tvShow.text=text

        binding.btnBack.setOnClickListener{
           // findNavController().navigateUp()
            activity.let {
                val intent = Intent(it, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}