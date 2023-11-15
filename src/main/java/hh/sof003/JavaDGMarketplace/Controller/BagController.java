package hh.sof003.JavaDGMarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof003.JavaDGMarketplace.Model.Bag;
import hh.sof003.JavaDGMarketplace.Model.Disc;
import hh.sof003.JavaDGMarketplace.Model.Profile;
import hh.sof003.JavaDGMarketplace.Repository.BagRepository;
import jakarta.validation.Valid;

@Controller
public class BagController {

	@Autowired
	BagRepository bagRepository;
	
	@GetMapping("/baglist")
	public String doBagList(Model model) {
		model.addAttribute("baglist",bagRepository.findAll());
		return "baglist";
	}
	
	@GetMapping("/addbag")
	public String doAddBag(Model model) {
		
		Bag bag = new Bag();
		
		model.addAttribute("bag", bag);
		model.addAttribute("baglist", bagRepository.findAll());
		return "addbag";
	}
	
	@PostMapping("/addbag") 
	public String doPostBag(Model model,@Valid @ModelAttribute("bag") Bag bag, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addbag";
		}
		bagRepository.save(bag);
		return "redirect:/baglist";
	}
	
	@GetMapping("/bagpage/{id}")
    public String doBagPage(@PathVariable String id, Model model) {
		Bag bagPage = bagRepository.findById(Integer.parseInt(id));
		model.addAttribute("bag", bagPage);
    	return "/bagpage";
    }
	
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/editbag/{id}")
	public String doEditBag(@PathVariable String id, Model model) {
		Bag editBag = bagRepository.findById(Integer.parseInt(id));
		model.addAttribute("bag", editBag);
		return "editbag";
	}
	
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/editbag")
	public String doPostEditBag(Model model, @ModelAttribute("bag") Bag bag) {
		bagRepository.save(bag);
		return "redirect:/baglist";
	}
	
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deletebag/{id}")
    public String doDeleteBag(@PathVariable String id, Model model) {
    	Bag deleteBag = bagRepository.findById(Integer.parseInt(id));
    	bagRepository.delete(deleteBag);
    	return "redirect:/baglist";
    }
}
