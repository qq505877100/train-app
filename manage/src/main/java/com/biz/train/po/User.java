package com.biz.train.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 15:43 2017/11/15
 */
@Entity
@Table(name = "test1")
public class User {
    @Id
    private int id;
    @Column(length = 30)
    private String name;
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
