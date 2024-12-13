package oasis.takeout.quartz.task;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyTask {

	public void showTime() {
		System.out.println("【oasis】Scheduling task starting: "+new Date());
	}
}
