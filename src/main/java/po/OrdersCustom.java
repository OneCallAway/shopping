package po;

/**
 * @author OneCallAway
 * @create 2018-03-28 下午2:29
 * @desc 订单扩展类
 **/

//通过此扩展类映射订单和用户查询的结果，让此类继承字段较多的pojo类
public class OrdersCustom extends Orders{
     //添加用户属性
    private String username;
    private String sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

