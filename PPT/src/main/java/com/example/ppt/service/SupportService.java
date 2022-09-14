package com.example.ppt.service;


import com.example.ppt.Repository.SupportRepository;
import com.example.ppt.exception.ApiException;
import com.example.ppt.model.Support;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportService {
        private final SupportRepository supportRepository;
        public List<Support> getSupport(){
                return supportRepository.findAll();
        }
        public void setSupport(Support support) {
                supportRepository.save(support);
        }
        public Support getSupportById(Integer id) {
                Support support= supportRepository.findSupportById(id);
                if(support==null){
                        throw new ApiException("Wrong user ID!");
                }
                return support;

        }
        }
