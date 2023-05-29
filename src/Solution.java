class Solution {
    //行
    private boolean[][] f1;
    //列
    private boolean[][] f2;
    //九宫
    private boolean[][] f3;
    //flag为true让函数直接回退
    private boolean flag = false;
    public void solveSudoku(char[][] board) {
        //回溯，类似n皇后
        f1 = new boolean[9][10];
        f2 = new boolean[9][10];
        f3 = new boolean[9][10];
        //初始化三个限制条件
        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                f1[i][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                f2[i][board[j][i] == '.' ? 0 : board[j][i] - '0'] = true;
                if (i <= 2){
                    if (j <= 2){
                        f3[0][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else if (j <= 5){
                        f3[1][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else {
                        f3[2][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    }
                } else if (i <= 5){
                    if (j <= 2){
                        f3[3][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else if (j <= 5){
                        f3[4][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else {
                        f3[5][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    }
                } else {
                    if (j <= 2){
                        f3[6][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else if (j <= 5){
                        f3[7][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    } else {
                        f3[8][board[i][j] == '.' ? 0 : board[i][j] - '0'] = true;
                    }
                }
            }
        }
        dfs(board,0,0);
    }
    void dfs(char[][] board,int x,int y){
        //退出条件
        if (x > 8){
            flag = true;
            return;
        }
        if (board[x][y] != '.'){
            if (y + 1 > 8){
                dfs(board,x + 1,0);
            } else {
                dfs(board,x,y + 1);
            }
        } else {
            for (int i = 1;i < 10;i++){
                if (!f1[x][i] && !f2[y][i]){
                    if (x <= 2){
                        if (y <= 2){
                            if (!f3[0][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[0][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[0][i] = false;
                                board[x][y] = '.';
                            }
                        } else if (y <= 5){
                            if (!f3[1][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[1][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[1][i] = false;
                                board[x][y] = '.';
                            }
                        } else {
                            if (!f3[2][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[2][i] = true;
                                if (y + 1 > 8){
                                    dfs(board,x + 1,0);
                                } else {
                                    dfs(board,x,y + 1);
                                }
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[2][i] = false;
                                board[x][y] = '.';
                            }
                        }
                    } else if (x <= 5){
                        if (y <= 2){
                            if (!f3[3][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[3][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[3][i] = false;
                                board[x][y] = '.';
                            }
                        } else if (y <= 5){
                            if (!f3[4][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[4][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[4][i] = false;
                                board[x][y] = '.';
                            }
                        } else {
                            if (!f3[5][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[5][i] = true;
                                if (y + 1 > 8){
                                    dfs(board,x + 1,0);
                                } else {
                                    dfs(board,x,y + 1);
                                }
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[5][i] = false;
                                board[x][y] = '.';
                            }
                        }
                    } else {
                        if (y <= 2){
                            if (!f3[6][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[6][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[6][i] = false;
                                board[x][y] = '.';
                            }
                        } else if (y <= 5){
                            if (!f3[7][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[7][i] = true;
                                dfs(board,x,y + 1);
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[7][i] = false;
                                board[x][y] = '.';
                            }
                        } else {
                            if (!f3[8][i]){
                                board[x][y] = (char)(i + '0');
                                f1[x][i] = true;
                                f2[y][i] = true;
                                f3[8][i] = true;
                                if (y + 1 > 8){
                                    dfs(board,x + 1,0);
                                } else {
                                    dfs(board,x,y + 1);
                                }
                                if (flag){
                                    break;
                                }
                                f1[x][i] = false;
                                f2[y][i] = false;
                                f3[8][i] = false;
                                board[x][y] = '.';
                            }
                        }
                    }
                }
            }
        }
    }
}