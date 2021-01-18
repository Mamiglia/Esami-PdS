import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BoardButton extends JToggleButton {
    private boolean mine = false;
    private int adjacentMines = 0;

    BoardButton() {
        super("", true);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reveal();
                }
        });
    }

    private void reveal() {
        setEnabled(false);
        if (mine) {
            setText("X");
            setBackground(Color.RED);
        } else {
            setText(String.valueOf(adjacentMines));
            setBackground(Color.CYAN);
        }
    }

    @Override
    public void setSelected(boolean b) {
        if (b) {
            reveal();
        } else {
            reset();
        }
    }

    public boolean isSelected() {
        return !getText().equals("");
    }

    void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    int getAdjacentMineCounts() {
        return adjacentMines;
    }

    public boolean hasMine() {
        return mine;
    }

    void setMine(boolean mine) {
        this.mine = mine;
    }

    void reset() {
        super.setSelected(true);
        setEnabled(true);
        setText("");
        setMine(false);
        setAdjacentMines(0);
        setBackground(Color.LIGHT_GRAY);
    }
}
