package sample.Entity;

public final class EnemyDecoration {

    private int i;
    private int ce1;

        private int  a ;

        private static final EnemyDecoration e1 = new EnemyDecoration();

        public static EnemyDecoration getEnemy() {
            return e1;
        }

    public void EnemyXMovement(Enemy e) {
            ce1++;
        //System.out.println(ce1);
        // System.out.println(e.getEPosX()+" "+e.getX());
        if (e.getX() > e.getEPosX() + 200) {
            i = -2;
        }
        if (e.getX() <= e.getEPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }

    public void EnemyYMovement(Enemy e) {
        if (e.getY() > e.getEPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getEPosY()) {
            i = 2;
        }
        e.setY(e.getY() + i);
    }
}