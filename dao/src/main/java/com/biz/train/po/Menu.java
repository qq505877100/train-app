package com.biz.train.po;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private static final long serialVersionUID = -6109507380556898319L;

    private Long id;

    private String name;

    private String url;

    private String icon = "fa fa-list";

    private List<Menu> children;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    private String viewName;

    public Menu(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }
    public Menu(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
    public Menu(String name, String icon, List<Menu> children) {
        this(name,icon);
        this.children = children;
    }
    public Menu(String name, String icon, List<Menu> children, String viewName) {
        this(name, icon);
        this.children = children;
        this.viewName = viewName;
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

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        if (getName() != null ? !getName().equals(menu.getName()) : menu.getName() != null)
            return false;
        if (getUrl() != null ? !getUrl().equals(menu.getUrl()) : menu.getUrl() != null)
            return false;
        if (getIcon() != null ? !getIcon().equals(menu.getIcon()) : menu.getIcon() != null)
            return false;
        return getChildren() != null ? getChildren().equals(menu.getChildren()) : menu.getChildren() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getIcon() != null ? getIcon().hashCode() : 0);
        result = 31 * result + (getChildren() != null ? getChildren().hashCode() : 0);
        return result;
    }
}
