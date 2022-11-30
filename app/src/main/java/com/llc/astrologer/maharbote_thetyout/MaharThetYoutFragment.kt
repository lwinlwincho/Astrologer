package com.llc.astrologer.maharbote_thetyout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.llc.astrologer.R
import com.llc.astrologer.databinding.FragmentMaharBoteThetYoutBinding
import com.llc.astrologer.mahar_bote.MaharBoteViewModel

class MaharBoteThetYoutFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private val viewModel: MaharThetYoutViewModel by viewModels()

    private var _binding: FragmentMaharBoteThetYoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var about: String

    var year = 1383
    var age = 0
    var spnDayPosition: Int = 0

    var remainder = 0
    var remainderListPosition = 0
    var lastItem = 0

    var remainderList = listOf(1, 4, 0, 3, 6, 2, 5)
    var remainderList1 = listOf<Int>()
    var remainderList2 = listOf<Int>()
    private var newRemainderList = mutableListOf<Int>()

    var agePlus: Int = 0
    var joValue: Int = 0

    var jo = listOf<Int>(1,2,3,4,0,5,8,6)
    var joSar = listOf<Int>(6,15,8,17,10,19,12,21)
    var maharThetyout = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaharBoteThetYoutBinding.inflate(inflater, container, false)
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

        maharThetyout.add(
            "သင်သည် \"ဘင်္ဂအိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "သင်္ဘောပျက်ကိန်းကြုံသဖြင့် စီးပွားပျက်ပြားတတ်သည်။\n" +
                    "အနာရောဂါ ကပ်ရောက်တတ်သည်။\n" +
                    "စိတ်သောက ပူဆွေးရတတ်သည်။\n" +
                    "အလုပ်အကိုင် အကြံအစည် အထမမြောက် မအောင်မြင်တတ်ပါ။\n" +
                    "ဆွေမျိုးညာတိနှင့် ကွဲကွာနေရတတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။"
        )
        maharThetyout.add(
            ("သင်သည် \"မာရဏ\"အိမ်တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "မကောင်းကြမ္မာ ဖိစီးနှိပ်စက်တတ်သည်။\n" +
                    "ဘေးဥပဒ်တွေ့တတ်သည်။\n" +
                    "သားသမီးကို စွန့်သောကိန်းကြုံရသဖြင့် ဆင်းရဲဒုက္ခရောက်တတ်သည်။\n" +
                    "ပစ္စည်းဥစ္စာ ပျက်ပြားတတ်သည်။\n" +
                    "သားသမီးကို သူတစ်ပါး စေခံအဖြစ်ဖြင့် ပေးရတတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။")
        )
        maharThetyout.add(
            ("သင်သည် \"အထွန်းအိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "နာမည်သတင်း ကျော်စောခြင်းရှိတတ်သည်။\n" +
                    "ဥစ္စာပစ္စည်း တိုးတတ်သည်။\n" +
                    "ချမ်းသာသုခ ဖြစ်တတ်သည်။\n" +
                    "ရန်သူကို နိုင်သောကိန်းကြုံသဖြင့် မိမိအကြံအစည် အလိုဆန္ဒ ပြည့်စုံအောင်မြင်တတ်သည်။\n" +
                    "လာဘ်လာဘ တိုးတတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။")
        )
        maharThetyout.add(
            ("သင်သည် \"သိုက်အိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "အဖအမွေကို ခံယူရသော ကိန်းကြုံသဖြင့် အမွေအနှစ်ရတတ်သည်။\n" +
                    "အိုးသစ် အိမ်သစ် ရတတ်သည်။\n" +
                    "အကြံအစည် အလုပ်အကိုင် တိုးတက်ကြီးပွားသည်။\n" +
                    "ချစ်သူ ခင်သူ ပေါတတ်သည်။\n" +
                    "စုတ် လာဘ် ၀◌င်တတ်သည်။\n" +
                    "ဘုန်းကျက်သရေ တိုးတက်မည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။")
        )
        maharThetyout.add(
            ("သင်သည် \"ရာဇအိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "အလုပ်အကိုင် ရတတ်သည်။\n" +
                    "စိတ်ရွှင်ပျ အေးကြည်တတ်သည်။\n" +
                    "သူတစ်ပါး ကယ်ဆယ်သည့် ကိန်းကြုံသဖြင့် မိတ်ဆွေများ ကြည့်ရှု မ,စ တတ်သည်။\n" +
                    "၎င်းနှင့်ပတ်သက်၍ အကျိုးပေးတတ်သည်။\n" +
                    "လာဘ်လာဘ ရွှင်တတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။\n")
        )
        maharThetyout.add(
            ("သင်သည် \"ပုတိအိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "နာမည်သတင်း ကျော်စောခြင်း မရှိပါ။\n" +
                    "ရန်သူ၏ လက်တွင်းသို့ ရောက်သောကိန်းကြုံသဖြင့် စိတ်ပူပင်သောက ဖြစ်တတ်သည်။\n" +
                    "ရန်သူ နှောက်ယှက် ဖျက်ဆီးခံရတတ်သည်။\n" +
                    "ပစ္စည်း ဥစ္စာမှာ ငွေကုန်လူပန်း အကျိုးမရှိ ဖြစ်ရတတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။")
        )
        maharThetyout.add(
            ("သင်သည် \"အဓိပတိအိမ်\"တွင် သက်ရောက်ဂြိုဟ်အိပ်နေပါသည်။\n" +
                    "\n" +
                    "စည်းစိမ်ဥစ္စာ ဖွံ့ဖြိုးကြွယ်၀ တတ်သည်။\n" +
                    "ကျော်စော ထင်ရှားတတ်သည်။\n" +
                    "အထွတ်အထိပ်သို့ ရောက်သောကိန်းကြုံသဖြင့် အကြီးအကဲဖြစ်တတ်သည်။\n" +
                    "ကာယသုခ စိတ္တသုခ ဖြစ်တတ်သည်။\n" +
                    "အကြံအစည် ပြီးမြောက် အောင်မြင်တတ်သည်။\n" +
                    "\n" +
                    "အမှာ _\n" +
                    "မဟာဘုတ်သက်ရောက်တွင် ပုတိ၊ ဘင်္ဂ၊ မာရဏ ကျလျှင်ညံ့သည်။\n" +
                    "အထွန်း၊ သိုက်၊ ရာဇ၊ အဓိပတိ ကျလျှင်ကောင်းသည်။\n" +
                    "ထို့အပြင် နှစ်စဉ်မဟာဘုတ်သက်ရောက် အထွန်းနှင့် မူလမဟာဘုတ်ရှိ အထွန်းချင်း၊\n" +
                    "သိုက်_သိုက်ချင်း၊ ရာဇ_ရာဇချင်း၊ အဓိပတိ_အဓိပတိချင်း တွေ့လျှင် သာလွန်ကောင်းသည်။\n" +
                    "ထိုနည်းတူ ပုတိ_ပုတိချင်း၊ ဘင်္ဂ_ဘင်္ဂချင်း၊ မာရဏ_မာရဏချင်း တွေ့လျှင် သာလွန်ညံ့သည်။")
        )

        binding.btnMaharboteThetyout.setOnClickListener {
            age = binding.etAge.text.toString().toInt()

            about=viewModel.getRemainder(age, spnDayPosition)
            //about = viewModel.getMaharBoteThetYout(spnDayPosition)

           /* year -= age
            remainder = year % 7

            remainderListPosition = remainderList.indexOf(remainder)
            lastItem = remainderList.size

            remainderList1 = remainderList.subList(remainderListPosition, lastItem)
            remainderList2 = remainderList.subList(0, remainderListPosition)

            newRemainderList.addAll(remainderList1)
            newRemainderList.addAll(remainderList2)

            if (age > 0 && age <= joSar[spnDayPosition]) {
                agePlus = joSar[spnDayPosition]
            } else if (age > joSar[spnDayPosition]) {
                agePlus = joSar[spnDayPosition]

                while (age > agePlus) {
                    if (spnDayPosition in 0..6)
                        ++spnDayPosition
                    else
                        spnDayPosition = 0

                    agePlus += joSar[spnDayPosition]
                }
            }
            if (spnDayPosition == 6)
                spnDayPosition = 3
            joValue = jo[spnDayPosition]
            */

            val action =
                MaharBoteThetYoutFragmentDirections.actionMaharBoteThetYoutFragmentToShowFragment(
                    maharThetyout[newRemainderList.indexOf(joValue)]
                )
            findNavController().navigate(action)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
        if (position in 0..8) {
            spnDayPosition = position

            Toast.makeText(
                requireContext(),
                "spnDayPosition$spnDayPosition",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) { }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        age = 0
        spnDayPosition = 0
        newRemainderList.clear()
    }
}