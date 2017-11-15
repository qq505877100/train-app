package com.biz.train.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
@Entity
public class Menu implements Serializable {
    private static final long serialVersionUID = -6109507380556898319L;

    @Id
    private Long id;

    @Column(length = 90,nullable = true)
    private String name;
    @Column(length = 90,nullable = true)
    private String url;
    @Column(length = 90,nullable = true)
    private String icon = "fa fa-list";
    @Column(length = 90,nullable = true)
    private String viewName;

    public Menu(){}

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }



    public Menu(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }
    public Menu(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
