/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.web.controller;

/**
 *
 * @author Neeti
 */
import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static java.lang.System.out;
import java.util.*;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.openmrs.module.webservices.rest.web.annotation.WSDoc;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.openmrs.module.basicmodule.RadiologyGroup;
import org.openmrs.module.basicmodule.RadiologyGroupService;

@Controller
@RequestMapping(value = "/rest/v1/basicmodule/radiologystudy")
public class RadiologyRestController extends BaseRestController{
    Gson gson = new GsonBuilder().serializeNulls().create();
/**
	 * Get all the groups (as REF representation) 
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws ResponseException
	 */
	@RequestMapping(method = RequestMethod.GET)
	@WSDoc("Get All studies in the system")
	@ResponseBody()
    @SuppressWarnings("empty-statement")
	public String getAllRadiologyStudies(HttpServletRequest request, HttpServletResponse response) throws ResponseException {
		
		ArrayList results = new ArrayList();
                String[] name = {"xyz","abc","pqr"};
                String[] Modality = {"MR", "CT", "US"};
                String[] Priority = {"HIGH", "LOW", "MEDIUM"};
                String[] ScheduledStatus = {"SCHEDULED", "ARRIVED", "DEPARTED"};
                String[] PerformedStatus = {"IN_PROGRESS", "COMPLETED", "DISCONTINUED"};
                String[] BodyScan = {"xy","ab","pq"};
                String[] RefPhyName = {"x","a","p"};
                String[] PerPhyName = {"y","b","q"};
                String[] ReadPhyName = {"z","c","r"};
                String[] AddInfo = {"","abcabc",""};
                Date[] StartDate = {new Date(2013,9,11), new Date (2013,9,10), new Date (2013,10,1)};
                Date[] ExpiryDate = {new Date(2013,9,15), new Date (2013,9,14), new Date (2013,10,2)};
		for (int i=0;i<3;i++ ) 
                {
			SimpleObject obj = new SimpleObject();
                        obj.add("name", name[i]);
                        obj.add("Modality", Modality[i]);
                        obj.add("Priority", Priority[i]);
                        obj.add("BodyScan", BodyScan[i]);
                        obj.add("RefPhyName", RefPhyName[i]);
                        obj.add("PerPhyName", PerPhyName[i]);
                        obj.add("ReadPhyName", ReadPhyName[i]);
                        obj.add("ScheduledStatus", ScheduledStatus[i]);
                        obj.add("PerformedStatus", PerformedStatus[i]);
                        obj.add("AddInfo", AddInfo[i]);
                        obj.add("StartDate", StartDate[i]);
                        obj.add("ExpiryDate", ExpiryDate[i]);
			results.add(obj);
		}
		return gson.toJson(new SimpleObject().add("results", results));
	}    
        /**
	 * Create new radiology group by POST'ing in the request body.
	 *
	 * @param post the body of the POST request
	 * @param request
	 * @param response
	 * @return 201 response status and RadiologyGroup object
	 * @throws ResponseException
	 */
        RadiologyGroupService service;
	@RequestMapping(method = RequestMethod.POST)
	@WSDoc("Save New Radiology Order")
	@ResponseBody
	public Object createNewRadiologyStudy(@RequestBody SimpleObject post, HttpServletRequest request, HttpServletResponse response)
	        throws ResponseException {
		RadiologyGroup radiologyGroup = new RadiologyGroup();
		radiologyGroup.setName(post.get("name").toString());
                radiologyGroup.setModality(post.get("Modality").toString());
                radiologyGroup.setBodyScan(post.get("BodyScan").toString());
                if (post.get("StartDate") != null) {
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
                radiologyGroup.setRefPhyName(post.get("RefPhyName").toString());
                radiologyGroup.setPerPhyName(post.get("PerPhyName").toString());
                radiologyGroup.setReadPhyName(post.get("ReadPhyName").toString());
                radiologyGroup.setScheduledStatus(post.get("ScheduledStatus").toString());
                radiologyGroup.setPerformedStatus(post.get("PerformedStatus").toString());
                radiologyGroup.setAddInfo(post.get("AddInfo").toString());
		RadiologyGroup created = service.saveRadiologyGroup(radiologyGroup);
		SimpleObject obj = new SimpleObject();
		obj.add("Name", created.getName());
                obj.add("Modality", created.getModality());
                obj.add("Priority", created.getPriority());
		obj.add("BodyScan", created.getBodyScan());
                obj.add("StartDate", created.getStartDate());
                obj.add("ExpiryDate", created.getExpiryDate());
                obj.add("RefPhyName", created.getRefPhyName());
                obj.add("PerPhyName", created.getPerPhyName());
                obj.add("ReadPhyName", created.getReadPhyName());
                obj.add("ScheduledStatus", created.getScheduledStatus());
                obj.add("PerformedStatus", created.getPerformedStatus());
                obj.add("AddInfo", created.getAddInfo());
                return RestUtil.created(response, obj);
	}
}
