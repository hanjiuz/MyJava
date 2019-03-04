package hjz.dp;

/**
 * @Project: spring
 * @description:   银联闪付的实现
 * @author: sunkang
 * @create: 2018-09-03 11:26
 * @ModificationHistory who      when       What
 **/
public class UnionPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎来到银联闪付");
        System.out.println("开始查询余额，开始扣款");
        return new PayState(200,"支付成功",uid,amount);
    }
}