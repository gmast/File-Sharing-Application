/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class HackBorder {

    public void setBorder(JComponent comp, String title, int fontSize, int emptyBorderWidth) {
        comp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                null, title, TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Serief", Font.BOLD, fontSize), new Color(0, 150, 255)),
                BorderFactory.createEmptyBorder(emptyBorderWidth, emptyBorderWidth, emptyBorderWidth, emptyBorderWidth)));
    }

    public void setBorder(JComponent comp, String title, int titleJustification, String fontName, int fontStyle, int fontSize, int emptyBorderWidth) {
        comp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                null, title, titleJustification, TitledBorder.TOP,
                new Font(fontName, fontStyle, fontSize), new Color(0, 150, 255)),
                BorderFactory.createEmptyBorder(emptyBorderWidth, emptyBorderWidth, emptyBorderWidth, emptyBorderWidth)));
    }

    public void setMainBorder(JComponent comp, String title, int fontSize, int emptyBorderWidth) {
        comp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                null, title, TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Serif", Font.PLAIN, fontSize), new Color(0, 150, 255)),
//                new Color(196, 251, 174)),
                BorderFactory.createEmptyBorder(emptyBorderWidth, emptyBorderWidth, emptyBorderWidth, emptyBorderWidth)));
    }
}
