package com.prospective.hadoop;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author wanbf
 * @date 2018/8/22 18:17
 */
public class Hadoop {
    public static void main(String[] args) throws IOException, URISyntaxException {
       try{
           FileSystem fs = FileSystem.get(new URI("hdfs://myha01"), new Configuration(),"root");
           fs.mkdirs(new Path("/opt/test1234"));
           fs.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
