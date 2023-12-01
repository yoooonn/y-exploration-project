package top.yooonn.explore.notes.mavendependence.b;

import top.yooonn.explore.notes.mavendependence.a.Helper;
import net.dongliu.commons.lang.Strings;

/**
 * @author yooonn
 */
public class Application {

    public static void main(String[] args) {
        Helper.log("hello");
        String sub = Strings.sub("a", 1);
        System.out.println("sub = " + sub);
    }
}
