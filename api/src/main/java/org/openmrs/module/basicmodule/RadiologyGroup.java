/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule;

/**
 *
 * @author Neeti
 */
import java.io.Serializable;
import java.util.Date;
import org.openmrs.BaseOpenmrsMetadata;

public class RadiologyGroup extends BaseOpenmrsMetadata implements Serializable {
	
	private Integer id;
	private String name;
        private String Modality;
        private String BodyScan;
        private Date StartDate;
        private Date ExpiryDate;
        private String RefPhyName;
        private String PerPhyName;
        private String ReadPhyName;
        private String ScheduledStatus;
        private String PerformedStatus;
        private String AddInfo;
        private String Priority;
        
	public RadiologyGroup() {
	}
	/** constructor with id */
	/**
	 * @param id: id to set
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the Id
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
        @Override
	public String getName() {
		return this.name;
	}
 @Override
	public void setName(String name) {
		this.name = name;
	}
	
	public String getModality() {
		return this.Modality;
	}
	public void setModality(String Modality) {
		this.Modality = Modality;
	}
        
        public String getPriority() {
		return this.Modality;
	}
	public void setPriority(String Priority) {
		this.Priority = Priority;
	}
        
        public String getBodyScan() {
		return this.BodyScan;
	}
	public void setBodyScan(String BodyScan) {
		this.BodyScan = BodyScan;
	}
	
        public Date getStartDate() {
		return this.StartDate;
	}
	public void setStartDate(Date StartDate) {
		this.StartDate = StartDate;
	}
        
        public Date getExpiryDate() {
		return this.ExpiryDate;
	}
	public void setExpiryDate(Date ExpiryDate) {
		this.ExpiryDate = ExpiryDate;
	}
        
        public String getRefPhyName() {
		return this.RefPhyName;
	}
	public void setRefPhyName(String RefPhyName) {
		this.RefPhyName = RefPhyName;
	}
        
        public String getPerPhyName() {
		return this.PerPhyName;
	}
	public void setPerPhyName(String PerPhyName) {
		this.PerPhyName = PerPhyName;
	}
        
        public String getReadPhyName() {
		return this.ReadPhyName;
	}
	public void setReadPhyName(String ReadPhyName) {
		this.ReadPhyName = ReadPhyName;
	}
        
        public String getScheduledStatus() {
		return this.ScheduledStatus;
	}
	public void setScheduledStatus(String ScheduledStatus) {
		this.ScheduledStatus = ScheduledStatus;
	}
        
        public String getPerformedStatus() {
		return this.PerformedStatus;
	}
	public void setPerformedStatus(String PerformedStatus) {
		this.PerformedStatus = PerformedStatus;
	}
        
        public String getAddInfo() {
		return this.AddInfo;
	}
	public void setAddInfo(String AddInfo) {
		this.AddInfo = AddInfo;
	}
        

	
	/**
	 * Compares two objects for similarity
	 *
	 */
        @Override
	public boolean equals(Object obj) {
		if (obj instanceof RadiologyGroup) {
			RadiologyGroup pList = (RadiologyGroup) obj;
			if (this.getId() != null && pList.getId() != null) {
				return (this.getId().equals(pList.getId()));
			}
		}
		return this == obj;
	}
	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		}
		return this.getId().hashCode();
	}
	
}