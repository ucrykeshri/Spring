package AngularBackend.AngularBackend.Controllers;

import AngularBackend.AngularBackend.Entity.Food;
import AngularBackend.AngularBackend.Services.FoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Food")
public class Controllers {
    @Autowired
    private FoodServices foodServices;

    @GetMapping("/getAll")
    public ResponseEntity<List<Food>> getAllFoodList() {
        try {
            Optional<List<Food>> optionalFoodList = foodServices.getALlFoodList();

            if (optionalFoodList.isPresent()) {
                List<Food> foodList = optionalFoodList.get();
                return ResponseEntity.ok(foodList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/id")
    public ResponseEntity<Food> getFoodListById(@RequestParam int id) {
        try {
            Optional<Food> optionalFood = foodServices.getFoodById(id);

            if (optionalFood.isPresent()) {
                Food food = optionalFood.get();
                return ResponseEntity.ok(food);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/addNewItem")
    public ResponseEntity<String> addFood(@RequestBody Food food) {
        try {
            Food addedFood = foodServices.addNewFoodItems(food);
            if (addedFood != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Food Added Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding food item");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding food item");
        }
    }

    @PutMapping("/updatefoodItem")
    public ResponseEntity<String> updateFood(@RequestBody Food food, @RequestParam String reviews, @RequestParam double price) {
        try {
            Food updatedFood = foodServices.updateExistingFoodItem(food.getFoodId(), price, reviews);
            if (updatedFood != null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Food Updated Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with the given ID not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating food item");
        }
    }


}
