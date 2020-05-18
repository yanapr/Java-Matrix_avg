
/**
 * Getting a 2d matrix and make it 2d array.
 *
 * @author (Andrey Isakov)
 * @version (30/12/2019)
 */
public class Matrix
{
    // instance variables - replace the example below with your own
    private int[][] _array = new int[0][0];
    private final int BLACK_VALUE = 255;

    /**
     * Constructor for objects of class Matrix
     */
    public Matrix(int[][] array)
    {
        // initialise instance variables
        _array = new int[array.length][array[0].length]; 
        for(int i=0;i<=array.length-1;i++){
            for(int j=0;j<=array[0].length-1;j++){
                _array[i][j]  = array[i][j]; 
            }
        }
    }

    public Matrix(int size1, int size2)
    {
        // initialise instance variables
        int [][] zeroArray = new int[size1][size2];
        for(int i=0;i<=size1-1;i++){
            for(int j=0;j<=size2-1;j++){
                zeroArray[i][j]=0;
            }
        }
    }
    /**string that represent this matrix
     * @return string that represent this matrix
     * 
     */
    
    public String toString(){
        String s="";
        int flag = 0;
        for(int i=0;i<=_array.length-1;i++){
            for(int j=0;j<=_array[0].length-1;j++){
                if(j==0)
                    s+=_array[i][j];

                if(j>=1&&j<_array[0].length-1)    
                    s+="\t"+_array[i][j];
                if(j==_array[0].length-1&&!(i==_array.length-1))
                    s+="\t"+_array[i][j]+"\n";

                if((j==_array[0].length-1)&&(i==_array.length-1))
                    s+="\t"+_array[i][j];

            }
        }
        return s;
    }

    /**return negative pictur
     * @return negative matrix as follow-evry sall that x will be 255-x
     * 
     */
    public Matrix makeNegative() {
        int [][] negativeArray = new int[_array.length][_array[0].length];

        for(int i=0;i<=_array.length-1;i++){
            for(int j=0;j<=_array[0].length-1;j++){
                negativeArray[i][j]=BLACK_VALUE-_array[i][j];
            }
        }
        Matrix negativeArray1 = new Matrix(negativeArray);
        return  negativeArray1;

    }

    /**Removing noise in the pictur
     * @return Smooth image

     */
    public Matrix imageFilterAverage(){
        int [][] averageArray1 = new int[_array.length][_array[0].length];

        for(int i=0;i<=_array.length-1;i++){
            for(int j=0;j<=_array[0].length-1;j++){
                int sum = 0;
                int count = 0;
                for(int p=-1;p<=1;p++){
                    for(int c=-1;c<=1;c++){
                        if(isValid(i+p,j+c)){
                            sum+=_array[i+p][j+c];
                            count++;
                        }
                    }
                }
                averageArray1[i][j]= sum/count;
            }
        }
        Matrix averageArray = new Matrix(averageArray1);
        return averageArray;
    }

    private boolean isValid(int row, int col){
        return(((row>-1)&&(row<_array.length))&&((col>-1)&&(col<_array[0].length)));

    }

    /**Rotates the image 90 degrees clockwise
     * @return Rotated image 90 degrees clockwise

     */    
    public Matrix rotateClockwise() {
        int [][] rotateArray = new int[_array[0].length][_array.length];  
        for(int j=0;j<=_array[0].length-1;j++){
            for(int i=0;i<=_array.length-1;i++){  
                rotateArray[j][_array.length-1-i] = _array[i][j];
            }
        }
        Matrix rotateArray1 = new Matrix(rotateArray);
        return rotateArray1;
    }
/**Rotates the image 90 degrees CounterClockwise
     * @return Rotated image 90 degrees CounterClockwise

     */
    public Matrix rotateCounterClockwise () {
        int [][] rotateCounterArray = new int[_array[0].length][_array.length];  
        for(int j=0;j<=_array.length-1;j++){
            for(int i=0;i<=_array[0].length-1;i++){  
                rotateCounterArray[_array[0].length-1-i][j] = _array[j][i];
            }
        }
        Matrix rotateCounterArray1 = new Matrix(rotateCounterArray);
        return rotateCounterArray1;
    }
}
