package com.llc.astrologer.maharbote_thetyout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.llc.astrologer.R
import com.llc.astrologer.databinding.FragmentMaharBoteThetYoutBinding

class MaharBoteThetYoutFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentMaharBoteThetYoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var about: String

    var year = 1383
    var age = 0
    var spnDayPosition: Int = 0

    var remainder = 0
    var remainderListPosition = 0
    var lastItem = 0

    var i: Int = 0
    var j: Int = spnDayPosition
    var k: Int = 0

    var remainderList = listOf(1, 4, 0, 3, 6, 2, 5)
    var remainderList1 = listOf<Int>()
    var remainderList2 = listOf<Int>()
    private var newRemainderList = mutableListOf<Int>()


    var remainderArr1 = ArrayList<Int>()
    var maharThetyout = ArrayList<String>()
    var jo = ArrayList<Int>()
    var jo1 = ArrayList<Int>()
    var joSar = ArrayList<Int>()

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
            year -= age
            remainder = year % 7

            remainderListPosition = remainderList.indexOf(remainder)
            lastItem = remainderList.size

            remainderList1 = remainderList.subList(remainderListPosition, lastItem)
            remainderList2 = remainderList.subList(0, remainderListPosition)

            newRemainderList.addAll(remainderList1)
            newRemainderList.addAll(remainderList2)

            joSar.add(6)
            joSar.add(15)
            joSar.add(8)
            joSar.add(17)
            joSar.add(10)
            joSar.add(19)
            joSar.add(12)
            joSar.add(21)

            /* jo.add("တနင်္ဂနွေ")
             jo.add("တနင်္လာ")
             jo.add("အင်္ဂါ")
             jo.add("ဗုဒ္ဓဟူး")
             jo.add("စနေ")
             jo.add("ကြာသပတေး")
             jo.add("ရာဟု")
             jo.add("သောကြာ")*/

            /*jo1.add("တနင်္ဂနွေ")
            jo1.add("တနင်္လာ")
            jo1.add("အင်္ဂါ")
            jo1.add("ဗုဒ္ဓဟူး")
            jo1.add("ကြာသပတေး")
            jo1.add("သောကြာ")
            jo1.add("စနေ")
            jo1.add("ရာဟု")*/

            jo.add(1)
            jo.add(2)
            jo.add(3)
            jo.add(4)
            jo.add(0)
            jo.add(5)
            jo.add(8)
            jo.add(6)

            jo1.add(1)
            jo1.add(2)
            jo1.add(3)
            jo1.add(4)
            jo1.add(5)
            jo1.add(6)
            jo1.add(0)
            jo1.add(8)

            if (age > 0 && age <= joSar[spnDayPosition]) {
                i = joSar[spnDayPosition]
            } else if (age > joSar[spnDayPosition]) {
                i = joSar[spnDayPosition]

                while (age > i) {
                    if (spnDayPosition in 0..6)
                        ++spnDayPosition
                    else
                        spnDayPosition = 0

                    i += joSar[spnDayPosition]
                }
            }

            /*while (jo1[j] != jo[spnDayPosition]) {
                if (j in 0..6)
                    ++j
                else j = 0
            }*/

            if (spnDayPosition == 6)
                spnDayPosition = 3

          k=jo[spnDayPosition]
           //  i = jo1.indexOf(jo1[++j])

            val action = MaharBoteThetYoutFragmentDirections.actionMaharBoteThetYoutFragmentToShowFragment(
                maharThetyout[newRemainderList.indexOf(k)]
            )
           /* val action = MaharBoteThetYoutFragmentDirections.actionMaharBoteThetYoutFragmentToShowFragment(
                "maharThetyout[newRemainderList.indexOf(0)]"
            )*/
            findNavController().navigate(action)

            Toast.makeText(
                requireContext(),
                "spnDayPosition$spnDayPosition",
                Toast.LENGTH_LONG
            ).show()

            Toast.makeText(
                requireContext(),
                "jo1${jo1.toString()}",
                Toast.LENGTH_LONG
            ).show()
            Toast.makeText(
                requireContext(),
                "i$i",
                Toast.LENGTH_LONG
            ).show()
            Toast.makeText(
                requireContext(),
                "k$k",
                Toast.LENGTH_LONG
            ).show()
            Toast.makeText(
                requireContext(),
                "josar${joSar[k]}",
                Toast.LENGTH_LONG
            ).show()

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
        if (position in 0..8) {
            spnDayPosition = position
            // ++spnDayPosition

            /* if (spnDayPosition == 7) {
                 spnDayPosition = 0
             }
 */
            Toast.makeText(
                requireContext(),
                "spnDayPosition$spnDayPosition",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        age = 0
        spnDayPosition = 0
        newRemainderList.clear()
    }
}