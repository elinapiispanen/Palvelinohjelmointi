package hh20swd.harjoitustyo.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh20swd.harjoitustyo.domain.PalveluRepository;
import hh20swd.harjoitustyo.domain.Sarja;
import hh20swd.harjoitustyo.domain.SarjaRepository;
import hh20swd.harjoitustyo.domain.StatusRepository;


@Controller
public class SarjaController {
	
	@Autowired
	private SarjaRepository sarjaRepository;
	
	@Autowired
	private PalveluRepository palveluRepository;

	
	@Autowired
	private StatusRepository statusRepository;
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	

	@RequestMapping(value="/sarjalista")
	public String showSarjat(Model model) {
		model.addAttribute("sarjat", sarjaRepository.findAll());
		return "sarjalista"; }
	
	@RequestMapping(value="/palvelulista")
	public String showPalvelut(Model model) {
		model.addAttribute("palvelut", palveluRepository.findAll());
		return "palvelulista"; }
	
	@RequestMapping(value="/statuslista")
	public String showStatuses(Model model) {
		model.addAttribute("statuses", statusRepository.findAll());
		return "statuslista"; }
	
	@RequestMapping(value = "/uusisarja", method = RequestMethod.GET)
	public String lisaaSarja(Model model) {
		model.addAttribute("sarja", new Sarja());
		model.addAttribute("palvelut", palveluRepository.findAll());
		model.addAttribute("statuses", statusRepository.findAll());
		return "lisaasarja";
	}
	
	@RequestMapping(value = "/uusisarja", method = RequestMethod.POST)
	public String saveSarja(@ModelAttribute Sarja sarja) {
		
		sarjaRepository.save(sarja);
		return "redirect:/sarjalista";
	}
	

@RequestMapping(value = "/poistasarja/{id}", method = RequestMethod.GET)
public String poistaSarja(@PathVariable("id") Long sarjaId) {
	sarjaRepository.deleteById(sarjaId);
	return "redirect:../sarjalista";
}

@GetMapping(value = "/muokkaasarja/{id}")
public String muokkaaSarja(@PathVariable("id") Long sarjaId, Model model) {
	Optional<Sarja> sarja = sarjaRepository.findById(sarjaId);
	model.addAttribute("sarja", sarja);
	model.addAttribute("palvelut", palveluRepository.findAll());
	model.addAttribute("statuses", statusRepository.findAll());
	
	return "muokkaasarja";
}

@RequestMapping(value = "/muokkaasarja/{id}", method = RequestMethod.POST)
public String save(@ModelAttribute Sarja sarja) {
	sarjaRepository.save(sarja);
	return "redirect:/sarjalista";
}
	
	@RequestMapping(value="/sarjat", method = RequestMethod.GET)
			public @ResponseBody List<Sarja> sarjaListRest() {
			return (List<Sarja>) sarjaRepository.findAll();
			}

}
