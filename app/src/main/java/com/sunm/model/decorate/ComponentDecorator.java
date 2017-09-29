package com.sunm.model.decorate;

/**
 * Created by Administrator on 2017/9/29.
 */

public class ComponentDecorator extends Component {

    private Component mComponent;

    public ComponentDecorator(Component component) {
        this.mComponent = component;
    }

    @Override
    public void display() {
        mComponent.display();
    }
}
