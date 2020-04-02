package hu.kry.robotweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kry.hu.Kar;
import kry.hu.KarEgyseg;
import kry.hu.Lab;
import kry.hu.LabEgyseg;
import kry.hu.Robot;

@Configuration
public class DependencyConfig {

	@Bean
	public Kar kar() {
		return new KarEgyseg();
	}

	@Bean
	public Lab lab() {
		return new LabEgyseg();
	}

	@Bean
	public Robot robot() {
		return new Robot(lab());
	}
}
