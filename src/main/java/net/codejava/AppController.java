package net.codejava;

import org.springframework.http.MediaType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.type.PhoneNumber;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private VisitorDAO visitorDAO;
	
//	 @Autowired
//	    private ImageDAO imageRepository;
//	
	@GetMapping("")
	public String viewStartpage() {
		return "getstarted";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model,HttpSession sess) {
		
	    User u =new User();
		model.addAttribute("user", u);
		//model.addAttribute("uid",u.getUnique_id());
		//sess.setAttribute("uid", u.getUnique_id());

		
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/s_viewmember")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "s_viewmember";
	}
	
	
	
//	@GetMapping("/s_viewmember/{unique_id}")
//	public String listUsers1(@PathVariable String unique_id, Model model) {
//	   User u = userRepo.getDataById(unique_id);
//	   model.addAttribute("u", u);
//		
//		return "s_viewmember";
//	}
//	
//	@GetMapping("/data/{unique_id}")
//	public User getDataById(@PathVariable String unique_id) {
//	    return userRepo.getDataById(unique_id);
//	}

	
	@GetMapping("/s_viewlog")
	public String listVisitor(Model model) {
		List<Visitor> listVisitor = visitorDAO.findAll();
		model.addAttribute("listVisitor", listVisitor);
		
		return "s_viewlog";
		
	}
	


@GetMapping("/delete/{id}")
public String deleteRecord(@PathVariable(name="id") Long id) {
	
	userRepo.deleteById(id);
	return "redirect:/s_viewmember";
	
}
@GetMapping("/edit/{id}")
public ModelAndView editRecord(@PathVariable(name="id") Long id) {
	ModelAndView editView =new ModelAndView("s_edit_form");
	Optional<User> user = userRepo.findById(id);
	userRepo.deleteById(id);
	editView.addObject("user",user);
	return editView;
	
}

	
    @GetMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...
         
        return "login";
    }
    
    @GetMapping("/who")
    public String who() {

         
        return "who";
    }
    @GetMapping("/users")
    public String viewMember() {
      	
         
        return "users";
    }
    
    @GetMapping("/s_home")
    public String home() {

         
        return "s_home";
    }
    
    @GetMapping("/memberlog")
    public String memberlog() {

         
        return "memberlog";
    }
    
    @GetMapping("/who_visited")
    public String who_visited() {
   
    	
    	
         
        return "who_visited";
    }
    
    
    @GetMapping("/w_visitor")
    public String w_visitor(Model m) {
     
    	m.addAttribute("visitor",new Visitor());
         
        return "w_visitor";
    }
    
    @PostMapping("/w_visitor")
    public String w_visitorsubmit(@ModelAttribute Visitor visitor,Model model) {
     
        System.out.println("visitor"); 
        
        model.addAttribute("Visitor", visitor);
        visitorDAO.save(visitor);
    	
        return "register_success";
    }
//	@GetMapping("/s_viewmember")
//	public String listMembers(Model model) {
//		List<User> listMember = memberRepo.findAll();
//		model.addAttribute("listMembers", listMembers);
//		
//		return "s_viewmember";
//	}
    


    

	@GetMapping("/my_viewlog")
	public String MyVisitor(Model model,HttpServletRequest req) {
		//User u1=userRepo.findByU_id(req.getParameter("u_id"));
		List<Visitor> myvisitor = visitorDAO.viewMember(req.getParameter("u_id"));
		model.addAttribute("myvisitor", myvisitor);
		
		
	      return "my_viewlog";
	}
	  @GetMapping("/error")
	    public String handleError() {
	       
	        return "error";
	    }
	  @GetMapping("/profile")
	    public String viewProfile() {
	      
	        return "profile";
	    }

//	  @GetMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE	)
//	  public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//	    Image image = new Image();
//	    image.setName(file.getOriginalFilename());
//	    image.setData(file.getBytes());
//	    imageRepository.save(image);
//	  }
	  
	  @RequestMapping("/excel")
	    public String index() {
	        return "index";
	    }
		
		@GetMapping("/download/visitors.xlsx")
	    public void downloadCsv(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=visitors.xlsx");
	        ByteArrayInputStream stream = ExcelFileExplorer.contactListToExcelFile(visitorDAO.findAll());
	        IOUtils.copy(stream, response.getOutputStream());
	    }
//		  @GetMapping("/index")
//		    public String index1() {
//		        return "index";
//		    }
//		

}
