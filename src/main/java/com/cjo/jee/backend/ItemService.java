package com.cjo.jee.backend;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by popom on 13/10/2016.
 */
@Default
public class ItemService {

    @Inject
    private Validator validator;

    public void createItem(@Valid @NotNull Item item) {
        Set<ConstraintViolation<Item>> validate = validator.validate(item);
//        System.out.println("validate: " + validate);
//        if (!validate.isEmpty()) {
//            throw new RuntimeException("Not validated: " + validate);
//        }
    }

}
