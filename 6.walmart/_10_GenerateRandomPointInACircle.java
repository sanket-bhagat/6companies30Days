package _6_walmart;

public class _10_GenerateRandomPointInACircle {
	
	double RAD, XC, YC;

    public _10_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        RAD = radius;
        XC = x_center;
        YC = y_center;
    }

    public double[] randPoint() {
        double ang = Math.random() * 2 * Math.PI,
                hyp = Math.sqrt(Math.random()) * RAD,
                adj = Math.cos(ang) * hyp,
                opp = Math.sin(ang) * hyp;
        return new double[]{XC + adj, YC + opp};
    }

    public static void main(String[] args) {
        double radius = 1.0, x_center = 0.0, y_center = 0.0;
        _10_GenerateRandomPointInACircle obj = new _10_GenerateRandomPointInACircle(radius, x_center, y_center);
        double[] param_1 = obj.randPoint();
        for(double i : param_1) {
            System.out.print(i + " ");
        }
    }


}
