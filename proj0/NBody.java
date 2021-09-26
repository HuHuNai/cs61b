import java.util.Scanner;

public class NBody {
    public static  double readRadius(String path){
        In in =new In(path);
        in.readInt();
        return  in.readDouble();
    }
    public static Planet[] readPlanets(String path){
        In in=new In(path);
        int n=in.readInt();
        in.readDouble();
        Planet[] planets=new Planet[n];
        for (int i=0;i<n;i++){
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double m=in.readDouble();
            String f=in.readString();
            planets[i]=new Planet(xP,yP,xV,yV,m,f);
        }
        return planets;
    }

    public static void main(String[] args){
        double t =Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        In in = new In(filename);
        int n=in.readInt();
        double radius =readRadius(filename);
        Planet[] planets=readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        double t0=0;
        while (t0<t) {
            Double[] xForce = new Double[n];
            Double[] yForce = new Double[n];
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < n; i++) {
                Planet p = planets[i];
                xForce[i] = p.calcNetForceExertedByX(planets);
                yForce[i] = p.calcNetForceExertedByX(planets);
                p.update(10000,xForce[i],yForce[i]);
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(1);
            t0 += dt;
        }
    }

}
