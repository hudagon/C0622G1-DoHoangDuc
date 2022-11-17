package com.thi.controller;

import com.thi.dto.ProductOrderDto;
import com.thi.model.Product;
import com.thi.model.ProductOrder;
import com.thi.model.ProductType;
import com.thi.service.product.IProductService;
import com.thi.service.product_order.IProductOrderService;
import com.thi.service.product_type.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productOrder")
public class ProductOrderController {

    @Autowired
    private IProductOrderService productOrderService;

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IProductService productService;


    @GetMapping("/list")
    public String showProductOrderList(Model model, @PageableDefault(value = 5) Pageable pageable) {

        Page<ProductOrder> productOrderPage = productOrderService.findAll(pageable);

        List<ProductOrderDto> productOrderDtoList = new ArrayList<>();

        for (ProductOrder x : productOrderPage) {
            ProductOrderDto productOrderDto = new ProductOrderDto();

            BeanUtils.copyProperties(x, productOrderDto);
            productOrderDto.setProductName(x.getProduct().getName());
            productOrderDto.setPrice(String.valueOf(x.getProduct().getPrice()));
            productOrderDto.setProductType(x.getProduct().getProductType().getName());
            productOrderDto.setBuyDate(x.getBuyDate());
            productOrderDto.setTotalMoney(x.getAmount() * x.getProduct().getPrice());

            productOrderDtoList.add(productOrderDto);
        }

        Page<ProductOrderDto> productOrderDtoPage = new PageImpl<>(productOrderDtoList,
                pageable, productOrderPage.getTotalElements());

        model.addAttribute("productOrderList", productOrderDtoPage);
        model.addAttribute("flag", "list");

        return "product_order/list";
    }

    @GetMapping("/viewProductOrder")
    public String viewProductOrder(@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
                                   @RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
                                   Model model,
                                   @PageableDefault(value = 5) Pageable pageable) {

        Page<ProductOrder> productOrderPage;

        if (startDate.equals("") || endDate.equals("")) {
            productOrderPage = productOrderService.findAll(pageable);
        } else {
            productOrderPage = productOrderService.findAll(pageable, startDate, endDate);
        }

        List<ProductOrderDto> productOrderDtoList = new ArrayList<>();

        for (ProductOrder x : productOrderPage) {
            ProductOrderDto productOrderDto = new ProductOrderDto();

            BeanUtils.copyProperties(x, productOrderDto);
            productOrderDto.setProductName(x.getProduct().getName());
            productOrderDto.setPrice(String.valueOf(x.getProduct().getPrice()));
            productOrderDto.setProductType(x.getProduct().getProductType().getName());
            productOrderDto.setBuyDate(x.getBuyDate());
            productOrderDto.setTotalMoney(x.getAmount() * x.getProduct().getPrice());

            productOrderDtoList.add(productOrderDto);
        }

        Page<ProductOrderDto> productOrderDtoPage = new PageImpl<>(productOrderDtoList,
                pageable, productOrderPage.getTotalElements());

        model.addAttribute("productOrderList", productOrderDtoPage);
        model.addAttribute("flag", "view");

        return "product_order/list";
    }

    @GetMapping("/edit/{id}")
    private String showEditForm(@PathVariable String id, Model model) {

        Optional<ProductOrder> productOrderATBE = productOrderService.findById(Integer.valueOf(id));

        ProductOrderDto productOrderDtoATBE = new ProductOrderDto();

        List<ProductType> productTypeList = (List<ProductType>) productTypeService.findAll();
        List<Product> productList = (List<Product>) productService.findAll();

        if (productOrderATBE.isPresent()) {
            BeanUtils.copyProperties(productOrderATBE.get(), productOrderDtoATBE);
            productOrderDtoATBE.setProductType(String.valueOf(productOrderATBE.get().getProduct().getProductType().getId()));
            productOrderDtoATBE.setProductName(String.valueOf(productOrderATBE.get().getProduct().getId()));
        }

        model.addAttribute("productTypeList", productTypeList);
        model.addAttribute("productList", productList);
        model.addAttribute("productOrderDtoATBE", productOrderDtoATBE);

        return "product_order/edit";
    }

    @PostMapping("/edit")
    private String editProductOrder(@ModelAttribute ProductOrderDto productOrderDto,
                                    RedirectAttributes redirectAttributes) {

        Optional<Product> product = productService.findById(Integer.valueOf(productOrderDto.getProductName()));

        ProductOrder productOrderATBE = new ProductOrder();

        BeanUtils.copyProperties(productOrderDto, productOrderATBE);

        productOrderATBE.setProduct(product.get());
        productOrderATBE.setDeleteStatus(1);

        productOrderService.save(productOrderATBE);

        redirectAttributes.addFlashAttribute("mess", "Product Order Edited successfully!");

        return "redirect:/productOrder/list";

    }



}
