package sbitneva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

@Service("crudAircraft")
public class CRUDAircraft {
    @Autowired
    AircraftsDao aircraftsDao;

   public Aircraft readAircraft(int id){

       return aircraftsDao.read(id);
   }
}
