package hh.sof003.JavaDGMarketplace.Controller;


import hh.sof003.JavaDGMarketplace.Repository.DiscTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import hh.sof003.JavaDGMarketplace.Model.DiscType;

@Controller
public class DiscTypeController {

	@Autowired
	DiscTypeRepository discTypeRepository;
	
	@GetMapping("/disctypelist")
	public String doDiscTypeList(Model model) {
		model.addAttribute("disctypelist",discTypeRepository.findAll());
        return "disctypelist";
	}
	
	@GetMapping("/adddisctype")
    public String doAddDiscType(Model model) {
    	DiscType discType = new DiscType();
    	model.addAttribute("disctype", discType);
        return "adddisctype";
    }
    
    @PostMapping("/adddisctype")
    public String doPostDiscType(Model model, @ModelAttribute("disctype") DiscType discType) {
    	discTypeRepository.save(discType);
    	model.addAttribute("disctypelist",discTypeRepository.findAll());
    	return "disctypelist";
    }
}
