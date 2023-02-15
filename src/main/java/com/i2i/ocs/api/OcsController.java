package com.i2i.ocs.api;

import com.i2i.ocs.model.Usage;
import com.i2i.ocs.service.OcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocs")
public class OcsController {

    @Autowired
    OcsService ocsService;

    @PostMapping("/usage")
    public void userUsage(@RequestBody Usage usage) {
        ocsService.userUsage(usage);
    }
}


