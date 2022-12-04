package it.amedei.validator;/*
@author Alessandro Amedei
2022    
*/

import javax.validation.groups.Default;

public interface ValidationGroups {
    interface Post extends Default {
    }

    interface Put extends Default {
    }
}
