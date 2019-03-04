package hjz.dp;

/**
 * @Project: spring
 * @description:    支付方式的接口
 * @author: sunkang
 * @create: 2018-09-03 11:14
 * @ModificationHistory who      when       What
 **/
public interface Payment {
    /**
     *
     * @param uid   表示人的uid
     * @param amount  表示支付的金额
     * @return
     */
    PayState pay(String uid, double amount);

}