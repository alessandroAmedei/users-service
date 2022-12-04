package it.amedei.api;/*
@author Alessandro Amedei
2022    
*/

import it.amedei.entity.User;
import it.amedei.exception.RestErrorEnum;
import it.amedei.exception.RestException;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserPersister {

    @PersistenceContext
    EntityManager em;

    public User findById(Integer id) throws RestException {
        User user = em.find(User.class, id);
        if (user == null)
            throw new RestException(RestErrorEnum.USER_NOT_FOUND);
        return user;
    }

    public List<User> find(User user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);

        Root<User> root = cr.from(User.class);
        cr.select(root);

        ParameterExpression<String> nameParameter = cb.parameter(String.class);
        ParameterExpression<String> surnameParameter = cb.parameter(String.class);


        List<Predicate> predicates = new ArrayList<>();
        if (user.getName() != null && user.getName().trim().length() > 0)
            predicates.add(cb.like(cb.lower(root.get("name")), nameParameter));
        if (user.getSurname() != null && user.getSurname().trim().length() > 0)
            predicates.add(cb.like(cb.lower(root.get("surname")), surnameParameter));

        cr.where(cb.and(predicates.toArray(new Predicate[0])));

        Query query = em.createQuery(cr);

        if (user.getName() != null && user.getName().trim().length() > 0)
            query.setParameter(nameParameter, "%".concat(user.getName().trim().toLowerCase()).concat("%"));
        if (user.getSurname() != null && user.getSurname().trim().length() > 0)
            query.setParameter(surnameParameter, "%".concat(user.getSurname().trim().toLowerCase()).concat("%"));

        return query.getResultList();
    }

    public User update(User user) throws RestException {
        User userDb = this.findById(user.getId());
        userDb.update(user);
        em.flush();
        return userDb;
    }

    public User create(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Transactional
    public void delete(Integer id) throws RestException {
        try {
            User user = em.getReference(User.class, id);
            em.remove(user);
        } catch (EntityNotFoundException enfe) {
            throw new RestException(RestErrorEnum.USER_NOT_FOUND);
        }
    }

}
