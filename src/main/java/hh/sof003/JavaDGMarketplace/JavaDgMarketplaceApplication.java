package hh.sof003.JavaDGMarketplace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof003.JavaDGMarketplace.Model.Disc;
import hh.sof003.JavaDGMarketplace.Repository.DiscRepository;

@SpringBootApplication
public class JavaDgMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDgMarketplaceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DiscRepository discRepository) {
	return (args) -> {
		
		discRepository.save(new Disc("FD", "Discmania", "Fairway Driver", "Red", 7, 5, 0, 1));
		discRepository.save(new Disc("DD3", "Discmania", "Distance Driver", "White", 12, 5, -1, 3));
		discRepository.save(new Disc("MD3", "Discmania", "Midrange", "Blue", 5, 5, 0, 1));
		discRepository.save(new Disc("P2", "Discmania", "Putter", "Orange", 2, 5, 0, 1));
		discRepository.save(new Disc("Tilt", "Discmania", "Fairway Driver", "Red", 9, 5, 1, 6));
		
	};

}
}