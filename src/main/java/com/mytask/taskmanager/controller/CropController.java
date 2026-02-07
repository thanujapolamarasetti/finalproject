package com.mytask.taskmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mytask.taskmanager.model.Crop;
import com.mytask.taskmanager.service.CropService;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.saveCrop(crop);
    }

    @GetMapping("/{farmerId}")
    public List<Crop> getCrops(@PathVariable Long farmerId) {
        return cropService.getCropsByFarmer(farmerId);
    }
    
    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id,
                           @RequestBody Crop crop) {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public String deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return "Crop deleted successfully";
    }

}
