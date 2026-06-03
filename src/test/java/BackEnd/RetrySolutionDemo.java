package BackEnd;

import org.checkerframework.checker.guieffect.qual.UI;
import org.template.framework.Utility.ConfigManager;
import org.template.framework.Utility.Enums.APIConfig;
import org.template.framework.Utility.Enums.DBConfig;
import org.template.framework.Utility.Enums.FrameWorkConfig;
import org.template.framework.Utility.Enums.UIConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RetrySolutionDemo {

    public static void main(String[] args) {
        System.setProperty("env","qa");
        System.out.println(ConfigManager.get(APIConfig.PAYMENT_BASE_PATH));
        System.out.println(ConfigManager.get(APIConfig.PRODUCT_BASE_PATH));
        System.out.println(ConfigManager.get(APIConfig.PAYMENT_BASE_URL));
        System.out.println(ConfigManager.get(APIConfig.PRODUCT_BASE_URL));
        System.out.println(ConfigManager.get(APIConfig.BASE_URL));
        System.out.println(ConfigManager.get(APIConfig.RELAXED_HTTPS));
        System.out.println(ConfigManager.get(APIConfig.TIMEOUT_MS));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(ConfigManager.get(UIConfig.BASE_URL));
        System.out.println(ConfigManager.get(UIConfig.BROWSER));
        System.out.println(ConfigManager.get(UIConfig.HEADLESS));
        System.out.println(ConfigManager.get(UIConfig.IMPLICIT_WAIT_SEC));
        System.out.println(ConfigManager.get(UIConfig.PAGE_LOAD_TIMEOUT_SEC));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(ConfigManager.get(DBConfig.URL));
        System.out.println(ConfigManager.get(DBConfig.USERNAME));
        System.out.println(ConfigManager.get(DBConfig.PASSWORD));


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}