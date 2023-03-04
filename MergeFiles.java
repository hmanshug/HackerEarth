package dummypkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class SharedInteger {
    private boolean available = false;
    public File processingFile;
    public Byte vectorBytes;

    SharedInteger() {
    }

    public synchronized Byte get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notify();
        return vectorBytes;
    }

    public synchronized void put(Byte value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        vectorBytes = value;
        available = true;
        notify();
    }
}

class Producer extends Thread {
    private SharedInteger sharedInteger;

    public Producer(SharedInteger c) {
        sharedInteger = c;
    }

    public void run() {
        FileInputStream fis = null;
        Vector<Byte> vectorBytes = new Vector<Byte>();
        try {
            fis = new FileInputStream(sharedInteger.processingFile);
            while (fis.available() != 0) {
            	sharedInteger.put((byte) fis.read());
                //vectorBytes.add((byte) fis.read());
            }
            System.out.println(Thread.currentThread().getName());
            
        } catch (Exception e) {

        }
    }
}

class Consumer extends Thread {
    private SharedInteger sharedInteger;
    private FileOutputStream fos;

    public Consumer(SharedInteger c) {
        sharedInteger = c;
    }

    public void run() {
        File newFile = sharedInteger.processingFile;
        System.out.println(newFile.getParentFile());
        try {
            fos = new FileOutputStream(newFile.getParentFile()+"1\\out.txt", true);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Byte v = sharedInteger.get();
        while(v!=null) {
        	
            try {
                if (null != v) {
                    writeToAFile(v);
                }
            } catch (IOException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }
            v=sharedInteger.get();
        }
        
    }

    public void writeToAFile(Byte contents) throws IOException {
        //for (int i = 0; i < contents.size(); i++) {
            System.out.println(Thread.currentThread());
            fos.write(contents);
            fos.flush();
        //}

    }
}

public class MergeFiles {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("C:\\Users\\lenovo\\Desktop\\vector\\in_file");
        File[] fileList = folder.listFiles();
        int countOfFiles = fileList.length;
        SharedInteger c;
        List<Producer> pList = new ArrayList<Producer>();
        List<Consumer> cList = new ArrayList<Consumer>();
        Producer p1 = null;
        Consumer c1 = null;

        for (int i = 0; i < countOfFiles; i++) {
            c = new SharedInteger();
            c.processingFile = fileList[i];

            p1 = new Producer(c);
            p1.setName("Producer--" + i);
            pList.add(p1);
            pList.get(i).start();

            c1 = new Consumer(c);
            c1.setName("Consumer--" + i);
            cList.add(c1);
            cList.get(i).start();
        }

    }
}