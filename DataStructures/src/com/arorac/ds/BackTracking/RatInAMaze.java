package com.arorac.ds.BackTracking;
/*
 * 
 */

public class RatInAMaze {
	
		
	public static void main(String[] args) {
		
//		int[][] maze = new int[][]{{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
		int[][] maze = new int[][]{{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
		int[][] sol = new int[4][4];
		int x = 0 ;
		int y = 0;
		
		 boolean t = findSolution(maze,x,y,sol );
		 

	}
	
	public static  boolean findSolution(int[][] maze , int x , int y , int[][] sol){
		
		if(x >= maze.length || x < 0 || y >= maze.length || y<0 || maze[x][y] == 0 || sol[x][y] == 1 ){
			return false;
		}
		
		if(x == maze.length-1 && y == maze.length-1 ){
			sol[x][y]=1;
			 for(int i = 0 ; i<maze.length;i++){
				 System.out.println("");
				 for (int j = 0 ; j<maze.length;j++){
					 System.out.print(sol[i][j]);
				 }}
			 sol[x][y]=0;
			 System.out.println("");
			return true;
		}
		
		sol[x][y]=1;
		
		
		//go to x direction--> 1
		findSolution(maze, x-1, y, sol); // up
		findSolution(maze, x+1, y, sol); // down 
		findSolution(maze, x, y-1, sol); // left
		findSolution(maze, x, y+1, sol); // right 
		
		sol[x][y]=0;
		return false;
	}

}
