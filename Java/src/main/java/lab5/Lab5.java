package lab5;

import java.text.DecimalFormat;

public class Lab5 {
        public static void main(String[] args){
            DecimalFormat df = new DecimalFormat("###.##"); //Округлення числа
            double[] x0 = {4.0, 4.5};
            int[][] GausMtr = {{ 4, 4}, {4, 2 }};
            int det = -8;
            double[] x = new double[2];

            System.out.println("Newton method\nf(x) = 2*x^2 + 4*x*y +y^2 - y, x[0] = [4,4.5]");
            System.out.println("\nGauss matrix");
            for (int i=0; i<2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(GausMtr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Det = "+det);
            System.out.println("\nReversed Gauss matrix");
            prinMatrix(GausRev(GausMtr));

            double[] f =func(x0[0],x0[1]);
            System.out.println("\nF(x0)= "+f[0]+";"+f[1]);

            f = multMatr(GausRev(GausMtr), func(x0[0],x0[1]));
            System.out.println("\nGausMatr*F(x0)= "+f[0]+";"+f[1]);

            f[0] = f[0]/(-8);
            f[1] = f[1]/(-8);
            System.out.println("\n(GausMatr*F(x0))/DET= "+df.format(f[0])+";"+df.format(f[1]));

            double rez = 2*Math.pow(x[0],2) + 4*x[0]*x[1] +Math.pow(x[1],2) - x[1];

            System.out.print("\nF(X) = "+df.format(rez)+" \n");

            x = minusVect(x0,VectDiv(multMatr(GausRev(GausMtr), func(x0[0],x0[1])),det));
            System.out.print("\nRexult: Xmin = ( "+df.format(x[0]) +" ; "+df.format(x[1])+" )\n");

        }

        static public void prinMatrix(int[][] matrix){
            for (int i=0; i<2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        static public double[] VectDiv(double[] vector, int num){
            for (int i = 0; i < 2; ++i)
                vector[i] = vector[i]/num;
            return vector;
        }
        static public double[] multMatr(int[][]matrix, double[] array) {
            double[] c = {0, 0};
            c[0] = matrix[0][0] * array[0] + matrix[0][1] * array[1];
            c[1] = matrix[1][0] * array[0] + matrix[1][1] * array[1];
            return c;
        }
        static public double[] minusVect(double[] arr1, double[] arr2) {
            double[] c = new double[2];
            for (int i = 0; i < 2; ++i)
                c[i] = arr1[i] - arr2[i];
            return c;
        }
        static public int[][] GausRev(int matrix[][]){
            int[][] revMatr = new int[2][2];
            revMatr[0][0] = matrix[1][1];
            revMatr[0][1] = -matrix[0][1];
            revMatr[1][0] = -matrix[1][0];
            revMatr[1][1] = matrix[0][0];
            return revMatr;
        }
        static public double[] func(double x1, double x2){
            double[] func = new double[2];
            func[0] = 4*x1 + 4*x2;
            func[1] = 4*x1+2*x2-1;
            return func;
        }

}
