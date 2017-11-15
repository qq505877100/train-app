package com.biz.train.po;

import com.biz.train.enumaration.CommonStatusEnum;
import com.biz.train.po.basePo.BasePO;
import com.biz.train.po.basePo.Identifiable;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员角色
 *
 * @author david-liu
 * @date 2017年04月07日
 * @reviewer
 */
@Entity
@Table(name = "adm_role")
public class Role extends BasePO<Long> implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 2033192329314085870L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotNull(message = "名称不能为空")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "adm_role_menuitem",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menuitem_id", referencedColumnName = "id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "menuitem_id"})})
    @Where(clause = "status='ENABLE'")
    private List<MenuItem> menuItems;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "adm_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "resource_id"})})
    @Where(clause = "status='ENABLE'")
    private List<Resource> resources;



    @Column
    @Enumerated(EnumType.STRING)
    private CommonStatusEnum status= CommonStatusEnum.ENABLE;

    public Role() {

    }

    public Role(Long id, String name, String description, List<MenuItem> menuItems, List<Resource> resources) {
        setId(id);
        this.name = name;
        this.description = description;
        this.menuItems = menuItems;
        this.resources = resources;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        if (!menuItems.contains(menuItem)) {
            menuItems.add(menuItem);
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuItem> getMenuItems() {
//
//        for(Iterator<MenuItem> it = menuItems.iterator(); it.hasNext();){
//            if(it.next().getName().equals("主页导航")){
//                it.remove();
//            }
//        }
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
