package com.ewp.xprt.model.hh.cv;

import com.ewp.xprt.model.hh.dictionaries.EducationLevel;

import java.util.List;

public class Education {
    private List<Elementary> elementary; //	array	Среднее образование. Обычно заполняется только при отсутствии высшего образования.
    private List<Additional> additional; //	array	Список куров повышения квалификации.
    private List<Attestation> attestation; // array	Список пройденных тестов или экзаменов.
    private List<Primary> primary; // array	Список образований выше среднего.
    private EducationLevel level; // object	Уровень образования. Элемент справочника education_level.

    public Education() {
    }

    public List<Elementary> getElementary() {
        return elementary;
    }

    public void setElementary(List<Elementary> elementary) {
        this.elementary = elementary;
    }

    public List<Additional> getAdditional() {
        return additional;
    }

    public void setAdditional(List<Additional> additional) {
        this.additional = additional;
    }

    public List<Attestation> getAttestation() {
        return attestation;
    }

    public void setAttestation(List<Attestation> attestation) {
        this.attestation = attestation;
    }

    public List<Primary> getPrimary() {
        return primary;
    }

    public void setPrimary(List<Primary> primary) {
        this.primary = primary;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public void setLevel(EducationLevel level) {
        this.level = level;
    }
}
