<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to WhUserType Register Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="POST"
					modelAttribute="whusertype" enctype="multipart/form-data">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="userType"> USERTYPE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="userType" value="Vendor"/> Vendor
							<form:radiobutton path="userType" value="Customer"/> Customer
						</div>
						<div class="col-4" id="userTypeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="code"> CODE</label>
						</div>
						<div class="col-4">
							<form:input path="code" class="form-control" />
						</div>
						<div class="col-4" id="codeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="userFor"> USERFOR</label>
						</div>
						<div class="col-4">
							<form:input path="userFor" class="form-control" readonly="true"/>
						</div>
						<div class="col-4" id="userForError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="userEmail"> USEREMAIL</label>
						</div>
						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
						<div class="col-4" id="userEmailError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="contact"> CONTACT</label>
						</div>
						<div class="col-4">
							<form:input path="contact" class="form-control" />
						</div>
						<div class="col-4" id="contactError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="userIdType"> USERIDTYPE</label>
						</div>
						<div class="col-4">
							<form:select path="userIdType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PAN">PAN</form:option>
								<form:option value="AADHAR">AADHAR</form:option>
								<form:option value="Other">Other</form:option>
							</form:select>
						</div>
						<div class="col-4" id="userIdTypeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="ifOther"> IFOTHER</label>
						</div>
						<div class="col-4">
							<form:input path="ifOther" class="form-control" />
						</div>
						<div class="col-4" id="ifOtherError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="idNum"> IDNUM</label>
						</div>
						<div class="col-4">
							<form:input path="idNum" class="form-control" />
						</div>
						<div class="col-4" id="idNumError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note"> NOTE</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4" id="noteError"></div>
					</div>
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note">DOCUMENT</label>
						</div>
						<div class="col-4">
							<input type="file" name="fileDoc" class="form-control"/>
						</div>
						
					</div>
					
					
					<input type="submit" value="Register" class="btn btn-success" />
				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function(){
	$('input[name="userType"][type="radio"]').click(function(){
		var val=$('input[name="userType"][type="radio"]:checked').val();
		if(val=='Vendor'){
			$("#userFor").val('Purchase');
		}else if(val=='Customer'){
			$("#userFor").val('Sale');
			
		}
	});
	
	$("#userIdType").change(function(){
		var val=$("#userIdType").val();
		if(val=='Other'){
			$("#ifOther").removeAttr("readonly");
		}else{
			$("#ifOther").attr("readonly","true");
			$("#ifOther").val('');
		}
	});
	
});
</script>	
</body>
</html>



