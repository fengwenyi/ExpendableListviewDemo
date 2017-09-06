package com.fengwenyi.expendablelistviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var groupList = ArrayList<String>()
    private var childList = ArrayList<ArrayList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        initData()

        val adapter = MyAdapter(this, groupList, childList)

        expendableListview.setAdapter(adapter)
    }

    private fun initData() {
        addData("幼稚园同学", arrayOf("周杰伦", "江一燕 ", "佟丽娅", "高圆圆", "刘诗诗", "刘亦菲", "angleBaby", "张静初", "张含韵"))
        addData("小学同学", arrayOf("光头强", "熊大", "熊二", "妙蛙种子", "比卡丘", "双蛋瓦斯", "贪吃蛇"))
        addData("初中同学", arrayOf("苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里"))
        addData("高中同学", arrayOf("习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"))
        addData("大学同学", arrayOf("周杰伦", "江一燕 ", "佟丽娅", "高圆圆", "刘诗诗", "刘亦菲", "angleBaby", "张静初", "张含韵"))
        addData("研究生同学", arrayOf("光头强", "熊大", "熊二", "妙蛙种子", "比卡丘", "双蛋瓦斯", "贪吃蛇"))
        addData("博士同学", arrayOf("苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里"))
        addData("教授同事", arrayOf("习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"))
        addData("众仙家名册", arrayOf("苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里", "习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"))
    }

    /**
     * 用来添加数据的方法
     */
    private fun addData(group: String, friend: Array<String>) {
        groupList.add(group)
        //每一个item打开又是一个不同的list集合
        val childitem = ArrayList<String>()
        friend.indices.mapTo(childitem) { friend[it] }
        childList.add(childitem)
    }
}
