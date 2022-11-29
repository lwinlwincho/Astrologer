package com.llc.astrologer.mahar_bote

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
import com.llc.astrologer.databinding.FragmentMaharBoteBinding

class MaharBoteFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private val viewModel: MaharBoteViewModel by viewModels()

    private var _binding: FragmentMaharBoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var about: String

    var age = 0
    var spnDayPosition: Int = 0

    var remainder = 0
    var remainderListPosition = 0
    var lastItem = 0

    var remainderList = listOf(1, 4, 0, 3, 6, 2, 5)
    var maharBoteList = mutableListOf<String>()

    var newRemainderList = mutableListOf<Int>()
    var remainderList1 = listOf<Int>()
    var remainderList2 = listOf<Int>()

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

        /* maharBoteList.add(
             """သင်သည်  "ဘင်္ဂဖွား"  ဖြစ်ပါသည်။

             ဘင်္ဂဖွားမှာ၊ ပျက်ပြားစွာ၊ မွေးကာလာတတ်မည်။
             ကြံစည်ပြုကာ၊ ပျက်တတ်တာ၊ သေချာမှတ်ရမည်။

             ငယ်စဉ်က ရောဂါ‌ေ၀ဒနာ များပြားပြီး ချူချာတတ်သည်။
             မိဘ၊ ဆွေမျိုး၊ ညာတိတို့ စိတ်သောက ကြောင့်ကြများ ရတတ်သည်။
             စိုးရိမ်ပူဆွေးခြင်း၊ စိတ်ပျက်လွယ်ခြင်း၊ စိတ်နုပြီးကြောက်လန့်ခြင်းတို့ ရှိတတ်သည်။။
             ရောဂါ ဖိစီးနှိပ်စက် တတ်သည်။
             အပျက်အစီး ဒုက္ခများနှင့်သာ တွေ့ကြုံနေရတတ်သည်။
             ဥစ္စာမတည် ပျက်ပြားဆုံးရှုံးတတ်သည်။"""
         )
         maharBoteList.add(
             "သင်သည်  \"မာရဏဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "မာရဏဖွားမှာ၊ \u200Cေ၀ဒနာ၊ မွေးကာများလတ်မည်။\n" +
                     "မသေကျေလတ်၊ မင်းဖြစ်တတ်၊ မုချမှတ်ရမည်။\n" +
                     "\n" +
                     "ငယ်စဉ်က ကြောက်မက်ဖွယ် ကောင်းလှသော ဘေးရန်များနှင့် တွေ့ရတတ်သည်။\n" +
                     "ကြောက်ရွံ့ ထိတ်လန့် အသည်းငယ်တတ်သည်။\n" +
                     "ရောဂါအန္တရာယ် တစ်ခုခုနှင့် သေဆုံးလွယ်သည်။\n" +
                     "မိဘကို စိတ်ဒုက္ခ ပေးတတ်သည်။\n" +
                     "အကယ်၍ မသေဘဲ ကြီးပြင်းလျှင်လည်း မင်း၊ မှူးမတ်၊ အရာရှိ၊ သူဌေး၊ သူကြွယ်၊ ရဟန်း သော်လည်းကောင်းဖြစ်နိုင်သည်။\n" +
                     "ချမ်းသာကြွယ်၀ပြီး ပစ္စည်းဥစ္စာနှင့် ပြည့်စုံတတ်သည်။"
         )
         maharBoteList.add(
             "သင်သည်  \"အထွန်းဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "အထွန်းဖွားမှာ၊ ထင်ရှားစွာ၊ မွေးကာလာတတ်မည်။\n" +
                     "နာမည်သတင်း၊ ထင်ရှားခြင်း၊ မယွင်းဖြစ်လတ်မည်။\n" +
                     "\n" +
                     "ကျော်စောထင်ရှားတတ်သည်။\n" +
                     "ဂုဏ်ထူးသတင်းကြီးပြီး သူတစ်ပါး၏ အရိုအသေပေးခြင်းကို ခံရတတ်သည်။\n" +
                     "စိတ်နေစိတ်ထား အကြံအစည် မြင့်မြတ်တတ်ပြီး စိတ်ကူး၊ ဉာဏ် ထက်မြက်စူးရှတတ်သည်။\n" +
                     "ဉာဏ်ပညာ ထွန်းကားပွားများတတ်ပြီး ရဲစွမ်းသတ္တိ၊ ဗျတ္တိ ကောင်းတတ်၏။\n" +
                     "တန်ခိုးဩဇာကြီးတတ်သည်။\n" +
                     "ချမ်းသာကြွယ်၀တတ်သည်။\n" +
                     "မာနလည်းရှိသည်။\n" +
                     "စာတတ်၊ ပေတတ်၊ စကားတတ်လည်း ဖြစ်တတ်သည်။\n"
         )
         maharBoteList.add(
             "သင်သည်  \"သိုက်ဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "သိုက်ဖွားသူမှာ၊ ကုသလာ၊ ပြုကာဖွားလတ်မည်။\n" +
                     "ရောင်း၀◌ယ်ဖောက်ကား၊ ကုန်သွယ်စား၊ မမှားဖြစ်ရမည်။\n" +
                     "\n" +
                     "ငယ်စဉ်က အနာရောဂါ ကင်းတတ်သည်။\n" +
                     "အကြံအစည် ကြီးတတ်ပြီး မင်း၊ ရဟန်း၊ ဆရာ၊ ပညာရှိ၊ အကြီးအကဲ၊ သူဌေးဖြစ်တတ်သည်။\n" +
                     "သူတစ်ပါးအား ကြင်နာတတ်ပြီး သဒ္ဒါစေတနာ တရားတို့နှင့် ပြည့်စုံတတ်သည်။\n" +
                     "ပေးကမ်းစွန့်ကြဲ တတ်သည်။\n" +
                     "မိဘ စိတ်ပျော်ရွှင်ရတတ်သည်။\n" +
                     "ဩဇာအာဏာ ကြီးတတ်သည်။\n" +
                     "စိတ်သဘောထား နူးညံ့သိမ်မွေ့တတ်သည်။\n" +
                     "ရွှေ၊ ငွေ၊ ဉစ္စာ၊ ရတနာ ပစ္စည်း ကြွယ်၀ပြည့်စုံတတ်သည်။\n" +
                     "မိတ်ဆွေ သင်္ဂဟ ပေါများတတ်သည်။\n" +
                     "အများ ကြည်ညိုခံရတတ်သည်။\n" +
                     "နှုတ်ပညာနှင့် အကျိုးပေးတတ်သည်။\n" +
                     "ရှေ့ရေး နောက်ရေး တွေးခေါ်တတ်ပြီး ဉာဏ်ပညာတို့နှင့် ပြည့်စုံတတ်သည်။\n"
         )
         maharBoteList.add(
             "သင်သည်  \"ရာဇ(တံခွန်)ဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "ရာဇဖွားမှာ၊ ထက်မြက်စွာ၊ စိတ်မှာလျင်ရမည်။\n" +
                     "ပန်းချီပန်းပု၊ နှုတ်လက်မှု၊ တတ်မှုစုံလိမ့်မည်။ \n" +
                     "\n" +
                     "စိတ်ကူး ဉာဏ်ထက်မြက်ပြီး ဖြောင့်စင်းသော စိတ်ဓာတ်ရှိမည်။\n" +
                     "အထက်တန်း မင်းစိုးရာဇာတို့နှင့် ပေါင်းသင်းဆက်ဆံလိုတတ်သည်။\n" +
                     "၎င်းတို့ကို အမှီပြု၍ အလုပ်အကိုင် လုပ်ရတတ်သည်။\n" +
                     "မင်းပိုင်း စိုးပိုင်း၌ အရေးပါ အရာရောက်သူ၊ ထင်ရှားကျော်စောသူ ဖြစ်တတ်၏။\n" +
                     "မင်းနှင့်တူသော စည်းစိမ်ကို ခံစားစံစား ရတတ်သည်။\n" +
                     "ခြွေရံသင်းပင်း ပေါများတတ်သည်။\n" +
                     "စက်မှု၊လက်မှု အနုပညာတို့နှင့် အကျိုးပေးတတ်သည်။\n"
         )
         maharBoteList.add(
             ("သင်သည်  \"ပုတိဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "ပုတိဖွားမှာ၊ ငြိုငြင်စွာ၊ မွေးကာဖွားလတ်မည်။\n" +
                     "\u200Cေ၀◌းရပ်ခြားရွာ၊ အိမ်ထောင်မှာ၊ ပြုကာနေရမည်။\n" +
                     "\n" +
                     "ငယ်စဉ်က မကျန်းမာ၊ မချမ်းသာ ရောဂါများတတ်သဖြင့် မိဘနှစ်ပါးကို များစွာဒုက္ခပေးခဲ့သူဖြစ်တတ်သည်။\n" +
                     "ကြီးပြင်းလာသောအခါ၌လည်း အလည်အပတ် ခရီးသွားလာများမည်။\n" +
                     "အရပ်တစ်ပါးသို့ သွားရောက်နေချင်၏။\n" +
                     "အခြားမြို့ရွာများ၌ အိမ်ထောင်ကျတတ်သည်။\n" +
                     "နှမြောတွန့်တိုသော စိတ်သဘော ရှိတတ်သည်။\n" +
                     "ဆွေပစ်၊ မျိုးပစ်၊ သားပစ်၊ မယားပစ်၊ ခရီးသွားလာနေထိုင်ရတတ်သည်။\n" +
                     "ကျော်စောသော ဂုဏ်သတင်းကင်းမည်။\n" +
                     "အပြောအဆို မယဉ်ကျေးတတ်ပါ။\n" +
                     "ခရီးသွားလျက် အသက်ကုန်ရတတ်သည်။\n")
         )
         maharBoteList.add(
             "သင်သည်  \"အဓိပတိဖွား\"  ဖြစ်ပါသည်။\n" +
                     "\n" +
                     "အဓိပတိဖွား၊ လူအများ၊ မမှားအုပ်စိုးမည်။\n" +
                     "ရဟန်းရှင်လူ၊ အများလူ၊ ကြည်ဖြူညွှတ်ခမည်။\n" +
                     "\n" +
                     "ဂုဏ်သတင်း ကျော်စော ထင်ရှားတတ်သည်။\n" +
                     "အကြောက်အလန့်မရှိ ရဲရင့်စွန့်စား၊ ဇွဲကြီးပြီး သူတထူးထက် ကြီးကဲ အောင်မြင်တတ်သည်။\n" +
                     "ဥာဏ်ပညာ ဗဟုသုတ များပြီး လိမ္မာ ယဉ်ကျေးတတ်သည်။\n" +
                     "ချစ်သူခင်သူ ပေါပြီး စကားပြော ချိုသာတတ်သည်။\n" +
                     "စိတ်သဘော ဖြောင့်မတ် တည်ကြည်တတ်သည်။\n" +
                     "ဂုဏ်ကျက်သရေရှိသည်။\n" +
                     "နှုတ်မှုပညာနှင့် အသက်မွေးရတတ်သည်။\n" +
                     "ဇာတ်သမား(သဘင်သည်) ဖြစ်တတ်သည်။\n" +
                     "အဟောအပြော ကောင်းသူ ဖြစ်တတ်သည်။\n"
         )*/

        binding.btnmahar.setOnClickListener {
            age = binding.etAge.text.toString().toInt()
            /* year -= age
             remainder = year % 7

             remainderListPosition = remainderList.indexOf(remainder)
             lastItem = remainderList.size

             remainderList1 = remainderList.subList(remainderListPosition, lastItem)
             remainderList2 = remainderList.subList(0, remainderListPosition)

             newRemainderList.addAll(remainderList1)
             newRemainderList.addAll(remainderList2)*/

            viewModel.getRemainder(age)

            about = viewModel.getMaharBoteList(spnDayPosition)

            /*  Toast.makeText(
                  requireContext(),
                  "newRemainderList$newRemainderList",
                  Toast.LENGTH_LONG
              ).show()

              when (remainder) {
                  0 -> {
                      remainderList.add(7)
                      remainderList.add(3)
                      remainderList.add(6)
                      remainderList.add(2)
                      remainderList.add(5)
                      remainderList.add(1)
                      remainderList.add(4)
                  }
                  1 -> {
                      remainderList.add(1)
                      remainderList.add(4)
                      remainderList.add(7)
                      remainderList.add(3)
                      remainderList.add(6)
                      remainderList.add(2)
                      remainderList.add(5)
                  }
                  2 -> {
                      remainderList.add(2)
                      remainderList.add(5)
                      remainderList.add(1)
                      remainderList.add(4)
                      remainderList.add(7)
                      remainderList.add(3)
                      remainderList.add(6)
                  }
                  3 -> {
                      remainderList.add(3)
                      remainderList.add(6)
                      remainderList.add(2)
                      remainderList.add(5)
                      remainderList.add(1)
                      remainderList.add(4)
                      remainderList.add(7)
                  }
                  4 -> {
                      remainderList.add(4)
                      remainderList.add(7)
                      remainderList.add(3)
                      remainderList.add(6)
                      remainderList.add(2)
                      remainderList.add(5)
                      remainderList.add(1)
                  }
                  5 -> {
                      remainderList.add(5)
                      remainderList.add(1)
                      remainderList.add(4)
                      remainderList.add(7)
                      remainderList.add(3)
                      remainderList.add(6)
                      remainderList.add(2)
                  }
                  6 -> {
                      remainderList.add(6)
                      remainderList.add(2)
                      remainderList.add(5)
                      remainderList.add(1)
                      remainderList.add(4)
                      remainderList.add(7)
                      remainderList.add(3)
                  }
              }
               val action = MaharBoteFragmentDirections.actionMaharBoteFragmentToShowFragment(
                maharBoteList[newRemainderList.indexOf(spnDayPosition)]
            )*/

            val action = MaharBoteFragmentDirections.actionMaharBoteFragmentToShowFragment(about)
            findNavController().navigate(action)

            /* Toast.makeText(
                 requireContext(),
                 "newRemainderList$newRemainderList",
                 Toast.LENGTH_LONG
             ).show()*/
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

            Toast.makeText(
                requireContext(),
                "spnDayPosition$spnDayPosition",
                Toast.LENGTH_LONG
            ).show()
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
