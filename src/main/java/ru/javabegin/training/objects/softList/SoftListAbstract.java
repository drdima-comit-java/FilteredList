package ru.javabegin.training.objects.softList;

import ru.javabegin.training.objects.User;

import java.util.Date;

public abstract class SoftListAbstract {

    private int idbl;
    private User user;
    private String listName;
    private String listContent;
    private Date listDate;





    public SoftListAbstract() {
        this.listDate = new Date();
    }

    public int getIdbl() {
        return idbl;
    }

    public void setIdbl(int idbl) {
        this.idbl = idbl;
    }

    public User getUser() {
        return user;
    }
    public int getUserId() {
        return user.getIduser();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserId(int iduser)
    {
        User user = new User(iduser);
        this.setUser(user);
    }



    public Date getListDate() {
        return listDate;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListContent() {

        try {
            return listContent.replaceAll("\\s+\n", "\n").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setListContent(String listContent) {
        this.listContent = listContent;
    }
}
