package ru.netology.repository;

import ru.netology.domain.CaseFlight;

public class CaseFlightRepository {
    private CaseFlight[] cases =new CaseFlight[0];

    public void save(CaseFlight item) {
        int length = cases.length + 1;
        CaseFlight[] tmp = new CaseFlight[length];
        System.arraycopy(cases, 0, tmp, 0, cases.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        cases = tmp;
    }

    public CaseFlight[] findAll() {
        return cases;
    }
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = cases.length - 1;
        CaseFlight[] tmp = new CaseFlight[length];
        int index = 0;
        for (CaseFlight item : cases) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        cases = tmp;
    }

    public CaseFlight findById(int id) {
        for (CaseFlight item : cases) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
