package com.angel.prospective.serialization.fst;

import de.ruedigermoeller.serialization.FSTConfiguration;
import de.ruedigermoeller.serialization.FSTObjectInput;
import de.ruedigermoeller.serialization.FSTObjectOutput;

import java.io.*;

public class HelloFst {

    static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();

    public static void main(String[] args) throws Exception {
        Fst fst = new Fst();
        fst.str = "hello fst";
/*        byte barray[] = conf.asByteArray(fst);
        Fst fst1 = (Fst)conf.asObject(barray);*/
        OutputStream out = new FileOutputStream(new File("test.in"));
        myWriteMethod(out, fst);
        InputStream in =new FileInputStream(new File("test.in"));
        Fst fst2 = myReadMethod(in);
        System.out.println(fst2.str);


    }

    public static Fst myReadMethod(InputStream stream) throws Exception {
        FSTObjectInput in = conf.getObjectInput(stream);
        Fst result = (Fst) in.readObject(Fst.class);
        // DON'T: in.close(); here prevents reuse and will result in an exception
        stream.close();
        return result;
    }

    public static void myWriteMethod(OutputStream stream, Fst toWrite) throws IOException {
        FSTObjectOutput out = conf.getObjectOutput(stream);
        out.writeObject(toWrite, Fst.class);
        // DON'T out.close() when using factory method;
        out.flush();
        stream.close();
    }

    static class Fst implements Serializable{
        String str;
    }
}
