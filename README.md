# 学习Android实现可折叠ListView（ExpandableListView）

> 首先要说明的是，本文是学习，并非原作者，源地址[Android常用控件(能折叠的ListView)--ExpandableListView的使用模仿QQ好友列表（http://blog.csdn.net/dl10210950/article/details/52525492）]

控件：

```
<ExpandableListView
        android:id="@+id/expendableListview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
Adapter：

```
class MyAdapter(
        private var mContext : Context,
        /** group 数据 */
        private var groupList: ArrayList<String>,
        /** child 数据 */
        private var childList : ArrayList<ArrayList<String>>) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Any {
        return groupPosition
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val groupView = View.inflate(mContext, R.layout.item_group, null)

        /** 分组名字 */
        val groupName = groupView.findViewById<TextView>(R.id.groupTvName)
        groupName.text = groupList[groupPosition]
        /** 子元素个数 */
        val count = groupView.findViewById<TextView>(R.id.groupTvCount)
        count.text = "${childList[groupPosition].size} 个"

        return groupView
    }

    /**
     * 这个返回的一定要是对应的item里面的List集合的size
     */
    override fun getChildrenCount(groupPosition: Int): Int {
        return childList[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return childList[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, view: View?, viewGroup: ViewGroup?): View {
        val childView = View.inflate(mContext, R.layout.item_child, null)
        val username = childView.findViewById<TextView>(R.id.childTvUserName)
        username.text = childList[groupPosition][childPosition]
        return childView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return groupList.size
    }

}
```
Main代码：

```
	val adapter = MyAdapter(this, groupList, childList)

        expendableListview.setAdapter(adapter)
```

```
About me

WenyiFeng(xfsy2014@gmail.com)

Copyright © 2017 fengwenyi.com. All Rights Reserved.
```