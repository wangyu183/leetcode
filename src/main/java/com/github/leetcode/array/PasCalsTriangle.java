package com.github.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 numRows, 生成帕斯卡三角形的前 numRows 行。 例如, 给定 numRows = 5, 返回 [ [1], [1,1],
 * [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author wangyu
 *
 */
public class PasCalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (numRows >= 1) {
            List<Integer> data = new ArrayList<Integer>();
            data.add(1);
            list.add(data);
        }
        if (numRows >= 2) {
            List<Integer> data = new ArrayList<Integer>();
            data.add(1);
            data.add(1);
            list.add(data);
        }
        if (numRows >= 3) {
            for (int i = 3; i <= numRows; i++) {
                List<Integer> data = new ArrayList<Integer>();
                List<Integer> prev = list.get(i - 2);
                data.add(1);
                for (int j = 2; j <= i - 1; j++) {
                    data.add(prev.get(j - 2) + prev.get(j - 1));
                }
                data.add(1);
                list.add(data);
            }
        }
        return list;

    }
    public static void main(String[] args) {
        PasCalsTriangle pasCalsTriangle = new PasCalsTriangle();
        List<List<Integer>> list = pasCalsTriangle.generate(7);
        System.out.println(list);
    }
}
