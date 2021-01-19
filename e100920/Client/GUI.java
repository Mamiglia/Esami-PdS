package e100920.Client;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import e100920.TicketCell.TicketCell;

class GUI extends JFrame {
    private final TicketCell[] cells = new TicketCell[15];
    private JPanel rootPanel;
    private JPanel UpperPart;
    private JTextField ipField;
    private JTextField portField;
    private JButton connectButton;
    private JButton disconnectButton;
    private JPanel sideBar;
    private JTextArea logArea;
    private JPanel bottomPanel;
    private JButton startButton;
    private JButton stopButton;
    private JPanel centerGrid;
    private Act act = new Act(this);

    private boolean connected = false;
    private boolean transmitting = false;

    public GUI() {
        createUIComponents();
        setContentPane(rootPanel);

        connectButton.addActionListener(act);
        disconnectButton.addActionListener(act);
        stopButton.addActionListener(act);
        startButton.addActionListener(act);
        update();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        centerGrid.getComponents()[0].setBackground(Color.RED);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        centerGrid = new JPanel();
        centerGrid.setLayout(new GridLayout(3, 5));
        for (int i = 0; i < 15; i++) {
            TicketCell t = new TicketCell();
            cells[i] = t;
            centerGrid.add(t);
        }

    }

    public List<TicketCell> getCells() {
        List<TicketCell> c = Arrays.asList(cells);
        return c;
    }

    public JTextArea getLogArea() {
        return logArea;
    }

    public String getIP() {
        return ipField.getText();
    }

    public int getPort() {
        return Integer.parseInt(portField.getText());
    }

    public void setStatus(boolean connected, boolean transmitting) {
        this.transmitting = transmitting;
        this.connected = connected;
        update();
    }

    public void reset() {
        for (TicketCell t : cells) {
            t.setSelected(false);
        }
    }


    private void update() {
        if (!connected) {
            connectButton.setEnabled(true);
            disconnectButton.setEnabled(false);
            startButton.setEnabled(false);
            stopButton.setEnabled(false);
        } else if (!transmitting) {
            connectButton.setEnabled(false);
            disconnectButton.setEnabled(true);
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        } else {
            connectButton.setEnabled(false);
            disconnectButton.setEnabled(false);
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        }
    }


}
