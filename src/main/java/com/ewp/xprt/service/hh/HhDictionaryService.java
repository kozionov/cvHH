package com.ewp.xprt.service.hh;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HhDictionaryService {
    private static Logger logger = LoggerFactory.getLogger(HhDictionaryService.class);
    private HHOauthService hhoAuthService;

    @Autowired
    public HhDictionaryService(HHOauthService hhoAuthService) {
        this.hhoAuthService = hhoAuthService;
    }

    /**
     * Справочники
     * Возвращает объект со справочниками полей и сущностей, используемых в API
     * https://github.com/hhru/api/blob/master/docs/dictionaries.md
     */
    public String getDictionaries(){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/dictionaries", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getDictionaries вернул код " + response.getCode());
            return null;
        }
    }

    /**
     * Справочник регионов
     * Возвращает древовидный список всех регионов с указанием названия региона, его идентификатором и ссылкой на родительский регион
     * https://github.com/hhru/api/blob/master/docs/areas.md
     */
    public String getAreas(){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/areas", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getAreas вернул код " + response.getCode());
            return null;
        }
    }

    /**
     * Справочник стран и гражданств
     * вернёт подмножество регионов, являющихся странами
     */
    public String getCountries(){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/areas/countries", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getCountries вернул код " + response.getCode());
            return null;
        }
    }

    /**
     * Отрасли компаний
     * Возвращает двухуровневый справочник всех отраслей
     * https://github.com/hhru/api/blob/master/docs/industries.md
     */
    public String getIndustries(){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/industries", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getIndustries вернул код " + response.getCode());
            return null;
        }
    }

    /**
     * Локализация
     */
    public String getLocales(){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/locales/resume", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getLocales вернул код " + response.getCode());
            return null;
        }
    }

    /**
     * Специализации
     */
    public String getSpecializations (){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/specializations", hhoAuthService.getService());
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("getSpecializations вернул код " + response.getCode());
            return null;
        }
    }


}
