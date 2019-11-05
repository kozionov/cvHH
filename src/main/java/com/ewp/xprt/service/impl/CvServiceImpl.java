package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.hh.cv.CV;
import com.ewp.xprt.service.interfaces.CvService;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService {

    /**
     * Создание шаблона резюме
     */
    @Override
    public CV createTemplateCV() {
        CV template = new CV();

        return template;
    }
}
