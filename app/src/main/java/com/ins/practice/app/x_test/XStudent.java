package com.ins.practice.app.x_test;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2018/1/30.
 */
@Table(name = "x_student")
public class XStudent {
    @Column(name = "x_name")
    private String name;
    @Column(name = "id",isId = true,autoGen = true)
    private int id;

    public XStudent(String name) {
        this.name = name;
    }

    public XStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
