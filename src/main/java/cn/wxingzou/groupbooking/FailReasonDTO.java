package cn.wxingzou.groupbooking;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/13 16:43
 **/
public class FailReasonDTO {

    public static final FailReasonDTO AMOUNT_GROUP_OVERSTEP = new FailReasonDTO(100, "账户创建群组数量超出限制！");


    private int code;
    private String msg;

    private FailReasonDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
