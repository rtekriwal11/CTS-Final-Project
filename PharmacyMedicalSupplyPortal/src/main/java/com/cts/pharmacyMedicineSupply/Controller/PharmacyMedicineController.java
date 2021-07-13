package com.cts.pharmacyMedicineSupply.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pharmacyMedicineSupply.dto.Datedto;
import com.cts.pharmacyMedicineSupply.dto.PharmacyMedicineSupply;
import com.cts.pharmacyMedicineSupply.dto.RepSchedule;
import com.cts.pharmacyMedicineSupply.feign.MedicalRepMicroServiceFeign;
import com.cts.pharmacyMedicineSupply.feign.MedicineSupplyFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PharmacyMedicineController {
	
	@Autowired
	MedicalRepMicroServiceFeign medicalRepMicroServiceFeign;
	
	@GetMapping("/home")
	public ModelAndView homepage() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@GetMapping("/checkSchedule")
	public ModelAndView checkmeeting() {
		ModelAndView mv=new ModelAndView("datepage");
		return mv;
	}
	
	@GetMapping("/checkSchedules")
	public ModelAndView showDate(@ModelAttribute Datedto Date,ModelMap map) {
		ModelAndView mv=new ModelAndView("RepSchedule");
		List<RepSchedule> schedule=medicalRepMicroServiceFeign.getSchedule(Date.getDate());
		map.addAttribute("schedule",schedule);
		mv.addObject(schedule);
		//mv.addObject("Date",date);
		return mv;
	}
	
	@Autowired
	private MedicineSupplyFeignClient medicineSupplyFeign;
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyPage(HttpSession session){
		log.info("Starting showSupplyPage");
			return new ModelAndView(medicineSupplyFeign.showSupplyHomePage());
	}
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(HttpSession session, @RequestParam String name, @RequestParam int demand,ModelMap model){
		log.info("Starting showList");
			List<PharmacyMedicineSupply> list=medicineSupplyFeign.showList(name, demand);
			if(list==null) {
				model.put("errorMessage", "PAGE EXPIRED");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");				
			}
			if(demand<5) {
				model.put("errorMessage", "Invalid Input!");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			if(list.isEmpty()) {
				model.put("errorMessage", "Stock not available!");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			model.put("pharmacyList", list);
			log.info("Ending showList");
			return new ModelAndView ("SupplyAvailed");
		}
	
	
}
