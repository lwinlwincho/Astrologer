package com.llc.astrologer.thet_yout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.llc.astrologer.R
import com.llc.astrologer.databinding.FragmentThetYoutBinding


class ThetYoutFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private val viewModel: ThetYoutViewModel by viewModels()

    private var _binding: FragmentThetYoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var about: String

    var age = 0
    var spnDayPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThetYoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spnDay.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.dayJosar,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnDay.adapter = adapter
        }

        binding.btnThetYout.setOnClickListener {
            age = binding.etAge.text.toString().toInt()

            about = viewModel.getThetYout(age, spnDayPosition)
            val action = ThetYoutFragmentDirections.actionThetYoutFragmentToShowFragment(about)
            findNavController().navigate(action)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
        if (position in 0..8)
            spnDayPosition = position
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun onDestroyView() {
        super.onDestroyView()

        age=0
        spnDayPosition=0
    }
}