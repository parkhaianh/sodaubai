package haianh.com.edu.sodaubai.utils;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object>{

	@Override
	public void initialize(PasswordsEqualConstraint arg0) {
	}

	@Override
	public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
		try {
			Method methodGetPassword = candidate.getClass().getMethod("getPassword");
			Method methodGetConfirmpassword = candidate.getClass().getMethod("getPasswordConfirm");
			if(methodGetPassword.invoke(candidate) == null && methodGetConfirmpassword.invoke(candidate)==null) 
	            return true;
	        else if(methodGetPassword.invoke(candidate) == null )
	            return false;
	        return methodGetPassword.invoke(candidate).equals(methodGetConfirmpassword.invoke(candidate));

		    } catch (NoSuchMethodException ex) {
		        ex.printStackTrace();
		        return false;
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        return false;
		    }
	}
}
