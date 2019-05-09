package cn.wangcaitao.common.util;

import cn.wangcaitao.common.constant.IntegerConstant;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 金额工具类
 *
 * @author wangcaitao
 */
public class AmountUtils {

    private static final String[] UNIT = {"万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分"};
    private static final String[] NUM = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    /**
     * 将金额转换成中文大写金额(精度到分)
     *
     * @param lowerAmount lowerAmount
     * @return 中文大写金额
     */
    public static String toUpper(BigDecimal lowerAmount) {
        lowerAmount = lowerAmount.multiply(BigDecimal.valueOf(100L)).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (Objects.equals(BigDecimal.ZERO, lowerAmount)) {
            return "零元整";
        }

        String lowerAmountStr = lowerAmount.toString();
        int unitIndex = UNIT.length - lowerAmountStr.length();
        boolean isZero = false;
        StringBuilder result = new StringBuilder();
        for (int numIndex = 0; numIndex < lowerAmountStr.length(); numIndex++, unitIndex++) {
            char num = lowerAmountStr.charAt(numIndex);
            if (Objects.equals('0', num)) {
                isZero = true;
                if (UNIT[unitIndex].equals(UNIT[4]) || UNIT[unitIndex].equals(UNIT[0]) || UNIT[unitIndex].equals(UNIT[12])) {
                    result.append(UNIT[unitIndex]);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    result.append("零");
                    isZero = false;
                }
                result.append(NUM[Integer.parseInt(String.valueOf(num))]).append(UNIT[unitIndex]);
            }
        }

        if (!result.toString().endsWith(UNIT[IntegerConstant.TEN + IntegerConstant.THREE]) && !result.toString().endsWith(UNIT[IntegerConstant.TEN + IntegerConstant.FOUR])) {
            result.append("整");
        }

        result = new StringBuilder(result.toString().replaceAll("亿万", "亿"));

        return result.toString();
    }

}
