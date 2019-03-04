package hjz.dp;

/**
 * @Project: spring
 * @description:  策略模式测试
 * @author: sunkang
 * @create: 2018-09-03 11:33
 * @ModificationHistory who      when       What
 **/
public class StrategyPatternTest {

    public static void main(String[] args) {
       Order order = new Order("1","order101",43.23);

        //比如选择阿里支付
       PayState payState =  order.pay(PayType.ALI_PAY);
       System.out.println(payState);
    }
}