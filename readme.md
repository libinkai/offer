# 说明
> 本代码为各种数据结构以及算法的Demo（运行环境 JDK8），之前没有形成文档，会逐渐整理好的~

# 数据结构
## 数组
- [实现一个int数组并完成增删改查](./src/main/java/com/equator/datastruct/array/MyIntArray.java)
- [实现一个泛型动态数组并实现增删改查](./src/main/java/com/equator/datastruct/array/MyGenericArray.java)
- 时间复杂度分析以及均摊时间复杂度：并不是每次操作都会触发resize方法，resize的成本可以均摊到其它的操作上面
- 防止时间复杂度的震荡（延迟缩容的时机）：缩容的条件与扩容的条件不对偶即可，如扩容2倍，那么在数组元素为容量的1/4时缩容一半，而不是在数组元素为容量的1/2时缩容

## 栈
- [使用动态数组实现栈](./src/main/java/com/equator/datastruct/stack/MyGenericStack.java)，push()、pop()的均摊时间复杂度均为O(1)

## 队列
> 循环队列，一般要循环利用指针，可以借助取余运算进行计算对应的下标
- [使用动态数组实现队列，入队O(1)，出队O(n)](./src/main/java/com/equator/datastruct/queue/MyArrayQueue.java)，front==tail时队列空，front+1==tail满队列（浪费一个空间）
- [循环动态队列，通过改变指针指向实现（取余运算）循环队列，入队O(1)，出队O(n)](./src/main/java/com/equator/datastruct/queue/MyCycleQueue.java)
- [循环有界队列](./src/main/java/com/equator/datastruct/queue/MyQuickQueue.java)
- 遍历一个循环队列的方法
  ```
  方法一：
  for(int i = 0;i < size;i++){
      data[(i + front) % data.length]
  }
  方法二：
  for(int i = front;i != tail;i = (i+1) % data.length){
      data[i]
  }
  ```
## 链表
- 链表实现
- 为了统一对节点的操作，创建一个虚拟的头节点
- 使用链表实现栈，将链表头作为栈顶即可
- 带有尾节点指针的链表，可以实现队列

## BST

## 集合与映射

## 优先队列与堆

## 线段树

## 字典树

## 并查集

## AVL

## 红黑树

## 哈希
# 算法

# leetcode题解