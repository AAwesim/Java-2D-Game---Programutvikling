package sample.Entity;

public final class Enemy2 {

    private int i;
    private int ce2;

    private int a;

    private static final Enemy2 e2 = new Enemy2();

    public static Enemy2 getEnemy() {
        return e2;
    }


    public void Enemy2Movement(Enemy e) {
        ce2++;
       // System.out.println(e);
     //   System.out.println(e.getEPosY() + " " + e.getX());
        if (e.getY() > e.getEPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getEPosY()) {
            i = 2;
        }
        e.setY(e.getY() + i);
    }
}

/*public class Enemy2 extends Enemy {

    private static int width = 35;
    private static int height = 35;
    private double EPosX;
    private double EPosY;
    private int i;
    private int j = 0;
    private boolean a = true;

    public static ArrayList<Enemy> E1List = new ArrayList<>();
   /* public Enemy2(double EPosX, double EPosY, Pane p) {
        System.out.println("ENEMY1 EPosX "+EPosX);
        System.out.println("ENEMY1 EPosY "+EPosY);
        setEPosX(EPosX);
        setX(EPosX);
        setEPosY(EPosY);
        setY(EPosY);
        //   this.setFill(Color.RED);
        this.setWidth(width);
        this.setHeight(height);
        E1List.add(this);
        p.getChildren().add(this);
    }

    /*public int Enemy2Movement() {
        if (getY()>getEPosY()+200){i=-2;}
        if (getY()<=getEPosY()){i=2;}
        return (int) (getX()+i);
    }*/ /*

      /*  public void initEnemy(Pane p) {
        this.setHeight(30);
        this.setWidth(30);
        setX(EPosX);
        setY(EposY);
        p.getChildren().add(this);
    }
}*/