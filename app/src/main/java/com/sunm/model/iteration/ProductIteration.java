package com.sunm.model.iteration;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ProductIteration implements AbstractIteration {

    private ProductList productList;
    private List products;
    private int cursor_pre;
    private int cursor_end;

    public ProductIteration(ProductList productList) {
        this.productList = productList;
        products = productList.getObjects();
        cursor_pre = 0;
        cursor_end = products.size() - 1;
    }

    @Override
    public void next() {
        if (cursor_pre < products.size()) {
            cursor_pre++;
        }
    }

    @Override
    public boolean isLast() {
        return cursor_pre == products.size();
    }

    @Override
    public void previous() {
        if (cursor_end > -1) {
            cursor_end--;
        }
    }

    @Override
    public boolean isFirst() {
        return cursor_end == -1;
    }

    @Override
    public Object getNext() {
        return products.get(cursor_pre);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor_end);
    }
}
