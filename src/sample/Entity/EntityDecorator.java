package sample.Entity;
/**
* Decorates Entities
*/


public abstract class EntityDecorator implements Entity {

    protected Entity decoratedEntity;
    private int ED;

    public EntityDecorator(Entity decoratedEntity) {
        this.decoratedEntity = decoratedEntity;
        ED++;
        System.out.println("ED"+ED);
    }

    public void RenderEntity(){
        decoratedEntity.RenderEntity();
    }
}
