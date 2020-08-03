package projects.adxmas.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projects.adxmas.eshop.entity.ItemObject;
import projects.adxmas.eshop.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class Controller {

    private final ShopService shopService;

    @Autowired
    public Controller(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/items/getall")
    public List<ItemObject> getItems() {
        return shopService.getItems();
    }

    @PostMapping("/items/additem")
    public ItemObject addItem(ItemObject itemObject) {
        return shopService.addItem(itemObject);
    }

    @DeleteMapping("/items/delete/{id}")
    public List<ItemObject> deleteBuilding(@PathVariable("id") int id) {
        return shopService.deleteItemById(id);
    }

    @PutMapping("/items/update/{id}")
    public ItemObject updateItem(@PathVariable("id") int id, ItemObject itemObject){
        return shopService.updateItem(id, itemObject);
    }

    @GetMapping("/items/buy")
    public List<ItemObject> buyItem(int id, String fName, String lName, String creditCardNumber ){
        return shopService.purchaseItem(id, fName, lName, creditCardNumber);
    }
}
