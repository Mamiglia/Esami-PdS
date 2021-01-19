package e151020.Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Sender  implements Runnable {
    // si occupa solamente di inviare al client le coppie di numeri
    private final ArrayList<Integer> indexList = new ArrayList<>();
    private final PrintWriter output;
    private File imageX;
    public boolean interrupted = false;

    public Sender(PrintWriter output, String imageX) {
        this.output = output;
        for (int i=0;i<5;i++) {
            indexList.add(i);
        }
        this.imageX = new File(imageX);

    }

    @Override
    public void run() {
        if (!imageX.exists()) {
            output.println("File not found");
            output.flush();
            return;
        }
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader(imageX));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (scan.hasNextLine() && !interrupted) {
            output.println(scan.nextLine());
            output.flush();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (interrupted) {
            output.println("INTERRUPTED");
            output.flush();
            System.out.println("Forced termination sent");
        } else {
            output.println("END");
            output.flush();
            System.out.println("Ending sent");
        }
    }
}
