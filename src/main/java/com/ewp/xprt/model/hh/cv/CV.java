package com.ewp.xprt.model.hh.cv;

import com.ewp.xprt.model.hh.dictionaries.*;

import java.util.List;

public class CV {

    private String id; //Идентификатор резюме
    private String last_name;
    private String first_name;
    private String middle_name;
    private Integer age;
    private String birth_date; //День рождения (в формате ГГГГ-ММ-ДД).
    private Gender gender; //Пол. Элемент справочника gender.
    private Area area; //Город проживания. Элемент справочника areas.
        /*
    metro	object или null	Ближайшая станция метро. Элемент справочника metro.
    */
    private Relocation relocation; //Информация о возможности переезда в другой город. Элемент справочника relocation
    /*
    business_trip_readiness	object	Готовность к командировкам. Элемент справочника resume_trip_readiness.
    */
    List<Contact> contact; //Список контактов соискателя.
        /*
    photo	object или null	Фотография пользователя.
    portfolio	array	Список изображений в портфолио пользователя.
    site	array	Профили в соц. сетях и других сервисах.
    */
    private String title; //Желаемая должность.
    private List<Specialization> specialization; //	array	Специализации соискателя. Элементы справочника specializations.
    private Salary salary; //	object или null	Желаемая зарплата.
    private List<Employments> employments; //	array	Список подходящих соискателю типов занятостей. Элементы справочника employment.
    private List<Schedules> schedules; //	array	Список подходящих соискателю графиков работы. Элементы справочника schedule.
    private List<Education> education; //	object	Образование.
    /*
    language	array	Список языков, которыми владеет соискатель. Элементы справочника languages.
    */
    private List<Experience> experience; //	array	Опыт работы.
    private TotalExperience total_experience; //	object или null	Общий опыт работы.
    private String skills; //Дополнительная информация, описание навыков в свободной форме.
    /*
    skill_set	array	Ключевые навыки (список уникальных строк).
    */
    private List<Citizenship> citizenship; //	array	Список гражданств соискателя. Элементы справочника регионов.
        /*
    work_ticket	array	Список регионов, в который соискатель имеет разрешение на работу. Элементы справочника регионов.
    travel_time	object	Желательное время в пути до работы. Элемент справочника travel_time.
    recommendation	array	Список рекомендаций.
    */
    private ResumeLocale resume_locale; //	object	Язык, на котором составлено резюме (локаль). Элемент справочника локали резюме.
    private List<Certificate> certificate; //	array	Список сертификатов соискателя.
    private String alternate_url; //URL резюме на сайте.
    private String created_at; //Дата и время создания резюме.
    private String updated_at; //Дата и время обновления резюме.
    /*
    download	object	Ссылки для скачивания резюме в нескольких форматах (подробнее).
    private boolean has_vehicle; //Наличие личного автомобиля у соискателя.
    driver_license_types	array	Список категорий водительских прав соискателя.
    hidden_fields	array	Список скрытых полей. Элемент справочника resume_hidden_fields.
     */

    public String getId() {
        return id;
    }
}
