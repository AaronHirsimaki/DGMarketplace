package hh.sof003.JavaDGMarketplace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof003.JavaDGMarketplace.Model.Disc;
import hh.sof003.JavaDGMarketplace.Repository.DiscRepository;

@RestController
public class DiscRestController {
	
	@Autowired
	DiscRepository discRepository;
	
	@GetMapping("/disc/list")
	public @ResponseBody List<Disc> getDiscsRest(){
		return(List<Disc>) discRepository.findAll();
	}
	
	@GetMapping("/disc/{id}")
	public @ResponseBody Disc getDiscsByIdRest(@PathVariable String id) {
		return discRepository.findById(Integer.parseInt(id));
	}
}
