package com.epam.travel_agency.entity.criteria;

import java.util.LinkedHashMap;
import java.util.Map;

public class Criteria<E> {

    private Map<E, Object> criteria = new LinkedHashMap<>();
    private final Class<E> searchType;

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }

    public Criteria(Class<E> cls) {
        searchType = cls;
    }

    public Class<E> getSearchType() {
        return searchType;
    }


}
