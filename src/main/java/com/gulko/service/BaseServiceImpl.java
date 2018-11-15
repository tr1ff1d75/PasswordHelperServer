package com.gulko.service;

import com.gulko.entity.BasePH;
import com.gulko.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class BaseServiceImpl implements BaseService {



    @Autowired
    private BaseRepository repository;
    @Transactional(readOnly=true)
    public List<BasePH> getAll() {
        return repository.findAll();
    }

    public BasePH save(BasePH userBase) {
      /*  BasePH tw=new BasePH();
        tw.setLogin(log);,
        tw.setSite(userBase.getSite());
        tw.setSiteLogin(userBase.getSitePass());
        tw.setSitePass(userBase.getSitePass());*/
        return repository.saveAndFlush(userBase);
    }

    public List<BasePH> getAllUserBase(String login) {
        List<BasePH> basePH = new ArrayList<BasePH>();
        List<BasePH> all_l=repository.findAll();
        for (BasePH l: all_l
             ) {
         if(l.getLogin().equals(login)){
             basePH.add(l);}

        }
        return basePH;
    }
}
