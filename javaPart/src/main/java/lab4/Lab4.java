package lab4;

public class Lab4 {
    public static double func(double x, double y)    {
        double f = Math.pow(x, 2) + 4 * x*y + 2 * Math.pow(y, 2) - 6 * x - 8 * y;
        return f;    }

    public static double[][] research(double[][]basic, double step, int N, int i)    {
        if (func(basic[i][0]+step,basic[i][1]) < func(basic[i][0],basic[i][1]))        {
            basic[i+1][0] = basic[i][0]+step;         }
        else        {
            if (func(basic[i][0]-step,basic[i][1]) < func(basic[i][0],basic[i][1]))            {
                basic[i+1][0] = basic[i][0]-step;            }
            else {
                basic[i+1][0] = basic[i][0];            }        }
        if(func(basic[i+1][0],basic[i][1]+step) < func(basic[i+1][0],basic[i][1]))        {
            basic[i+1][1] = basic[i][1]+step;        }
        else        {
            if(func(basic[i+1][0],basic[i][1]-step) < func(basic[i+1][0],basic[i][1]))            {
                basic[i+1][1] = basic[i][1]-step;            }
            else {
                basic[i+1][1] = basic[i][1];            }        }
        return new double[][] {{basic[0][0], basic[0][1]},
                {basic[1][0], basic[1][1]}};    }

    public static double[] researchExample(double[][] P, double [][] basic, double step, int N, int i){
        research(basic, step, N, i);
        System.out.println("\tP (" + P[i][0] + "; " + P[i][1]+ ")");
        research(P, step, N, i);
        return new double[] {P[i][0], P[i][1]};    }

    public static void main(String[] args)    {
        final int N = 1;
        double step = 20;
        double eps = 0.1;
        double[][] basic = new double[10000][N+1];
        double[][] P = new double[10000][N+1];
        int i=1;
        basic[i][0] = 0;
        basic[i][1] = 0;
        do {
            func(basic[i][0], basic[i][1]); // значення функції в базисній точці
            System.out.println("Функція f(b" + i +") при (" + basic[i][0] + "; " + basic[i][1] + "): " + func(basic[i][0], basic[i][1]));
            System.out.println("....................................");
            System.out.println("\tВиконуємо дослідження");
            do {
                step = step*0.1;
                System.out.println("\tstep = " + step);
                research(basic, step, N, i);
            } while (basic[i+1][0] != basic[i][0] && basic[i+1][1] != basic[i][1]);
            System.out.println("\nФункція f(b" + (i+1) +") при (" + basic[i+1][0] + "; " + basic[i+1][1] + "): " + func(basic[i+1][0], basic[i+1][1]));
            basic[i][0] = basic[i+1][0];
            basic[i][1] = basic[i+1][1];
            System.out.println("\n\tКрок пошуку за зразком");
            P[i][0] =basic[i][0]+2*(basic[i+1][0]-basic[i][0]);
            P[i][1] =basic[i][1]+2*(basic[i+1][1]-basic[i][1]);
            researchExample(P, basic, step, N, i);
            do {
                basic[i+2][0] = P[i][0];
                basic[i+2][1] = P[i][1];
                i++;
                System.out.println("\t i = " + i);
                researchExample(P, basic, step, N, i);
            } while (func(P[i][0], P[i][1]) < func(basic[i+1][0], basic[i+1][1]));
            System.out.println("\nФункція f(P" + i +") при (" + P[i][0] + "; " + P[i][1] + "): " + func(P[i][0], P[i][1]));
            research(basic, step, N, i);
            System.out.println("\tstep = " + step);
        } while (step>eps);
        System.out.println("\n\nРозв'язок: (" + basic[i][0] + "; " + basic[i][1] + ")");
        System.out.println("Функція f(b" + i +") при (" + basic[i][0] + "; " + basic[i][1] + "): " + func(basic[i][0], basic[i][1]));
    }
}
