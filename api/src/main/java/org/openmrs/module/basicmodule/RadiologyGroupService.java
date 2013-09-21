/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule;
import java.util.List;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.OpenmrsService;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Neeti
 */
@Transactional
public interface RadiologyGroupService extends OpenmrsService {
           //void setRadiologyGroupDAO(RadiologyGroupDAO dao);
    @Authorized( { "Add" })
	public RadiologyGroup saveRadiologyGroup(RadiologyGroup radiologyGroup);
    /*
    @Authorized( { "View" })
	public List<RadiologyGroup> getRadiologyGroupByName(String name);*/
    @Authorized( { "View" })
	public RadiologyGroup getRadiologyGroupByUuid(String uuid);
    @Authorized( { "Edit" })
	RadiologyGroup updateRadiologyGroup(RadiologyGroup radiologyGroup);
    @Authorized( { "View Drug Groups" })
	public List<RadiologyGroup> getAllRadiologyGroup(boolean includeRetired);
}