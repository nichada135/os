//64050135 นิชาดา หวานรอบรู้
import java.util.Arrays;
public class Lab_MatrixMul {
    public static void main(String[] args) {
        int[][] inputA = {{5,6,7} , {4,8,9}};
        int[][] inputB = {{6,4},{5,7},{1,1}};
        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);
        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r,matC_c);
        //Q4
        Thread[][] thread = new Thread[matC_c][matC_r];
        for(int i = 0; i < matC_r; i++){
            for(int j = 0; j < matC_c; j++){
                thread[i][j] = new Thread(new MatrixMulThread(i, j, matA,matB, matC));
                thread[i][j].start();
            }
        }
        //Q5
        try{
            for(int i = 0; i < thread.length; i++){
                for(int j = 0; j < thread.length; j++){
                    thread[i][j].join();
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        matC.show();
    }
}
class MatrixMulThread implements Runnable{
    int processing_row;
    int processing_col;
    MyData datA;
    MyData datB;
    MyData datC;
    MatrixMulThread(int tRow,int tCol,MyData a, MyData b , MyData c){
        //Q1
        processing_row = tRow;
        processing_col = tCol;
        datA = a;
        datB = b;
        datC = c;
    }
/*Q2*/public void run(){
        //Q3
        for(int i = 0; i < datA.data.length; i++) {
            for(int j = 0; j < datB.data.length; j++){
                datC.data[processing_row][i] += datA.data[processing_row][j] * datB.data[j][i];
            }   
        }
        //System.out.pritnln("perform sum of multiplication of assigned row and col ");
    }
}//class
class MyData{
    int[][] data;
    MyData(int[][] m){
        data = m;
    }
    MyData(int r,int c){
        data = new int[r][c];
        for(int[] aRow : data)
           Arrays.fill(aRow,9);
           //9 will be overwritten anyway

    }
    void show(){
        System.out.println(Arrays.deepToString(data));
    }
}
