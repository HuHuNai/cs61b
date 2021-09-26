public class Planet {
    double xxPos, yyPos,xxVel,yyVel,mass;
    String imgFileName;
    static final double G=6.67e-11;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos =xP;
        yyPos =yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    public Planet(Planet p){
        this.xxPos =p.xxPos;
        this.yyPos =p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dis,square;
        double dx=this.xxPos -p.xxPos;
        double dy=this.yyPos -p.yyPos;
        square=dx*dx+dy*dy;
        dis=Math.sqrt(square);
        return dis;
    }

    public double calcForceExertedBy(Planet p){
        double dis = this.calcDistance(p);
        double square=dis*dis;
        double f=G*this.mass*p.mass/square;
        return f;
    }

    public double calcForceExertedByX(Planet p){
        double r=this.calcDistance(p);
        double dx=p.xxPos -this.xxPos;
        double fx=this.calcForceExertedBy(p)*dx/r;
        return fx;
    }

    public double calcForceExertedByY(Planet p){
        double r=this.calcDistance(p);
        double dy=p.yyPos -this.yyPos;
        double fy=this.calcForceExertedBy(p)*dy/r;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double nfx=0;
        for(Planet p:allPlanets){
            if (p!=this){
            nfx+=this.calcForceExertedByX(p);
            }
        }
        return nfx;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double nfy=0;
        for(Planet p:allPlanets){
            if (p!=this){
                nfy += this.calcForceExertedByY(p);
            }
            else {
                continue;
            }
        }
        return nfy;
    }

    public void update(double dt,double fx,double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
        this.xxVel+=ax*dt;
        this.yyVel+=ay*dt;
        this.xxPos +=this.xxVel*dt;
        this.yyPos +=this.yyVel*dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}
