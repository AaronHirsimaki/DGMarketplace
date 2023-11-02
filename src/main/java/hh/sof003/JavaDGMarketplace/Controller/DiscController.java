package hh.sof003.JavaDGMarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof003.JavaDGMarketplace.Model.Disc;
import hh.sof003.JavaDGMarketplace.Model.Profile;
import hh.sof003.JavaDGMarketplace.Repository.DiscRepository;
import hh.sof003.JavaDGMarketplace.Repository.ProfileRepository;


@Controller
public class DiscController {
	
	@Autowired
	DiscRepository discRepository;
	
	@Autowired
	ProfileRepository profileRepository;
	
	//Home page
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	//Show list of different discs
	@GetMapping("/disclist")
	public String doDiscList(Model model) {
		model.addAttribute("disclist",discRepository.findAll());
		return "disclist";
	}
	
	//Add a new disc to the list
	@GetMapping("/adddisc")
	public String doAddDisc(Model model) {
		
		Disc disc = new Disc();
		
		model.addAttribute("disc", disc);
		model.addAttribute("disclist", discRepository.findAll());
		return "adddisc";
	}
	
	@PostMapping("/adddisc") 
	public String doPostDisc(Model model, @ModelAttribute("disc") Disc disc) {
		discRepository.save(disc);
		return "redirect:/disclist";
	}
	
	//Edit a specific disc
	@GetMapping("/editdisc/{id}")
	public String doEditDisc(@PathVariable String id, Model model) {
		Disc editDisc = discRepository.findById(Integer.parseInt(id));
		model.addAttribute("disc", editDisc);
		return "editdisc";
	}
	
	@PostMapping("/editdisc")
	public String doPostEditDisc(Model model, @ModelAttribute("disc") Disc disc) {
		discRepository.save(disc);
		return "redirect:/disclist";
	}
	
	//Delete a specific disc
    @GetMapping("/deletedisc/{id}")
    public String doDeleteDisc(@PathVariable String id, Model model) {
    	Disc deleteDisc = discRepository.findById(Integer.parseInt(id));
    	discRepository.delete(deleteDisc);
    	return "redirect:/disclist";
    }
    
    @GetMapping("/discpage/{id}")
    public String doDiscPage(@PathVariable String id, Model model) {
		Disc discPage = discRepository.findById(Integer.parseInt(id));
		model.addAttribute("disc", discPage);
    	return "/discpage";
    }
    
    @GetMapping("/profilepage/{id}")
    public String doProfilePage(@PathVariable String id, Model model) {
    	Profile profilePage = profileRepository.findById(Integer.parseInt(id));
    	model.addAttribute("profile", profilePage);
    	return "/profilepage";
    }
	
}
