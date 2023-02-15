package com.i2i.ocs.service;

import com.i2i.ocs.model.Usage;
import com.i2i.ocs.repo.VoltDBRepo;
import org.springframework.stereotype.Service;
import com.i2i.project.voltdb.VoltDbOperations;

@Service
public class OcsService {
    private VoltDbOperations voltDbOperation;
    //private VoltDBRepo voltDBRepo;

    public OcsService(){
        voltDbOperation = new VoltDbOperations();
    }
    public void userUsage(Usage usage){
        if(usage.getService().equalsIgnoreCase("voice")){
            voltDbOperation.sendVoiceAmount(usage.getMsisdn(), usage.getAmount());
        } else if (usage.getService().equalsIgnoreCase("sms")) {
            voltDbOperation.sendSmsAmount(usage.getMsisdn(), usage.getAmount());
        }else if(usage.getService().equalsIgnoreCase("data")){
            voltDbOperation.sendDataAmount(usage.getMsisdn(), usage.getAmount());
        }else{
            //Buraya log4J yatptıktan sonra log bas beklenmeyen bir servis ismi geldi diye.
        }

        //usage ı Kafkayada  gönder.

    }
}
