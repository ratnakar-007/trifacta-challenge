package com.trifacta.utility;

import com.trifacta.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Util extends Base {
    /**
     * Get screenshot and capture as Base64
     * @name captureAsBase64
     * @return String
     */
    public static String captureAsBase64()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    /**
     * Get screenshot and return its path
     * @name getScreenshot
     * @return String
     */
    public static String getScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationLoc = System.getProperty("user.dir")+ "\\screenshots\\" +
                System.currentTimeMillis() + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(destinationLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(destinationLoc);
        return destinationLoc;
    }
}
