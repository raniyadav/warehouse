package com.app.validator;

import com.app.model.Part;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Component
public class PartValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return Part.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
  }
}
