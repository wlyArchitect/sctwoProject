package com.wh.sys.entity;

public class Menu {
    private Integer id;

    private Integer pid;

    private String href;

    private String title;

    private Integer spread;

    private String icon;

    private Integer available;

    public Menu() {
    }

    public Menu(Integer id, Integer pid, String href, String title, Integer spread, String icon, Integer available) {
        this.id = id;
        this.pid = pid;
        this.href = href;
        this.title = title;
        this.spread = spread;
        this.icon = icon;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}