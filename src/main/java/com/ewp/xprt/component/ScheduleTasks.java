package com.ewp.xprt.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
public class ScheduleTasks {

	private static Logger logger = LoggerFactory.getLogger(ScheduleTasks.class);

	@Autowired
	public ScheduleTasks() {

	}

//	@Scheduled(cron = "0/30 0/1 * ? * *") // Каждые 30 сек для тестов
	@Scheduled(cron = "0 0 0 * * *") //Ежедневно в 00:00
	private void sendDailyAdvertisementReport() throws IOException {
        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedDate = date.format(formatter);
		System.out.println(formattedDate);
	}


}