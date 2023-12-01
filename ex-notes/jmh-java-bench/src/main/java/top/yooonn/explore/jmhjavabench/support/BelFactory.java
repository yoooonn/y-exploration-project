package top.yooonn.explore.jmhjavabench.support;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.tranquil.core.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yooonn
 * @date 2021.01.23
 */
@Slf4j
public class BelFactory {

    /**
     * 匹配bel表达式
     * <p>
     * 最简单形式
     * ${happy}
     */
    public static final Pattern PATTERN1        = Pattern.compile("^\\$\\{([\\w ]+)\\}");
    /**
     * ${happy|00-00-00 00:00:00}等
     */
    public static final Pattern PATTERN2        = Pattern.compile("^\\$\\{([\\w ]+)\\|([\\w\\-: ]+)\\}$");
    /**
     * ${arr:arr_alias}
     */
    public static final Pattern PATTERN3        = Pattern.compile("^\\$\\{([\\w]+):([\\w ]+)\\}$");
    private final       String  BEL_PREFIX      = "${";
    private final       String  BEL_SUFFIX      = "}";
    private final       String  STRING          = "string";
    private final       String  INTEGER         = "integer";
    private final       String  LONG            = "long";
    private final       String  DOUBLE          = "double";
    private final       String  NEW_JSON_OBJECT = "new JSONObject";
    private final       String  NEW_JSON_ARRAY  = "new JSONArray";
    private final       String  NEW_DATE        = "new Date";
    private final       String  TIMESTAMP       = "timestamp";

    public static void main(String[] args) {
        /*log.info("judge(\"${a|b}\") = {}", judge("${a|b}"));
        log.info("judge(\"${aa_bb}\") = {}", judge("${aa_bb}"));
        log.info("judge(\"${new JSONArray}\") = {}", judge("${new JSONArray}"));
        log.info("judge(\"${new JSONObject}\") = {}", judge("${new JSONObject}"));
        log.info("judge(\"${new Date|2021-01-25 11:59:34}\") = {}", judge("${new Date|yyyy-MM-dd hh:mm:ss}"));
        log.info("judge(\"${new Date|Long}\") = {}", judge("${new Date|Long}"));
        log.info("judge(\"${lat|Double}\") = {}", judge("${lat|Double}"));
        log.info("judge(\"${bike_sn|String}\") = {}", judge("${bike_sn|String}"));*/
    }

    public Bel newInstance(String belFormatString) {
        Bel bel = parse(belFormatString);
        return bel;
    }

    public boolean hasBelFormat(String string) {
        String trim = string.trim();
        if (StringUtils.isEmpty(trim)) {
            return false;
        }
        return trim.startsWith(this.BEL_PREFIX) && trim.endsWith(BEL_SUFFIX);
    }

    public Bel parse(String belFormatString) {
        if (StringUtils.isEmpty(belFormatString)) {
            return null;
        }
        if (!hasBelFormat(belFormatString)) {
            return null;
        }
        Bel semiBel = new Bel();
        semiBel.setOriginal(belFormatString);
        // log.debug("belFormatString = {}", belFormatString);
        Matcher matcher = PATTERN1.matcher(belFormatString.trim());
        if (matcher.matches()) {
            return resolvePattern1(matcher, semiBel);
        }
        matcher = PATTERN2.matcher(belFormatString.trim());
        if (matcher.matches()) {
            return resolvePattern2(matcher, semiBel);
        }
        matcher = PATTERN3.matcher(belFormatString.trim());
        if (matcher.matches()) {
            return resolvePattern3(matcher, semiBel);
        }
        return null;
    }

    /**
     * {@link BelFactory#PATTERN1}
     * <p>
     * 这种模式的bel是{@code a}，只有一个group，且值类型是采用默认或value pool对应值类型
     *
     * @param matcher matcher
     * @param semiBel bel半成品
     * @return bel
     */
    private Bel resolvePattern1(Matcher matcher, Bel semiBel) {
        String gp1 = matcher.group(1);
        if (StringUtils.isEmpty(gp1)) {
            log.error("groups matched by regex expression PATTERN2 in state unexpected.");
            throw new IllegalStateException("groups matched by regex expression in state unexpected.");
        }
        semiBel.setVariable(gp1);
        // 是否常量
        if (judgedConstant(gp1, semiBel)) {
            return semiBel;
        }
        if (NEW_DATE.equalsIgnoreCase(gp1)) {
            semiBel.set(System.currentTimeMillis(), BelTypeEnum.TIMESTAMP_LONG, false);
            return semiBel;
        }
        if (TIMESTAMP.equalsIgnoreCase(gp1)) {
            semiBel.set(System.currentTimeMillis(), BelTypeEnum.TIMESTAMP_LONG, false);
            return semiBel;
        }

        semiBel.setType(BelTypeEnum.OBJECT);
        semiBel.setAccessPool(true);
        return semiBel;
    }

    /**
     * {@link BelFactory#PATTERN2}
     * <p>
     * 这种模式是{@code a|b}，共两组，a为常量或可以立即赋值的量，b为最终的类型。
     *
     * @param matcher matcher
     * @param semiBel bel半成品
     * @return bel
     */
    private Bel resolvePattern2(Matcher matcher, Bel semiBel) {
        String gp1 = matcher.group(1);
        String gp2 = matcher.group(2);
        if (StringUtils.isEmpty(gp1) || StringUtils.isEmpty(gp2)) {
            log.error("groups matched by regex expression PATTERN2 in state unexpected.");
            throw new IllegalStateException("groups matched by regex expression in state unexpected.");
        }
        semiBel.setVariable(gp1);
        // 是否常量
        if (judgedConstant(gp1, semiBel)) {
            return semiBel;
        }

        if (NEW_DATE.equalsIgnoreCase(gp1)) {
            String dateString;
            try {
                dateString = DateUtil.format(new Date(), gp2);
            } catch (Exception e) {
                log.error("date pattern in Bel is error.");
                throw new IllegalArgumentException("date pattern in Bel is error.", e);
            }
            semiBel.set(dateString, BelTypeEnum.NOW_STRING, false);
            return semiBel;
        }
        if (TIMESTAMP.equalsIgnoreCase(gp1)) {
            if (LONG.equalsIgnoreCase(gp2)) {
                semiBel.set(System.currentTimeMillis(), BelTypeEnum.TIMESTAMP_LONG, false);
                return semiBel;
            }
            if (STRING.equalsIgnoreCase(gp2)) {
                semiBel.set(System.currentTimeMillis() + "", BelTypeEnum.TIMESTAMP_STRING, false);
                return semiBel;
            }
        }

        // need access pool to get value and cast the value
        if (INTEGER.equalsIgnoreCase(gp2)) {
            semiBel.set(null, BelTypeEnum.INTEGER, true);
            return semiBel;
        }
        if (LONG.equalsIgnoreCase(gp2)) {
            semiBel.set(null, BelTypeEnum.LONG, true);
            return semiBel;
        }
        if (DOUBLE.equalsIgnoreCase(gp2)) {
            semiBel.set(null, BelTypeEnum.DOUBLE, true);
            return semiBel;
        }
        if (STRING.equalsIgnoreCase(gp2)) {
            semiBel.set(null, BelTypeEnum.STRING, true);
            return semiBel;
        }

        semiBel.setType(BelTypeEnum.OBJECT);
        semiBel.setAccessPool(true);
        return semiBel;
    }

    /**
     * {@link BelFactory#PATTERN1}
     * <p>
     * 这种模式是为json数组类型的变量映射别名准备的。比如{@code a:b}，则表示，b是a在value pool中的别名，从value pool中取值时，使用get(b)；约定这种模式.
     * <pre>
     *     bel.setVariable(b);
     *     bel.setValue(a);
     *     bel.setType("string")
     *     bel.setAccessPool(true);
     * </pre>
     * <p>
     * 表示实际值为a，它的类型是String，但变量是b，需要向pool取值.
     *
     * @param matcher matcher
     * @param semiBel bel半成品
     * @return bel
     */
    private Bel resolvePattern3(Matcher matcher, Bel semiBel) {
        String gp1 = matcher.group(1);
        String gp2 = matcher.group(2);
        if (StringUtils.isEmpty(gp1) || StringUtils.isEmpty(gp2)) {
            log.error("groups matched by regex expression PATTERN2 in state unexpected.");
            throw new IllegalStateException("groups matched by regex expression in state unexpected.");
        }
        semiBel.setVariable(gp2);
        semiBel.setValue(gp1);
        semiBel.setType(BelTypeEnum.STRING);
        semiBel.setAccessPool(true);
        return semiBel;
    }

    /**
     * 是否常量，是则赋值
     *
     * @param gp1
     * @param semiBel
     * @return
     */
    private boolean judgedConstant(String gp1, Bel semiBel) {
        if (NEW_JSON_OBJECT.equalsIgnoreCase(gp1)) {
            semiBel.set(new JSONObject(), BelTypeEnum.EMPTY_OBJECT, false);
            return true;
        }
        if (NEW_JSON_ARRAY.equalsIgnoreCase(gp1)) {
            semiBel.set(new JSONArray(), BelTypeEnum.EMPTY_ARRAY, false);
            return true;
        }
        return false;
    }
}
