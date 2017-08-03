package com.nmerris.basicinvoiceaddition.controllers;


import com.nmerris.basicinvoiceaddition.models.Product;
import com.nmerris.basicinvoiceaddition.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    // this allows productRepository to be used throughout this class
    // so you don't need to keep instantiating it in every method
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("welcomemessage", "Welcome to the Invoice App");
        return "index";

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
        model.addAttribute("newproduct", new Product());

        // populate the <h1> element
        model.addAttribute("addproductheader", "Add a product");

        // below: name of the html file that deals with this
        // only using addsingleproduct below because intellij won't recognize addproduct.html as an html file
        // normally want to name html file the same as the route name
        return "addsingleproduct";
    }


    // show the details of the product after user clicks submit
    @PostMapping("/addproduct")
    // add validation
    // binding result will hold a list of validation errors

    // need to use newproduct again here, because need to pass it back to
    // addsingleproduct if it has errors, and there it expects the name to be newproduct
    public String postProduct(@Valid @ModelAttribute("newproduct")
                                          Product product, BindingResult bindingResult) {
        // 'Product product' above kinda signifies the type that showproductdetails.html
        // will use, where it is referred to as 'addedproduct'


        if(bindingResult.hasErrors()) {
            return "addsingleproduct"; // show the form again if validation error
        }

        // peep at the validation errors in our console
        System.out.println(bindingResult.toString());

        // HERE ONLY, you can mess with Product product
        // however, "addedproduct" is what showproductdetails.html uses
        // so we essentially renamed the thymeleaf reference in this method
        // in the GetMapping, we called it just "product"
        // so you can test it any way you want.....
        System.out.println("Product details: " + product.getDescription());

        productRepository.save(product); // save it to the db
        return "showproductdetails";
    }





    // show the details of the product after user clicks submit
    @GetMapping("/showproductdetails")
    public String showProductDetails() {
        return "showproductdetails";
    }


    @GetMapping("/showproducts")
    public @ResponseBody String showAllProducts() {
        Iterable<Product> productList = productRepository.findAll();
//        for(Product p : productList) {
//            // testing to console
//            System.out.println(p.getDescription());
//        }

        // or test to the web
        // this will output Java's normal memory refs to the page!  Silly!
        return productList.toString();

        // TODO: use th:each to spit our product list out to the web page


    }



    @RequestMapping("/listproducts")
    public String listProducts(Model model) {
        String dependecyList = "The dependencies used are: spring-boot-starter-web, spring-boot-starter-test, spring-boot-starter-thymeleaf";

        model.addAttribute("productlistheading", "This is a list of your products");
        model.addAttribute("dependencylist", dependecyList);

        return "listproducts";
    }


}
