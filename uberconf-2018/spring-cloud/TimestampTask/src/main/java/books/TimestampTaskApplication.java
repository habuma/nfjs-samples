package books;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TimestampTaskApplication {
	
	@Bean
	public TimestampTask task() {
		return new TimestampTask();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(TimestampTaskApplication.class, args);
	}

	public class TimestampTask implements CommandLineRunner {
		private final org.slf4j.Logger logger = LoggerFactory.getLogger(TimestampTask.class);

		@Override
		public void run(String... strings) throws Exception {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ; HH:mm:ss");
			logger.info(dateFormat.format(new Date()));
		}
	}
}
