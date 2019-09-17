package com.joeknowles.Week19.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joeknowles.Week19.models.prodcat.Category;
import com.joeknowles.Week19.models.prodcat.Product;
import com.joeknowles.Week19.models.prodcat.ProductFormObject;
import com.joeknowles.Week19.services.ProdCatService;

@Controller
public class ProdCatController {
	private ProdCatService service;
	
	public ProdCatController(ProdCatService s) { service = s; }
	
	@PostMapping("/prodcat")
	public String prodcathome( ) {
		return "prodcat/index";
	}
	
	@PostMapping("/prodcat/newProduct")
	public String newProduct(Model model) {
		model.addAttribute("pfo", new ProductFormObject());
		return "prodcat/newProduct"; 
	}
	
	@PostMapping("/prodcat/newCategory")
	public String newCategory( ) {
		return "prodcat/newCategory";
	}
	
	@GetMapping("/prodcat/showProducts")
	public String showProducts(Model model, @RequestParam(name="product", required=false) Long id) {
		List<Product> pList = service.allProducts();
		List<Category> cList = service.allCategories();
		if (pList == null || pList.isEmpty()) {
			model.addAttribute("noProd", true);
			model.addAttribute("products", "No products!");
		} else {
			model.addAttribute("products", pList);
			Optional<Product> oP = service.findProductById(id);
			Product p = null;
			if (oP.isPresent()) {
				p = oP.get();					
			} else {
				p = pList.get(0);
			}
			model.addAttribute("product", p);		
			if (cList == null || cList.isEmpty()) {
				model.addAttribute("noCat", true);
				model.addAttribute("categories", "No categories!");
			} else {
				for (Category c : p.getCategories()) {
					cList.remove(c);
				}
			}			
		}				
		model.addAttribute("categories", cList);
		return "prodcat/pShow";
	}
	
	@GetMapping("/prodcat/showCategories/{id}")
	public String showCategoriesSelected(Model model, @PathVariable("id") long id) {
		model.addAttribute("categories", service.allCategories());
		Optional<Category> oC = service.findCategoryById(id);
		if (oC.isPresent()) {
			model.addAttribute("category", oC.get());
		}
		return "prodcat/cShow";
	}
	
	@GetMapping("/prodcat/showCategories")
	public String showCategories(Model model, @RequestParam(name="category", required=false) Long id) {
		List<Product> pList = service.allProducts();
		List<Category> cList = service.allCategories();
		if (cList == null || cList.isEmpty()) {
			model.addAttribute("noCat", true);
			model.addAttribute("categories", "No categories!");
		} else {
			model.addAttribute("categories", cList);
			Optional<Category> oC = service.findCategoryById(id);
			Category c = null;
			if (oC.isPresent()) {
				c = oC.get();
			} else {
				c = cList.get(0);
			}
			model.addAttribute("category", c);
			if (pList == null || pList.isEmpty()) {
				model.addAttribute("noProd", true);
				model.addAttribute("products", "No products!");
			} else {
				for (Product p : c.getProducts()) {
					pList.remove(p);
				}
			}
		}					
		model.addAttribute("products", pList);
		return "prodcat/cShow";
	}
	
	@PostMapping("/prodcat/createProduct")
	public String createProduct(Model model, @Valid @ModelAttribute("pfo") ProductFormObject pfo, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("failed", true);
			return "prodcat/newProduct";
		}
		Product p = new Product(pfo.name, pfo.description, pfo.price);
		p = service.saveProduct(p);
		model.addAttribute("products", service.allProducts());
		model.addAttribute("product", p);
		return "redirect:/prodcat/showProducts";
	}
	
	@GetMapping("/prodcat/createCategory")
	public String createCategory(Model model, @RequestParam("name") String n) {
		if (n == null || n.isEmpty()) {
			model.addAttribute("error", true);
			model.addAttribute("msg", "Please enter a category name!");
			return "prodcat/newCategory";
		}
		Category c = new Category(n);
		if (!service.createCategory(c)) {
			model.addAttribute("category", c);
			model.addAttribute("error", true);
			model.addAttribute("msg", "Error creating category!");
			return "prodcat/newCategory";
		}
		return"redirect:/prodcat/showCategories/" + c.getId();
	}
	
	@GetMapping("/prodcat/addCatToProd")
	public ModelAndView addCatToProd(ModelMap model, @RequestParam("product") Long p_id, @RequestParam("category") Long c_id) {
		Optional<Product> oP = service.findProductById(p_id);
		Optional<Category> oC = service.findCategoryById(c_id);
		if (oP.isPresent()) {
			Product p = oP.get();
			if(oC.isPresent()) {
				p.addCategory(oC.get());
				service.saveProduct(p);
			}
			model.addAttribute("product", p_id);
		}
		return new ModelAndView("redirect:/prodcat/showProducts", model);
	}
	
	@GetMapping("/prodcat/addProdToCat")
	public ModelAndView addProdToCat(ModelMap model, @RequestParam("product") Long p_id, @RequestParam("category") Long c_id) {
		Optional<Product> oP = service.findProductById(p_id);
		Optional<Category> oC = service.findCategoryById(c_id);
		if (oC.isPresent()) {
			Category c = oC.get();
			if(oP.isPresent()) {
				c.addProduct(oP.get());
				service.updateCategory(c);
			}
			model.addAttribute("category", c_id);
		}
		return new ModelAndView("redirect:/prodcat/showCategories", model);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}