package com.sunm.model.iteration;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ProductList extends AbstractObjectList{

    public ProductList(List objects) {
        super(objects);
    }

    @Override
    public AbstractIteration createIteration() {
        return new ProductIteration(this);
    }
}
