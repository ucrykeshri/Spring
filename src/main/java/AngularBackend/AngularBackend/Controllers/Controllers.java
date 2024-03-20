package AngularBackend.AngularBackend.Controllers;

import AngularBackend.AngularBackend.Entity.Food;
import AngularBackend.AngularBackend.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Food")
public class Controllers {


    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/getAll")
    public List<Food> getAllFoodList(){
        return foodRepository.findAll();
    }
    @GetMapping("/id")
    public List<Food> getFoodListById( @RequestParam int id){
      return foodRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping("/add-new-fooditem")
    public List<Food> AddFood(@RequestBody Food food){
        return (List<Food>) foodRepository.save(food);
    }
}
