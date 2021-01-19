package e100920.TicketCell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicketCell extends JPanel {
    private static ArrayList<Integer> NUMBERS;
    private JLabel label = new JLabel("50");

    //private JLabel label = new JLabel(String.valueOf(getRandomNumber()));
    private boolean selected = false;

    public TicketCell() {
        setLayout(new GridLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label);
        setOpaque(false);
    }

    public int getValue() {
       return Integer.parseInt(label.getText());
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
        String s = label.getText();
        remove(getComponent(0));
        label = new JLabel("30");
        if (this.selected) {
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.YELLOW);
        }
        add(label);
    }

    public boolean isSelected() {
        return selected;
    }

    private static int getRandomNumber() {
        if (NUMBERS == null) {
            NUMBERS = new ArrayList<>();
            for (int i=1; i<=90; i++) {
                NUMBERS.add(i);
            }
        }
        int res = NUMBERS.get((int) (Math.random() * NUMBERS.size()));
        NUMBERS.remove((Integer) res);
        return res;
    }

}
