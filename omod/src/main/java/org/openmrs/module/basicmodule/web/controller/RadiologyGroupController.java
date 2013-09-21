/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.web.controller;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.openmrs.module.webservices.rest.web.annotation.WSDoc;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.openmrs.module.basicmodule.RadiologyGroup;
import org.openmrs.module.basicmodule.RadiologyGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Neeti
 */
/*@Controller
@RequestMapping(value = "/rest/v1/basicmodule/radiologygroup")*/
public class RadiologyGroupController {
	/*RadiologyGroupService service;
	Gson gson = new GsonBuilder().serializeNulls().create();
	
	private static final String[] REF = { "uuid", "name", "orderType", "modality", "bodyScan", "startDate", "expiryDate", "refPhyName", "perPhyName", "readPhyName", "scheduledStatus", "performedStatus", "addInfo"};
	
	public void initRadiologyGroupController() {
		service = Context.getService(RadiologyGroupService.class);
	}
		
	private String getResourceVersion() {
		return "1.0";
	}
*/
	/**
	 * Create new radiology group by POST'ing in the request body.
	 *
	 * @param post the body of the POST request
	 * @param request
	 * @param response
	 * @return 201 response status and RadiologyGroup object
	 * @throws ResponseException
	 */
/*	@RequestMapping(method = RequestMethod.POST)
	@WSDoc("Save New RadiologyGroup")
	@ResponseBody
	public Object createNewRadiologyGroup(@RequestBody SimpleObject post, HttpServletRequest request, HttpServletResponse response)
	        throws ResponseException {
		initRadiologyGroupController();
		RadiologyGroup radiologyGroup = new RadiologyGroup();
		radiologyGroup.setName(post.get("name").toString());
                radiologyGroup.setModality(post.get("modality").toString());
                radiologyGroup.setBodyScan(post.get("bodyScan").toString());
                if (post.get("startDate") != null) {
			String[] supportedFormats = { "EEE MMM dd yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
			        "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss",
			        "yyyy-MM-dd" };
			for (int i = 0; i < supportedFormats.length; i++) {
				try {
					Date date = new SimpleDateFormat(supportedFormats[i]).parse(post.get("startDate").toString());
					radiologyGroup.setStartDate(date);
				}
				catch (Exception ex) {}
			}
		}
                if (post.get("expiryDate") != null) {
			String[] supportedFormats = { "EEE MMM dd yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
			        "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss",
			        "yyyy-MM-dd" };
			for (int i = 0; i < supportedFormats.length; i++) {
				try {
					Date date = new SimpleDateFormat(supportedFormats[i]).parse(post.get("expiryDate").toString());
					radiologyGroup.setExpiryDate(date);
				}
				catch (Exception ex) {}
			}
		}
                radiologyGroup.setRefPhyName(post.get("refPhyName").toString());
                radiologyGroup.setPerPhyName(post.get("perPhyName").toString());
                radiologyGroup.setReadPhyName(post.get("readPhyName").toString());
                radiologyGroup.setScheduledStatus(post.get("scheduledStatus").toString());
                radiologyGroup.setPerformedStatus(post.get("performedStatus").toString());
                radiologyGroup.setAddInfo(post.get("addInfo").toString());
		RadiologyGroup created = service.saveRadiologyGroup(radiologyGroup);
		SimpleObject obj = new SimpleObject();
		obj.add("uuid", created.getUuid());
		obj.add("name", created.getName());
                obj.add("modality", created.getModality());
		obj.add("bodyScan", created.getBodyScan());
                obj.add("startDate", created.getStartDate());
                obj.add("expiryDate", created.getExpiryDate());
                obj.add("refPhyName", created.getRefPhyName());
                obj.add("perPhyName", created.getPerPhyName());
                obj.add("readPhyName", created.getReadPhyName());
                obj.add("scheduledStatus", created.getScheduledStatus());
                obj.add("performedStatus", created.getPerformedStatus());
                return RestUtil.created(response, obj);
	}
*/	
		/**
	 * Updates the Group by making a POST call with uuid in URL and
	 *
	 * @param uuid the uuid for the group resource
	 * @param post
	 * @param request
	 * @param response
	 * @return 200 response status
	 * @throws ResponseException
	 */
/*	@RequestMapping(value = "/{uuid}", method = RequestMethod.POST)
	@WSDoc("Updates an existing drug group")
	@ResponseBody
	public Object updateRadiologyGroup(@PathVariable("uuid") String uuid, @RequestBody SimpleObject post,
	        HttpServletRequest request, HttpServletResponse response) throws ResponseException {
		initRadiologyGroupController();
		RadiologyGroup radiologyGroup = service.getRadiologyGroupByUuid(uuid);
		radiologyGroup.setName(post.get("name").toString());
                radiologyGroup.setModality(post.get("modality").toString());
                radiologyGroup.setBodyScan(post.get("bodyScan").toString());
                if (post.get("startDate") != null) {
			String[] supportedFormats = { "EEE MMM dd yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
			        "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss",
			        "yyyy-MM-dd" };
			for (int i = 0; i < supportedFormats.length; i++) {
				try {
					Date date = new SimpleDateFormat(supportedFormats[i]).parse(post.get("startDate").toString());
					radiologyGroup.setStartDate(date);
				}
				catch (Exception ex) {}
			}
		}
                if (post.get("expiryDate") != null) {
			String[] supportedFormats = { "EEE MMM dd yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
			        "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss",
			        "yyyy-MM-dd" };
			for (int i = 0; i < supportedFormats.length; i++) {
				try {
					Date date = new SimpleDateFormat(supportedFormats[i]).parse(post.get("expiryDate").toString());
					radiologyGroup.setExpiryDate(date);
				}
				catch (Exception ex) {}
			}
		}
                radiologyGroup.setRefPhyName(post.get("refPhyName").toString());
                radiologyGroup.setPerPhyName(post.get("perPhyName").toString());
                radiologyGroup.setReadPhyName(post.get("readPhyName").toString());
                radiologyGroup.setScheduledStatus(post.get("scheduledStatus").toString());
                radiologyGroup.setPerformedStatus(post.get("performedStatus").toString());
                radiologyGroup.setAddInfo(post.get("addInfo").toString());
		RadiologyGroup created = service.updateRadiologyGroup(radiologyGroup);
		SimpleObject obj = new SimpleObject();
		obj.add("uuid", created.getUuid());
		obj.add("name", created.getName());
                obj.add("modality", created.getModality());
		obj.add("bodyScan", created.getBodyScan());
                obj.add("startDate", created.getStartDate());
                obj.add("expiryDate", created.getExpiryDate());
                obj.add("refPhyName", created.getRefPhyName());
                obj.add("perPhyName", created.getPerPhyName());
                obj.add("readPhyName", created.getReadPhyName());
                obj.add("scheduledStatus", created.getScheduledStatus());
                obj.add("performedStatus", created.getPerformedStatus());
		return RestUtil.noContent(response);
	}
*/	
	/**
	 * Get all the groups (as REF representation) 
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws ResponseException
	 */
/*	@RequestMapping(method = RequestMethod.GET)
	@WSDoc("Get All Radiology Groups in the system")
	@ResponseBody()
	public String getAllRadiologyGroups(HttpServletRequest request, HttpServletResponse response) throws ResponseException {
		initRadiologyGroupController();
		List<RadiologyGroup> allRadiologyGroup = service.getAllRadiologyGroup(false);
		ArrayList results = new ArrayList();
		for (RadiologyGroup radiologyGroup : allRadiologyGroup) {
			SimpleObject obj = new SimpleObject();
                        obj.add("uuid", radiologyGroup.getUuid());
                        obj.add("name", radiologyGroup.getName());
                        obj.add("modality", radiologyGroup.getModality());
                        obj.add("bodyScan", radiologyGroup.getBodyScan());
                        obj.add("startDate", radiologyGroup.getStartDate());
                        obj.add("expiryDate", radiologyGroup.getExpiryDate());
                        obj.add("refPhyName", radiologyGroup.getRefPhyName());
                        obj.add("perPhyName", radiologyGroup.getPerPhyName());
                        obj.add("readPhyName", radiologyGroup.getReadPhyName());
                        obj.add("scheduledStatus", radiologyGroup.getScheduledStatus());
                        obj.add("performedStatus", radiologyGroup.getPerformedStatus());
			results.add(obj);
		}
		return gson.toJson(new SimpleObject().add("results", results));
	}
*/	
		/**
	 * Search Group by Name and get the resource as REF representation
	 *
	 * @param query the string to search name 
	 * @param request
	 * @return
	 * @throws ResponseException
	 */
	/*@RequestMapping(method = RequestMethod.GET, params = "q")
	@WSDoc("Gets Radiology Groups by name")
	@ResponseBody()
	public String getRadiologyGroupsByName(@RequestParam("q") String query, HttpServletRequest request) throws ResponseException {
		initRadiologyGroupController();
		List<RadiologyGroup> allRadiologyGroup = service.getRadiologyGroupByName(query);
		ArrayList results = new ArrayList();
		for (RadiologyGroup radiologyGroup : allRadiologyGroup) {
			SimpleObject obj = new SimpleObject();
			obj.add("uuid", radiologyGroup.getUuid());
                        obj.add("name", radiologyGroup.getName());
                        obj.add("orderType", radiologyGroup.getOrderType());
                        obj.add("modality", radiologyGroup.getModality());
                        obj.add("bodyScan", radiologyGroup.getBodyScan());
                        obj.add("startDate", radiologyGroup.getStartDate());
                        obj.add("expiryDate", radiologyGroup.getExpiryDate());
                        obj.add("refPhyName", radiologyGroup.getRefPhyName());
                        obj.add("perPhyName", radiologyGroup.getPerPhyName());
                        obj.add("readPhyName", radiologyGroup.getReadPhyName());
                        obj.add("scheduledStatus", radiologyGroup.getScheduledStatus());
                        obj.add("performedStatus", radiologyGroup.getPerformedStatus());
			results.add(obj);
		}
		return gson.toJson(new SimpleObject().add("results", results));
	}*/
}