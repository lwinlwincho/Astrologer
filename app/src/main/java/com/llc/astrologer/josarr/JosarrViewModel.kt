package com.llc.astrologer.josarr

import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class JosarrViewModel: ViewModel() {

    var age = 0
    var spnDayPosition: Int = 0

    var agePlus: Int = 0

    var joSar = listOf<Int>(6, 15, 8, 17, 10, 19, 12, 21)
    var josarrList = mutableListOf<String>()

    fun getJosarr(age:Int,position: Int):String{

        spnDayPosition=position

        if (age > 0 && age <= joSar[spnDayPosition]) {
            agePlus = joSar[spnDayPosition]
        }
        else if (age > joSar[spnDayPosition]) {
            agePlus = joSar[spnDayPosition]

            while (age > agePlus) {
                if (spnDayPosition in 0..6)
                    ++spnDayPosition
                else
                    spnDayPosition = 0

                agePlus += joSar[spnDayPosition]
            }
        }
        addJosarr()
        return josarrList[spnDayPosition]
    }

    private fun addJosarr() {

        josarrList.add(
            "သင်သည် \"တနင်္ဂနွေ\" ဂြိုဟ်စား နေသဖြင့် ရွှေ၊ ငွေ၊ ဥစ္စာ အိမ်တွင်းရှိ ပစ္စည်းများ ကုန်ဆုံးခြင်း၊ \n" +
                    "အနာရောဂါ ဖြစ်ပွားခြင်း၊ ခိုက်ရန်ဒေါသ အငြင်းအခုန်ဖြစ်ရခြင်း၊ ကိုယ့်ထက်ကြီသော ဆရာမိဘ၏\n" +
                    "သဘောကွဲ အထင်အမြင် လွဲခံရခြင်း၊ ကိုယ့်အောက်ကလူများ၊ ကျေးကျွန်များ တော်လှန်အာခံတတ်ခြင်း၊ \n" +
                    "အိမ်တွင်း ဆူဆူညံညံရှိခြင်း၊ သောကဖြစ်ခြင်း၊ ယာယီခရီးသွားရခြင်း၊ ခိုးကိန်း၊ မီးကိန်း ဖြစ်ခြင်းတို့ ဖြစ်နိုင်သည်။\n" +
                    "အရှေ့မြောက်အရပ်က လူ၀◌င်လူထွက် လက်မခံနှင့်။\n" +
                    "အိမ်တွင်းရေးကို ရှုပ်ထွေးစေ၍ ခိုးယူဖျက်ဆီးကိန်းနှင့် ကြုံရတတ်သည်။\n" +
                    "အရှေ့မြောက်အရပ်ကို ခရီးသွားရှောင်ပါ။\n" +
                    "ဘေးရန် တစ်ခုခုနှင့် ကြုံတွေ့ဖွယ်ရှိသည်။\n" +
                    "\n" +
                    "တနင်္ဂနွေနေ့၌ဖြစ်စေ၊ တနင်္ဂနွေထောင့်၌ဖြစ်စေ အုန်းဆွမ်း၊ အုန်းပင်၊ အုန်းလက်တို့ကို ကိုယ်တိုင်သွား၍ \n" +
                    "လှူဒါန်းပြီး လိုရာဆုမွန်ကိုတောင်းပါ။"
        )
        josarrList.add(
            ("သင်သည် \"တနင်္လာ\" ဂြိုဟ်စား နေသဖြင့် အရှေ့ဘက်က ၀◌မ်းသာအားရစရာ၊ ရွှေ၊ ငွေ၊ ဥစ္စာ၊ စီးပွား၊ \n" +
                    "ကျွန်သင်း၊ ကျွဲနွား၊ အ၀◌တ်စားကောင်းများ လွယ်လွယ်ကူကူနှင့် ၀◌င်ကိန်း ရကိန်းမြင်သည်။\n" +
                    "အရှေ့အရပ်က ချစ်သူခင်သူများ လာရောက် မ,စ ကူညီသဖြင့် အကြံအစည် အောင်မြင်ရန်ရှိသည်။\n" +
                    "အပျို၊ လူပျိုများ အိမ်ထောင်ကျကိန်း၊ ချစ်သူခင်သူများရကိန်း၊ ကြင်ဖော်ကြင်ဖက်တွေ့ကိန်း ရှိသည်။\n" +
                    "သမီးကညာ ခြေနှစ်ချောင်း ရတတ်သည်။\n" +
                    "မိတ်ကောင်း၊ ဆွေကောင်းများ ၀◌င်ရောက် မ,စမည်။\n" +
                    "ရောဂါကင်းပြီး ရန်မာန်ဥပဒ်လည်း မကပ်ရောက်နိုင်ပါ။\n" +
                    "အရှေ့အရပ်နှင့် အနောက်အရပ်များသို့ သွားရောက် စီးပွားရှာဖွေ လုပ်ကိုင်ပါက အကြံအစည် အောင်မည်။\n" +
                    "\n" +
                    "တနင်္လာနေ့၌သော်လည်း\u200Cကောင်း၊ တနင်္လာအရပ်မှသော်လည်းကောင်း ကံ့ကော်ညွန့်၊ ကြာပန်း၊ ကြာပန်းခိုင်၊ \n" +
                    "ငွေကြေးကို ဘုရားစေတီမှာ ဖြစ်စေ၊ အိမ်၌ပဲဖြစ်စေ ကိုယ်တိုင်လှူဒါန်းပြီး ဆုမွန်ကောင်းတောင်းပါ။\n")
        )
        josarrList.add(
            ("သင်သည် \"အင်္ဂါ\" ဂြိုဟ်စား နေသဖြင့် ချစ်သူမယား ကြင်ဖက် ရည်းစားများနှင့် သေကွဲ ရှင်ကွဲ ဖြစ်တတ်ပြီး\n" +
                    "အနှောင်အဖွဲ့၊ အမှုအခင်း၊ အငြင်းအခုန်၊ စိတ်ပူဆွေးရတတ်ပြီး အိမ်သူမယား ဆွေမျိုးသားချင်းများနှင့်\n" +
                    "သဘောကွဲလွဲအောင် ကုန်းတိုက်မည့်သူ ဖြစ်နိုင်သည့် အိမ်ထောင်ပျက် မိန်းမ၊ ယောက်ျားများ လာလျှင် လက်မခံပါနှင့်။\n" +
                    "စီးပွားပျက်တတ်ပြီး သူခိုး ခိုးခံရတတ်သည်။\n" +
                    "ဘေးဒဏ်ဖြစ်ပြီး လူတကာမုန်း၍ ဆွေမျိုးများကပင် ရန်ရှာတတ်သည်။\n" +
                    "အရှေ့တောင်အရပ်သို့ ညအိပ်နေ၀◌င် မြစ်ကူးချောင်းခြား ခရီး\u200Cေ၀◌း မသွားပါလေနှင့်၊ရှောင်ပါ။\n" +
                    "သွားလျှင် ဧကန် ဘေးရန်တွေ့ပြီး ဓားလှံ ထိတတ်၊ သွေးထွက်သံယို ဖြစ်တတ်သည်။\n" +
                    "\n" +
                    "အင်္ဂါနေ့မှာသော်လည်း\u200Cကောင်း၊ အင်္ဂါအရပ်မှ ဘုရားစေတီ ဗောဓိညောင်ပင် မှာသော်လည်းကောင်း\n" +
                    "ဆွမ်း၊ နှင်းဆီပန်း ကိုယ်တိုင် သွားရောက် လှူဒါန်းပြီး ဆုမွန်ကောင်းတောင်းယူပါ။\n")
        )
        josarrList.add(
            ("သင်သည် \"ဗုဒ္ဓဟူး\" ဂြိုဟ်စား နေသဖြင့်\n" +
                    "အပျိုကညာ ရည်းစားများ၊ ကြင်ဖော်ကြင်ဖက်များနှင့် ဧကန် တွေ့ရကိန်းရှိသည်။\n" +
                    "ရွှေ၊ ငွေ၊ ဥစ္စာ ၊ စုတ်ကောင်း၊ လာဘ်ကောင်း ၀◌င်မည်။\n" +
                    "သောက ကင်း\u200Cေ၀◌းပြီး၊ မျက်နှာပွင့်မည်။\n" +
                    "အကြံအစည်အောင်ပြီး နာမည်ကောင်းရမည်။\n" +
                    "တောင်အရပ်မှ အဖြူရောင် ရှိသည့် အ၀◌တ်အထည်နှင့် အခြားပစ္စည်း ၀◌င်ကိန်းရှိသည်။\n" +
                    "ဗုဒ္ဓဟူးသားသမီးကသော်လည်းကောင်း၊ တရုတ်လူမျိုးများကသော်လည်းကောင်း\n" +
                    "အကြံအစည် အကူအညီပေး၍ စီးပွားတက်လိမ့်မည်။\n" +
                    "\n" +
                    "ဗုဒ္ဓဟူးနေ့မှာသော်လည်း\u200Cကောင်း၊ ဗုဒ္ဓဟူးအရပ်မှာသော်လည်းကောင်း\n" +
                    "ရွှေပြား၊ ဖယောင်းတိုင်၊ ရေစင် ရေကောင်းများကို ဘုရားစေတီတို့၌ ကိုယ်တိုင် ကပ်လှူပြီး \n" +
                    "ကောင်းကျိုး ချမ်းသာများ ၀◌င်ရောက်ရန် ဆုမွန်ကောင်းတောင်းပါ။")
        )
        josarrList.add(
            ("သင်သည် \"စနေ\" ဂြိုဟ်စား နေသဖြင့် အနောက်တောင်အရပ်က ရန်ညှိုးဖွဲ့သူ မိန်းမ ယောက်ျားနှင့် ကြုံတွေ့ရတတ်သည်။\n" +
                    "ဆွေမျိုး ညာတိ မိတ်ဆွေများကပင် အထင်မြင်သေးခြင်း၊ သဘောကွဲခြင်း၊ ရန်သူလုပ်ခြင်းကြောင့် \n" +
                    "စိတ်ဆင်းရဲ၊ ကိုယ်ဆင်းရဲ ဖြစ်ရကိန်း ရှိသည်။\n" +
                    "နေရာပြောင်းမှသာ ကောင်းဖို့ရှိသည်။\n" +
                    "ချစ်သူစွန့်သွားတတ်သည်။ \n" +
                    "စုန်း နတ် ရုက္ခစိုး ဖမ်းစားတတ်သည်။\n" +
                    "နေအိမ် မီးလောင်တတ်ပြီး ပစ္စည်းဥစ္စာ ပျောက်ပျက်တတ်သည်။\n" +
                    "ဆွေမတော် မျိုးမစပ်သော စနေသားသမီးများ၊ အိမ်ထောင်ပျက် မိန်းမယောက်ျားများ၊ လင်သေမုဆိုးမများ\n" +
                    "၀◌င်လျှင် လက်မခံနှင့်၊ အမှုအခင်းဖြစ်ရတတ်သည်။\n" +
                    "စနေဖျက်လျှင် အသက်ပင် ထွက်ရတတ်သည် ဖြစ်၍ ဒါနဖက်မှ ဂြိုဟ်ဆိုးများ ပျက်ပြား ရှောင်ရှားရမည် ဖြစ်သည်။\n" +
                    "အရပ်တပါးသို့ထွက်၍ တရားအားထုတ်သင့်၏။\n" +
                    "\n" +
                    "စနေနေ့မှ သော်လည်းကောင်း၊ စနေအရပ်ကသော်လည်းကောင်း ဘုရားစေတီ၌ ထီးဖြူ၊ ထီးနီ၊ နာနတ်ပန်း၊ ဒေါနပန်းများကို\n" +
                    "ကိုယ်တိုင် သွား၍ လှူဒါန်းပြီး ဆုမွန်ကောင်း တောင်းယူရမည်။\n")
        )
        josarrList.add(
            ("သင်သည် \"ကြာသပတေး\" ဂြိုဟ်စား နေသဖြင့် အနောက်အရပ်က ကြာသပတေး သားသမီးများ ချစ်ခင်ကြင်နာ၍ မ,စ ကူညီအံ့။\n" +
                    "အနောက်အရပ်နှင့် အရှေ့အရပ်များမှ ကြင်ဖော်ကြင်ဖက် ရည်းစား စုတ်ကောင်း လာဘ်ကောင်း ၀◌င်ကိန်းရှိသည်။\n" +
                    "မိတ်ကောင်းဆွေကောင်းများ၊ သူတော်ကောင်း ဆရာမိဘများ ချီးမြှင့်ထောက်ပံ့လာခြင်းကြောင့် ကြာသပတေးနံ ပိုးဖဲပိတ် \n" +
                    "စသော ပစ္စည်းများ ၀◌င်ကိန်းရှိသည်။\n" +
                    "မင်းပူဇော် မင်းချီးမြှင့်လည်း ခံရတတ်သည်။ \n" +
                    "အပျို၊ လူပျိုများဖြစ်ပါက မိမိတို့ကြိုက်သည့် ရည်းစားများနှင့် ဖူးစာဆုံရကိန်းရှိသည်။\n" +
                    "စန်းပွင့်မည်၊ ချစ်သူပေါမည်။\n" +
                    "စုတ်အားကြီးသည်၊ သတိနှင့်နေပါလေ။\n" +
                    "ရွှေ၊ ငွေ၊ ဥစ္စာ၊ ခြေလေးချောင်း ၀◌င်လာစရာရှိသည်။\n" +
                    "အိမ်ထောင်ရှင် မိန်းမ ယောက်ျားများမှာမူ အမွေဟောင်း၊ ကြွေးဟောင်းများ ၀င်ကိန်းရကိန်းရှိသည်။\n" +
                    "\n" +
                    "ကြာသပတေးနေ့၌သော်လည်းကောင်း၊ ကြာသပတေးအရပ်ကသော်လည်းကောင်း \n" +
                    "အောင်သပြေပန်း၊ မေမြိုပန်း၊ ငှက်ပျောသီးများကို ကိုယ်တိုင်သွား၍ ဘုရားစေတီများ၌ \n" +
                    "လှူဒါန်းပူဇော်ကာ ဆုမွန်ကောင်း တောင်ယူရမည်။\n")
        )
        josarrList.add(
            ("သင်သည် \"ရာဟု\" ဂြိုဟ်စား နေသဖြင့် ကိုယ်၌ ယားယံသော ၀◌ဲနာ၊ ပွေးနာ၊ အဖုအပိန့်များ စွဲကပ်အံ့။\n" +
                    "နှလုံးမသာ၊ သေလုနီးပါး လေနာ၊ ရင်နာ၊ ၀◌မ်းဥပဒ် ဖြစ်တတ်သည်။၀◌က်သားကိုရှောင်ပါ\n" +
                    "ရွှေ၊ ငွေ၊ ဥစ္စာ စီးပွားရေး ဟူသမျှ ပျက်စီးကုန်ကျကိန်း ရှိသည်။\n" +
                    "ရောဂါလည်းထူတတ်သည်။ ကျေးကျွန်ထွက်ပြေးတတ်သည်။\n" +
                    "ကြွေးမြီးဆုံးပါးတတ်သည်။ အိမ်ခြေမတည်ဖြစ်တတ်သည်။\n" +
                    "အနောက်မြောက်အရပ်များသို့ ခရီး\u200Cေ၀◌း မြစ်ကူး ချောင်းခြားမသွားကောင်း။\n" +
                    "သွားလျှင် ဓားလှံသင့်တတ်၊ ဘေးဆိုး ရန်ဆိုး အနာဆိုးများနှင့် တွေ့ရကြုံရကိန်းရှိသည်။\n" +
                    "\n" +
                    "ရာဟုဖျက်က စီးပွားပျက်ကိန်း ရှိသည်ဖြစ်၍ ဗုဒ္ဓဟူးနေ့ ညနေဖက်၌ အနောက်မြောက်အရပ် \n" +
                    "ဘုရားတွင် ရေစင် ရေကောင်း၊ ယပ်တောင် ကိုယ်တိုင်သွား၍ လှူဒါန်းပြီးလျှင် ဆုမွန်တောင်းပါလေ။")
        )
        josarrList.add(
            ("သင်သည် \"သောကြာ\" ဂြိုဟ်စား နေသဖြင့် မိမိမမြင်ဖူးသော ကြင်ဖော်ကြင်ဖက်နှင့် တွေ့ရတတ်သည်။\n" +
                    "မြောက်အရပ်က အဖြူရောင်ရှိသောအရာ ရွှေ၊ ငွေ၊ ဥစ္စာ၊ ကျေးကျွန်၊ ဆင်မြင်း၊ စုတ်ကောင်း လာဘ်ကောင်းများ \n" +
                    "၀◌င်လာကိန်း ဧကန်ရှိသည်။\n" +
                    "နောက်နောက်က မတွေ့မကြုံ မရရှိဖူးသေးသည့် လာဘ်ကောင်း၊ အ၀◌တ်အထည်ကောင်းများ၊ အခြေအနေများကို\n" +
                    "ရရှိခံစားရကိန်းရှိသည်။\n" +
                    "စီးပွားလာဘ်လာဘ၊ ဂုဏ်ကျက်သရေတိုးမည်။\n" +
                    "ဘေးကင်းရန်ကွာ စိတ်ချမ်းသာ၍ မျက်နှာရွှင်လန်း လွန်ပွင့်လင်းအံ့။\n" +
                    "လူပျိုကာလသားများသည် စန်းပွင့်၍ မိမိကြိုက်သူ ရည်းစားများနှင့် ပေါင်းဖော်ရကိန်းရှိသည်။ \n" +
                    "အိမ်ထောင်ရှင်တို့ အိမ်တဆောင် မီးတပြောင် နေထိုင်နိုင်ကိန်း ကြုံမည်။\n" +
                    "\n" +
                    "သောကြာနေ့မှာဖြစ်စေ၊ သောကြာအရပ်ကဖြစ်စေ သစ်သီး၊ ရေစင်ရေကောင်းများကို \n" +
                    "ဘုရားစေတီတော်သို့ ကိုယ်တိုင်သွားရောက်ပြီး လှူဒါန်း၍ ဆုမွန်ကောင်း တောင်းယူပါ။\n")
        )

    }
}