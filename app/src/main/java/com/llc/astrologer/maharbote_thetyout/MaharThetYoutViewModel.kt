package com.llc.astrologer.maharbote_thetyout

import android.graphics.PostProcessor
import androidx.lifecycle.ViewModel

class MaharThetYoutViewModel : ViewModel() {

    private var _year = 1383
    val year: Int get() = _year

    private var _age = 0
    val age: Int get() = _age

    private var _remainder = 0
    val remainder: Int get() = _remainder

    private var _remainderListPosition = 0
    val remainderListPosition: Int get() = _remainderListPosition

    private var _lastItem = 0
    val lastItem: Int get() = _lastItem

    var remainderList = listOf(1, 4, 0, 3, 6, 2, 5)
    var remainderList1 = listOf<Int>()
    var remainderList2 = listOf<Int>()

    private var _newRemainderList = mutableListOf<Int>()
    val newRemainderList = _newRemainderList

    var agePlus: Int = 0
    var joValue: Int = 0

    var spnDayPosition=0

    var jo = listOf<Int>(1,2,3,4,0,5,8,6)
    var joSar = listOf<Int>(6,15,8,17,10,19,12,21)
    var maharThetyout = mutableListOf<String>()

    fun getRemainder(age: Int,position: Int):String{
        spnDayPosition = position
        _year -= age
        _remainder = _year % 7

        _remainderListPosition = remainderList.indexOf(_remainder)
        _lastItem = remainderList.size

        remainderList1 = remainderList.subList(_remainderListPosition, _lastItem)
        remainderList2 = remainderList.subList(0, _remainderListPosition)

        _newRemainderList.addAll(remainderList1)
        _newRemainderList.addAll(remainderList2)

        if (_age > 0 && _age <= joSar[spnDayPosition]) {
            agePlus = joSar[spnDayPosition]
        }
        else if (_age > joSar[spnDayPosition]) {
            agePlus = joSar[spnDayPosition]

            while (_age > agePlus) {
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

        addMaharBoteThetyout()
        return maharThetyout[newRemainderList.indexOf(joValue)]

    }

   /* fun getMaharBoteThetYout(position: Int): String {

          }
*/
    private fun addMaharBoteThetyout() {
        maharThetyout.add(
            "?????????????????? \"???????????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "?????????????????????????????????????????????????????????????????????????????? ??????????????????????????????????????????????????????????????????\n" +
                    "???????????????????????? ?????????????????????????????????????????????\n" +
                    "???????????????????????? ??????????????????????????????????????????\n" +
                    "????????????????????????????????? ???????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????????????????????????????? ????????????????????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????"
        )
        maharThetyout.add(
            ("?????????????????? \"????????????\"???????????????????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "??????????????????????????????????????? ????????????????????????????????????????????????????????????\n" +
                    "??????????????????????????????????????????????????????\n" +
                    "?????????????????????????????? ???????????????????????????????????????????????????????????????????????? ?????????????????????????????????????????????????????????????????????\n" +
                    "???????????????????????????????????? ?????????????????????????????????????????????\n" +
                    "?????????????????????????????? ???????????????????????? ?????????????????????????????????????????? ?????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????")
        )
        maharThetyout.add(
            ("?????????????????? \"??????????????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "?????????????????????????????? ?????????????????????????????????????????????????????????????????????\n" +
                    "???????????????????????????????????? ?????????????????????????????????\n" +
                    "?????????????????????????????? ?????????????????????????????????\n" +
                    "???????????????????????? ????????????????????????????????????????????????????????????????????? ???????????????????????????????????? ???????????????????????? ????????????????????????????????????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????")
        )
        maharThetyout.add(
            ("?????????????????? \"???????????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "??????????????????????????? ???????????????????????? ????????????????????????????????????????????? ???????????????????????????????????????????????????\n" +
                    "????????????????????? ????????????????????? ????????????????????????\n" +
                    "???????????????????????? ????????????????????????????????? ?????????????????????????????????????????????????????????\n" +
                    "?????????????????? ??????????????? ??????????????????????????????\n" +
                    "???????????? ???????????? ?????????????????????????????????\n" +
                    "???????????????????????????????????? ?????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????")
        )
        maharThetyout.add(
            ("?????????????????? \"?????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "????????????????????????????????? ????????????????????????\n" +
                    "????????????????????????????????? ??????????????????????????????????????????\n" +
                    "???????????????????????? ?????????????????????????????? ????????????????????????????????????????????? ????????????????????????????????? ???????????????????????? ???,??? ?????????????????????\n" +
                    "???????????????????????????????????????????????? ????????????????????????????????????????????????\n" +
                    "????????????????????? ????????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????\n")
        )
        maharThetyout.add(
            ("?????????????????? \"????????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "?????????????????????????????? ??????????????????????????????????????? ?????????????????????\n" +
                    "?????????????????? ???????????????????????????????????? ????????????????????????????????????????????????????????????????????? ??????????????????????????????????????? ?????????????????????????????????\n" +
                    "??????????????? ?????????????????????????????? ???????????????????????????????????????????????????\n" +
                    "????????????????????? ???????????????????????? ??????????????????????????????????????? ?????????????????????????????? ????????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????")
        )
        maharThetyout.add(
            ("?????????????????? \"??????????????????????????????\"???????????? ??????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "??????????????????????????????????????? ????????????????????????????????????????????? ?????????????????????\n" +
                    "???????????????????????? ??????????????????????????????????????????\n" +
                    "?????????????????????????????????????????? ????????????????????????????????????????????????????????????????????? ?????????????????????????????????????????????????????????\n" +
                    "?????????????????? ???????????????????????? ?????????????????????????????????\n" +
                    "???????????????????????? ?????????????????????????????? ????????????????????????????????????????????????\n" +
                    "\n" +
                    "???????????? _\n" +
                    "????????????????????????????????????????????????????????? ??????????????? ?????????????????? ???????????? ??????????????????????????????????????????\n" +
                    "????????????????????? ?????????????????? ???????????? ?????????????????? ???????????????????????????????????????????????????\n" +
                    "??????????????????????????? ?????????????????????????????????????????????????????????????????? ????????????????????????????????? ??????????????????????????????????????? ????????????????????????????????????\n" +
                    "???????????????_????????????????????????????????? ?????????_??????????????????????????? ??????????????????_????????????????????????????????? ??????????????????????????? ????????????????????????????????????????????????\n" +
                    "??????????????????????????? ????????????_?????????????????????????????? ???????????????_????????????????????????????????? ????????????_??????????????????????????? ??????????????????????????? ???????????????????????????????????????")
        )
    }

    override fun onCleared() {
        super.onCleared()

        newRemainderList.clear()
        _age = 0
        _remainder = 0
        _remainderListPosition = 0
        joValue = 0
        agePlus = 0
    }
}