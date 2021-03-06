<%-- 
    Document   : ticketEdit
    Created on : Aug 6, 2013, 2:19:50 AM
    Author     : helanio
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:include page="header.jsp" />

<div class="row">
    
    <html:form action="/detailTicket">
        <div class="well span6 pull-left">
                
                <form class="form-horizontal">
                    
                    <h4>Ticket Details</h4>
                    
                        <div class="control-group">
                          <label class="control-label">Id</label>
                          <div class="controls">
                               <html:text property="idTicket" disabled="true"/>
                          </div>
                        </div>
                    
                        <div class="control-group">
                          <label class="control-label">Title</label>
                          <div class="controls">
                               <html:text property="title" disabled="true"/>
                          </div>
                        </div>
                      
                      <div class="control-group">
                      <label class="control-label">Description</label>
                      <div class="controls">
                          <html:textarea property="description" disabled="true"/>
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">System</label>
                      <div class="controls">
                          <html:text property="system" disabled="true"/>
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">Component</label>
                      <div class="controls">
                          <html:text property="component" disabled="true"/>
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">Status</label>
                      <div class="controls">
                          <html:text property="status" disabled="true"/>
                      </div>
                      </div>
                      
                      <div class="control-group">
                      <label class="control-label">Operador</label>
                      <div class="controls">
                          <html:text property="operador" disabled="true"/>
                      </div>
                      </div>
                      
                    <div class="control-group">
                      <div class="controls">
                          <a href="ticketList.jsp">
                            <button class="btn btn-primary">Back to Ticket List</button>
                          </a>
                       </div>
                    </div>
                </form>
                       
            </div>
           
    </html:form>
    
   </div>

<jsp:include page="footer.jsp" />