package com.equator.algorithm.sort.heap;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/27 22:54
 **/

/**
 * 堆排序 对 完全二叉树 进行0为开始下标的层序遍历
 * 对于一个节点，其下标为i，则
 * 其父节点为 (i-1)/2
 * 左孩子为 2i+1
 * 右孩子为 2i+2
 */
public class HeapSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length;
        int lastNodeIndex = len - 1;
        // 从最后一个有孩子的节点（即最后一个叶子节点的父节点）开始建立大顶堆，最后一个非叶子结点
        for (int i = (lastNodeIndex - 1) / 2; i >= 0; i--) {
            heapify(array, i, len);
        }
        // 从最后一个节点 i 开始，依次和堆顶 0 进行交换
        for (int i = lastNodeIndex; i >= 0; i--) {
            SortUtil.swap(array, i, 0);
            // 堆（待排序的序列）不断缩短，故将i作为len传入函数
            heapify(array, 0, i);
        }
    }

    /**
     * 堆化，调整数组使其保持大顶堆的属性，使 [index,len] 保持大顶堆属性
     *
     * @param array
     * @param len   堆的节点个数
     * @param index 要调整的节点的下标
     */
    public void heapify(int[] array, int index, int len) {
        if (index >= len) {
            return;
        }
        // 计算左右孩子的下标
        int childrenLeftIndex = 2 * index + 1;
        int childrenRightIndex = 2 * index + 2;
        // 找出index节点以及其左右孩子三者中的最大值
        int maxIndex = index;
        if (childrenLeftIndex < len && array[childrenLeftIndex] > array[maxIndex]) {
            maxIndex = childrenLeftIndex;
        }
        if (childrenRightIndex < len && array[childrenRightIndex] > array[maxIndex]) {
            maxIndex = childrenRightIndex;
        }
        // 如果index节点不是其与其左右孩子三者中的最大值，则交换
        if (maxIndex != index) {
            SortUtil.swap(array, maxIndex, index);
            // 调整之后其它的大顶堆属性可能被破坏，需要继续调整
            heapify(array, maxIndex, len);
        }
    }

    public static void main(String[] args) {
        SortUtil.sort(new HeapSort());
    }
}
