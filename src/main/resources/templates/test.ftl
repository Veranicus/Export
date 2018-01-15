<html>
<head>
	<title>Generated Report</title>
	<style>
		#pageHeader {
			height: 50px;
			background-color: #0065A0;
			color: #FFFFFF;
			text-align: center;
			padding: 0;
			position: running(pageHeader);
		}
		#pageFooter {
			height: 50px;
			background-color: #0065A0;
			color: #FFFFFF;
			position: running(pageFooter);
		}
		#pageHeader img {
			background-color: red;
		}
		
		@page { 
		    margin-top: 0;
		    padding-top: 60px;
		    padding-bottom: 30px;
		    
		    @top-center {
		    	content: element(pageHeader);
		    }
		    @bottom-center {
		    	content: element(pageFooter);
	    	}
	    	
		}
		
		<#include "Structure.css">
	</style>
</head>
<body>
	<div id="pageHeader">
		<div class="media" data-src="images/logo.png" > 
		 <img alt="Tieto DevOps Space" src="${logo}" /> 
		Report
	</div>
	</div>
	
	<div id="pageFooter">
		<div style="float:left; margin-left: 15px; padding-top: 10px;">© 2014-2017 Tieto</div>  
		<div style="float:right; margin: 0 auto; margin-right: 15px; padding-top: 10px;">Report</div>
	</div>
	<div id="sideFiller"></div>
	
	<#-- TODO: -->
	<#-- Header: Logo(image or fonted)		Report		FirstName Lastname -->
	<#-- Footer: currentYear&credits		Page/Max	date of creation-->
	<#-- font for logo is 'Helvetica® Neue'; header color is #0065A0; footer color is white-->
	
	<#-- Spread both header and footer to full extent of the page width (keep the content in place though) -->
	<#-- Get image files from Jiri -->

  	
	<div id="structure-component">
	  <div flex="auto" class="container">
	    <h1 class="pagetitle">Structure</h1>
		<div class="flex-container multi-input-line-table" fxLayout="column">
	
		  	<span class="roles" style="padding: 0;" title="global roles">
		  		<#list user.globalRoles as globalRole>
					${globalRole.title!"---"}
					<#if !globalRole?is_last>
						${", "}
					<#else>
						${" : "}
					</#if>
				<#else>
					---
		  		</#list>
		  	</span>
		  	
		  	
		  	
	  		<#list user.companies as company>
		  		<div style="padding-bottom: 10px;">
		  			<i class="material-icons" style="color: rgba(0,0,0,0.54); cursor: default; padding: 5px; padding-right: 10px;" title="area">
		  				assessment
					</i>
		  			<span style="font-weight: bold;">${company.title!"---"}</span>
		  			<span class="roles" title="area roles">
		  				<#list company.userCompanyRoles as companyRole>
		  					${companyRole!"---"}
		  					<#if !companyRole?is_last>
		  						${", "}
		  					<#else>
		  						${" : "}
		  					</#if>
		  				</#list>
		  			</span>
		  			
					<#list company.userProductSpaces as project>
						<div style="padding-left: 30px; padding-bottom: 10px; page-break-inside: avoid;">
			  				<i class="material-icons" style="color: rgba(0,0,0,0.54); cursor: default; padding: 5px; padding-right: 10px;" title="project">
				  				dvr
				  			</i>
		  					
		  					<span style="font-weight: bolder;" title="${project.description}">
		  						${project.name!"---"}
		  					</span>
		  					<span class="roles" title="project roles">
		  						<#list project.userProductSpaceRoles as projectRole>
		  							${projectRole!"---"}
				  					<#if !projectRole?is_last>
				  						${", "}
				  					<#else>
				  						${" : "}
				  					</#if>
		  						</#list>
							</span>
		          			
		      				<#list project.servers as server>
		      					<div style="padding-left: 30px;">
		          					<i class="material-icons" style="color: rgba(0,0,0,0.54); cursor: default; padding: 5px; padding-right: 10px;" title="server">
			          					<#if server.aurUserPersonalData??>
				          					desktop_windows
				      					<#else>
			      							important_devices
				      					</#if>
			      					</i>
			      					${server.fqdn!"---"}
		      					</div>
		      				</#list>
		      			</div>
					</#list>
		  		</div>
	  		</#list>
		   </div>
		</div>
	</div>
  	
  	
  	<#--
  	<div style="position: fixed; width: 100%; left: 0; bottom: 0; margin-top: 10%; background-color: #0065A0; color: #FFFFFF;">
 		<footer style="display: flex; justify-content: space-between; align-items: center; height: 100%;">
    		<div style="float:left; margin-left: 5%;">© 2014-2017 Tieto</div>  
			<div style="float:right; margin: 0 auto; margin-right: 5%;">Report</div>
 		</footer>
  	</div>
  	-->
</body>
</html>