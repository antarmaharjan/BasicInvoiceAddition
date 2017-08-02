package com.nmerris.basicinvoiceaddition.controllers;


import com.nmerris.basicinvoiceaddition.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/index")
    public @ResponseBody
    String indexPage() {
        return "<h1>Welcome to the basic invoice web app<h1>";
    }


    @GetMapping("/login")
    public @ResponseBody String loginPage() {
        return "This is the login page";
    }


    // get the product info from the user
    // will be put in a new Product object
    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        // below.. 'product' MUST match th:object="${product}" in addsingleproduct.html file
        // basically 'product' is how we reference a Product object in the html file
        model.addAttribute("product", new Product());
        // below: name of the html file that deals with this
        // only using addsingleproduce below because intellij won't recognize addproduct.html as an html file
        // normally want to name html file the same as the route name
        return "addsingleproduct";
    }


    // show the details of the product after user clicks submit
    @PostMapping("/addproduct")
    public String addProductSubmit(@ModelAttribute Product product) {
        return "showproductdetails";
    }

    // show the details of the product after user clicks submit
    @GetMapping("/showproductdetails")
    public String showProductDetails() {
        return "showproductdetails";
    }


    @RequestMapping("/listproducts")
    public String listProducts(Model model) {
        String dependecyList = "The dependencies used are: spring-boot-starter-web, spring-boot-starter-test, spring-boot-starter-thymeleaf";

        model.addAttribute("productlistheading", "This is a list of your products");
        model.addAttribute("dependencylist", dependecyList);

        return "listproducts";
    }


}
