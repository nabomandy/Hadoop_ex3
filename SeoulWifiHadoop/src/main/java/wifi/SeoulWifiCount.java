package wifi;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class SeoulWifiCount {
	public static void main(String[] args) throws IOException, 
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		//윈도우에서는 문제 없으나, 리눅스에서 구동 시에 파일 명에 공백(" ")이 있으면 문제가 될 수 있음
		String in = "infile/서울시 공공와이파이 서비스 위치 정보.csv";
		String out = "outfile/wifiguout";
		Job job1 = Job.getInstance(conf, "SeoulWifiCount");
		Job job2 = Job.getInstance(conf, "SeoulWifiCount");
		
		job1.setJarByClass(SeoulWifiCount.class);
		
		FileInputFormat.addInputPath(job1, new Path(in));
		FileOutputFormat.setOutputPath(job1, new Path(out));
		
		job1.setMapperClass(SeoulWifiGuCountMapper.class);
		job1.setReducerClass(SeoulWifiCountReducer.class);
		job1.setInputFormatClass(TextInputFormat.class);
		job1.setOutputFormatClass(TextOutputFormat.class);
		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(IntWritable.class);
		
		FileSystem hdfs = FileSystem.get(conf);
		
		if (hdfs.exists(new Path(out))) {
			hdfs.delete(new Path(out), true);
			System.out.println("기존 출력 파일 삭제");
		}
		
		job1.waitForCompletion(true);
		
		out = "outfile/wifiyearout";
		
		job2.setJarByClass(SeoulWifiCount.class);
		
		FileInputFormat.addInputPath(job2, new Path(in));
		FileOutputFormat.setOutputPath(job2, new Path(out));
		
		job2.setMapperClass(SeoulWifiYearCountMapper.class);
		job2.setReducerClass(SeoulWifiCountReducer.class);
		job2.setInputFormatClass(TextInputFormat.class);
		job2.setOutputFormatClass(TextOutputFormat.class);
		job2.setMapOutputKeyClass(Text.class);
		job2.setMapOutputValueClass(IntWritable.class);
		
		if (hdfs.exists(new Path(out))) {
			hdfs.delete(new Path(out), true);
			System.out.println("기존 출력 파일 삭제");
		}
		
		job2.waitForCompletion(true);
	}
}
