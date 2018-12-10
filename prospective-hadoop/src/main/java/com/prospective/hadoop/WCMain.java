package com.prospective.hadoop;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCMain {

    private static String iPath = "hdfs://myha01/user/root/input/testHdfs.txt";
    private static String oPath = "hdfs://myha01/user/root/output/";

    public static void main(String[] args) throws Exception {

        System.setProperty("HADOOP_USER_NAME", "root");

        Configuration conf = new Configuration();
        Job wcjob = Job.getInstance(conf);

        wcjob.setJarByClass(WCMain.class);
        wcjob.setMapperClass(WCMapper.class);
        wcjob.setReducerClass(WCReducer.class);

        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(IntWritable.class);

        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(IntWritable.class);

        FileSystem fs = FileSystem.get(conf);
        Path IPath = new Path(iPath);
        if (fs.exists(IPath)) {
            FileInputFormat.addInputPath(wcjob, IPath);
        }

        Path OPath = new Path(oPath);
        fs.delete(OPath, true);
        FileOutputFormat.setOutputPath(wcjob, OPath);

        boolean res = wcjob.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
