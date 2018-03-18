package com.skip.api.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.skip.api.domain.Customer;
import com.skip.api.repositories.CustomerRepository;
import com.skip.api.services.exception.FieldMessage;

public class CustomerInsertValidator implements ConstraintValidator<CustomerInsert, Customer> {

    @Autowired
    private CustomerRepository clientRepository;

    @Override
    public void initialize(CustomerInsert ann) {
    }

    @Override
    public boolean isValid(Customer objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Customer clientAux = clientRepository.findByEmail(objDto.getEmail());

        if (clientAux != null) {
            list.add(new FieldMessage("email", "Email already exists"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}