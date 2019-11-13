package cn.wxingzou.groupbooking;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 17:02
 **/
public class User {

    private Long id;
    private String userName;

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
