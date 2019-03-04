package hjz.dp;

/**
 * @Project: spring
 * @description:  模拟一个订单类
 * @author: sunkang
 * @create: 2018-09-03 11:27
 * @ModificationHistory who      when       What
 **/
public class Order {
    private String uid;
    private  String oid;
    private  double amount;

    public Order(String uid, String oid, double amount) {
        this.uid = uid;
        this.oid = oid;
        this.amount = amount;
    }
    //为订单支付
    public PayState pay(PayType payType){
       return  payType.get().pay(uid,amount);
    }
}