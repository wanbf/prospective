package com.prospective.hadoop;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

/**
 * @author wanbf
 * @date 2018/8/22 18:05
 */
public class HadoopTest {
    private FileSystem fs = null;

    /**
     * 创建连接
     *
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        Configuration conf = new Configuration();
        fs = FileSystem.get(new URI("hdfs://192.168.1.12:9000/"), conf, "root");
    }


    @Test
    public void download() throws IOException {
        fs.mkdirs(new Path("/opt/test1"));
        fs.mkdirs(new Path("/aaa/bbb/ccc"));
    }

    @Test
    public void tt() throws IOException {
        Path dst = new Path("hdfs://192.168.1.12:9000/ctrip");

        FSDataOutputStream os = fs.create(dst);

        FileInputStream is = new FileInputStream("D://ctrip");

        IOUtils.copy(is, os);
    }

    @Test
    public void copy() throws IOException {
        System.setProperty("hadoop.home.dir", "/usr/hadoop/hadoop");

        fs.copyToLocalFile(new Path("hdfs://192.168.1.12:9000/aa/test.cab"),new Path("D:\\ctrip\\test.cab"));

    }

    @Test
    public void testList() throws FileNotFoundException, IllegalArgumentException, IOException {

        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while (listFiles.hasNext()) {
            LocatedFileStatus file = listFiles.next();
            System.out.println(file.getPath());

        }
        System.out.println("----------------------------------");
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : listStatus) {
            System.out.println((fileStatus.isDirectory() ? "-d-  " : "-f-  ") + fileStatus.getPath());
        }
    }

}
