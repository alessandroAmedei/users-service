package it.amedei.api;/*
@author Alessandro Amedei
2022    
*/

import io.quarkus.logging.Log;
import it.amedei.entity.User;
import it.amedei.exception.RestErrorEnum;
import it.amedei.exception.RestException;
import it.amedei.helper.CsvHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserController {

    @Inject
    UserPersister userPersister;

    public User findById(Integer id) throws RestException {
        return userPersister.findById(id);
    }

    public List<User> find(User user) {
        return userPersister.find(user);
    }

    @Transactional
    public User update(User user) throws RestException {
        return userPersister.update(user);
    }

    @Transactional
    public User create(User user) {
        return userPersister.create(user);
    }

    public void delete(Integer id) throws RestException {
        userPersister.delete(id);
    }

    @Transactional
    public List<User> insertCsv(File file) throws IOException, RestException {

        List<User> users = new ArrayList<>();

        List<List<String>> csvMap = CsvHelper.fileToCsvMap(file, 6, ",");

        for (List<String> row : csvMap) {
            User user = new User();
            user.setName(row.get(0));
            user.setSurname(row.get(1));
            user.setEmail(row.get(2));
            user.setPhone(row.get(4));
            user.setCity(row.get(5));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(sdf.parse(row.get(3)));
            } catch (ParseException e) {
                Log.info(e.getMessage());
                throw new RestException(RestErrorEnum.INVALID_DATE_FORMAT);
            }

            users.add(user);

            userPersister.create(user);
        }

        return users;
    }

}
