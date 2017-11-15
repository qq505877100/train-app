package com.biz.train.enumaration;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:58 2017/11/15
 */
public enum CommonStatusEnum {
    ENABLE(1),DISABLE(0);

    private int value;
    CommonStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEnable() {
        return this.value == 1;
    }
}
