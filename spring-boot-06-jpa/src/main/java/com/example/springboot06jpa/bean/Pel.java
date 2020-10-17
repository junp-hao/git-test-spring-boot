package com.example.springboot06jpa.bean;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity   //告诉JPA这是应该实体类
@Table(name="pel")  //指定与哪个数据表对应;如果省略则默认表名为user
public class Pel {
    @Id//这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name",length = 50) //这是和数据库对应的一个列
    private String lastName;

    @Column  //省略默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
