package com.llc.astrologer.mahar_bote

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
import com.llc.astrologer.databinding.FragmentMaharBoteBinding

class MaharBoteFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private val viewModel: MaharBoteViewModel by viewModels()

    private var _binding: FragmentMaharBoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var about: String

    var age = 0
    var spnDayPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaharBoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spnDay.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.maharBote,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spnDay.adapter = adapter
        }

        binding.btnmahar.setOnClickListener {
            age = binding.etAge.text.toString().toInt()

            viewModel.getRemainder(age)

            about = viewModel.getMaharBoteList(spnDayPosition)

            val action = MaharBoteFragmentDirections.actionMaharBoteFragmentToShowFragment(about)
            findNavController().navigate(action)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
            /*activity.let {
                val intent = Intent(it, MainActivity::class.java)
                startActivity(intent)
            }*/
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
        if (position in 0..7) {
            spnDayPosition = position
            ++spnDayPosition
            if (spnDayPosition == 7) {
                spnDayPosition = 0
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        age = 0
        spnDayPosition = 0
    }
}
