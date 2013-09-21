/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.web.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import org.openmrs.module.basicmodule.RadiologyGroup;
import org.openmrs.module.basicmodule.RadiologyGroupService;
/**
 *
 * @author Neeti
 */
@Resource("radiologygroup")
@Handler(supports = RadiologyGroup.class, order = 0)
public class RadiologyGroupReource extends MetadataDelegatingCrudResource<RadiologyGroup>{
  private RadiologyGroupService getRadiologyGroupService() {
		return Context.getService(RadiologyGroupService.class);
	}  
  @Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
                        description.addProperty("name");
                        description.addProperty("orderType");
                        description.addProperty("modality");
                        description.addProperty("bodyScan");
                        description.addProperty("startDate");
                        description.addProperty("expiryDate");
                        description.addProperty("refPhyName");
                        description.addProperty("perPhyName");
                        description.addProperty("readPhyName");
                        description.addProperty("scheduledStatus");
                        description.addProperty("performedStatus");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
                        description.addProperty("name");
                        description.addProperty("orderType");
                        description.addProperty("modality");
                        description.addProperty("bodyScan");
                        description.addProperty("startDate");
                        description.addProperty("expiryDate");
                        description.addProperty("refPhyName");
                        description.addProperty("perPhyName");
                        description.addProperty("readPhyName");
                        description.addProperty("scheduledStatus");
                        description.addProperty("performedStatus");
			description.addSelfLink();
			return description;
		}
		return null;
	}
  @Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addRequiredProperty("uuid");
                        description.addRequiredProperty("name");
                        description.addRequiredProperty("orderType");
                        description.addRequiredProperty("modality");
                        description.addRequiredProperty("bodyScan");
                        description.addRequiredProperty("startDate");
                        description.addRequiredProperty("expiryDate");
                        description.addRequiredProperty("refPhyName");
                        description.addRequiredProperty("perPhyName");
                        description.addRequiredProperty("readPhyName");
                        description.addRequiredProperty("scheduledStatus");
                        description.addRequiredProperty("performedStatus");
		return description;
	}
  public RadiologyGroup getByUniqueId(String uuid) {
		return getRadiologyGroupService().getRadiologyGroupByUuid(uuid);
	}
@Override
	public RadiologyGroup save(RadiologyGroup radiologyGroup) {
		return getRadiologyGroupService().saveRadiologyGroup(radiologyGroup);
	}	

    @Override
    public void purge(RadiologyGroup t, RequestContext rc) throws ResponseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RadiologyGroup newDelegate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}