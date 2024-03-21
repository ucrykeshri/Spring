package AngularBackend.AngularBackend.Services;


import AngularBackend.AngularBackend.Entity.Food;
import AngularBackend.AngularBackend.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FoodServices {

    @Autowired
    private FoodRepository foodRepository;


    public Optional<Food> getFoodById(int id)
    {
        return foodRepository.findById(id);
    }
    public Optional<List<Food>> getALlFoodList()
    {
        return Optional.of(foodRepository.findAll());
    }
    public Food addNewFoodItems(Food food)
    {
        return foodRepository.save(food);
    }
    public Food updateExistingFoodItem(int id , double price, String reviews)
    {
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isPresent()) {
            Food food = existingFood.get();
            food.setPrice(price);
            food.setReviews(reviews);

            // Save the updated food item
            return foodRepository.save(food);
        } else {
            // Handle the case where the food item with the given id is not found
            throw new IllegalArgumentException("Food item with id " + id + " not found");
        }
    }

}
