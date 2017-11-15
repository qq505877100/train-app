package com.biz.train.po;

import com.biz.train.enumaration.CommonStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:34 2017/11/15
 */
@Entity
@Table(name = "adm_admin")
public class Admin implements UserDetails,Serializable {

    private static final long serialVersionUID = -4877271072444358347L;

    /**
     * 用户名
     */

    @Id
    @Column(length = 20, nullable = false, unique = true)
    @NotNull( message = "用户名不能为空")
    @NotBlank( message = "用户名不能为空")
    private String username;

    /**
     * 密码
     * before:, nullable = false
     * after:删除了这个参数
     */
    @Column(length = 200)
    private String password;

    /**
     * 名字
     */
    @Column(length = 50, nullable = false)
    private String name;

    /**
     * 联系电话
     */
    @Column(length = 50)
    private String phone;

    /**
     * 工号
     */
    @Column(name = "emp_no")
    private String empNo;


    @Column
    private String department;
    /**
     * 状态
     */
    @Column
    @Enumerated(EnumType.STRING)
    private CommonStatusEnum status = CommonStatusEnum.ENABLE;

    /**
     * 所拥有的权限
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "adm_admin_role", joinColumns = {
            @JoinColumn(name = "username", referencedColumnName = "username")}, inverseJoinColumns = {
            @JoinColumn(name = "roleId", referencedColumnName = "id")}, uniqueConstraints = {
            @UniqueConstraint(columnNames = {"username", "roleId"})})
    private List<Role> roles;



    /**
     * 菜单
     */
    @Transient
    private List<Menu> menus;

    @Column
    private Date createDate;

    @Column(length = 50)
    private String createBy;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (roles != null) {
            roles.forEach(role -> {
                role.getMenuItems().forEach(menuItem -> {
                    if (StringUtils.isNotBlank(menuItem.getSymbol())) {
                        String[] roleSymbol = menuItem.getSymbol().split("[^\\w_]+");
                        Arrays.stream(roleSymbol).forEach(symbol -> authorities.add(new AdminAuthority(symbol)));
                    }
                });

                role.getResources().forEach(resource -> {
                    if (StringUtils.isNotBlank(resource.getSymbol())) {
                        String[] roleSymbol = resource.getSymbol().split("[^\\w_]+");
                        Arrays.stream(roleSymbol).forEach(symbol -> authorities.add(new AdminAuthority(symbol)));
                    }
                });
            });
            System.out.println(" auth size:" + authorities.size());
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status.isEnable();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
