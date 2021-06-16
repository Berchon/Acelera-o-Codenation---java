package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{accelerationId}")
    Optional<Acceleration> findById(@PathVariable Long accelerationId) {
        return accelerationService.findById(accelerationId);
    }

    @GetMapping
    List<Acceleration> findByCompanyId(@RequestParam Long companyId){
        return accelerationService.findByCompanyId(companyId);
    }

}
