package Wojaro;

public class RootSolver {

    public static double bisekcja(double xl, double xu, double eaMax, int iMax, ScalarFunction f) {
        int y = 1;
        double xrOld = 0;
        double xr=0;
        for (int i = 1; i <= iMax; i++) {
            xr = (xl + xu) / 2;
            double fxr = f.function(xr);
            double fxl = f.function(xl);

            if (fxr * fxl < 0) {
                xu = xr;

            } else if (fxl * fxr > 0) {
                xl = xr;

            } else if (fxl * fxr == 0) {
                xl = xr;
                xu = xr;
            }
            double ea = Math.abs(((xr - xrOld) / xr) * 100);
            if (ea > eaMax) {
                xrOld = xr;
                y++;
            } else {
                break;
            }
        }
        return xr;
    }

    public static double pktStaly(double x0, double eaMax, int maxIter, ScalarFunction f) {
        double xn = 0;


        for (int i = 1; i <= maxIter; i++) {
            xn = f.function(x0) + x0;
            double ea = Math.abs(((xn - x0) / xn) * 100);
            if (ea > eaMax) {
                x0 = xn;
            } else {
                break;
            }
        }
        return xn;
    }

    public static double styczne(double xi, double eaMax, int maxIter, ScalarFunction f, double ekscentrycznosc) {
        double x0 = xi;
        for (int i = 1; i <= maxIter; i++) {

            xi = x0 - (f.function(x0)) / (ekscentrycznosc * Math.cos(x0) - 1);
            double ea = Math.abs(((xi - x0) / xi) * 100);


            if (ea > eaMax) {
                x0 = xi;
            } else {
                break;
            }
        }
        return xi;
    }


    public static double sieczne(double xi, double xj, double eaMax, int maxIter, ScalarFunction f) {

        double xn=0;

        for (int i = 1; i <= maxIter; i++) {
             xn = xi - (f.function(xi) * (xj - xi) / (f.function(xj)-f.function(xi)));
            double ea = Math.abs(((xn - xj) / xn) * 100);


            if (ea > eaMax) {
                xi = xj;
                xj = xn;

            } else {
                break;
            }
        }
        return xn;
    }

}
