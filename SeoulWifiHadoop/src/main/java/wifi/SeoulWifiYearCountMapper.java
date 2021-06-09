package wifi;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SeoulWifiYearCountMapper extends Mapper<LongWritable, Text, 
		Text, IntWritable> {
	private final static IntWritable outputValue = new IntWritable(1);
	private Text outputKey = new Text();
	
	@Override
	public void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, IntWritable>.Context context) 
					throws IOException, InterruptedException {
		if (key.get() == 0) return;
		
		Wifi wifi = new Wifi(value);
		
		outputKey.set(Integer.toString(wifi.getYear()));	// 연도
		
		context.write(outputKey, outputValue);
	}
}
