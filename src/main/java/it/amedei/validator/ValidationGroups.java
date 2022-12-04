package it.amedei.validator;/*
@author Alessandro Amedei
Net Studio S.p.A
2022    
*/

import javax.validation.groups.Default;

public interface ValidationGroups {
    interface Post extends Default {
    }

    interface Put extends Default {
    }
}
