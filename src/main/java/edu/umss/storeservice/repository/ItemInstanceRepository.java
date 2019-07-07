/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ItemInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemInstanceRepository extends GenericRepository<ItemInstance> {
    @Query("select u from ItemInstance u where u.featured = :featured")
    public List<ItemInstance> findItemInstanceByfeatured(@Param("featured") Boolean feature);
}
  