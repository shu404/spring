package com.spring3;

public class UserBean {
    private Integer id;
    private String username;
    private String pwd;
    private String birt;
    private String tel;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBirt() {
        return birt;
    }

    public void setBirt(String birt) {
        this.birt = birt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birt='" + birt + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}'+'\n';
    }
}
