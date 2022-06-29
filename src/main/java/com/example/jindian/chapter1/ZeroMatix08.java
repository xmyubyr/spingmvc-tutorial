package com.example.jindian.chapter1;
//1.8 零矩阵。编写一种算法，若M ×N 矩阵中某个元素为0，则将其所在的行与列清零。
public class ZeroMatix08 {
    public static void main(String[] args) {

    }
    public static void setZero(int matrix[][]){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix.length];
        for(int i=0;i< matrix.length;i++){
           for(int j=0;j< matrix[0].length;j++){
               if(matrix[i][j]==0){
                   row[i]=true;
                   column[j]=true;
               }
           }
        }
        //置空行
        for(int i=0;i< row.length;i++){
           if(row[i]){
              nullifyRow(matrix,i);
           }
        }
        //置空列
        for(int i=0;i< column.length;i++){
            if(row[i]){
                nullifyColumn(matrix,i);
            }
        }
    }
    public static void nullifyRow(int matrix[][],int row){
        for(int i=0;i< matrix[0].length;i++){
            matrix[row][i]=0;
        }

    }
    public static void nullifyColumn(int matrix[][],int column){
        for(int i=0;i< matrix.length;i++){
            matrix[i][column]=0;
        }
    }
}
