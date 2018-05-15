package sample.Entity;
/**
* Decorates Entities
*/

public abstract class EntityDecorator implements Entity {

    protected Entity decoratedEntity;

    public EntityDecorator(Entity decoratedEntity) {
        this.decoratedEntity = decoratedEntity;
    }

    public void RenderEntity(){
        decoratedEntity.RenderEntity();
    }
}
