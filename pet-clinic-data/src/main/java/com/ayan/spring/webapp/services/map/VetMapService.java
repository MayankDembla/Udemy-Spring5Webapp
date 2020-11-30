package com.ayan.spring.webapp.services.map;

import com.ayan.spring.webapp.model.Speciality;
import com.ayan.spring.webapp.model.Vet;
import com.ayan.spring.webapp.services.SpecialityServices;
import com.ayan.spring.webapp.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityServices specialityServices;

    public VetMapService(SpecialityServices specialityServices) {
        this.specialityServices = specialityServices;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {

                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityServices.save(speciality);
                    savedSpeciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
