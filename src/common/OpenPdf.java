/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Database.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author PEACE
 */
public class OpenPdf {

    public static void OpenById(String id) {
        try {
            if (new File(InventoryUtils.billPath + id + ".pdf").exists()) {
                // File exists, proceed with logic
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + InventoryUtils.billPath + id + ".pdf");

            } else {
                JOptionPane.showMessageDialog(null, "File is not Exists");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
