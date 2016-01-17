package com.iugu.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListInvoiceCriteria implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;
	
	private Integer limit;
	
	private Integer start;
	
	@JsonProperty("created_at_from")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("created_at_from")
	private Date createdAtFrom;
	
	@JsonProperty("created_at_to  ")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("created_at_to")
	private Date createdAtTo;
	
	@JsonProperty("due_date  ")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("dueDate")
	private Date dueDate;
	
	@JsonProperty("updated_since")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("updated_since")
	private Date updatedSince;
	
	private String query;
	
	private String sortBy;
	
	 
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;

	public static class Builder {
		
		//optional
		private Integer limit;
		private Integer start;
		private Date createdAtFrom;
		private Date createdAtTo;
		private Date dueDate;
		private Date updatedSince;
		private String query;
		private String sortBy;
		private String customerId;
		
		public Builder() {

		}
		
		public Builder limit(Integer limitOfRows) {
		  this.limit = limitOfRows;
		  return this;
		}
		
		public Builder start(Integer indexRowToStart) {
			  this.start = indexRowToStart;
			  return this;
			}
		
		public Builder createdAtFrom(Date filterByCreatedDateInit) {
			  this.createdAtFrom = filterByCreatedDateInit;
			  return this;
		}
		
		public Builder createdAtTo(Date filterByCreatedDateEnd) {
			  this.createdAtTo = filterByCreatedDateEnd;
			  return this;
		}
		
		public Builder dueDate(Date dueDate) {
			  this.dueDate = dueDate;
			  return this;
		}
		
		public Builder updatedSince(Date updatedSince) {
			  this.updatedSince = updatedSince;
			  return this;
		}
		
		public Builder query(String searchText) {
			  this.query = searchText;
			  return this;
		}
		
		public Builder sortBy(String sortByHash) {
			  this.sortBy = sortByHash;
			  return this;
		}
		
		public Builder customerId(String customerId) {
			  this.customerId = customerId;
			  return this;
		}
		
	    public ListInvoiceCriteria build() {
	        return new ListInvoiceCriteria(this);
	      }
	}
	
	private ListInvoiceCriteria(Builder builder) {
		limit = builder.limit;
		start = builder.start;
		createdAtFrom = builder.createdAtFrom;
		createdAtTo = builder.createdAtTo;
		dueDate = builder.dueDate;
		updatedSince = builder.updatedSince;
		query = builder.query;
		sortBy = builder.sortBy;
		createdAtFrom = builder.createdAtFrom;
		customerId = builder.customerId;
		
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Date getCreatedAtFrom() {
		return createdAtFrom;
	}

	public void setCreatedAtFrom(Date createdAtFrom) {
		this.createdAtFrom = createdAtFrom;
	}

	public Date getCreatedAtTo() {
		return createdAtTo;
	}

	public void setCreatedAtTo(Date createdAtTo) {
		this.createdAtTo = createdAtTo;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getUpdatedSince() {
		return updatedSince;
	}

	public void setUpdatedSince(Date updatedSince) {
		this.updatedSince = updatedSince;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	

}