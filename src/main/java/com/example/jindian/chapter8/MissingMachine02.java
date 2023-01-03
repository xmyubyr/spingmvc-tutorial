package com.example.jindian.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
//网格中的障碍物和空位置分别用 1 和 0 来表示。
//返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
//示例
//输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释:
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
public class MissingMachine02 {
    public static List<List<Integer>> pathWithObstacles(int [][] grid){
        int m=grid.length;
        int n=grid[0].length;
        //保存路径用的数组
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0,0,new boolean[m][n],ansList,grid);
        return ansList;
    }
    public static boolean dfs(int r,int c,boolean[][] visited, List<List<Integer>> pathList,int [][] grid){
        //异常情况：行坐标超出范围 或 列坐标超出范围 或 格子里是障碍物 或 访问过这个格子
        if(r>=grid.length||c>=grid[0].length||visited[r][c]||grid[r][c]==1){
            return false;
        }
        pathList.add(Arrays.asList(r,c));
        //到最后一个格子了，也就是完成任务了
        if(r==grid.length-1 && c==grid[0].length-1){
            return true;
        }
        //如果不是上边所列的异常情况，将当前格子标记为已经历过
        visited[r][c]=true;
        //如果右边格子或者下边格子是true的话，返回true。这里有一点需要注意，因为||的性质，前者，
        // 即右格为true的时候，就先不执行下格了。只有右格之后的路径难以为继的时候，才会来这里继续执行下格
        if(dfs(r,c+1,visited,pathList,grid) || dfs(r+1,c,visited,pathList,grid)){
            return true;
        }
        //如果已经到了末路，即当前格子没有障碍，但右、下格子都是障碍的话，但还没有到达最后的格子，
        // 删掉数组pathList的最后一个元素。并返回false
        pathList.remove(pathList.size()-1);
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0},{1,0,0,1},{0,0,0,0}};
        List<List<Integer>> res= pathWithObstacles(grid);
        System.out.println(res);
    }
}
