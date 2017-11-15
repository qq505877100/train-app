package com.biz.train.po.basePo;

import java.io.Serializable;

public interface Identifiable<ID> extends Serializable {

    ID getId();

    void setId(ID id);
}
