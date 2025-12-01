package de.seuhd.campuscoffee.domain.ports;

import java.util.List;

import de.seuhd.campuscoffee.domain.exceptions.NotFoundException;
import de.seuhd.campuscoffee.domain.model.User;
import io.micrometer.common.lang.NonNull;

public interface UserService {
    void clear();

/**
 * 
 * @return
 */
@NonNull List<User> getall();

/**
 * 
 * @param id
 * @return 
 * @throws NotFoundException
 */
@NonNull User getById(@NonNull Long id);

/**
 * 
 * @param name
 * @return
 * @throws NotFoundException
 */
@NonNull User getByName(@NonNull String name);

/**
 * 
 * @param user
 * @return
 * @throws NotFoundException
 */
@NonNull User upsert(@NonNull User user);


@NonNull

/**
 * 
 * @param id
 * @throws NotFoundException
 */
void delete(@NonNull Long id);
}
