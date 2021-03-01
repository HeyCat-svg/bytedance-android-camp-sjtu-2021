## Homework1

- #### 要求

  实现一个RecycleView、页面跳转、搜索框

- #### 遇到的问题

  1. java中子类在调用构造函数时，super()是不是相当于调用父类的构造函数，和C++中子类构造函数中调用基类构造函数一样
  2. `SearchLayout.java`的46行：`mImageView.setImageResource(R.drawable.icon_search)`明明在xml的ImageView属性src中设置过了，为什么还要在类中再设置一遍图像地址
  3. `SearchActivity.java`的32行：`final List<String> items = new ArrayList<>()`，其中关键字`final`的意义是什么，定义成普通的局部变量不行吗

