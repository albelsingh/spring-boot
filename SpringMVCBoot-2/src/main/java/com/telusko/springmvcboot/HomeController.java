package com.telusko.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute                                //before calling RequestMapping this method will call
	public void modelData(Model m)
	{
		m.addAttribute("name", "Albel");
	}
    
	@RequestMapping("/")  //Whenever requested home page than only call this method
	public String home()
	{
		/* System.out.println("Home Page Requested"); */
		return "index";    //DispatcherServlet calling the jsp page
	}
	
	/*
	 * @RequestMapping("add") public ModelAndView add(@RequestParam("num1") int
	 * a,@RequestParam("num2") int b) {
	 * 
	 * ModelAndView mv=new ModelAndView(); mv.setViewName("result");
	 * 
	 * int result=a+b; mv.addObject("result",result); return mv; }
	 */
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int a,@RequestParam("num2") int b,ModelMap m)
	{ 
		int result=a+b;
		m.addAttribute("result",result);
		return "result";
	}
	//@RequestMapping("addAlien") //It works for both methods
	//@RequestMapping(value="addAlien",method=RequestMethod.GET) //diff to work with method
	//@RequestMapping(value="addAlien",method=RequestMethod.POST)
	//@GetMapping(value="addAlien")
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a)  //ModelAttribute also responsibe to add the data into model
	{
	    repo.save(a); 
		return 	"result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		m.addAttribute("showAliens", repo.findAll());
		return "showAliens";
	}
	
	
	  @GetMapping("getAlien") 
	  public String getAlien(@RequestParam int aid, Model m) 
	  {  
		 // List<Alien> aliens=Arrays.asList(new Alien(101,"Albel"),new Alien(102,"Muai"));
		  m.addAttribute("result",repo.getOne(aid));
		  return "showAliens";
	   }
	  
	  @GetMapping("getAlienByName") 
	  public String getAlienByName(@RequestParam String aname, Model m) 
	  { 
		 // m.addAttribute("result",repo.findByAnameOrderByAidDesc(aname));  //DSL method
		  m.addAttribute("result",repo.find(aname));
		  return "showAliens";
		}
	 
}
