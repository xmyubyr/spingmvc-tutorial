package com.example.jindian.chapter8;

public class PaintFill10 {
    public static int[][] paintFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int[][] visited =new int[m][n];
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,newColor,oldColor);
        return image;
    }
    public static void dfs(int[][] image, int r, int c, int newColor,int oldColor){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length){
            return;
        }
        if (oldColor != image[r][c]) return;
        if(oldColor == image[r][c]){
            image[r][c] =newColor;
           dfs(image,r+1,c,newColor,oldColor);
           dfs(image,r-1,c,newColor,oldColor);
           dfs(image,r,c-1,newColor,oldColor);
           dfs(image,r,c+1,newColor,oldColor);
        }
    }

    public static void main(String[] args) {
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        int sr =1,sc=1;
        int newColor =2;
        image = paintFill(image,sr,sc,newColor);
        for(int i =0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.println(image[i][j]);
            }

        }

    }
}
