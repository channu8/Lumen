<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Life Blood Bank</title>
<style>
h1 {
  color: blue;
  font-family: verdana;
  font-size: 300%;
  color:red;
  text-align:center;
  border: 2px solid red;
  border-radius: 5px;
  background-color:LightGrey;
}
h3 {
  color: blue;
  text-align:right;
  font-family: Garamond;
  font-size: 130%;
  color:red;
 
}
body{
background-color: powderblue;
}
p
{color: DarkBlue;
 font-family: Garamond;
 font-size:22px;
}

input {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
}
</style>
</head>
<body >
<h1>${bloodBankName}</h1>
<h3>Every drop Matter's</h3>
<p style="display:inline;">Register as a donor By clicking on the button</p>
<a href="addDonor"><input type="button" value="Register New Donor"></a><br>
<p style="display:inline;">Register a BloodDonation Camp By clicking on the button</p>
<a href="addCamp"><input type="button" value="Register BloodDonation Camp"></a><br>
<p style="display:inline;">Click to view all the donors in the Life BloodBank</p>
<a href="getAllDonors"><input type="button" value="Donors Avaliable"></a><br>
<p style="display:inline;">Click to view all the BloodDonation Camps Registered in the Life BloodBank</p>
<a href="getAllCamps"><input type="button" value="BloodCamps Avaliable"></a><br>
<p style="display:inline;">Click to update the Donor details(Note-if already registered)</p>
<a href="updateDonorById"><input type="button" value="Update Donor Details"></a><br>
<p style="display:inline;">Click to See the Eligible Donors(Donated in last six months)</p>
<a href="getDonorsInSixMonth"><input type="button" value="Eligible Donors"></a><br>
<p style="display:inline;">Click to Search donors by Location</p>
<a href="searchByLoc"><input type="button" value="Search Donors By Location"></a><br>
<p style="display:inline;">Click to Unregister as a Donor</p>
<a href="deleteById"><input type="button" value="Unregister"></a><br>
<p style="display:inline;">Click to Search Donors By BloodGroup</p>
<a href="searchByBloodGroup"><input type="button" value="Search Donors By BloodGroup"></a><br>

</body>
</html>