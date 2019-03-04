package hjz.dp;

/**
 * @Project: spring
 * @description:    支付方式的一个context
 * @author: sunkang
 * @create: 2018-09-03 11:29
 * @ModificationHistory who      when       What
 **/
public enum  PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    UNION_PAY(new UnionPay());

    private Payment payment ;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return  this.payment;
    }
}